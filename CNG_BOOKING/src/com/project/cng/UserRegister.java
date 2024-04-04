package com.project.cng;

import java.io.IOException;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kunal.dbconnect.DbConnect;

/**
 * Servlet implementation class UserRegister
 */
public class UserRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserRegister() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		String nm=request.getParameter("name");
		String mail=request.getParameter("email");
		String mob=request.getParameter("mobile");
		String addr=request.getParameter("address");
		String pass=request.getParameter("password");
		String ct=request.getParameter("city");
		try
		{
			Connection con=DbConnect.getConnect();
			PreparedStatement ps1=con.prepareStatement("insert into users values(?,?,?,?,?,?,?)");
			ps1.setInt(1, 0);
			ps1.setString(2, nm);
			ps1.setString(3, mail);
			ps1.setString(4, mob);
			ps1.setString(5, addr);
			ps1.setString(6, pass);
			ps1.setString(7, ct);
			int i=ps1.executeUpdate();
			if(i>0)
			{
				response.sendRedirect("UserRegisterSuccess.html");
			}
			else
			{
				response.sendRedirect("failedUserRegister.html");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
