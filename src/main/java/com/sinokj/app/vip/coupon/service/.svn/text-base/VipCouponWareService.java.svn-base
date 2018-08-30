package com.sinokj.app.vip.coupon.service;

import com.sinokj.app.vip.coupon.model.VipCouponWare;
import com.sinokj.code.service.BaseService;

import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;

public class VipCouponWareService extends BaseService<VipCouponWare> {
	public void deleteByIntoId(String intoId) throws Exception {
		if (StringUtils.isBlank(intoId)) {
			throw new Exception("intoId is null");
		}
		Map<String,String> param = new HashMap<String,String>();
		param.put("vipCouponId", intoId);
		this.publicDAO.delete("VipCouponWare.VipCouponWare", param);
	}
}