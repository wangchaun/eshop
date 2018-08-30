package com.sinokj.app.good.phone_package;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;

import com.sinokj.app.good.good.model.Good;
import com.sinokj.app.good.good.service.GoodService;
import com.sinokj.app.good.ware.model.Ware;
import com.sinokj.app.good.ware.service.WareService;
import com.sinokj.app.store.advertise.model.Advertise;
import com.sinokj.app.store.advertise.service.AdvertiseService;
import com.sinokj.app.store.information.model.Information;
import com.sinokj.app.store.information.service.InformationService;
import com.sinokj.code.struct.BaseAction;
import com.sinokj.code.util.PageInfo;

public class PhonepackageAction extends BaseAction {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(PhonepackageAction.class);
	private Phonepackage phonepackage;
	private PhonepackageService phonepackageService;
	private String wareId;
 
	private Good good;
	private Ware ware;
	private GoodService goodService;
	private WareService wareService;
 
	

	public String phonepackage_json() {
		
		logger.info("start list phonespackage!");
		List<Phonepackage> phonespackage = null;
		int totalRows = 0;
		try {
			PageInfo pageInfo = createPageInfo();

			if (this.phonepackage == null) {
				this.phonepackage = new Phonepackage();
			}
			if (this.ware == null) {
				this.ware = new Ware();
			}
			
			String countryflow = this.phonepackage.getCountryflow();
			String packagetypephone = this.phonepackage.getPackagetypephone();
			String calltime = this.phonepackage.getCalltime();
			String pmessage = this.phonepackage.getPmessage();
			String prepaid = this.phonepackage.getPrepaid();
			String networkphone = this.phonepackage.getNetworkphone();
			String freearea = this.phonepackage.getFreearea();
			String overpackagefree = this.phonepackage.getOverpackagefree();
			String prepaidforphone = this.phonepackage.getPrepaidforphone();
			String packagephone = this.phonepackage.getPackagephone();
			
			phonepackage.setWareId(wareId);
			phonepackage.setPackagetypephone(packagetypephone);
			phonepackage.setCountryflow(countryflow);
			phonepackage.setCalltime(calltime);
			phonepackage.setPmessage(pmessage);
			phonepackage.setPrepaid(prepaid);
			phonepackage.setNetworkphone(networkphone);
			phonepackage.setFreearea(freearea);
			phonepackage.setOverpackagefree(overpackagefree);
			phonepackage.setPrepaidforphone(prepaidforphone);
			phonepackage.setPackagephone(packagephone);
			phonespackage = this.phonepackageService.pageList(pageInfo, this.phonepackage, true);
			totalRows = pageInfo.getCount();

		} catch (Exception e) {
			e.printStackTrace();
			logger.error("error occur when list phonespackage", e);
		}
		if (phonespackage == null) {
			phonespackage = new ArrayList<Phonepackage>();
		}
		this.jsonMap = new HashMap<String, Object>();
		this.jsonMap.put("total", Integer.valueOf(totalRows));
		this.jsonMap.put("rows", phonespackage);
		 
		logger.info("finish list all data!");
		return "success";
	}
    
	public String selectPhonepackage() {
		
		//this.informationList = this.informationService.select(new Information());
		if (this.ware == null) {
			this.ware = new Ware();
		}
		String goodId = this.good.getId();
		String wareId = this.ware.getId();
		String calltime=this.phonepackage.getCalltime();
		this.good = new Good();
		this.good.setId(goodId);
		List<Good> listgood = this.goodService.select("Good.Good_SY", this.good);

		if ((listgood != null) && (listgood.size() > 0))
			this.good = ((Good) listgood.get(0));
		this.ware = ((Ware) this.wareService.getModel(wareId));
		this.phonepackage=((Phonepackage)this.phonepackageService.getModel(calltime));
		//this.advertiseList = this.advertiseService.getAdvertiseList();
		return "selectPhonepackage";
	}

	public void setPhonepackageService(PhonepackageService phonepackageService) {
		this.phonepackageService = phonepackageService;
	}

	public Phonepackage getPhonepackage() {
		return phonepackage;
	}

	public void setPhonepackage(Phonepackage phonepackage) {
		this.phonepackage = phonepackage;
	}


	public Good getGood() {
		return good;
	}

	public void setGood(Good good) {
		this.good = good;
	}

	public Ware getWare() {
		return ware;
	}

	public void setWare(Ware ware) {
		this.ware = ware;
	}

	public GoodService getGoodService() {
		return goodService;
	}

	public void setGoodService(GoodService goodService) {
		this.goodService = goodService;
	}

	public WareService getWareService() {
		return wareService;
	}

	public void setWareService(WareService wareService) {
		this.wareService = wareService;
	}


	public String getWareId() {
		return wareId;
	}

	public void setWareId(String wareId) {
		this.wareId = wareId;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public static Logger getLogger() {
		return logger;
	}

	public PhonepackageService getPhonepackageService() {
		return phonepackageService;
	}
	
}
