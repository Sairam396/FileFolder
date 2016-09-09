package com.learn.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.learn.dataaccess.ConnectionFactory;
import com.learn.dataaccess.DBUtil;
import com.learn.dto.User;

public class UserDAO {

	private Connection con;
	private PreparedStatement pst;
	private Statement st;
	private ResultSet rs;
	
    //All CRUD operations
	public User createUser(User user) throws Exception {

		String sql = "INSERT INTO Users (firstName, lastName, userName, password, email, phone,"
				+ "address1,address2,city,state,zip) " + "VALUES (?, ?, ?, ?,?,?,?,?,?,?,?)";
		try {
			
			con = ConnectionFactory.getConnection();
			System.out.println("connection ==>" + con);
			pst = con.prepareStatement(sql);
			
			setStatement(pst, user);
			
			int rowsInserted = pst.executeUpdate();
			if (rowsInserted >= 0)
				System.out.println("Rows inserted " + rowsInserted);
			;
		} catch (SQLException ex) {
			ex.printStackTrace();
			throw ex;
		}catch (Exception exception) {
			throw exception;
		}
		finally {
			new DBUtil().closeConnection(con, rs, st, pst);
		}

		return user;
	}

	public User updateUser(User user) {
		return user;
	}

	public Boolean deleteUser() {
		return true;
	}

	public User getUser(String userName, String password) {
		System.out.println("Retrieving user with user name-->" +"'"+userName+"'");
		User user = null;
		
		String sql = "select * from Users where userName ="+"'"+userName+"'"+" and "+"password="+"'"+password+"'";
		System.out.println("Get User -->" + sql);
		con = ConnectionFactory.getConnection();
		try {
			st = con.createStatement();
			rs= st.executeQuery(sql);
			while(rs.next()){
				user = new User();
				getUser(rs, user);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch(Exception ex){
			ex.printStackTrace();
		} finally{
			new DBUtil().closeConnection(con, rs, st, pst);
		}
		
		return user;
	}

	public User getUserByUserName(String userName) {
		System.out.println("Retrieving user with user name-->" +"'"+userName+"'");
		User user = null;
		
		String sql = "select * from Users where userName ="+"'"+userName+"'";
		System.out.println("Get User -->" + sql);
		con = ConnectionFactory.getConnection();
		try {
			st = con.createStatement();
			rs= st.executeQuery(sql);
			while(rs.next()){
				user = new User();
				getUser(rs, user);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch(Exception ex){
			ex.printStackTrace();
		} finally{
			new DBUtil().closeConnection(con, rs, st, pst);
		}
		
		return user;
	}
	
	public Boolean isUserExistedAlready(String userName) {
		
		Boolean isUserExisted = false;
		String sql = "select * from user where userName ="+","+userName+",";
		
		con = ConnectionFactory.getConnection();
		try {
			st = con.createStatement();
			rs= st.executeQuery(sql);
			if(rs!=null){
				isUserExisted= true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isUserExisted;
	}

	private PreparedStatement setStatement(PreparedStatement pst, User user) throws SQLException {
		pst.setString(0, user.getId());
		pst.setString(1, user.getFirstName());
		pst.setString(2, user.getLastName());
		pst.setString(3, user.getUserName());
		pst.setString(4, user.getPassword());
		pst.setString(5, user.getEmail());
		pst.setString(6, user.getPhone());
		pst.setString(7, user.getAddress1());
		pst.setString(8, user.getAddress2());
		pst.setString(9, user.getCity());
		pst.setString(10, user.getState());
		pst.setInt(11, user.getZip());

		return pst;
	}
	
	private User getUser(ResultSet rs,User user) throws SQLException{
		
		user.setId(rs.getString(0));
		user.setFirstName(rs.getString(1));
		user.setLastName(rs.getString(2));
		user.setUserName(rs.getString(3));
		user.setEmail(rs.getString(5));
		user.setPhone(rs.getString(6));
		user.setAddress1(rs.getString(7));
		user.setAddress2(rs.getString(8));
		user.setCity(rs.getString(9));
		user.setState(rs.getString(10));
		user.setZip(rs.getInt(11));
		System.out.println(user.toString());
		return user;
	}

}
