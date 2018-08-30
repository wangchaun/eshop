package com.sinokj.app.order.paycard;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.sinokj.app.customer.model.Customer;
import com.sinokj.app.customer.service.CustomerService;
import com.sinokj.app.good.phone.Phone;
import com.sinokj.app.good.phone.PhoneService;
import com.sinokj.app.order.sale.saleOrder.model.SaleOrder;
import com.sinokj.app.order.sale.saleOrder.service.SaleOrderService;
import com.sinokj.code.struct.BaseAction;
import com.sinokj.code.util.CreditUtil;
import com.sinokj.code.util.NumberUtil;

public class CardAction extends BaseAction {
	private SaleOrderService saleOrderService;
	private SaleOrder saleOrder;
	private CardService cardService;
	private static final Logger logger = Logger.getLogger(CardAction.class);
	private PhoneService phoneService;
	private Phone phone;
	private Customer customer;
	private CustomerService customerService;

	/* 首先验证支付表单 */
	public void getZfbPayError() {
		HttpServletRequest request = getRequest();
		String orderId = request.getParameter("orderId");
		
		if (orderId != null) {
			SaleOrder saleOrder = (SaleOrder) this.saleOrderService.getModel(orderId);

			if (saleOrder != null) {
				Double orderMoney = saleOrder.getOrderMoney();
				String price = "0";
				if (orderMoney != null) {
					price = NumberUtil.double2Str(orderMoney);
				}
				responseFlag(true);
			} else
				responseFlag("订单为空");
		} else {
			responseFlag("订单Id为空");
		}
	}

	/* 跳转到支付页面 */
	public String payCard() {
		
		HttpServletRequest request = getRequest();
		String orderId = request.getParameter("orderId");
		this.saleOrder = (SaleOrder) this.saleOrderService.getModel(orderId);
		return "paycard";
	}

	/* 持一卡通身份验证及支付 */
	public void confirmation() throws Exception{
		//Thread.sleep(5000);
		HttpServletRequest request = getRequest();
		boolean falg=false;
		/* 三个参数值 */
		this.customer = getSessionCustomerInfo();
		String orderId = request.getParameter("orderId");
		String cardpd = request.getParameter("pwd");
		String cardno = request.getParameter("cardno");
	    String[]cardnos=cardno.split(",");
	    String[]cardpds=cardpd.split(",");
		SaleOrder saleOrder = (SaleOrder) this.saleOrderService.getModel(orderId);
		/*验证订单备注是否为空*/
		if(saleOrder.getRemark()!=null){
		 String remark[]=saleOrder.getRemark().split(",");
		 String telphone=remark[1].substring(4);
		 
		  if(this.phone==null){
			this.phone=new Phone();
		  }
		this.phone.setTelphone(telphone);
		this.phone=this.phoneService.select(this.phone).get(0);
		this.phone.setIsBuy("y");
		falg=true;
		}
		double ordermoney = saleOrder.getOrderMoney();
   
		cardService = new CardService();
		try {
			double money=0;
			boolean falg2=false;

			/******一卡通账户验证通过*****/
			for(int i=0;i<cardnos.length;i++){ 
		        falg2 = cardService.confimeatin(cardnos[i].trim(), cardpds[i].trim());
		        if(!falg2){
		        	break;
		        }
		        money=money+cardService.getMoney();
			}
			/*******一卡通开始支付*****/
			if(falg2){
				if(ordermoney>money){
					responseFlag("money");
				}else{
					 
					double temp=ordermoney;
					for(int i=0;i<cardnos.length;i++){
						cardService.confimeatin(cardnos[i].trim(), cardpds[i].trim());
						if(0==temp)break;
						if(temp>=cardService.getMoney()){
							temp-=cardService.getMoney();
							cardService.updateCardinfo(cardService.getMoney(), cardnos[i].trim(),cardpds[i].trim());
						}else {
							cardService.updateCardinfo(temp, cardnos[i].trim(),cardpds[i].trim());
							temp=0;
						}
					}					
					cardService.updategoodNumber(orderId);
					this.customer.setCredit(this.customer.getCredit()+CreditUtil.getCredit1(ordermoney));
					this.customerService.update(this.customer);
					if(falg){
					  phoneService.update(this.phone);
					}
					responseFlag(true);
				}
			}else{
				responseFlag("pwd");
			}
		} catch (Exception e) {
			responseFlag("false");
			e.printStackTrace();
		}

	}

	public CardService getCardService() {
		return cardService;
	}

	public void setCardService(CardService cardService) {
		this.cardService = cardService;
	}

	public Phone getPhone() {
		return phone;
	}

	public void setPhone(Phone phone) {
		this.phone = phone;
	}

	public SaleOrderService getSaleOrderService() {
		return saleOrderService;
	}

	public CustomerService getCustomerService() {
		return customerService;
	}

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	public PhoneService getPhoneService() {
		return phoneService;
	}

	public void setPhoneService(PhoneService phoneService) {
		this.phoneService = phoneService;
	}

	public SaleOrder getSaleOrder() {
		return saleOrder;
	}

	public void setSaleOrder(SaleOrder saleOrder) {
		this.saleOrder = saleOrder;
	}

	public void setSaleOrderService(SaleOrderService saleOrderService) {
		this.saleOrderService = saleOrderService;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
}
