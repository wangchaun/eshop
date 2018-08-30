package com.sinokj.app.order.pay;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.sinokj.code.db.DBUtil;

public class SaleOrderPayDao {
	private Connection conn;
	private PreparedStatement statement;
    private ResultSet rs;
	private static final String add_creditsql = "insert into sale_order_pay (orderCode,type,credit ,money,starttime)values(?,'积分支付',?,?,GETDATE())";
	private static final String add_paysql = "insert into sale_order_pay (orderCode,type,money,startTime)values(?,'乾付宝支付',?,GETDATE())";
	private static final String add_cardsql = "insert into sale_order_pay (orderCode,type,vccardno ,money,starttime)values(?,'一卡通支付',?,?,GETDATE())";
    private static final String findAll="select type,vccardno,credit,money from sale_order_pay where orderCode=?";
	private static final String updateCredit="update customer set credit=credit+? where id=?";
    
    public void addCredit(String ordercode, int credit, double money) {
		try {
			conn = DBUtil.getConnectionMysql();
			statement = conn.prepareStatement(add_creditsql);
			statement.setString(1, ordercode);
			statement.setInt(2, credit);
			statement.setDouble(3, money);
			statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addPay(String orderCode, double money) {
		try {
			conn = DBUtil.getConnectionMysql();
			statement = conn.prepareStatement(add_paysql);
			statement.setString(1, orderCode);
			statement.setDouble(2, money);
			statement.executeUpdate();
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public void addCard(String orderCode, String vccardno, double money) {
		try {
			conn = DBUtil.getConnectionMysql();
			statement = conn.prepareStatement(add_cardsql);
			statement.setString(1, orderCode);
			statement.setString(2, vccardno);
			statement.setDouble(3, money);
			statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public List<SaleOrderPay>findAllByOrderCode(String code){
		try {
			conn = DBUtil.getConnectionMysql();
			statement=conn.prepareStatement(findAll);
			statement.setString(1, code);
			rs=statement.executeQuery();
			List<SaleOrderPay>pays=new ArrayList<SaleOrderPay>();
			SaleOrderPay saleOrderPay;
			while(rs.next()){
				saleOrderPay=new SaleOrderPay(rs.getInt(3),rs.getString(2),rs.getString(1),rs.getDouble(4));
				pays.add(saleOrderPay);
			}
			return pays;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public void updateCredit(String id,int credit){
		try {
			conn = DBUtil.getConnectionMysql();
			statement = conn.prepareStatement(updateCredit);
			statement.setInt(1,credit);
		    statement.setString( 2, id);
		    statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
