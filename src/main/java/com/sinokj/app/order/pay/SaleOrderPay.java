package com.sinokj.app.order.pay;

public class SaleOrderPay {
	private int id;
	private int credit;
	private String orderCode;
	private String vcCardNo;
	private String type;
	private double money;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}

	public String getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

	public String getVcCardNo() {
		return vcCardNo;
	}

	public void setVcCardNo(String vcCardNo) {
		this.vcCardNo = vcCardNo;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	public SaleOrderPay(int credit, String vcCardNo, String type, double money) {
		super();
		this.credit = credit;
		this.vcCardNo = vcCardNo;
		this.type = type;
		this.money = money;
	}

}
