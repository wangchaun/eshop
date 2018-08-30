package com.sinokj.app.baseInfo.payment.action;

import com.sinokj.app.baseInfo.payment.model.Payment;
import com.sinokj.app.baseInfo.payment.service.PaymentService;
import com.sinokj.app.system.user.model.SysUser;
import com.sinokj.code.struct.BaseAction;
import com.sinokj.code.util.PageInfo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

public class PaymentAction extends BaseAction {
	private static final long serialVersionUID = 7519735437267228896L;
	private static final Logger logger = Logger.getLogger(PaymentAction.class);
	private PaymentService paymentService;
	private Payment payment;

	public void setPaymentService(PaymentService paymentService) {
		this.paymentService = paymentService;
	}

	public String listJson() {
		logger.info("start list all payment data!");
		List resultList = null;
		int totalRows = 0;
		try {
			PageInfo pageInfo = createPageInfo();
			resultList = this.paymentService.pageList(pageInfo, this.payment,
					true);
			totalRows = pageInfo.getCount();
		} catch (Exception e) {
			logger.error("error occur when list payment data!", e);
		}
		if (resultList == null) {
			resultList = new ArrayList();
		}

		this.jsonMap = new HashMap();
		this.jsonMap.put("total", Integer.valueOf(totalRows));
		this.jsonMap.put("rows", resultList);

		logger.info("finish list all payment data!");
		return "success";
	}

	public String list() {
		return "list_payment";
	}

	public String edit() {
		try {
			logger.info("start to query payment data!");
			SysUser loginMan = getSessionUserInfo();
			if (this.payment == null) {
				this.payment = new Payment();
			}
			String id = this.payment.getId();
			if (StringUtils.isBlank(id)) {
				super.initModel(true, this.payment, loginMan);
			} else {
				this.payment = ((Payment) this.paymentService.getModel(id));
				super.initModel(false, this.payment, loginMan);
			}
		} catch (Exception e) {
			logger.info("error occur when quering DeliveryWay data!");
			e.printStackTrace();
		}
		logger.info("finish quering payment data!");
		return "edit_payment";
	}

	public void save() {
		try {
			String id = this.payment.getId();

			if (StringUtils.isBlank(id))
				this.paymentService.insert(this.payment);
			else {
				this.paymentService.update(this.payment);
			}
			responseFlag(true);
		} catch (Exception e) {
			responseFlag(false);
			logger.error("error occur when save model!", e);
		}
	}

	public void delete() {
		SysUser loginMan = getSessionUserInfo();

		String id = this.payment.getId();
		logger.info("delete DeliveryWay,id:" + id);
		try {
			String[] idArr = id.split(",");
			for (String idStr : idArr) {
				this.paymentService.delete(idStr);
			}
			logger.info(loginMan.getCode() + " delete DeliveryWay,id:" + id);
			responseFlag(true);
		} catch (Exception e) {
			responseFlag(false);
			logger.info("error occur when " + loginMan.getCode()
					+ " delete DeliveryWay,id:" + id, e);
		}
	}

	public void isCodeExisted() {
		boolean isCodeExisted = true;

		String id = this.payment.getId();
		String code = this.payment.getCode();
		logger.info("check isCodeExisted,code:" + code + ";id:" + id);
		try {
			Payment way = this.paymentService.getPayment(this.payment);
			if (way == null) {
				isCodeExisted = false;
			} else if (id.equals(way.getId()))
				isCodeExisted = false;
			else {
				isCodeExisted = true;
			}

			logger.info("check isCodeExisted result:" + isCodeExisted);
			responseFlag(isCodeExisted);
		} catch (Exception e) {
			logger.error("error occur when check isCodeExisted!", e);
		}
	}

	public Payment getPayWay() {
		return this.payment;
	}

	public void setPayWay(Payment payWay) {
		this.payment = payWay;
	}

	public Payment getPayment() {
		return this.payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}
}