package com.app.Controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.app.Service.Data;


@WebServlet("/SaveTestScore")
public class SaveTestScore extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	Connection con;
	ResultSet rs,rs2;
    
    public SaveTestScore() {
        super();
       
    }

	
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
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String test=(String) session.getAttribute("test");
		ArrayList arr=(ArrayList)session.getAttribute("RegIDs");
		
		String res= "";
		try {
			for(int i=0;i<arr.size();i++) {
				String RegID=(String) arr.get(i);
				if(res!="") 
					res=res+", `"+RegID+"` = ?";
				else
					res=res+"`"+RegID+"` = ?";
			}
			
			
			String sql="UPDATE resultdata SET "+res+" WHERE TName = '"+test+"';";
			System.out.println(sql);
			
			PreparedStatement ps=con.prepareStatement(sql);
			
			for(int i=0;i<arr.size();i++){
				String RegID=(String) arr.get(i);
				int  mark=Integer.parseInt(request.getParameter(RegID));
				ps.setInt(i+1, mark);
			}
			ps.executeUpdate();
			response.sendRedirect("RecordSetting.jsp");
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
