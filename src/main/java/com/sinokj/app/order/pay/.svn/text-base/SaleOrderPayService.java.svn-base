package com.sinokj.app.order.pay;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import sun.util.logging.resources.logging;

import com.sinokj.app.customer.model.Customer;
import com.sinokj.app.customer.service.CustomerService;
import com.sinokj.app.order.paycard.CardService;
import com.sinokj.code.service.BaseService;
import com.sinokj.code.util.CreditUtil;

public class SaleOrderPayService  {
	private SaleOrderPayDao dao;
	private CardService cardService;
	
    /*增加记录*/
	public void create(double jd, double cardMoney, double summoney,ArrayList<String> cards, String orderCode) {
		double flag=summoney-(jd+cardMoney);
		if (jd != 0.0) {
			addCredit(orderCode, (int) (jd * CreditUtil.getMinMoney()), jd);
		}
		if (cardMoney != 0.0) {
			cardService=new CardService();
			double temp = summoney - jd;
			for (String card : cards) {
				String[] keys = card.split(",");
				cardService.confimeatin(keys[0].trim(), keys[1].trim());
				if (0 == temp)
					break;
				if (temp >= cardService.getMoney()) {
					temp -= cardService.getMoney();
					cardService.updateCardinfo(cardService.getMoney(), keys[0].trim(), keys[1].trim());
					addCard(orderCode,keys[0],cardService.getMoney());
				} else {
					cardService.updateCardinfo(temp, keys[0].trim(), keys[1].trim());
					addCard(orderCode,keys[0],temp);
					temp = 0;
				}
			}

	   }
	   if(flag>0.0){
		   addPay(orderCode, flag);
	   }else{
		   
	   }
	   
	}
	/*前台用户取消订单退还记录表*/
	public void returnPays(String saleCode,Customer customer)throws Exception{
		dao=new SaleOrderPayDao();
		List<SaleOrderPay>pays=dao.findAllByOrderCode(saleCode.trim());
		cardService=new CardService();
		 
		for(SaleOrderPay pay:pays){
			 
			if(pay.getType().trim().equals("一卡通支付")){
				cardService.returnCardinfo(pay.getMoney(), pay.getVcCardNo());
			}
			else if(pay.getType().trim().equals("积分支付")){
			    updateCredit(customer.getId(), pay.getCredit());
			}
		}
	}
	/*后台管理员退还记录表*/
	public void returnPays(String saleCode,Customer customer,double money)throws Exception{
		dao=new SaleOrderPayDao();
		List<SaleOrderPay>pays=dao.findAllByOrderCode(saleCode.trim());
		cardService=new CardService();
		 
		for(SaleOrderPay pay:pays){
			 
			if(pay.getType().trim().equals("一卡通支付")){
				cardService.returnCardinfo(pay.getMoney(), pay.getVcCardNo());
			}else if(pay.getType().trim().equals("积分支付")){
			    updateCredit(customer.getId(), pay.getCredit()-CreditUtil.getCredit1(money));
			}
		}
	}
	public void addCredit(String orderCode, int credit, double money) {
		dao=new SaleOrderPayDao();
		dao.addCredit(orderCode, credit, money);
	}

	public void addPay(String orderCode, double money) {
		dao=new SaleOrderPayDao();
		dao.addPay(orderCode, money);
	}

	public void addCard(String orderCode, String vccardno, double money) {
		dao=new SaleOrderPayDao();
		dao.addCard(orderCode, vccardno, money);
	}
	public void updateCredit(String id,int credit){
		dao=new SaleOrderPayDao();
		dao.updateCredit(id, credit);
	}

}
