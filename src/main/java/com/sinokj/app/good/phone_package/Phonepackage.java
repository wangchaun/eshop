package com.sinokj.app.good.phone_package;

import java.io.Serializable;

import com.sinokj.code.bean.Base;

public class Phonepackage extends Base implements Serializable{

	private static final long serialVersionUID = 1L;
	private String packagephone;
	private String countryflow;
	private String calltime;
	private String pmessage;
	private String prepaid;
	private String networkphone;
	private String freearea;
	private String overpackagefree;
	private String prepaidforphone;
	private String wareId;
	private String packagetypephone;
	
	public String getWareId() {
		return wareId;
	}

	public void setWareId(String wareId) {
		this.wareId = wareId;
	}
	public String getCountryflow() {
		return countryflow;
	}

	public void setCountryflow(String countryflow) {
		this.countryflow = countryflow;
	}

	public String getCalltime() {
		return calltime;
	}

	public void setCalltime(String calltime) {
		this.calltime = calltime;
	}

	public String getPmessage() {
		return pmessage;
	}

	public void setPmessage(String pmessage) {
		this.pmessage = pmessage;
	}

	public String getPrepaid() {
		return prepaid;
	}

	public void setPrepaid(String prepaid) {
		this.prepaid = prepaid;
	}

	public String getNetworkphone() {
		return networkphone;
	}

	public void setNetworkphone(String networkphone) {
		this.networkphone = networkphone;
	}

	public String getFreearea() {
		return freearea;
	}

	public void setFreearea(String freearea) {
		this.freearea = freearea;
	}

	public String getOverpackagefree() {
		return overpackagefree;
	}

	public void setOverpackagefree(String overpackagefree) {
		this.overpackagefree = overpackagefree;
	}

	public String getPrepaidforphone() {
		return prepaidforphone;
	}

	public void setPrepaidforphone(String prepaidforphone) {
		this.prepaidforphone = prepaidforphone;
	}

	public String getPackagephone() {
		return packagephone;
	}

	public void setPackagephone(String packagephone) {
		this.packagephone = packagephone;
	}

	public String getPackagetypephone() {
		return packagetypephone;
	}

	public void setPackagetypephone(String packagetypephone) {
		this.packagetypephone = packagetypephone;
	}

}
