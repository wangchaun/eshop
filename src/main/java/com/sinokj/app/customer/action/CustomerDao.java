package com.sinokj.app.customer.action;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.sinokj.code.db.DBUtil;

public class CustomerDao {
	private Connection connection;
	private PreparedStatement stmt;
	private ResultSet rs;
	private static final String STATE_SQL = "select vcState from AMS_WEB_Custom where  vccustNO=?";

	public String getState(String name) throws Exception{
		 
			connection = DBUtil.getConnection2();
			stmt = connection.prepareStatement(STATE_SQL);
			stmt.setString(1, name);
			rs=stmt.executeQuery();
			if(rs.next()){
				String temp=rs.getString(1).trim();	
				return temp;
			}
		    return "2";
	}
}
