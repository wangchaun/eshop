package com.sinokj.app.order.paycard;

import java.sql.SQLException;
import java.util.List;

import com.sinokj.app.order.sale.saleWare.model.SaleWare;

public class CardService {
	private double money = 0;
	private CardDao cardDao;
	private boolean falg = false;

	public double getMoney() {
		return money;
	}
    /*验证身份*/
	public boolean confimeatin(String cardno, String cardpd) {
		cardDao = new CardDao();
		try {
			falg = cardDao.valiateCard(cardno, cardpd);
			money = cardDao.getMoney();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

		return falg;
	}
    /*更新表记录*/
	public void updateCardinfo(double money, String cardno, String cardpd) {
		try {
			cardDao = new CardDao();
			cardDao.updateCardByState(money, cardno, cardpd, "支付");
		} catch (Exception e) {
			e.printStackTrace();
		} 

	}
	/*更新ware和good表中的商品数量*/
	public void updategoodNumber(String saleOrder){
		cardDao = new CardDao();
		try {
			List<SaleWare>details=cardDao.findorderDetailId(saleOrder);
			for(SaleWare saleWare:details){
				cardDao.updateStock(saleWare.getWareId(),(saleWare.getOrderNumber()).intValue());
				cardDao.updateWarehouse(saleWare.getWareId(),(saleWare.getOrderNumber()).intValue());
				String goodId=cardDao.findGoodId(saleWare.getWareId());
			    cardDao.updateNumber(goodId, (saleWare.getOrderNumber()).intValue());
			}
			cardDao.updateState(saleOrder);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/*退还或取消*/
	public void returnCardinfo(double money, String cardno) {
		cardDao = new CardDao();
		try {
			cardDao.updateCardByState(money, cardno, "", "退回");
		} catch (Exception e) {
			e.printStackTrace();
		} 

	}
	
}
