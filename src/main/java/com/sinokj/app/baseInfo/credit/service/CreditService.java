package com.sinokj.app.baseInfo.credit.service;

import java.util.List;

import com.sinokj.app.baseInfo.credit.model.Credit;
import com.sinokj.code.service.BaseService;

public class CreditService extends BaseService<Credit> {

	public Credit credit;

	/* 根据设定的积分和金额数来计算单位 */
	public double getCreditMoney() {
		if (this.credit == null) {
			credit = new Credit();
		}
		credit.setMemo("0");
		credit = (Credit) selectOne(credit);
		double temp = credit.getCreditNum() / credit.getMinMoney();
		return temp;
	}

	/* 根据订单金额数目得到相应的积分 */
	public List<Credit> getCredits() {
		if (this.credit == null) {
			credit = new Credit();
		}
		credit.setMemo("1");
		List<Credit> credits = select(credit);
		return credits;
	}

	public static void main(String[] args) {
		System.out.println(new CreditService().getCredits().size());
	}

}
