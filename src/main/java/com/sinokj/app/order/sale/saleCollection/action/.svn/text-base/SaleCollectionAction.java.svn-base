package com.sinokj.app.order.sale.saleCollection.action;

import com.sinokj.app.baseInfo.bankAccount.model.BankAccount;
import com.sinokj.app.baseInfo.bankAccount.service.BankAccountService;
import com.sinokj.app.baseInfo.payment.model.Payment;
import com.sinokj.app.baseInfo.payment.service.PaymentService;
import com.sinokj.app.component.serialNumber.service.SerialNumberService;
import com.sinokj.app.order.sale.saleCollection.model.SaleCollection;
import com.sinokj.app.order.sale.saleCollection.model.SaleCollectionItem;
import com.sinokj.app.order.sale.saleCollection.service.SaleCollectionItemService;
import com.sinokj.app.order.sale.saleCollection.service.SaleCollectionService;
import com.sinokj.app.order.sale.saleDelivery.model.SaleDelivery;
import com.sinokj.app.order.sale.saleDelivery.service.SaleDeliveryService;
import com.sinokj.app.order.sale.saleOrder.model.SaleOrder;
import com.sinokj.app.order.sale.saleOrder.service.SaleOrderService;
import com.sinokj.app.system.user.model.SysUser;
import com.sinokj.code.struct.BaseAction;
import com.sinokj.code.util.PageInfo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.aspectj.weaver.patterns.ThisOrTargetAnnotationPointcut;

public class SaleCollectionAction extends BaseAction {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger
			.getLogger(SaleCollectionAction.class);
	private SaleCollection saleCollection;
	private SaleDelivery saleDelivery;
	private SaleOrderService saleOrderService;
	private SaleCollectionService saleCollectionService;
	private SaleDeliveryService saleDeliveryService;
	private SerialNumberService serialNumberService;
	private BankAccountService bankAccountService;
	private PaymentService paymentService;
	private SaleCollectionItemService saleCollectionItemService;
	private List<Payment> paymentList;
	private List<BankAccount> bankAccountList;
	private String[] orderIdArr;
	private Double[] moneyAccountArr;
	private Double[] moneyAlreadyReceivedArr;
	private Double[] moneyCurrentReceivedArr;
	private String[] remarkArr;
     
	public void setSaleCollectionService(SaleCollectionService saleCollectionService) {
		this.saleCollectionService = saleCollectionService;
	}

	public void setSaleDeliveryService(SaleDeliveryService saleDeliveryService) {
		this.saleDeliveryService = saleDeliveryService;
	}

	public void setSerialNumberService(SerialNumberService serialNumberService) {
		this.serialNumberService = serialNumberService;
	}

	public void setBankAccountService(BankAccountService bankAccountService) {
		this.bankAccountService = bankAccountService;
	}

	public void setPaymentService(PaymentService paymentService) {
		this.paymentService = paymentService;
	}

	public void setSaleCollectionItemService(
			SaleCollectionItemService saleCollectionItemService) {
		this.saleCollectionItemService = saleCollectionItemService;
	}

	public String list() {
		return "list_saleCollection";
	}

	public String listJson() {
		logger.info("start list saleCollection!");
		List resultList = null;
		int totalRows = 0;
		try {
			PageInfo pageInfo = createPageInfo();
			if (this.saleCollection == null) {
				this.saleCollection = new SaleCollection();
			}
			resultList = this.saleCollectionService.pageList(pageInfo,
					this.saleCollection, true);
			totalRows = pageInfo.getCount();
		} catch (Exception e) {
			logger.error("error occur when list sale collection order", e);
		}
		if (resultList == null) {
			resultList = new ArrayList();
		}
		this.jsonMap = new HashMap();
		this.jsonMap.put("total", Integer.valueOf(totalRows));
		this.jsonMap.put("rows", resultList);
		logger.info("finish list all sale collection order!");
		return "success";
	}

