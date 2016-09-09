package com.learn.dataaccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//Factory design pattern
public class ConnectionFactory {

	
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://spoutedu-cluster-1.cluster-c63gi17267yu.us-west-2.rds.amazonaws.com/spoutdb";
	
	static final String USER_NAME = "webapp";
	static final String PASS = "webapp123";

	private static ConnectionFactory instance = new ConnectionFactory();
	

	private ConnectionFactory(){
		//Register JDBC Driver
		System.out.println("Initilizing JDBC");
		try {
			Class.forName(JDBC_DRIVER);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private  Connection createConnection(){
		Connection connection = null;
        try {
            connection = DriverManager.getConnection(DB_URL, USER_NAME, PASS);
        } catch (SQLException e) {
            System.out.println("ERROR: Unable to Connect to Database.");
        }
        return connection;
	}
	
	public static Connection getConnection() {
		
        return instance.createConnection();
    }
}
