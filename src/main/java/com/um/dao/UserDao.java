package com.um.dao;

import java.sql.Connection;


import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import com.um.model.User;

public class UserDao {

	private static String url ="jdbc:mysql://localhost:3306/project";
	private static String user ="root";
	private static String password = "riyaz";
	private static String checkLogin = "select * from uadmin";
	private static String insert ="insert into user(name,email,city) values(?,?,?)";
	private static String display ="select * from user";
	private static String delete = "delete from user where id=?";
	private static String selectUserById = "select *from user where id=?";
	private static String updateUser = "update user set name=?,email=?,city=? where id=?";
	private static Statement s = null;
	private static Connection  con = null;
	private static PreparedStatement ps = null;
	
	// admin login check
	public static String checkLogin(String aname,String apassword)
    {
	 try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, user, password);
			s = con.createStatement();
			ResultSet rs = s.executeQuery(checkLogin);
			while(rs.next())
			{
				String name = rs.getString("name");
				String password = rs.getString("password");
				if(name.equals(aname) &&  password.equals(apassword))
				{
					return "sucess";
				}
		
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 finally {
		try {
			s.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	 
	return "failure";
   	 
    }
	
	// insert data to database 
	public static void insert(User u)
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, user, password);
			ps = con.prepareStatement(insert);
			ps.setString(1, u.getName());
			ps.setString(2, u.getEmail());
			ps.setString(3, u.getCity());
			ps.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
	// display details
	public static ArrayList<User> display()
	{
		ArrayList<User> al = new ArrayList<User>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, user, password);
			s = con.createStatement();
			ResultSet rs = s.executeQuery(display);
			while(rs.next())
			{
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String email = rs.getString("email");
				String city = rs.getString("city");
				User u = new User(id, name, email, city);
				al.add(u);
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				s.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		return al; 
	}
	
	// delete user
	public static void delete(int id)
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, user, password);
			ps = con.prepareStatement(delete);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	// select user by id
	public static User SelectUserById(int id1)
	{
		User u =null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, user, password);
			ps = con.prepareStatement(selectUserById);
			ps.setInt(1, id1);
		    ResultSet rs = ps.executeQuery();
		    rs.next();
		    int id = rs.getInt("id");
		    String name = rs.getString("name");
		    String email = rs.getString("email");
		    String city = rs.getString("city");
		    u = new User(id, name, email, city);
		    
			ps.executeUpdate();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return u;

		
	}
	// updating user
	public static void updateUser(User u)
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, user, password);
			ps = con.prepareStatement(updateUser);
			ps.setString(1,u.getName());
			ps.setString(2,u.getEmail());
			ps.setString(3,u.getCity());
			ps.setInt(4,u.getId());
			ps.executeUpdate();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	}
		finally {
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
	
}
}