	public String edit() {
		SysUser loginMan = getSessionUserInfo();
		if (this.saleCollection == null) {
			this.saleCollection = new SaleCollection();
		}
		if (StringUtils.isBlank(this.saleCollection.getId())) {
			if ((this.saleDelivery != null)
					&& (StringUtils.isNotBlank(this.saleDelivery.getId()))) {
				try {
					this.saleCollection = this.saleCollectionService
							.getSaleCollectionByOrderId(this.saleDelivery
									.getId());
				} catch (Exception e) {
					logger
							.error(
									"error occur when get sale collection by sale order id",
									e);
				}
				if (this.saleCollection == null) {
					this.saleCollection = new SaleCollection();
					this.saleDelivery = ((SaleDelivery) this.saleDeliveryService
							.getModel(this.saleDelivery.getId()));

					this.saleCollection.setOrderId(this.saleDelivery.getId());
					this.saleCollection.setBankAccountId(this.saleDelivery
							.getBankAccountId());
					this.saleCollection.setBankAccountName(this.saleDelivery
							.getBankAccountName());
					this.saleCollection.setCustomerId(this.saleDelivery
							.getCreatorId());
					this.saleCollection.setCustomerName(this.saleDelivery
							.getCustomerName());
					this.saleCollection.setLinkman(this.saleDelivery
							.getLinkman());
					this.saleCollection
							.setMobile(this.saleDelivery.getMobile());
				}
			}

			if (StringUtils.isBlank(this.saleCollection.getCreatorId())) {
				initModel(true, this.saleCollection, loginMan);
				this.saleCollection.setPaymentState("0");
				this.saleCollection.setHandlerId(loginMan.getId());
				this.saleCollection.setHandlerName(loginMan.getName());
				this.saleCollection.setDeptId(loginMan.getDeptId());
				this.saleCollection.setDeptName(loginMan.getDeptName());
				try {
					String code = this.serialNumberService
							.getSerialNumberByDate("SSK", "saleCollection");
					this.saleCollection.setCode(code);
				} catch (Exception e) {
					logger.error("error occur when get serialNumber", e);
				}
			}
		} else {
			this.saleCollection = ((SaleCollection) this.saleCollectionService
					.getModel(this.saleCollection.getId()));
			initModel(false, this.saleCollection, loginMan);
		}

		this.paymentList = this.paymentService.select(new Payment());

		this.bankAccountList = this.bankAccountService
				.select(new BankAccount());

		return "edit_saleCollection";
	}

	public void save() {
		logger.info("start save a collection order");

		Payment payment = (Payment) this.paymentService
				.getModel(this.saleCollection.getPaymentId());
		this.saleCollection.setPaymentCode(payment.getCode());
		this.saleCollection.setPaymentName(payment.getName());

		BankAccount bankAccount = (BankAccount) this.bankAccountService
				.getModel(this.saleCollection.getBankAccountId());
		this.saleCollection.setBankAccountName(bankAccount.getName());
		if (StringUtils.isBlank(this.saleCollection.getId())) {
			String id = this.saleCollectionService.makeId();
			this.saleCollection.setId(id);
			try {
				this.saleCollectionService.insert(this.saleCollection);
				SaleDelivery saleDelivery = (SaleDelivery) this.saleDeliveryService
						.getModel(this.saleCollection.getOrderId());
				if (saleDelivery == null)
					return;
				SaleOrder saleOrder = (SaleOrder) this.saleOrderService
						.getModel(saleDelivery.getOrderId());
				if (saleOrder == null)
					return;
				this.saleOrderService.updataPaymentStateTime(saleDelivery
						.getOrderId());
			} catch (Exception e) {
				responseFlag(false);
				logger.error("error occur when insert a sale collection", e);
			}
		} else {
			try {
				this.saleCollectionService.update(this.saleCollection);
			} catch (Exception e) {
				responseFlag(false);
				logger.error("error occur when update a sale collection", e);
			}
			try {
				this.saleCollectionItemService
						.deleteItemByCollectionId(this.saleCollection.getId());
			} catch (Exception e) {
				responseFlag(false);
				logger.error("error occur when delete saleCollectionItem", e);
			}

		}

		label265: if (this.saleCollection.getPaymentState().equals("1")) {
			try {
				this.bankAccountService.updateMoney(this.saleCollection
						.getBankAccountId(), this.saleCollection
						.getMoneyAccount());
			} catch (Exception e) {
				logger.error("error occur when update bankAccount money", e);
			}
			try {
				this.saleDeliveryService.updateDelivery(this.saleCollection
						.getOrderId(), this.saleCollection.getMoneyAccount());
			} catch (Exception e) {
				logger.error("error occur when update saleDeliveryInfo", e);
			}
		}

		String collectionId = this.saleCollection.getId();
		if ((this.orderIdArr != null) && (this.orderIdArr.length != 0)) {
			for (int i = 0; i < this.orderIdArr.length; i++) {
				System.out.println("===============================");
				System.out.println(this.moneyCurrentReceivedArr[i]);
				SaleCollectionItem saleCollectionItem = new SaleCollectionItem();
				saleCollectionItem.setOrderId(this.orderIdArr[i]);
				saleCollectionItem.setMoneyAccount(this.moneyAccountArr[i]);
				saleCollectionItem.setMoneyAlreadyReceived(this.moneyAlreadyReceivedArr[i]);
				saleCollectionItem.setMoneyCurrentReceived(this.moneyCurrentReceivedArr[i]);
				saleCollectionItem.setCollectionId(collectionId);
				saleCollectionItem.setRemark(this.remarkArr[i]);
				saleCollectionItem.setSort(Integer.valueOf(i));
				try {
					this.saleCollectionItemService.insert(saleCollectionItem);
				} catch (Exception e) {
					responseFlag(false);
					logger.error("error occur when insert a saleCollectionItem", e);
				}
			}
		}

		responseFlag(true);
	}

