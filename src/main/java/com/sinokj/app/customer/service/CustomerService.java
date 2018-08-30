package com.sinokj.app.customer.service;

import com.sinokj.app.customer.model.Customer;
import com.sinokj.code.ibatis.impl.PublicDAO;
import com.sinokj.code.service.BaseService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

public class CustomerService extends BaseService<Customer> {
	private static final Logger logger = Logger.getLogger(CustomerService.class);

	public Customer getCustomerByCode(String code) throws Exception {
		Customer customer = null;
		if (StringUtils.isBlank(code)) {
			throw new Exception(
					"customer code is empty,can not query customer information");
		}
		Map map = new HashMap();
		map.put("code", code);
		Object obj = this.publicDAO.selectOne("Customer.Customer", map);
		if (obj != null) {
			customer = (Customer) obj;
		}
		return customer;
	}

	public Customer getCustomerByEmail(String code) throws Exception {
		Customer customer = null;
		if (StringUtils.isBlank(code)) {
			throw new Exception(
					"customer email is empty,can not query customer information");
		}
		Map map = new HashMap();
		map.put("email", code);
		Object obj = this.publicDAO.selectOne("Customer.Customer", map);
		if (obj != null) {
			customer = (Customer) obj;
		}
		return customer;
	}

	public Customer getCustomerByMobile(String mobile) throws Exception {
		Customer customer = null;
		if (StringUtils.isBlank(mobile)) {
			throw new Exception(
					"customer mobile is empty,can mobile query customer information");
		}
		Map map = new HashMap();
		map.put("mobile", mobile);
		Object obj = this.publicDAO.selectOne("Customer.Customer", map);
		if (obj != null) {
			customer = (Customer) obj;
		}
		return customer;
	}

	public Boolean isSystemCustomer(String code, String pwd) throws Exception {
		Boolean isExists = Boolean.valueOf(true);
		if (StringUtils.isBlank(code)) {
			throw new Exception(" mobile is null,can not login");
		}
		if (StringUtils.isBlank(pwd)) {
			throw new Exception("pwd is null,can not login");
		}
		Map map = new HashMap();
		map.put("code", code);
		map.put("pwd", pwd);
		List list = super.select(map);
		if ((list == null) || (list.isEmpty())) {
			isExists = Boolean.valueOf(false);
		} else {
			Customer customer = (Customer) list.get(0);
			logger.info("pwd from input:" + pwd);
			logger.info("pwd from db:" + customer.getPwd());
			isExists = Boolean.valueOf(pwd.equals(customer.getPwd()));
		}
		return isExists;
	}

	public Boolean isSystemCustomerBymobile(String mobile, String pwd)throws Exception {
		Boolean isExists = Boolean.valueOf(true);
		if (StringUtils.isBlank(mobile)) {
			throw new Exception(" mobile is null,can not login");
		}
		if (StringUtils.isBlank(pwd)) {
			throw new Exception("pwd is null,can not login");
		}
		Map<String,String> map = new HashMap<String,String>();
		map.put("mobile", mobile);
		map.put("pwd", pwd);
		List list = super.select(map);
		if ((list == null) || (list.isEmpty())) {
			isExists = Boolean.valueOf(false);
		} else {
			Customer customer = (Customer) list.get(0);
			logger.info("pwd from input:" + pwd);
			logger.info("pwd from db:" + customer.getPwd());
			isExists = Boolean.valueOf(pwd.equals(customer.getPwd()));
		}
		return isExists;
	}

	public Boolean isSystemCustomerByEmail(String email, String pwd)
			throws Exception {
		Boolean isExists = Boolean.valueOf(true);
		if (StringUtils.isBlank(email)) {
			throw new Exception(" email is null,can not login");
		}
		if (StringUtils.isBlank(pwd)) {
			throw new Exception("pwd is null,can not login");
		}
		Map map = new HashMap();
		map.put("email", email);
		map.put("pwd", pwd);
		List list = super.select(map);
		if ((list == null) || (list.isEmpty())) {
			isExists = Boolean.valueOf(false);
		} else {
			Customer customer = (Customer) list.get(0);
			logger.info("pwd from input:" + pwd);
			logger.info("pwd from db:" + customer.getPwd());
			isExists = Boolean.valueOf(pwd.equals(customer.getPwd()));
		}
		return isExists;
	}

	public void updateAccount(String id, String pwd, String email)
			throws Exception {
		if (StringUtils.isBlank(id)) {
			throw new Exception(
					"primary key is null,can not update Customer account information");
		}
		Map map = new HashMap();
		map.put("id", id);
		map.put("pwd", pwd);
		map.put("email", email);
		this.publicDAO.update("Customer.Customer_account", map);
	}

	public void updateState(String id, String state) throws Exception {
		if (StringUtils.isBlank(id)) {
			throw new Exception(
					"primary key is null,can not update Customer Status");
		}
		Map map = new HashMap();
		map.put("id", id);
		map.put("state", state);
		this.publicDAO.update("Customer.Customer_state", map);
	}

	public void updatePayables(String customerId, Double changeMoney)
			throws Exception {
		if (StringUtils.isBlank(customerId)) {
			throw new Exception(
					"primary key is null,can not update Customer payables");
		}
		Map para = new HashMap();
		para.put("id", customerId);

		Customer customer = (Customer) this.publicDAO.selectOne(
				"Customer.Customer", para);
		if (customer != null) {
			Double money = customer.getPayables();
			money = Double.valueOf(money.doubleValue()
					+ changeMoney.doubleValue());
			customer.setPayables(money);
			this.publicDAO.update("Customer.Customer", customer);
		}
	}

	public Customer getCustomer(Customer model) {
		Customer customer = null;
		Object obj = this.publicDAO.selectOne("Customer.Customer", model);
		if (obj != null) {
			customer = (Customer) obj;
		}
		return customer;
	}

	public void updatePwd(String id, String pwd) throws Exception {
		if (StringUtils.isBlank(id)) {
			throw new Exception(
					"primary key is null,can not update Customer Status");
		}
		if (StringUtils.isBlank(pwd)) {
			throw new Exception("pwd is null,can not update Customer Status");
		}
		Map map = new HashMap();
		map.put("id", id);
		map.put("pwd", pwd);
		this.publicDAO.update("Customer.Customer", map);
	}

	public void updateCredits(String id, Double credits) throws Exception {
		if (StringUtils.isBlank(id)) {
			throw new Exception("id is null");
		}
		Map param = new HashMap();
		param.put("id", id);
		Customer customer = (Customer) this.publicDAO.selectOne(
				"Customer.Customer", param);
		if (customer != null) {
			Double newCredits = customer.getCredits();
			newCredits = Double.valueOf(newCredits.doubleValue()
					+ credits.doubleValue());
			customer.setCredits(newCredits);
			this.publicDAO.update("Customer.Customer", customer);
		}
	}

	public List<Customer> getSumCustomerList(Customer customer) {
		List list = this.publicDAO.select("Customer.Customer", customer);
		return list;
	}
}