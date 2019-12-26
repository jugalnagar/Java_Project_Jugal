package com.app.Controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.app.Service.Data;

@WebServlet("/ImageRetrive")
public class ImageRetrive extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con;
	PreparedStatement ps;
	public void init(ServletConfig config) throws ServletException {
		try {
			con=Data.cannect();
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

	
	public void destroy() {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String sql="Select Student_Image from allStudent where RegistrationID=?";
		try {
			
			ps=con.prepareStatement(sql);
			
			HttpSession session=request.getSession();
			int RegID= (int)session.getAttribute("RegID");
			
			ps.setInt(1, RegID);
			
			ResultSet rs=ps.executeQuery();
			rs.next();
			byte b[]=rs.getBytes(1);
			
			ServletOutputStream out=response.getOutputStream();
			out.write(b);
			out.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
