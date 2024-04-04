package com.project.cng;

import java.io.IOException;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kunal.dbconnect.DbConnect;

/**
 * Servlet implementation class RegisterCng
 */
public class RegisterCng extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterCng() {
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
		String addr=request.getParameter("address");
		String ct=request.getParameter("city");
		String tal=request.getParameter("taluka");
		String dist=request.getParameter("district");
		String opent=request.getParameter("opentime");
		String closet=request.getParameter("closetime");
		String mob=request.getParameter("mobile");
		String lati=request.getParameter("latitude");
		String longi=request.getParameter("longitude");
		String pass=request.getParameter("pwd");
		int kg=Integer.parseInt(request.getParameter("cngkg"));
		String sts="pending";
		
		try
		{
			Connection con=DbConnect.getConnect();
			PreparedStatement ps1=con.prepareStatement("insert into pumps1 values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			ps1.setInt(1, 0);
			ps1.setString(2, nm);
			ps1.setString(3, addr);
			ps1.setString(4, ct);
			ps1.setString(5, tal);
			ps1.setString(6, dist);
			ps1.setString(7, opent);
			ps1.setString(8, closet);
			ps1.setString(9, mob);
			ps1.setString(10, lati);
			ps1.setString(11, longi);
			ps1.setString(12, pass);
			ps1.setInt(13, kg);
			ps1.setString(14, sts);
			int i=ps1.executeUpdate();
			if(i>0)
			{
				response.sendRedirect("success.html");
			}
			else
			{
				response.sendRedirect("failed.html");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

}
