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


@WebServlet("/ShowStudents")
public class ShowStudents extends HttpServlet {
	private static final long serialVersionUID = 1L;
    Connection con;
    ResultSet rs,rs2,rs1;
    ArrayList<Integer> arr;
    
    public ShowStudents() {
        super();
        // TODO Auto-generated constructor stub
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
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sql="Select Batch from Test where Tname=?";
		
		//all student of above Batch
		String sql2="Select RegistrationID from allstudent where Batch=?";
		
		String TName=request .getParameter("TName");
		
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, TName);
			rs=ps.executeQuery();
			rs.next();
			String Batch=rs.getString(1);
			
			PreparedStatement ps2=con.prepareStatement(sql2);
			ps2.setString(1, Batch);
			rs2 =ps2.executeQuery();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		HttpSession session=request.getSession();
		session.setAttribute("teststudent", rs2);
		session.setAttribute("test", TName);
		//session.setAttribute("RegIDs", arr);
		
		response.sendRedirect("TestStudents.jsp");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
