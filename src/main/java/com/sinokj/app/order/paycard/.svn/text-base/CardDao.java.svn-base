package com.sinokj.app.order.paycard;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sinokj.app.order.sale.saleWare.model.SaleWare;
import com.sinokj.code.db.DBUtil;
import com.sinokj.code.util.MD5;

public class CardDao {
	private Connection connection;
	private PreparedStatement stmt;
	private ResultSet rs;
	private CallableStatement callStmt;
	private static final String FIND_SQL = "select * from IC_CardInfo where vcCardno = ? and vcPsw=?";
	private double money = 0;

	public double getMoney() {
		return money;
	}
	/* 验证用户 */
	public boolean valiateCard(String cardno, String cardpd)
			throws SQLException {
		boolean falg = false;
		// 把密码解析为md5
		//if (cardpd.length() != 6) {
			cardpd = MD5.compute(cardno + ":" + cardpd);
		//}
		try {
			connection = DBUtil.getConnection();
			stmt = connection.prepareStatement(FIND_SQL);
			stmt.setString(1, cardno);
			stmt.setString(2, cardpd);
			rs = stmt.executeQuery();
			if (rs.next()) {
				money = rs.getDouble(6);
				falg = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return falg;
	}
	/* 根据orderId号查询订单明细表sale_ware */
	public List<SaleWare> findorderDetailId(String orderId) throws Exception {
		connection = DBUtil.getConnectionMysql();
		stmt = connection.prepareStatement("select ware_id,order_number from sale_ware where sale_id=?");
		stmt.setString(1, orderId);
		rs = stmt.executeQuery();
		List<SaleWare> orderDetail = new ArrayList<SaleWare>();
		while (rs.next()) {
			SaleWare saleWare = new SaleWare();
			saleWare.setWareId(rs.getString(1));
			saleWare.setOrderNumber(rs.getDouble(2));
			orderDetail.add(saleWare);
		}
		return orderDetail;
	}

	/* 根据wareid号在ware表中查询goodid号 */
	public String findGoodId(String wareId) throws Exception {
		String goodId = "";
		connection = DBUtil.getConnectionMysql();
		stmt = connection.prepareStatement("select good_id from ware where id=?");
		stmt.setString(1, wareId);
		rs = stmt.executeQuery();
		if (rs.next()) {
			goodId = rs.getString(1);
		}
		return goodId;
	}

	/* 根据wareid来更新ware表中的库存量stock */
	public void updateStock(String wareId, int number) throws Exception {
		System.out.println(wareId);
		connection = DBUtil.getConnectionMysql();
		stmt = connection
				.prepareStatement("update ware set stock=stock-? where id=?");
		stmt.setInt(1, number);
		stmt.setString(2, wareId);
		stmt.executeUpdate();
	}

	/* 根据商品号在good表中更新totalnumber */
	public void updateNumber(String goodId, int number) throws Exception {
		connection = DBUtil.getConnectionMysql();
		stmt = connection.prepareStatement("update good set total_num=total_num-? where id=?");
		stmt.setInt(1, number);
		stmt.setString(2, goodId);
		stmt.executeUpdate();
	}

	/* 根据订单号更新sale_order中的订单状态 */
	public void updateState(String orderId) throws Exception {
		connection = DBUtil.getConnectionMysql();
		stmt = connection.prepareStatement("update sale_order set payment_state='1',order_state='1' where id=?");
		stmt.setString(1, orderId);
		stmt.executeUpdate();
	}

	/* 更新商品库存量的数据 */
	public void updateWarehouse(String goodId, int number) throws Exception {
		connection = DBUtil.getConnectionMysql();
		stmt = connection.prepareStatement("update warehouse_ware set ware_count=ware_count-? where ware_id=?");
		stmt.setInt(1, number);
		stmt.setString(2, goodId);
		stmt.executeUpdate();
	}
	public void updateCardByState(double money, String cardno, String cardpd,String state)throws Exception{
		connection=DBUtil.getConnection();
		cardpd = MD5.compute(cardno + ":" + cardpd);
		callStmt=connection.prepareCall("{call IC_CardInfo_PayCard (?,?,?,?)}");
		//给存储过程的参数设置值
		callStmt.setDouble(1, money);
		callStmt.setString(2, cardno);
		callStmt.setString(3, cardpd);
		callStmt.setString(4, state);
		//执行存储过程
		callStmt.execute();
		connection.close();
	}
}
