package com.sinokj.app.good.phone;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import net.sourceforge.jtds.jdbc.DateTime;

import com.sinokj.app.good.goodSpecification.model.GoodSpecificationVal;
import com.sinokj.code.db.DBUtil;

public class PhoneDao {
	private Connection connection;
	private PreparedStatement stmt;
	private ResultSet rs;

	private static final String findAll = "select id,value from good_specification_val where good_specification_id in("
			+ "select id from good_specification where name='选择版号')";
	private static final String findByName = "select  ware_id from ware_specification_val "
			+ "where good_specification_val_id in ( select id from good_specification_val where value=?)";
	private static final String ff="select modify_time from phone where id=?";

	public List<GoodSpecificationVal> getRevesion() {
		List<GoodSpecificationVal> revesions = new ArrayList<GoodSpecificationVal>();
		try {
			connection = DBUtil.getConnectionMysql();
			stmt = connection.prepareStatement(findAll);
			rs = stmt.executeQuery();
			GoodSpecificationVal val;
			while (rs.next()) {
				val=new GoodSpecificationVal();
				val.setId(rs.getString(1));
				val.setValue(rs.getString(2));
				revesions.add(val);
			}
			return revesions;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String getByRevesion(String name) {
		try {
			connection = DBUtil.getConnectionMysql();
			stmt = connection.prepareStatement(findByName);
			stmt.setString(1, name);
			rs = stmt.executeQuery();
			if(rs.next()){
				return rs.getString(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
