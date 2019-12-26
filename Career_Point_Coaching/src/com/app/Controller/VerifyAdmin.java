package com.app.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/VerifyAdmin")
public class VerifyAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	
	public void destroy() {
		// TODO Auto-generated method stub
	}

	
	
	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String s1=request.getParameter("email");
		String s2=request.getParameter("pswd");
		
		//verify admin data
		HttpSession session =request.getSession();
		if( s1.equals("jugalnagar0@gmail.com") && s2.equals("72230165") ) {
			session.setAttribute("email", "jugalnagar0@gmail.com");
			
			response.sendRedirect("AdminPage.jsp");
		}
		else{
			PrintWriter out=response.getWriter();
			if(s1.equals("jugalnagar0@gmail.com")) {
				//response.sendRedirect("login.jsp");
				out.println("<html>"
						+ "<body>"
						+ "<p style='text-align:center;'>Incorrect password !<br>"
						+ "<a href='login.jsp'> Try Again</a></p>"
						+ "</body>"
						+ "</html>");
				out.println("");
			}
		}
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
