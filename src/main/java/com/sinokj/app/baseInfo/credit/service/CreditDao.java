package com.sinokj.app.baseInfo.credit.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sinokj.app.baseInfo.credit.model.Credit;
import com.sinokj.code.db.DBUtil;

public class CreditDao {
	private static final String find = "select * from credit where memo=1 ";
	private static final String findAll = "select * from credit where memo=0 ";
	private Connection connection;
	private PreparedStatement stmt;
	private ResultSet rs;

	public double getCreditMoney() {
		try {
			connection = DBUtil.getConnectionMysql();
			stmt = connection.prepareStatement(find);
			rs = stmt.executeQuery();
			if (rs.next()) {
				double money = rs.getDouble(2);
				int credit = rs.getInt(4);
				return money / credit;
			}
		} catch (Exception e) {

			e.printStackTrace();
		}
		return 0;
	}
	public int getMinMoney() {
		try {
			connection = DBUtil.getConnectionMysql();
			stmt = connection.prepareStatement(find);
			rs = stmt.executeQuery();
			if (rs.next()) {
				int credit = rs.getInt(4);
				return credit;
			}
		} catch (Exception e) {

			e.printStackTrace();
		}
		return 0;
	}

	public List<Credit> getCredits() {
		try {
			connection = DBUtil.getConnectionMysql();
			stmt = connection.prepareStatement(findAll);
			rs = stmt.executeQuery();
			List<Credit> credits = new ArrayList<Credit>();
			Credit credit;
			while (rs.next()) {
				credit = new Credit();
				credit.setMinMoney(rs.getDouble(2));
				credit.setMaxMoney(rs.getDouble(3));
				credit.setCreditNum(rs.getInt(4));
				credits.add(credit);
			}
			return credits;
		} catch (Exception e) {

			e.printStackTrace();
		}
		return null;
	}
}
