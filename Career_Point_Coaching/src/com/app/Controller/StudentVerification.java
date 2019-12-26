package com.app.Controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.app.Service.Data;
import com.app.StudentInfo.StudentBean;
import com.app.StudentInfo.TestBean;

@WebServlet("/StudentVerification")
public class StudentVerification extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con;
	ResultSet rs;
	public void init(ServletConfig config) throws ServletException {
		try {
			con=Data.cannect();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	public void destroy() {
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sql ="select RegistrationID,Name ,Father_Name ,Mother_Name ,DOB,Class ,Medium,Batch ,Subject,Mobile_No ,Father_Mobile_Nuber ,EmailID ,Address from allstudent where RegistrationID=? and DOB=?";
		
		try {
			
			int RegID=Integer.parseInt(request.getParameter("RegID"));
			String Dob=request.getParameter("psw");
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1,RegID);
			ps.setString(2,Dob);
			rs=ps.executeQuery();
			if(rs.next()) {
			
				int Reg=rs.getInt(1);
				String Name=rs.getString(2);
				String Fname=rs.getString(3);
				String Mname=rs.getString(4);
				String dob=rs.getString(5);
				String Class=rs.getString(6);
				String med=rs.getString(7);
				String batch=rs.getString(8);
				String subject=rs.getString(9);
				String mobile=rs.getString(10);
				String fmobile=rs.getString(11);
				String email=rs.getString(12);
				String address=rs.getString(13);
			
				StudentBean student=new StudentBean(Reg,Name,Fname,Mname,dob,Class,med,batch,subject,mobile,fmobile,email,address);
				
				String sql1=" select TName,`"+Reg+"` from resultdata where `"+Reg+"`!=\"Null\";";
				String sql2="select TName,Subject,Date,TMark from Test where ";	
				Statement s=con.createStatement();
				ResultSet Tests=s.executeQuery(sql1);
				ArrayList arr =new ArrayList();
				while(Tests.next()) {
					arr.add(Tests.getString(1));
					arr.add(Tests.getInt(2));
					sql2=sql2+"TName='"+Tests.getString(1)+"' OR";
					
				}
				int last=sql2.lastIndexOf("OR");
				char ch[]=sql2.toCharArray();
				for(int i=last;i<sql2.length();i++)
				{
					if(i==last) {
						ch[i]=';';
					}
					else
						ch[i]='\0';
				}
				
				String newsql2= new String(ch);
				Statement s1=con.createStatement();
				System.out.print(newsql2);
				ResultSet TestDetail=s1.executeQuery(newsql2);
				
				int i=0;
				ArrayList<TestBean> arr1 =new ArrayList<>();
				while(TestDetail.next()) {
					String TName=TestDetail.getString(1);
					String Subject=TestDetail.getString(2);
					String Date=TestDetail.getString(3);
					int TMark=TestDetail.getInt(4);
					int OMark= (int) arr.get(i+1);
					i++;
					TestBean testdetail=new TestBean(TName,Subject,Date,TMark,OMark);
					arr1.add(testdetail);
				}
				
				
				
				HttpSession session=request.getSession();
				session.setAttribute("student", student);
				session.setAttribute("RegID", Reg);
				session.setAttribute("Tests", arr);
				session.setAttribute("testdetail", arr1);
				response.sendRedirect("StudentPage.jsp");
			}else {
				response.sendRedirect("Student.jsp");
			}
		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
