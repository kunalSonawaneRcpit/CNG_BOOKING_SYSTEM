package com.project.cng;

import java.io.IOException;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kunal.dbconnect.DbConnect;

/**
 * Servlet implementation class LoginCng
 */
public class LoginCng extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginCng() {
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
		
		String mob=request.getParameter("mobile");
		String pass=request.getParameter("password");
		String sts="Approved";
		try
		{
			Connection con=DbConnect.getConnect();
			PreparedStatement ps1=con.prepareStatement("select * from pumps1 where pcontact=? and password=? and status=?");
			ps1.setString(1, mob);
			ps1.setString(2, pass);
			ps1.setString(3, sts);
			ResultSet rs=ps1.executeQuery();
			
			if(rs.next())
			{
				UserData.setPname(rs.getString(2));
				UserData.setMobile(mob);
				UserData.setPassword(pass);
				response.sendRedirect("UpdateCng.html");
				
			}
			else
			{
				response.sendRedirect("failedCng.html");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
