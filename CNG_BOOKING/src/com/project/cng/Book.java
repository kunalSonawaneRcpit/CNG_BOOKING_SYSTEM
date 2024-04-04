package com.project.cng;

import java.io.IOException;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kunal.dbconnect.DbConnect;

/**
 * Servlet implementation class Book
 */
public class Book extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Book() {
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
		
		int id=Integer.parseInt(request.getParameter("id"));
		int q=Integer.parseInt(request.getParameter("quant"));
		String nm=UserData.getName();
		String em=UserData.getMail();
		String ct=UserData.getCity();
		try
		{
			String pname=null,pcity=null;
			int pq=0;
			Connection con=DbConnect.getConnect();
			PreparedStatement ps1=con.prepareStatement("select * from pumps1 where pid=?");
			ps1.setInt(1, id);
			ResultSet rs=ps1.executeQuery();
			while(rs.next())
			{
				pname=rs.getString("pname");
				pcity=rs.getString("pcity");
				pq=rs.getInt("avail_cng");
			}
			if(q<pq)
			{
				PreparedStatement ps2=con.prepareStatement("insert into book values(?,?,?,?,?,?,?)");
				ps2.setInt(1, 0);
				ps2.setString(2, nm);
				ps2.setString(3, em);
				ps2.setString(4, ct);
				ps2.setString(5, pname);
				ps2.setString(6, pcity);
				ps2.setInt(7, q);
				int i=ps2.executeUpdate();
				
				PreparedStatement ps3=con.prepareStatement("update pumps1 set avail_cng=avail_cng-? where pid=?");
				ps3.setInt(1, q);
				ps3.setInt(2, id);
				int j=ps3.executeUpdate();
				if(i>0 && j>0)
				{
					response.sendRedirect("bookSuccess.html");
				}
				else
				{
					response.sendRedirect("bookFailed.html");
				}
			}
			else
			{
				response.sendRedirect("bookFailed.html");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
