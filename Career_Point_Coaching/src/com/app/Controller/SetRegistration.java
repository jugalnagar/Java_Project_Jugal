package com.app.Controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.Service.Data;

/**
 * Servlet implementation class SetRegistration
 */
@WebServlet("/SetRegistration")
public class SetRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;
    Connection con;
    ResultSet rs;
    
    public SetRegistration() {
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
		int RegID=Integer.parseInt(request.getParameter("RegID"));
		String psw=request.getParameter("psw");
		
		if(psw.equals("72230165")) {
			String sql="ALTER TABLE allstudent AUTO_INCREMENT=?";
			try {
				PreparedStatement ps=con.prepareStatement(sql);
				ps.setInt(1, RegID);
				ps.executeUpdate();
				response.sendRedirect("AdminPage.jsp");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {
			response.sendRedirect("index.jsp");
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
