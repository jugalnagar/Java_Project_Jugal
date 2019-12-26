package com.app.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.Service.Data;

@WebServlet("/SaveResultInfo")
public class SaveResultInfo extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Connection con;
	PreparedStatement ps;
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		try {
			con=Data.cannect();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void destroy() {
		// TODO Auto-generated method stub
		try {
			
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String TName=request.getParameter("TName");
		String Class=request.getParameter("Class");
		String Subject=request.getParameter("Subject");
		String Batch=request.getParameter("Batch");
		String Date=request.getParameter("Date");
		String TMark=request.getParameter("TMark");
		
		String sql2="insert into resultdata(TName) values(?)";
		
		System.out.println(sql2);
		
		
		try {
			String sql1="insert into Test values(?,?,?,?,?,?)";
			ps=con.prepareStatement(sql1);
			PreparedStatement ps2=con.prepareStatement(sql2);
			
			ps.setString(1, TName);
			ps.setString(2, Class);
			ps.setString(3, Subject);
			ps.setString(4, Batch);
			ps.setString(5, Date);
			ps.setString(6, TMark);
			
			ps.executeUpdate();
			
			ps2.setString(1, TName);
			ps2.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("AdminPage.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
