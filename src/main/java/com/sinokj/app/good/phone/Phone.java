package com.sinokj.app.good.phone;

import java.io.Serializable;

import com.sinokj.code.bean.Base;

public class Phone extends Base implements Serializable{

	private static final long serialVersionUID = 1L;
	private String id;
	private String telphone;
	private String isBuy;
	private String wareId;
	private Double price;
	private String phoneFee;
	
    
	public String getPhoneFee() {
		return phoneFee;
	}

	public void setPhoneFee(String phoneFee) {
		this.phoneFee = phoneFee;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTelphone() {
		return telphone;
	}

	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}

	public String getIsBuy() {
		return isBuy;
	}

	public void setIsBuy(String isBuy) {
		this.isBuy = isBuy;
	}

	public String getWareId() {
		return wareId;
	}

	public void setWareId(String wareId) {
		this.wareId = wareId;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

}
