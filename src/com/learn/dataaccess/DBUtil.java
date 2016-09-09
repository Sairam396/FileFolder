package com.learn.dataaccess;

import java.sql.*;

public class DBUtil {

	public void closeConnection(Connection con, ResultSet rs ,Statement st, PreparedStatement pst){
		System.out.println("close connection");
		
		try {
			if(rs!=null)
			rs.close();
			
			if(pst!=null)
			pst.close();
			
			if(st!=null)
			st.close();
			
			if(con!=null)
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
}