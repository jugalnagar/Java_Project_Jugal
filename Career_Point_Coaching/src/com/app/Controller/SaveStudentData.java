package com.app.Controller;
import com.app.Service.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.http.fileupload.servlet.ServletRequestContext;

import com.app.Service.Data;
import com.app.Service.SendMail;

@WebServlet(asyncSupported = true, urlPatterns = { "/SaveStudentData" })
//database Student_Data

// table1:  AllStudent
//
public class SaveStudentData extends HttpServlet {
	Connection con;
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
		
		String sql="insert into AllStudent(Name ,Father_Name ,Mother_Name ,DOB,Class ,Medium,Batch ,Subject,Mobile_No ,Father_Mobile_Nuber ,EmailID ,Address,Student_Image) Values(?,?,?,?,?,?,?,?,?,?,?,?,?);";
		//sql query for get RegistrationID
		String sql2="select max(RegistrationID) as RegistrationID from allstudent;";
		
		try {
			
			Statement s=con.createStatement();
			ResultSet rs=s.executeQuery(sql2);
			rs.next();
			int RegID=rs.getInt(1);
			RegID=RegID+1;
			//for create column in resultdata table 
			String sql1="alter table resultdata add `"+RegID+"` int";
			
			PreparedStatement ps=con.prepareStatement(sql);
			PreparedStatement ps1=con.prepareStatement(sql1);
			DiskFileItemFactory factory=new DiskFileItemFactory();
			ServletFileUpload upload=new ServletFileUpload(factory);
			try {
				List<FileItem> items=upload.parseRequest(new ServletRequestContext(request));
				
			//get values 
			
			String Name=(items.get(1)).getString();
			String FatherName=(items.get(2)).getString();
			String MotherName=(items.get(3)).getString();
			String DOB=(items.get(4)).getString();
			String Class=(items.get(5)).getString();
			String Medium=(items.get(6)).getString();
			String Batch=(items.get(7)).getString();
			String Subject=(items.get(8)).getString();
			String MobileNo=(items.get(9)).getString();
			String FatherMobileNo=(items.get(10)).getString();
			String EmailID=(items.get(11)).getString();
			String Address=(items.get(12)).getString();
			FileItem Image=items.get(13);
			byte b[]=Image.get();
			
			//pass value
			ps.setString(1, Name);
			ps.setString(2, FatherName);
			ps.setString(3, MotherName);
			ps.setString(4, DOB);
			ps.setString(5, Class);
			ps.setString(6, Medium);
			ps.setString(7, Batch);
			ps.setString(8, Subject);
			ps.setString(9, MobileNo);
			ps.setString(10, FatherMobileNo);
			ps.setString(11, EmailID);
			ps.setString(12, Address);
			ps.setBytes(13, b);
			//ps1.setInt(1, RegID);
			System.out.println(Name);
			System.out.println(RegID);
			
			int n=ps.executeUpdate();
			ps1.executeUpdate();
			
			//problem set global max_allowed_packet=33554432/9,273,681
			//store data in session object
			HttpSession  session=request.getSession();
			session.setAttribute("name", Name);
			session.setAttribute("id", RegID);
			session.setAttribute("class", Class);
			
			//send mail to student
			if(n==1) {
				String EmailID1=EmailID.trim();
				SendMail.sendTextmail( EmailID1,Name, RegID);
			}
			
			PrintWriter out=response.getWriter();
			out.println(Name);
			response.sendRedirect("AdminPage.jsp");
			} catch (Exception e) {
				e.printStackTrace();
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
