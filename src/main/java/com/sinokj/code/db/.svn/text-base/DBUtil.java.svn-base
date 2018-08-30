package com.sinokj.code.db;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DBUtil {
	private static String driver;
	private static String url;
	private static String user;
	private static String password;
	private static String driver1;
	private static String url1;
	private static String user1;
	private static String password1;
	private static String driver2;
	private static String url2;
	private static String user2;
	private static String password2;
	 
	static {
		try {
			Properties props = ConfigUtil.props;
			/*demo数据库配置*/
			driver = props.getProperty("driver");
			url = props.getProperty("url");
			user = props.getProperty("user");
			password = props.getProperty("password");
			/*sinoeshop数据库配置*/
			driver1 = props.getProperty("jdbc.driverClassName");
			url1 = props.getProperty("jdbc.url");
			user1 = props.getProperty("jdbc.username");
			password1 = props.getProperty("jdbc.password");
			/*卡内*/
			driver2 = props.getProperty("jdbc.driverClassName2");
			url2 = props.getProperty("jdbc.url2");
			user2 = props.getProperty("jdbc.username2");
			password2 = props.getProperty("jdbc.password2");
			 

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}
	public static Connection getConnection() throws Exception {
		Connection connection = null;
		Class.forName(driver);
		connection = DriverManager.getConnection(url, user, password);
		return connection;
	}
    public static Connection getConnectionMysql()throws Exception{
    	Connection connection = null;
		Class.forName(driver1);
		connection = DriverManager.getConnection(url1, user1, password1);
		return connection;
    }
	public static Connection getConnection2() throws Exception {
		Connection connection = null;
		Class.forName(driver2);
		connection = DriverManager.getConnection(url2, user2, password2);
		return connection;
	}
	

	public static void closeConnection(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void closeStatement(Statement stmt) {
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}

	}

	public static void closeResultSet(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}

	}
}
