package com.kunal.dbconnect;
import java.sql.*;
public class DbConnect 
{
	static Connection con = null;
	public static Connection getConnect()
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cng_web", "root", "");

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return con;
	}
}
