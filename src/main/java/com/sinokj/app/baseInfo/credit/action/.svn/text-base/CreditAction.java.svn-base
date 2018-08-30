package com.sinokj.app.baseInfo.credit.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.aspectj.weaver.patterns.ThisOrTargetAnnotationPointcut;

import com.sinokj.app.baseInfo.area.model.Area;
import com.sinokj.app.baseInfo.credit.model.Credit;
import com.sinokj.app.baseInfo.credit.service.CreditService;
import com.sinokj.app.order.paycard.CardAction;
import com.sinokj.code.struct.BaseAction;
import com.sinokj.code.util.ConfigUtil;
import com.sinokj.code.util.PageInfo;

public class CreditAction extends BaseAction {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(CardAction.class);
	private CreditService creditService;
	private Credit credit;

	public String list() {
		String maxLevel = ConfigUtil.getAreaLevel();
		getRequest().setAttribute("maxLevel", maxLevel);
		return "list_credit";
	}

	public String listJson() {
		if (this.credit == null) {
			this.credit = new Credit();
		}
		List<Credit> resultList = null;
		int totalRows = 0;
		try {

			PageInfo pageInfo = createPageInfo();
			resultList = this.creditService.pageList(pageInfo, this.credit,true);
			totalRows = pageInfo.getCount();
		} catch (Exception e) {
			logger.error("error occur when list data!", e);
		}
		if (resultList == null) {
			resultList = new ArrayList<Credit>();
		}

		this.jsonMap = new HashMap();
		this.jsonMap.put("total", Integer.valueOf(totalRows));
		this.jsonMap.put("rows", resultList);
		logger.info("finish list all data!");
		return "success";
	}

	public void save() {
		try {
			if (this.credit == null) {
				this.credit = new Credit();
			}
 
			if (StringUtils.isNotBlank(this.credit.getId())) {
				this.creditService.update(this.credit);
			} else {
				String id = this.creditService.makeId();
				this.credit.setId(id);
				this.credit.setMemo("0");
				this.creditService.insert(this.credit);
			}
			responseFlag(true);
		} catch (Exception e) {
			e.printStackTrace();
			responseFlag(false);
		}
	}

	public String edit() {
		if (this.credit == null) {
			this.credit = new Credit();
		}
		if (StringUtils.isNotBlank(this.credit.getId())) {
			this.credit = (Credit) this.creditService.getModel(this.credit.getId());
		}
		if (this.credit == null) {
			this.credit = new Credit();
		}
		return "edit_credit";
	}

	public void delete() {
		try {
			logger.info("start to delete area information");
			if (this.credit == null) {
				this.credit = new Credit();
			}
			if (StringUtils.isNotBlank(this.credit.getId())) {
				this.creditService.delete(this.credit.getId());
				responseFlag(true);
			} else {
				responseFlag(false);
			}
		} catch (Exception e) {

			e.printStackTrace();
			responseFlag(false);
		}
	}

	public Credit getCredit() {
		return this.credit;
	}

	public void setCredit(Credit credit) {
		this.credit = credit;
	}

	public void setCreditService(CreditService creditService) {
		this.creditService = creditService;
	}

}
