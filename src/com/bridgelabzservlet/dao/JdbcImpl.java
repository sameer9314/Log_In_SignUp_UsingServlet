package com.bridgelabzservlet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bridgelabzservlet.dto.ConnectionPoolManager;
import com.bridgelabzservlet.dto.UserBean;

/**
 * Purpose  : To authenticate email,password ,user log in details and Update Account.
 * @author  : Sameer Saurabh
 * @version : 1.0
 * @since   : 29/06/2018
 */
public class JdbcImpl implements UserDao{

	public boolean emailChecker(String email) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ConnectionPoolManager pool = null;
		try
		{
			pool = ConnectionPoolManager.getInstance();
			con = pool.getConnectionFromPool();
			
			String query = " select * from  user_detail where email = ?"; 
			pstmt =con.prepareStatement(query);
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();
			if(rs.next())
			{
				return true;
			}
			else{
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally{
			try 
			{
				if(pstmt!=null){
					pstmt.close();
				}
				if(rs!=null){
					rs.close();
				}
				pool.returnConnectionToPool(con);
				

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}//End of outer try-catch
	}
	public boolean passwordChecker(String email,String password) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ConnectionPoolManager pool = null;
		try
		{
			pool = ConnectionPoolManager.getInstance();
			con = pool.getConnectionFromPool();
			
			String query = " select * from  user_detail   "+
					" where email = ?  "+
					" and password = ?";

			pstmt =con.prepareStatement(query);
			pstmt.setString(1, email);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();
			if(rs.next())
			{
				return true;
			}
			else{
				return false;
			}

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally{
			try 
			{
				if(pstmt!=null){
					pstmt.close();
				}
				if(rs!=null){
					rs.close();
				}
				pool.returnConnectionToPool(con);
				

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}//End of outer try-catc
	}
	
	public UserBean authenticate(String email, String password)
	{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ConnectionPoolManager pool = null;
		try
		{
			pool = ConnectionPoolManager.getInstance();
			con = pool.getConnectionFromPool();
			
			String query = " select * from  user_detail   "+
					" where email = ?  "+
					" and password = ?";

			pstmt =con.prepareStatement(query);
			pstmt.setString(1, email);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();

			//4. Process the Results returned by SQL Queries
			if(rs.next())
			{
				UserBean bean=new UserBean();
				bean.setId(rs.getInt("Sl_No"));
				bean.setUser_name(rs.getString("user_name"));
				bean.setEmail(rs.getString("email"));
				bean.setPhoneNumber("phoneNumber");
				bean.setPassword(rs.getString("password"));

				System.out.println("bean set");
				
				
				return bean;	
			}
			else{
				return null;
			}

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally{
			//5. Close ALL JDBC Objects
			try 
			{
				if(pstmt!=null){
					pstmt.close();
				}
				if(rs!=null){
					rs.close();
				}
				pool.returnConnectionToPool(con);
				

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}//End of outer try-catch
	}//End of authenticate
	
	public int updateAccount(String user_name, String email,String phoneNumber,String password) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ConnectionPoolManager pool = null;
		int count=0;
		try
		{
			pool = ConnectionPoolManager.getInstance();
			con = pool.getConnectionFromPool();
			
			// inserting values into the table account.
			String	query = "insert into user_detail(user_name,email,phoneNumber,password) values(?,?,?,?)";
				pstmt = con.prepareStatement(query);
				pstmt.setString(1, user_name);
				pstmt.setString(2, email);
				pstmt.setString(3,phoneNumber);
				pstmt.setString(4, password);
				count = pstmt.executeUpdate();
			}catch(Exception e)
			{
			e.printStackTrace();
			}finally {
			try {
				
				if (pstmt != null) {
					pstmt.close();
				}
				pool.returnConnectionToPool(con);
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return count;
}
	static Connection getConnection() {
		Connection con = null;
		ConnectionPoolManager pool = null;
		try {
			pool = ConnectionPoolManager.getInstance();
			con = pool.getConnectionFromPool();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	public String returnPassword(String email) {
		String password=null;
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			ConnectionPoolManager pool = null;
			try
			{
				pool = ConnectionPoolManager.getInstance();
				con = pool.getConnectionFromPool();
				
				String query = " select * from  user_detail where email = ?"; 
				pstmt =con.prepareStatement(query);
				pstmt.setString(1, email);
				rs = pstmt.executeQuery();
				if(rs.next()){
					password=rs.getString("password");
				}
				
	}catch (Exception e) {
		e.printStackTrace();
	}
			return password;
		}
}
