package com.sinokj.code.util;
import java.util.List;

import com.sinokj.app.baseInfo.credit.model.Credit;
import com.sinokj.app.baseInfo.credit.service.CreditDao;
public class CreditUtil {
	public  static CreditDao dao=new CreditDao();
	public static Integer getCredit1(double orderMoney) {
		Integer  temp = 0;
		List<Credit>credits=dao.getCredits();
		for(Credit credit:credits){
			if(orderMoney>=credit.getMinMoney()&&orderMoney<=credit.getMaxMoney()){
				temp=credit.getCreditNum();
				break;
			}
		} 
		return temp;
	}
	public static double getUnit(){
		return dao.getCreditMoney();
	}
	public static double  getMinMoney(){
		return dao.getMinMoney();
	}
	 
}