	public void delete() {
		try {
			logger.info("start to delete saleCollection information");
			if (this.saleCollection == null) {
				this.saleCollection = new SaleCollection();
			}
			String id = this.saleCollection.getId();

			if (StringUtils.isNotBlank(id)) {
				String[] idArr = id.split(",");
				for (String idStr : idArr) {
					this.saleCollectionService.delete(idStr);
				}
				responseFlag(true);
			} else {
				responseFlag(false);
			}
		} catch (Exception e) {
			logger.info("error occur when deleting saleCollection information");
			e.printStackTrace();
			responseFlag(false);
		}
	}

	public SaleCollection getSaleCollection() {
		return this.saleCollection;
	}

	public void setSaleCollection(SaleCollection saleCollection) {
		this.saleCollection = saleCollection;
	}

	public SaleDelivery getSaleDelivery() {
		return this.saleDelivery;
	}

	public void setSaleDelivery(SaleDelivery saleDelivery) {
		this.saleDelivery = saleDelivery;
	}

	public List<Payment> getPaymentList() {
		return this.paymentList;
	}

	public void setPaymentList(List<Payment> paymentList) {
		this.paymentList = paymentList;
	}

	public String[] getOrderIdArr() {
		return this.orderIdArr;
	}

	public Double[] getMoneyAccountArr() {
		return this.moneyAccountArr;
	}

	public Double[] getMoneyAlreadyReceivedArr() {
		return this.moneyAlreadyReceivedArr;
	}
    /**
	public Double[] getMoneyCurrentReceivedArr() {
		return this.moneyCurrentReceivedArr;
	}
    **/
	public String[] getRemarkArr() {
		return this.remarkArr;
	}

	public void setOrderIdArr(String[] orderIdArr) {
		this.orderIdArr = orderIdArr;
	}

	public void setMoneyAccountArr(Double[] moneyAccountArr) {
		this.moneyAccountArr = moneyAccountArr;
	}

	public void setMoneyAlreadyReceivedArr(Double[] moneyAlreadyReceivedArr) {
		this.moneyAlreadyReceivedArr = moneyAlreadyReceivedArr;
	}
    /**
	public void setMoneyCurrentReceivedArr(Double[] moneyCurrentReceivedArr) {
		this.moneyCurrentReceivedArr = moneyCurrentReceivedArr;
	}
    **/
	public void setRemarkArr(String[] remarkArr) {
		this.remarkArr = remarkArr;
	}
    
	public List<BankAccount> getBankAccountList() {
		return this.bankAccountList;
	}

	public void setBankAccountList(List<BankAccount> bankAccountList) {
		this.bankAccountList = bankAccountList;
	}

	public SaleOrderService getSaleOrderService() {
		return this.saleOrderService;
	}

	public void setSaleOrderService(SaleOrderService saleOrderService) {
		this.saleOrderService = saleOrderService;
	}

	public SaleCollectionService getSaleCollectionService() {
		return this.saleCollectionService;
	}

	public SaleDeliveryService getSaleDeliveryService() {
		return this.saleDeliveryService;
	}

	public SerialNumberService getSerialNumberService() {
		return this.serialNumberService;
	}

	public BankAccountService getBankAccountService() {
		return this.bankAccountService;
	}

	public PaymentService getPaymentService() {
		return this.paymentService;
	}

	public SaleCollectionItemService getSaleCollectionItemService() {
		return this.saleCollectionItemService;
	}
}

/*
 * 
 * 
 */