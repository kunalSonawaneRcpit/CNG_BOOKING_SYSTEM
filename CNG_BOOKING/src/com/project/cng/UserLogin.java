package com.project.cng;

import java.io.IOException;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kunal.dbconnect.DbConnect;

/**
 * Servlet implementation class UserLogin
 */
public class UserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLogin() {
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
		
		String mail=request.getParameter("email");
		String pass=request.getParameter("password");
		try
		{
			Connection con=DbConnect.getConnect();
			PreparedStatement ps1=con.prepareStatement("select * from users where uemail=? and upass=?");
			ps1.setString(1, mail);
			ps1.setString(2, pass);
			ResultSet rs=ps1.executeQuery();
			if(rs.next())
			{
				UserData.setMail(rs.getString("uemail"));
				UserData.setName(rs.getString("uname"));
				UserData.setCity(rs.getString("ucity"));
				response.sendRedirect("ViewCng4.jsp");
			}
			else
			{
				response.sendRedirect("failedUserLogin.html");
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
