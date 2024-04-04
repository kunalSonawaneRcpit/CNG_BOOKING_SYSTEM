package com.project.cng;

public class UserData 
{
	static String mobile;
	static String password;
	static String name;
	static String mail;
	static String city;
	static String pname;
	static String pmobile;
	static int pid;
	
	
	
	public static int getPid() {
		return pid;
	}

	public static void setPid(int pid) {
		UserData.pid = pid;
	}

	public static String getPmobile() {
		return pmobile;
	}

	public static void setPmobile(String pmobile) {
		UserData.pmobile = pmobile;
	}

	public static String getPname() {
		return pname;
	}

	public static void setPname(String pname) {
		UserData.pname = pname;
	}

	public static String getCity() {
		return city;
	}

	public static void setCity(String city) {
		UserData.city = city;
	}

	public static String getName() {
		return name;
	}

	public static void setName(String name) {
		UserData.name = name;
	}

	public static String getMail() {
		return mail;
	}

	public static void setMail(String mail) {
		UserData.mail = mail;
	}

	public static String getPassword() 
	{
		return password;
	}

	public static void setPassword(String password) 
	{
		UserData.password = password;
	}

	public static String getMobile() 
	{
		return mobile;
	}

	public static void setMobile(String mobile) 
	{
		UserData.mobile = mobile;
	}
	
}
