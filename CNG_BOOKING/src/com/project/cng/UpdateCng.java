package com.project.cng;

import java.io.IOException;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kunal.dbconnect.DbConnect;

/**
 * Servlet implementation class UpdateCng
 */
public class UpdateCng extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCng() {
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
		
		int cng=Integer.parseInt(request.getParameter("cngkg"));
		String mob=UserData.getMobile();
		String pass=UserData.getPassword();
		try
		{
			Connection con=DbConnect.getConnect();
			PreparedStatement ps1=con.prepareStatement("update pumps1 set avail_cng=avail_cng+? where pcontact=? and password=?");
			ps1.setInt(1, cng);
			ps1.setString(2, mob);
			ps1.setString(3, pass);
			int i=ps1.executeUpdate();
			if(i>0)
			{
				response.sendRedirect("successUpdate.html");
			}
			else
			{
				response.sendRedirect("failedUpdate.html");
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
