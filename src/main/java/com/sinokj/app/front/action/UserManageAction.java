package com.sinokj.app.front.action;

import com.sinokj.app.baseInfo.area.model.Area;
import com.sinokj.app.baseInfo.area.service.AreaService;
import com.sinokj.app.component.serialNumber.service.SerialNumberService;
import com.sinokj.app.customer.model.Customer;
import com.sinokj.app.customer.model.CustomerAddress;
import com.sinokj.app.customer.service.CustomerAddressService;
import com.sinokj.app.customer.service.CustomerService;
import com.sinokj.app.front.browse.model.Browse;
import com.sinokj.app.front.browse.service.BrowseService;
import com.sinokj.app.front.model.MyAuthenticator;
import com.sinokj.app.front.model.WareComment;
import com.sinokj.app.front.service.WareCommentService;
import com.sinokj.app.good.favorite.model.Favorite;
import com.sinokj.app.good.favorite.service.FavoriteService;
import com.sinokj.app.good.good.model.Good;
import com.sinokj.app.good.good.service.GoodService;
import com.sinokj.app.good.goodExtend.model.GoodExtend;
import com.sinokj.app.good.goodExtend.service.GoodExtendService;
import com.sinokj.app.good.ware.model.Ware;
import com.sinokj.app.good.ware.service.WareService;
import com.sinokj.app.good.ware.service.WareSpecificationValService;
import com.sinokj.app.order.pay.SaleOrderPayService;
import com.sinokj.app.order.sale.saleOrder.model.SaleOrder;
import com.sinokj.app.order.sale.saleOrder.service.SaleOrderService;
import com.sinokj.app.order.sale.saleReturn.model.SaleReturn;
import com.sinokj.app.order.sale.saleReturn.service.SaleReturnService;
import com.sinokj.app.order.sale.saleWare.model.SaleWare;
import com.sinokj.app.order.sale.saleWare.service.SaleWareService;
import com.sinokj.app.store.advertise.model.Advertise;
import com.sinokj.app.store.advertise.service.AdvertiseService;
import com.sinokj.app.store.greetingCard.model.GreetingCard;
import com.sinokj.app.store.greetingCard.service.GreetingCardService;
import com.sinokj.app.store.information.model.Information;
import com.sinokj.app.store.information.service.InformationService;
import com.sinokj.app.vip.applyCash.model.ApplyToCash;
import com.sinokj.app.vip.applyCash.service.ApplyToCashService;
import com.sinokj.app.vip.coupon.model.VipCoupon;
import com.sinokj.app.vip.coupon.model.VipCouponWare;
import com.sinokj.app.vip.coupon.service.VipCouponService;
import com.sinokj.app.vip.coupon.service.VipCouponWareService;
import com.sinokj.app.vip.message.model.Message;
import com.sinokj.app.vip.message.service.MessageService;
import com.sinokj.app.vip.prepaid.model.Prepaid;
import com.sinokj.app.vip.prepaid.service.PrepaidService;
import com.sinokj.code.struct.BaseAction;
import com.sinokj.code.util.PageInfo;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

public class UserManageAction extends BaseAction {
	private static final long serialVersionUID = -2840234214848371282L;
	private static final Logger logger = Logger.getLogger(UserManageAction.class);
	private CusLoginAction CusLoginAction;
	private CustomerService customerService;
	private Customer customer;
	private PrepaidService prepaidService;
	private List<Prepaid> prepaidList;
	private SaleOrderService saleOrderService;
	private List<SaleOrder> saleOrderList;
	private SaleOrder saleOrder;
	private List<SaleWare> saleWareList;
	private SaleWareService saleWareService;
	private SaleWare saleWare;
	private WareService wareService;
	private GoodService goodService;
	private List<Good> goodList;
	private List<Good> goodList1;
	private List<Good> goodList2;
	private WareSpecificationValService wareSpecificationValService;
	private ApplyToCash applyToCash;
	private ApplyToCashService applyToCashService;
	private List<ApplyToCash> applyToCashList;
	private VipCouponService vipCouponService;
	private List<VipCoupon> vipCouponList;
	private VipCoupon vipCoupon;
	private FavoriteService favoriteService;
	private Favorite favorite;
	private WareCommentService wareCommentService;
	private List<WareComment> wareCommentList;
	private WareComment wareComment;
	private Message message;
	private MessageService messageService;
	private List<Message> messageList;
	private List<GreetingCard> greetingCardList;
	private GreetingCardService greetingCardService;
	private GreetingCard greetingCard;
	private List<Information> informationList;
	private InformationService informationService;
	private BrowseService browseService;
	private Browse browse;
	private List<Browse> browseList;
	private GoodExtendService goodExtendService;
	private List<Advertise> advertiseList;
	private AdvertiseService advertiseService;
	private Integer warehousecount;
	private VipCouponWareService vipCouponWareService;
	private Information information1;
	private Information information2;
	private CustomerAddress customerAddress;
	private CustomerAddressService customerAddressService;
	private List<CustomerAddress> addressList;
	private Area area;
	private List<Area> areaList;
	private AreaService areaService;
	private List<SaleReturn> saleReturnList;
	private SaleReturn saleReturn;
	private SaleReturnService saleReturnService;
	private SerialNumberService serialNumberService;
    private SaleOrderPayService payService;
 
	public void statisticsOrder() {
		try {
			this.customer = getSessionCustomerInfo();
			HttpServletRequest request = getRequest();

			SaleOrder order = new SaleOrder();
			order.setCustomerId(this.customer.getId());
			List salelist = this.saleOrderService.select(order);
			request.setAttribute("total", Integer.valueOf(salelist.size()));

			SaleOrder paymentOrder = new SaleOrder();
			paymentOrder.setPaymentState("0");
			paymentOrder.setIscancel("0");
			paymentOrder.setCustomerId(this.customer.getId());
			List paySaleOrderList = this.saleOrderService.select(paymentOrder);
			request.setAttribute("payment", Integer.valueOf(paySaleOrderList.size()));

			SaleOrder cancelOrder = new SaleOrder();
			cancelOrder.setIscancel("1");
			cancelOrder.setCustomerId(this.customer.getId());
			List cancelOrderList = this.saleOrderService.select(cancelOrder);
			request.setAttribute("cancelOrder", Integer.valueOf(cancelOrderList.size()));

			SaleWare saleware = new SaleWare();
			saleware.setCustomerId(this.customer.getId());
			saleware.setDeliveryState("1");
			List deliveryOrderList = this.saleWareService.select("SaleWare.SaleWare_deliveryState", saleware);
			request.setAttribute("deliveryOrder", Integer.valueOf(deliveryOrderList.size()));

			SaleWare saleware2 = new SaleWare();
			saleware2.setCustomerId(this.customer.getId());
			saleware2.setDeliveryState("0");
			List deliveryOrderList2 = this.saleWareService.select("SaleWare.SaleWare_deliveryState", saleware2);
			request.setAttribute("deliveryOrder2", Integer.valueOf(deliveryOrderList2.size()));

			SaleOrder commentOrder = new SaleOrder();
			commentOrder.setIscancel("0");
			commentOrder.setCustomerId(this.customer.getId());
			List commentOrderList = this.saleOrderService.select("SaleOrder.SaleOrder_comment", commentOrder);
			request.setAttribute("commentOrder", Integer.valueOf(commentOrderList.size()));
             
			Favorite fa = new Favorite();
			fa.setCreatorId(this.customer.getId());
			List list = this.favoriteService.select(fa);
			request.setAttribute("favolist", Integer.valueOf(list.size()));

			VipCoupon coupon = new VipCoupon();
			coupon.setState("s");
			coupon.setCustomerId(this.customer.getId());
			List couponList = this.vipCouponService.select(coupon);
			request.setAttribute("couponList", Integer.valueOf(couponList.size()));
			 
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
	}

	public String customersManage() throws Exception {
		HttpServletRequest request = getRequest();
		String areasId = (String) request.getSession().getAttribute("areasId");
		try {
			this.customer = getSessionCustomerInfo();
			this.informationList = this.informationService
					.select(new Information());
			if (this.customer == null) {
				this.customer = new Customer();
			}

			this.messageList = this.messageService
					.getReplyByCustomerId(this.customer.getId());
			getRequest().setAttribute("messagelist",
					Integer.valueOf(this.messageList.size()));

			if (this.browse == null)
				this.browse = new Browse();
			this.browse.setCustomerId(this.customer.getId());
			this.browseList = this.browseService.select("Browse.Browse_reply",
					this.browse);
			if (this.browseList.size() > 0) {
				for (int i = 0; i < this.browseList.size(); i++) {
					Good g = (Good) this.goodService
							.getModel(((Browse) this.browseList.get(i))
									.getGoodId());
					if (g != null) {
						((Browse) this.browseList.get(i)).setPriceMarket(g
								.getPriceMarket());
						((Browse) this.browseList.get(i)).setGoodPrice(g
								.getPrice());
						((Browse) this.browseList.get(i))
								.setGoodPic(g.getPic());
					}
					GoodExtend ge = this.goodExtendService
							.getByGoodId(((Browse) this.browseList.get(i))
									.getGoodId());
					if (ge != null)
						((Browse) this.browseList.get(i)).setIntroBrief(ge
								.getIntroBrief());
				}
			}

			if (this.favorite == null)
				this.favorite = new Favorite();
			this.favorite.setCreatorId(this.customer.getId());
			List goodlist = this.favoriteService
					.selectByCreatorId(this.favorite);
			if (goodlist.size() > 0) {
				for (int i = 0; i < goodlist.size(); i++) {
					Good g = (Good) this.goodService
							.getModel(((Favorite) goodlist.get(i)).getGoodId());
					if (g != null) {
						((Favorite) goodlist.get(i)).setPriceMarket(g
								.getPriceMarket());
						((Favorite) goodlist.get(i)).setPrice(g.getPrice());
						((Favorite) goodlist.get(i)).setPic(g.getPic());
					}
					GoodExtend ge = this.goodExtendService
							.getByGoodId(((Favorite) goodlist.get(i))
									.getGoodId());
					if (ge != null)
						((Favorite) goodlist.get(i)).setIntroBrief(ge
								.getIntroBrief());
				}
			}
			request.setAttribute("goodlist", goodlist);

			Good g = new Good();
			g.setIsInventory("1");
			g.setBeginTime(new Date());
			this.goodList = this.goodService.select("Good.Good_SY", g);

			Good good = new Good();
			good.setProperty("1");
			good.setIsInventory("0");
			if (areasId != null)
				good.setAreasId(areasId);
			this.goodList2 = this.goodService.select("Good.Good_SY", good);

			Advertise advertise = new Advertise();
			advertise.setPlaceId("会员中心");
	 
			this.informationList = this.informationService.select(new Information());

			statisticsOrder();
		} catch (Exception e) {
			e.printStackTrace();
		}

		Area area = new Area();
		area.setLevel(2);
		this.areaList = this.areaService.select(area);
		for (int i = 0; i < this.areaList.size(); i++) {
			Area arer = new Area();
			arer.setParentId(((Area) this.areaList.get(i)).getId());
			arer.setLevel(3);
			List list = this.areaService.select(arer);
			if (list.size() > 0)
				((Area) this.areaList.get(i)).setAreaList(list);
		}
		this.advertiseList = this.advertiseService.getAdvertiseList();
		return "customersManage";
	}

	public String orderManage() {
		HttpServletRequest request = getRequest();
		String areasId = (String) request.getSession().getAttribute("areasId");

		this.customer = getSessionCustomerInfo();
		this.informationList = this.informationService
				.select(new Information());
		try {
			Good good = new Good();
			good.setProperty("5");
			good.setIsInventory("0");
			if (areasId != null)
				good.setAreasId(areasId);
			this.goodList1 = this.goodService.select("Good.Good_SY", good);

			statisticsOrder();
		} catch (Exception e) {
			e.printStackTrace();
		}

		this.advertiseList = this.advertiseService.getAdvertiseList();
		this.informationList = this.informationService
				.select(new Information());
		Area area = new Area();
		area.setLevel(2);
		this.areaList = this.areaService.select(area);
		for (int i = 0; i < this.areaList.size(); i++) {
			Area arer = new Area();
			arer.setParentId(((Area) this.areaList.get(i)).getId());
			arer.setLevel(3);
			List list = this.areaService.select(arer);
			if (list.size() > 0)
				((Area) this.areaList.get(i)).setAreaList(list);
		}

		return "orderManage";
	}

	public String saleOrderJsion() {
		List resultList = null;

		this.customer = getSessionCustomerInfo();
		try {
			if (this.saleOrder == null) {
				this.saleOrder = new SaleOrder();
			}

			Date time = new Date();
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(time);
			calendar.add(5, -30);
			Date newDate = calendar.getTime();
			String data = dateFormat.format(newDate);

			this.saleOrder.setCustomerId(this.customer.getId());
			if (this.saleOrder.getData().equals("0"))
				this.saleOrder.setData(data);
			else {
				this.saleOrder.setData(null);
			}

			if ((this.saleOrder.getSearch() != null)
					&& (!this.saleOrder.getSearch().equals("商品编号/订单号"))) {
				this.saleOrder.setSearchOrder("strs");
				this.saleOrder.setCode(this.saleOrder.getSearch());
			}

			resultList = this.saleOrderService.select(this.saleOrder);

			if (resultList.size() > 0) {
				for (int i = 0; i < resultList.size(); i++) {
					SaleWare ware = new SaleWare();
					ware.setSaleId(((SaleOrder) resultList.get(i)).getId());
					List wareList = this.saleWareService.select(ware);
					if (wareList.size() > 0) {
						for (int j = 0; j < wareList.size(); j++) {
							Ware wares = new Ware();
							wares = (Ware) this.wareService
									.getModel(((SaleWare) wareList.get(j))
											.getWareId());
							if (wares != null) {
								Good good = (Good) this.goodService
										.getModel(wares.getGoodId());
								if (good != null) {
									((SaleWare) wareList.get(j))
											.setGoodName(good.getName());
									((SaleWare) wareList.get(j))
											.setGoodPic(good.getPic());

									((SaleWare) wareList.get(j)).setGoodId(good
											.getId());
								}
							}
						}
						((SaleOrder) resultList.get(i)).setWarelist(wareList);
					}
				}
			}
		} catch (RuntimeException e) {
			e.printStackTrace();
		}

		this.jsonMap = new HashMap();
		this.jsonMap.put("rows", resultList);
		return "success";
	}

	public String shippedGoods() {
		HttpServletRequest request = getRequest();
		String areasId = (String) request.getSession().getAttribute("areasId");
		this.customer = getSessionCustomerInfo();
		try {
			if (this.saleOrder == null) {
				this.saleOrder = new SaleOrder();
			}

			this.saleOrder.setCustomerId(this.customer.getId());

			if (this.saleOrder.getDeliveryState().equals("0")) {
				this.saleOrder.setDeliveryState("0");
			}
			this.saleOrder.setIscancel("0");
			request.setAttribute("deliveryState", this.saleOrder
					.getDeliveryState());
			this.saleOrderList = this.saleOrderService.select(this.saleOrder);
			if (this.saleOrderList.size() > 0) {
				for (int i = 0; i < this.saleOrderList.size(); i++) {
					SaleWare ware = new SaleWare();
					ware.setSaleId(((SaleOrder) this.saleOrderList.get(i))
							.getId());
					List wareList = this.saleWareService.select(ware);
					if (wareList.size() > 0) {
						for (int j = 0; j < wareList.size(); j++) {
							Ware wares = new Ware();
							wares = (Ware) this.wareService
									.getModel(((SaleWare) wareList.get(j))
											.getWareId());
							if (wares != null) {
								Good good = (Good) this.goodService
										.getModel(wares.getGoodId());
								if (good != null) {
									((SaleWare) wareList.get(j))
											.setGoodName(good.getName());
									((SaleWare) wareList.get(j))
											.setGoodPic(good.getPic());
									((SaleWare) wareList.get(j)).setGoodId(good
											.getId());
								}
							}
						}
						((SaleOrder) this.saleOrderList.get(i))
								.setWarelist(wareList);
					}
				}
  
			}

			Good good = new Good();
			good.setProperty("5");
			good.setIsInventory("0");
			if (areasId != null)
				good.setAreasId(areasId);
			this.goodList1 = this.goodService.select("Good.Good_SY", good);
            
			statisticsOrder();
		} catch (RuntimeException e) {
			e.printStackTrace();
		}

		this.informationList = this.informationService.select(new Information());
		this.advertiseList = this.advertiseService.getAdvertiseList();
		Area area = new Area();
		area.setLevel(2);
		this.areaList = this.areaService.select(area);
		for (int i = 0; i < this.areaList.size(); i++) {
			Area arer = new Area();
			arer.setParentId(((Area) this.areaList.get(i)).getId());
			arer.setLevel(3);
			List list = this.areaService.select(arer);
			if (list.size() > 0)
				((Area) this.areaList.get(i)).setAreaList(list);
		}
         
		return "shippedGoods";
	}

	public String information() {
		this.customer = getSessionCustomerInfo();

		if (this.area == null) {
			this.area = new Area();
		}
		this.area.setLevel(2);
		this.areaList = this.areaService.select(this.area);

		this.informationList = this.informationService
				.select(new Information());
		this.advertiseList = this.advertiseService.getAdvertiseList();
		Area area = new Area();
		area.setLevel(2);
		this.areaList = this.areaService.select(area);
		for (int i = 0; i < this.areaList.size(); i++) {
			Area arer = new Area();
			arer.setParentId(((Area) this.areaList.get(i)).getId());
			arer.setLevel(3);
			List list = this.areaService.select(arer);
			if (list.size() > 0)
				((Area) this.areaList.get(i)).setAreaList(list);

		}

		statisticsOrder();

		return "information";
	}

	public String selectCityJson() {
		List resultList = null;
		if (this.area == null) {
			this.area = new Area();
		}
		if (this.area.getParentId() != null) {
			Area a = (Area) this.areaService.getModel(this.area.getParentId());
			if (a != null) {
				this.area.setLevel(a.getLevel() + 1);
			}
			resultList = this.areaService.select(this.area);
		}

		this.jsonMap = new HashMap();
		this.jsonMap.put("rows", resultList);
		return "success";
	}

	public void customerSave() {
		logger.info("start to update Customer information");
		HttpServletRequest request = getRequest();
		try {
			if (this.customer == null) {
				this.customer = new Customer();
			}

			this.customerService.update(this.customer);
			this.customer = ((Customer) this.customerService
					.getModel(this.customer.getId()));
			request.getSession().setAttribute("loginCustomer", this.customer);
			responseFlag(true);
		} catch (Exception e) {
			logger.info("error occur when save Customer information");
			e.printStackTrace();
			responseFlag(false);
		}
		logger.info("finish to save Customer information");
	}

	public String paymentOrder() {
		HttpServletRequest request = getRequest();
		String areasId = (String) request.getSession().getAttribute("areasId");
		this.customer = getSessionCustomerInfo();
		try {
			if (this.saleOrder == null) {
				this.saleOrder = new SaleOrder();
			}
			this.saleOrder.setCustomerId(this.customer.getId());

			if (this.saleOrder.getIscancel().equals("0")) {
				this.saleOrder.setPaymentState("0");
			}
			this.saleOrderList = this.saleOrderService.select(this.saleOrder);
			getRequest().setAttribute("size",
					Integer.valueOf(this.saleOrderList.size()));
			if (this.saleOrderList.size() > 0) {
				for (int i = 0; i < this.saleOrderList.size(); i++) {
					List list = this.goodService
							.getSaleGoodList(((SaleOrder) this.saleOrderList
									.get(i)).getId());
					if (list.size() > 0)
						((SaleOrder) this.saleOrderList.get(i))
								.setGoodlist(list);
				}

			}

			Good good = new Good();
			good.setProperty("5");
			good.setIsInventory("0");
			if (areasId != null)
				good.setAreasId(areasId);
			this.goodList1 = this.goodService.select("Good.Good_SY", good);

			this.informationList = this.informationService
					.select(new Information());

			Area area = new Area();
			area.setLevel(2);
			this.areaList = this.areaService.select(area);
			for (int i = 0; i < this.areaList.size(); i++) {
				Area arer = new Area();
				arer.setParentId(((Area) this.areaList.get(i)).getId());
				arer.setLevel(3);
				List list = this.areaService.select(arer);
				if (list.size() > 0)
					((Area) this.areaList.get(i)).setAreaList(list);
			}

			request.setAttribute("iscancel", this.saleOrder.getIscancel());
			this.advertiseList = this.advertiseService.getAdvertiseList();
			statisticsOrder();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "paymentOrder";
	}

	public String showOrder() {
		this.customer = getSessionCustomerInfo();
		PageInfo pageInfo = createPageInfo();
		if (this.saleOrder == null)
			this.saleOrder = new SaleOrder();
		try {
			String saleId = this.saleOrder.getId();

			this.saleOrder = ((SaleOrder) this.saleOrderService
					.getModel(saleId));

			if (this.saleWare == null) {
				this.saleWare = new SaleWare();
			}
			this.saleWare.setSaleId(saleId);
			this.saleWareList = this.saleWareService.select(this.saleWare);
			for (int i = 0; i < this.saleWareList.size(); i++) {
				Ware ware = new Ware();
				ware = (Ware) this.wareService
						.getModel(((SaleWare) this.saleWareList.get(i))
								.getWareId());
				if (ware != null) {
					Good good = (Good) this.goodService.getModel(ware
							.getGoodId());
					if (good != null) {
						((SaleWare) this.saleWareList.get(i)).setGoodCode(good
								.getCode());
						((SaleWare) this.saleWareList.get(i)).setGoodName(good
								.getName());
					}
				}

			}

			this.informationList = this.informationService.select(new Information());
			this.advertiseList = this.advertiseService.getAdvertiseList();
			Area area = new Area();
			area.setLevel(2);
			this.areaList = this.areaService.select(area);
			for (int i = 0; i < this.areaList.size(); i++) {
				Area arer = new Area();
				arer.setParentId(((Area) this.areaList.get(i)).getId());
				arer.setLevel(3);
				List list = this.areaService.select(arer);
				if (list.size() > 0)
					((Area) this.areaList.get(i)).setAreaList(list);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "showOrder";
	}

	public void updateOrderState() {
		Customer customer = getSessionCustomerInfo();
		payService=new SaleOrderPayService();
		try {
			if (this.saleOrder == null) {
				this.saleOrder = new SaleOrder();
			}
			if (StringUtils.isNotBlank(this.saleOrder.getId())) {
				SaleOrder order = (SaleOrder) this.saleOrderService.getModel(this.saleOrder.getId());
				order.setIscancel("1");
				order.setCancelTime(new Date());
				this.saleOrderService.update(order);
				payService.returnPays(order.getCode(),customer);
				responseFlag(true);
			}
		} catch (Exception e) {
			responseFlag(false);
			e.printStackTrace();
		}
	}

	public void isPwdRightInput() {
		String id = this.customer.getId();
		String pwd = this.customer.getPwd();
		logger.info("check password whether it is right input");
		try {
			if (StringUtils.isNotBlank(id)) {
				this.customer = ((Customer) this.customerService.getModel(id));
				if (pwd.equals(this.customer.getPwd()))
					responseFlag(true);
				else
					responseFlag(false);
			} else {
				responseFlag(false);
			}
		} catch (Exception e) {
			logger.error("error occur when check password is right input!", e);
			e.printStackTrace();
		}
	}

	public String password() {
		this.customer = getSessionCustomerInfo();

		this.informationList = this.informationService.select(new Information());
		this.advertiseList = this.advertiseService.getAdvertiseList();
		Area area = new Area();
		area.setLevel(2);
		this.areaList = this.areaService.select(area);
		for (int i = 0; i < this.areaList.size(); i++) {
			Area arer = new Area();
			arer.setParentId(((Area) this.areaList.get(i)).getId());
			arer.setLevel(3);
			List list = this.areaService.select(arer);
			if (list.size() > 0)
				((Area) this.areaList.get(i)).setAreaList(list);
		}

		statisticsOrder();

		return "password";
	}

	public void saveModifierPwd() {
		String id = this.customer.getId();
		String pwd = this.customer.getNewPwd();
		logger.info("saveModifierPwd,id:" + id + ";pwd:" + pwd);
		try {
			this.customerService.updatePwd(id, pwd);
			logger.info("modifyPassword success");
			HttpServletRequest request = getRequest();
			request.getSession().removeAttribute("loginCustomer");
			responseFlag(true);
		} catch (Exception e) {
			e.printStackTrace();
			responseFlag(false);
		}
	}

	public String passwordSuccess() {
		HttpServletRequest request = getRequest();
		request.getSession().removeAttribute("loginCustomer");

		this.informationList = this.informationService.select(new Information());
		this.advertiseList = this.advertiseService.getAdvertiseList();
		Area area = new Area();
		area.setLevel(2);
		this.areaList = this.areaService.select(area);
		for (int i = 0; i < this.areaList.size(); i++) {
			Area arer = new Area();
			arer.setParentId(((Area) this.areaList.get(i)).getId());
			arer.setLevel(3);
			List list = this.areaService.select(arer);
			if (list.size() > 0)
				((Area) this.areaList.get(i)).setAreaList(list);
		}

		return "password1";
	}

	public String myCoupon() throws Exception {
		this.customer = getSessionCustomerInfo();
		HttpServletRequest request = getRequest();

		Information i = new Information();
		i.setTitle("优惠券使用规则");
		i.setType("9");
		this.information1 = ((Information) this.informationService.selectOne(i));
		if (this.vipCoupon == null) {
			this.vipCoupon = new VipCoupon();
		}

		Double money = this.vipCouponService.getMoneyByCustomerId(this.customer
				.getId());
		request.setAttribute("money", money);

		Information ii = new Information();
		ii.setTitle("如何获得优惠券");
		ii.setType("9");
		this.information2 = ((Information) this.informationService.selectOne(ii));

		this.informationList = this.informationService
				.select(new Information());

		Area area = new Area();
		area.setLevel(2);
		this.areaList = this.areaService.select(area);
		for (int j = 0; j < this.areaList.size(); j++) {
			Area arer = new Area();
			arer.setParentId(((Area) this.areaList.get(j)).getId());
			arer.setLevel(3);
			List list = this.areaService.select(arer);
			if (list.size() > 0)
				((Area) this.areaList.get(j)).setAreaList(list);

		}

		statisticsOrder();
		return "myCoupon";
	}

	public String vipCountJson() {
		this.customer = getSessionCustomerInfo();
		List resultList = null;

		Date time = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(time);
		calendar.add(5, -90);
		Date newDate = calendar.getTime();
		String data = dateFormat.format(newDate);
		try {
			if (this.vipCoupon == null) {
				this.vipCoupon = new VipCoupon();
			}
			this.vipCoupon.setCustomerId(this.customer.getId());
			if (this.vipCoupon.getData().equals("0"))
				this.vipCoupon.setData(data);
			else {
				this.vipCoupon.setData(null);
			}

			if (this.vipCoupon.getState().equals("s"))
				this.vipCoupon.setState("s");
			else if (this.vipCoupon.getState().equals("d"))
				this.vipCoupon.setState("d");
			else if (this.vipCoupon.getState().equals("b"))
				this.vipCoupon.setState("b");
			else {
				this.vipCoupon.setState(null);
			}
			resultList = this.vipCouponService.select(this.vipCoupon);
			if (resultList.size() > 0)
				for (int i = 0; i < resultList.size(); i++) {
					VipCouponWare ware = new VipCouponWare();
					ware.setVipCouponId(((VipCoupon) resultList.get(i))
							.getCode());
					List wareList = this.vipCouponWareService.select(ware);
					if (wareList.size() > 0)
						((VipCoupon) resultList.get(i)).setTypes("1");
					else
						((VipCoupon) resultList.get(i)).setTypes("2");
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.jsonMap = new HashMap();
		this.jsonMap.put("rows", resultList);
		return "success";
	}

	public String myFavorite() {
		this.customer = getSessionCustomerInfo();
		HttpServletRequest request = getRequest();
		String areasId = (String) request.getSession().getAttribute("areasId");
		try {
			if (this.favorite == null) {
				this.favorite = new Favorite();
			}
			this.favorite.setCreatorId(this.customer.getId());
			List favoriteList = this.favoriteService.select(this.favorite);
			if (favoriteList.size() > 0) {
				for (int i = 0; i < favoriteList.size(); i++) {
					Good good = new Good();

					good = (Good) this.goodService
							.getModel(((Favorite) favoriteList.get(i))
									.getGoodId());
					if (good != null) {
						((Favorite) favoriteList.get(i)).setGoodCode(good
								.getCode());
						((Favorite) favoriteList.get(i)).setPicId(good
								.getPicId());
						((Favorite) favoriteList.get(i)).setPic(good.getPic());
						((Favorite) favoriteList.get(i))
								.setUnit(good.getUnit());
						((Favorite) favoriteList.get(i)).setPrice(good
								.getPrice());

						this.warehousecount = ((Integer) this.goodService
								.selectToT("Good.Good_warehousecount_query",
										good));
						if (this.warehousecount != null) {
							if (this.warehousecount.intValue() > 0)
								((Favorite) favoriteList.get(i))
										.setWarehousecount(this.warehousecount);
						} else {
							((Favorite) favoriteList.get(i))
									.setWarehousecount(Integer.valueOf(0));
						}
					}

				}

			}

			Good good = new Good();
			good.setProperty("5");
			good.setIsInventory("0");
			if (areasId != null)
				good.setAreasId(areasId);
			this.goodList1 = this.goodService.select("Good.Good_SY", good);

			this.informationList = this.informationService.select(new Information());
			this.advertiseList = this.advertiseService.getAdvertiseList();
			Area area = new Area();
			area.setLevel(2);
			this.areaList = this.areaService.select(area);
			for (int i = 0; i < this.areaList.size(); i++) {
				Area arer = new Area();
				arer.setParentId(((Area) this.areaList.get(i)).getId());
				arer.setLevel(3);
				List list = this.areaService.select(arer);
				if (list.size() > 0)
					((Area) this.areaList.get(i)).setAreaList(list);

			}

			statisticsOrder();
			request.setAttribute("favoriteList", favoriteList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "myFavorite";
	}

	public void deleteFavorites() {
		try {
			if (this.favorite == null) {
				this.favorite = new Favorite();
			}
			String fav = this.favorite.getId();
			if (StringUtils.isNotBlank(fav)) {
				String[] idArr = fav.split(",");
				for (String idStr : idArr) {
					this.favoriteService.delete(idStr);
				}
				responseFlag(true);
			}
		} catch (Exception e) {
			responseFlag(false);
			e.printStackTrace();
		}
	}

	public String myComment() {
		this.customer = getSessionCustomerInfo();
		HttpServletRequest request = getRequest();
		try {
			WareComment wareComment = new WareComment();
			wareComment.setCreatorId(this.customer.getId());
			this.wareCommentList = this.wareCommentService.select(wareComment);
			
			if (this.wareCommentList.size() > 0) {
				for (int i = 0; i < this.wareCommentList.size(); i++) {
					Good good = new Good();

					good = (Good) this.goodService.getModel(((WareComment) this.wareCommentList.get(i)).getWareId());
					if (good != null) {
						((WareComment) this.wareCommentList.get(i)).setGoodName(good.getName());
						((WareComment) this.wareCommentList.get(i)).setGoodId(good.getId());
						((WareComment) this.wareCommentList.get(i)).setPic(good.getPic());
					}

				}
			 }
		     if (this.saleOrder == null){
					this.saleOrder = new SaleOrder();
				}	
				this.saleOrder.setCustomerId(this.customer.getId());
				this.saleOrderList = this.saleOrderService.select("SaleOrder.SaleOrder_comment", this.saleOrder);
				request.setAttribute("size", Integer.valueOf(this.saleOrderList.size()));
				if (this.saleOrderList.size() > 0) {
					for (int i = 0; i < this.saleOrderList.size(); i++) {
						
						List<Good> list = this.goodService.getSaleGoodList(((SaleOrder) this.saleOrderList.get(i)).getId());
						if (list.size() > 0){
							((SaleOrder) this.saleOrderList.get(i)).setGoodlist(list);
						}	
					}
				}
			
			getRequest().setAttribute("size",Integer.valueOf(this.wareCommentList.size()));
		} catch (Exception e) {
			e.printStackTrace();
		}

		this.informationList = this.informationService.select(new Information());
		this.advertiseList = this.advertiseService.getAdvertiseList();
		Area area = new Area();
		area.setLevel(2);
		this.areaList = this.areaService.select(area);
		for (int i = 0; i < this.areaList.size(); i++) {
			Area arer = new Area();
			arer.setParentId(((Area) this.areaList.get(i)).getId());
			arer.setLevel(3);
			List list = this.areaService.select(arer);
			if (list.size() > 0)
				((Area) this.areaList.get(i)).setAreaList(list);

		}

		statisticsOrder();
		return "myComment";
	}

	public String pingjiaPage() {
		this.customer = getSessionCustomerInfo();
		if (this.wareComment == null) {
			this.wareComment = new WareComment();
		}

		this.informationList = this.informationService.select(new Information());

		Area area = new Area();
		area.setLevel(2);
		this.areaList = this.areaService.select(area);
		for (int i = 0; i < this.areaList.size(); i++) {
			Area arer = new Area();
			arer.setParentId(((Area) this.areaList.get(i)).getId());
			arer.setLevel(3);
			List list = this.areaService.select(arer);
			if (list.size() > 0)
				((Area) this.areaList.get(i)).setAreaList(list);
		}

		return "pingjiaPage";
	}

	public void wareCommentSaveTwo() {
		this.customer = getSessionCustomerInfo();
		if (this.customer == null) {
			responseFlag("frontLogin");
		} else {
			if (this.wareComment == null) {
				this.wareComment = new WareComment();
			}
			this.wareComment.setId(this.wareCommentService.makeId());
			this.wareComment.setCreatorId(this.customer.getId());
			this.wareComment.setCreatorName(this.customer.getName());
			this.wareComment.setCreateTime(new Date());
			this.wareComment.setSort(Integer.valueOf(0));
			this.wareComment.setState("c");
			try {
				this.wareCommentService.insert(this.wareComment);
				responseFlag(true);
				Good g = new Good();
				g = (Good) this.goodService.getModel(this.wareComment
						.getWareId());
				int a = 0;
				if (g != null) {
					if (g.getCommentCount() != null) {
						a = g.getCommentCount().intValue();
						g.setCommentCount(Integer.valueOf(a + 1));
					} else {
						g.setCommentCount(Integer.valueOf(1));
					}
					this.goodService.update(g);
				}
			} catch (Exception e) {
				responseFlag(false);
				e.printStackTrace();
			}
		}
	}

	public String myMessage() {
		this.customer = getSessionCustomerInfo();
		if (this.message == null)
			this.message = new Message();
		try {
			this.message.setCreatorId(this.customer.getId());
			this.message.setState("c");
			this.messageList = this.messageService.select(this.message);
			if (this.messageList.size() > 0) {
				for (int i = 0; i < this.messageList.size(); i++) {
					Good good = new Good();

					good = (Good) this.goodService.getModel(((Message) this.messageList.get(i)).getGoodId());
					if (good != null) {
						((Message) this.messageList.get(i)).setGoodName(good.getName());
						((Message) this.messageList.get(i)).setPic(good.getPic());
					}
					if (((Message) this.messageList.get(i)).getReplyState().equals("1")) {
						Message me = this.messageService.getRepalyById(((Message) this.messageList.get(i)).getId());
						if (me != null) {
							((Message) this.messageList.get(i)).setReplyContent(me.getContent());
						}
					}
				}
			}

			this.informationList = this.informationService.select(new Information());
			this.advertiseList = this.advertiseService.getAdvertiseList();
			Area area = new Area();
			area.setLevel(2);
			this.areaList = this.areaService.select(area);
			for (int i = 0; i < this.areaList.size(); i++) {
				Area arer = new Area();
				arer.setParentId(((Area) this.areaList.get(i)).getId());
				arer.setLevel(3);
				List list = this.areaService.select(arer);
				if (list.size() > 0)
					((Area) this.areaList.get(i)).setAreaList(list);

			}

			statisticsOrder();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "myMessage";
	}

	public String myaddress() {
		this.customer = getSessionCustomerInfo();
		if (this.customerAddress == null) {
			this.customerAddress = new CustomerAddress();
		}
		if (this.area == null) {
			this.area = new Area();
		}
		this.customerAddress.setCustomerId(this.customer.getId());
		this.addressList = this.customerAddressService
				.select(this.customerAddress);
		if (this.addressList.size() > 0) {
			for (int i = 0; i < this.addressList.size(); i++) {
				String[] cons = ((CustomerAddress) this.addressList.get(i))
						.getAddress().split("-");
				String areaName = "";
				for (int j = 0; j < cons.length; j++) {
					areaName = areaName + cons[j];
				}
				((CustomerAddress) this.addressList.get(i))
						.setAddress(areaName);
			}
		}
		this.area.setLevel(2);
		this.areaList = this.areaService.select(this.area);

		this.informationList = this.informationService.select(new Information());
		this.advertiseList = this.advertiseService.getAdvertiseList();
		Area area = new Area();
		area.setLevel(2);
		this.areaList = this.areaService.select(area);
		for (int i = 0; i < this.areaList.size(); i++) {
			Area arer = new Area();
			arer.setParentId(((Area) this.areaList.get(i)).getId());
			arer.setLevel(3);
			List list = this.areaService.select(arer);
			if (list.size() > 0)
				((Area) this.areaList.get(i)).setAreaList(list);

		}

		statisticsOrder();
		return "myaddress";
	}

	public void saveAddress() {
		this.customer = getSessionCustomerInfo();
		try {
			if (this.customerAddress == null) {
				this.customerAddress = new CustomerAddress();
			}
			if (this.customerAddress.getId() == null) {
				this.customerAddress.setCustomerId(this.customer.getId());
				this.addressList = this.customerAddressService
						.select(this.customerAddress);
				if (this.addressList.size() < 10) {
					this.customerAddress.setIsDefault("1");
					this.customerAddressService.insert(this.customerAddress);
				} else {
					responseFlag("error");
				}
			} else {
				this.customerAddressService.update(this.customerAddress);
			}

			this.informationList = this.informationService.select(new Information());
			responseFlag(true);
		} catch (Exception e) {
			responseFlag(false);
			e.printStackTrace();
		}
	}

	public void updateAddress() {
		this.customer = getSessionCustomerInfo();
		try {
			if (this.customerAddress == null) {
				this.customerAddress = new CustomerAddress();
			}

			CustomerAddress address = this.customerAddressService.getAdress(
					this.customer.getId(), "0");
			if (address != null) {
				address.setIsDefault("1");
				if (address != null)
					this.customerAddressService.update(address);
			}

			this.customerAddressService.update(this.customerAddress);

			responseFlag(true);
		} catch (Exception e) {
			responseFlag(false);
			e.printStackTrace();
		}
	}

	public void delAddress() {
		try {
			if (this.customerAddress == null) {
				this.customerAddress = new CustomerAddress();
			}
			if (this.customerAddress.getId() != null) {
				this.customerAddressService
						.delete(this.customerAddress.getId());
				responseFlag(true);
			}
		} catch (Exception e) {
			responseFlag(false);
			e.printStackTrace();
		}
	}

	public void selectAdddress() {
		try {
			if (this.customerAddress == null) {
				this.customerAddress = new CustomerAddress();
			}
			String responseString = "";
			if (this.customerAddress.getId() != null) {
				this.customerAddress = ((CustomerAddress) this.customerAddressService
						.getModel(this.customerAddress.getId()));
				if (this.customerAddress != null) {
					String[] cons = this.customerAddress.getAddress()
							.split("-");
					responseString = this.customerAddress.getId() + ","
							+ this.customerAddress.getName() + "," + cons[0]
							+ "," + cons[1] + "," + cons[2] + ","
							+ this.customerAddress.getStreet() + ","
							+ this.customerAddress.getZipCode() + ","
							+ this.customerAddress.getMobile() + ",";
					responseFlag(responseString);
				}
			}

			responseFlag(responseString);
		} catch (Exception e) {
			responseFlag(false);
			e.printStackTrace();
		}
	}

	public String security() {
		this.customer = getSessionCustomerInfo();

		this.informationList = this.informationService.select(new Information());

		Area area = new Area();
		area.setLevel(2);
		this.areaList = this.areaService.select(area);
		for (int i = 0; i < this.areaList.size(); i++) {
			Area arer = new Area();
			arer.setParentId(((Area) this.areaList.get(i)).getId());
			arer.setLevel(3);
			List list = this.areaService.select(arer);
			if (list.size() > 0)
				((Area) this.areaList.get(i)).setAreaList(list);

		}
		this.advertiseList = this.advertiseService.getAdvertiseList();
		statisticsOrder();
		return "security";
	}

	public String mail() {
		this.customer = getSessionCustomerInfo();
		Area area = new Area();
		area.setLevel(2);
		this.areaList = this.areaService.select(area);
		for (int i = 0; i < this.areaList.size(); i++) {
			Area arer = new Area();
			arer.setParentId(((Area) this.areaList.get(i)).getId());
			arer.setLevel(3);
			List list = this.areaService.select(arer);
			if (list.size() > 0)
				((Area) this.areaList.get(i)).setAreaList(list);
		}

		this.informationList = this.informationService.select(new Information());
		this.advertiseList = this.advertiseService.getAdvertiseList();
		statisticsOrder();
		return "mail";
	}

	public void updateEmail() throws Exception {
		try {
			Customer loginMan = getSessionCustomerInfo();
			if (this.customer == null) {
				this.customer = new Customer();
			}
			String newEmail = this.customer.getNewEmail();
			if (newEmail != null) {
				loginMan.setEmail(newEmail);
				this.customerService.update(loginMan);
				responseFlag(true);
			}
			Area area = new Area();
			area.setLevel(2);
			this.areaList = this.areaService.select(area);
			for (int i = 0; i < this.areaList.size(); i++) {
				Area arer = new Area();
				arer.setParentId(((Area) this.areaList.get(i)).getId());
				arer.setLevel(3);
				List list = this.areaService.select(arer);
				if (list.size() > 0)
					((Area) this.areaList.get(i)).setAreaList(list);
			}

			this.informationList = this.informationService.select(new Information());
			this.advertiseList = this.advertiseService.getAdvertiseList();
			statisticsOrder();
		} catch (RuntimeException e) {
			responseFlag(false);
			e.printStackTrace();
		}
	}

	public String sendEmail() throws MessagingException {
		HttpServletRequest request = getRequest();
		try {
			this.customer = getSessionCustomerInfo();
			String toMail = this.customer.getEmail();
			String registerName = this.customer.getCode();

			String userName = "598628744@qq.com";
			String password = "yibeizi19911030";

			String registerId = Math.random() * Math.random() + "";
			String url = "http://localhsot:8080/frontLogin.do?registerId="+ registerId;

			request.getSession().setAttribute(registerId, registerName);
			request.getSession().setMaxInactiveInterval(600);
			Properties props = new Properties();
			props.setProperty("mail.smtp.host", "smtp.126.com");
			props.setProperty("mail.smtp.auth", "true");
			Authenticator authenticator = new MyAuthenticator(userName,
					password);
			Session session = Session.getDefaultInstance(props, authenticator);
			session.setDebug(true);

			Address from = new InternetAddress(userName);
			Address to = new InternetAddress(toMail);

			MimeMessage msg = new MimeMessage(session);
			msg.setFrom(from);
			msg.setSubject("邮箱验证");
			msg.setSentDate(new Date());
			msg.setContent("<a href='" + url + "'>点击" + url + "</a>","text/html;charset=utf-8");
			// msg.setRecipient(Message.RecipientType.TO, to);
			Transport.send(msg);

			String headEmail = this.customer.getEmail().substring(0, 3);
			String[] email = this.customer.getEmail().split("@");
			String customerEmail = "";
			if (email != null) {
				customerEmail = headEmail + "***@" + email[1];
				this.customer.setNewEmail(customerEmail);
				this.customer.setFootEmail("@" + email[1]);
			}

			Area area = new Area();
			area.setLevel(2);
			this.areaList = this.areaService.select(area);
			for (int i = 0; i < this.areaList.size(); i++) {
				Area arer = new Area();
				arer.setParentId(((Area) this.areaList.get(i)).getId());
				arer.setLevel(3);
				List list = this.areaService.select(arer);
				if (list.size() > 0)
					((Area) this.areaList.get(i)).setAreaList(list);
			}

			this.informationList = this.informationService
					.select(new Information());

			statisticsOrder();
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return "emailOne";
	}

	public String tuihuan() {
		this.customer = getSessionCustomerInfo();
		if (this.saleReturn == null) {
			this.saleReturn = new SaleReturn();
		}
		this.saleReturn.setCustomerId(this.customer.getId());
		this.saleReturnList = this.saleReturnService.select(this.saleReturn);
		if (this.saleReturnList.size() > 0) {
			for (int i = 0; i < this.saleReturnList.size(); i++) {
				List list = this.goodService
						.getSaleGoodList(((SaleReturn) this.saleReturnList
								.get(i)).getId());
				if (list.size() > 0)
					((SaleReturn) this.saleReturnList.get(i)).setGoodlist(list);
			}

		}
		this.advertiseList = this.advertiseService.getAdvertiseList();
		this.informationList = this.informationService.select(new Information());
		statisticsOrder();
		return "tuihuan";
	}

	public String tuihuanJsion() {
		this.customer = getSessionCustomerInfo();
		List resultList = null;
		if (this.saleOrder == null) {
			this.saleOrder = new SaleOrder();
		}

		Date time = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(time);
		calendar.add(5, -30);
		Date newDate = calendar.getTime();
		String data = dateFormat.format(newDate);
		try {
			this.saleOrder.setCustomerId(this.customer.getId());
			this.saleOrder.setPaymentState("2");
			this.saleOrder.setOrderState("1");
			this.saleOrder.setDeliveryState("1");
			this.saleOrder.setIscancel("0");
			if (this.saleOrder.getData().equals("0"))
				this.saleOrder.setData(data);
			else {
				this.saleOrder.setData(null);
			}

			if ((this.saleOrder.getSearch() != null)
					&& (!this.saleOrder.getSearch().equals("商品编号/订单号"))) {
				this.saleOrder.setSearchOrder("strs");
				this.saleOrder.setCode(this.saleOrder.getSearch());
			}

			resultList = this.saleOrderService.select(this.saleOrder);
			if (resultList.size() > 0)
				for (int i = 0; i < resultList.size(); i++) {
					SaleWare ware = new SaleWare();
					ware.setSaleId(((SaleOrder) resultList.get(i)).getId());
					List wareList = this.saleWareService.select(ware);
					if (wareList.size() > 0) {
						for (int j = 0; j < wareList.size(); j++) {
							Ware wares = new Ware();
							wares = (Ware) this.wareService
									.getModel(((SaleWare) wareList.get(j))
											.getWareId());
							if (wares != null) {
								Good good = (Good) this.goodService
										.getModel(wares.getGoodId());
								if (good != null) {
									((SaleWare) wareList.get(j))
											.setGoodName(good.getName());
									((SaleWare) wareList.get(j))
											.setGoodPic(good.getPic());
									((SaleWare) wareList.get(j)).setGoodId(good
											.getId());
								}
							}
						}
						((SaleOrder) resultList.get(i)).setWarelist(wareList);
					}
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.jsonMap = new HashMap();
		this.jsonMap.put("rows", resultList);
		return "success";
	}

	public String application() throws Exception {
		HttpServletRequest request = getRequest();

		this.customer = getSessionCustomerInfo();
		if (this.saleOrder == null) {
			this.saleOrder = new SaleOrder();
		}
		if (this.saleWare == null) {
			this.saleWare = new SaleWare();
		}
		this.saleOrder = ((SaleOrder) this.saleOrderService
				.getModel(this.saleOrder.getId()));
		this.saleWare.setSaleId(this.saleOrder.getId());
		if ((this.saleWare.getChestr() != null)
				&& (!this.saleWare.getChestr().equals(""))) {
			String[] cons = new String[100];
			cons = this.saleWare.getChestr().split(",");
			this.saleWare.setCheckStrId(cons);
			this.saleWareList = this.saleWareService.select(
					"SaleWare.SaleWare_saleGoods", this.saleWare);
			request.setAttribute("size", Integer.valueOf(this.saleWareList
					.size()));
		} else {
			this.saleWareList = this.saleWareService.select(this.saleWare);
			request.setAttribute("size", Integer.valueOf(this.saleWareList
					.size()));
		}

		for (int i = 0; i < this.saleWareList.size(); i++) {
			Ware ware = new Ware();
			ware = (Ware) this.wareService
					.getModel(((SaleWare) this.saleWareList.get(i)).getWareId());
			if (ware != null) {
				Good good = (Good) this.goodService.getModel(ware.getGoodId());
				if (good != null) {
					((SaleWare) this.saleWareList.get(i)).setGoodName(good
							.getName());
					((SaleWare) this.saleWareList.get(i)).setGoodPic(good
							.getPic());
					((SaleWare) this.saleWareList.get(i)).setGoodId(good
							.getId());
				}

			}

		}

		if (this.area == null) {
			this.area = new Area();
		}
		this.area.setLevel(2);
		this.areaList = this.areaService.select(this.area);

		this.informationList = this.informationService
				.select(new Information());

		Area area = new Area();
		area.setLevel(2);
		this.areaList = this.areaService.select(area);
		for (int i = 0; i < this.areaList.size(); i++) {
			Area arer = new Area();
			arer.setParentId(((Area) this.areaList.get(i)).getId());
			arer.setLevel(3);
			List list = this.areaService.select(arer);
			if (list.size() > 0)
				((Area) this.areaList.get(i)).setAreaList(list);
		}

		return "application";
	}

	public void saveApplication() {
		try {
			if (this.saleReturn == null) {
				this.saleReturn = new SaleReturn();
			}
			if (this.saleWare == null) {
				this.saleWare = new SaleWare();
			}
			SaleOrder order = (SaleOrder) this.saleOrderService
					.getModel(this.saleReturn.getOrderId());

			String id = this.saleReturnService.makeId();
			this.saleReturn.setId(id);
			this.saleReturn.setOrderId(order.getId());
			this.saleReturn.setCode(this.serialNumberService
					.getSerialNumberByDate("DY", "saleReturn"));

			this.saleReturn.setBankAccountName(order.getBankAccountName());
			this.saleReturn.setBankAccountId(order.getBankAccountId());

			this.saleReturn.setDeliveryCode(order.getDeliveryCode());
			this.saleReturn.setDeliveryName(order.getDeliveryName());
			this.saleReturn.setDeliveryCost(order.getDeliveryCost());

			this.saleReturn.setCustomerId(order.getCreatorId());
			this.saleReturn.setCustomerName(order.getCustomerName());
			this.saleReturn.setMoneyAccount(order.getOrderMoney());
			this.saleReturn.setDeliveryCost(order.getDeliveryCost());
			this.saleReturn.setLinkman(order.getLinkman());
			this.saleReturn.setMobile(order.getMobile());
			this.saleReturn.setDeliveryId(order.getDeliveryId());
			this.saleReturn.setDeliveryCode(order.getDeliveryCode());
			this.saleReturn.setDeliveryName(order.getDeliveryName());
			this.saleReturn.setReturnState("0");
			this.saleReturn.setState("c");
			this.saleReturn.setCreateTime(new Date());

			this.saleReturn.setWarehouseId(order.getWarehouseId());
			this.saleReturn.setWarehouseName(order.getWarehouseName());

			this.saleReturnService.insert(this.saleReturn);

			this.saleWare.setSaleId(order.getId());
			this.saleWareList = this.saleWareService.select(this.saleWare);

			String[] WareId = new String[''];
			WareId = this.saleReturn.getWareId().split(",");

			String[] number = new String[''];
			number = this.saleReturn.getNumber().split(",");

			for (int i = 0; i < WareId.length; i++) {
				SaleWare saleWare = new SaleWare();
				saleWare.setSaleId(id);
				saleWare.setWareId(WareId[i]);
				saleWare.setOrderNumber(Double.valueOf(Double
						.parseDouble(number[i])));

				SaleWare ware = new SaleWare();
				ware.setSaleId(order.getId());
				ware.setWareId(WareId[i]);
				ware = (SaleWare) this.saleWareService.selectOne(ware);

				saleWare.setGoodPrice(ware.getGoodPrice());
				saleWare.setMoney(Double.valueOf(ware.getGoodPrice()
						.doubleValue()
						* Double.parseDouble(number[i])));

				saleWare.setType("2");
				saleWare.setSort(Integer.valueOf(i));
				try {
					this.saleWareService.insert(saleWare);
				} catch (Exception e) {
					responseFlag(false);
					logger.error("error occur when insert a sale ware", e);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		responseFlag(true);
	}

	public String results() {
		try {
			this.customer = getSessionCustomerInfo();
			if (this.saleReturn == null) {
				this.saleReturn = new SaleReturn();
			}
			if (this.saleWare == null) {
				this.saleWare = new SaleWare();
			}
			this.saleReturn = ((SaleReturn) this.saleReturnService
					.getModel(this.saleReturn.getId()));
			this.saleWare.setSaleId(this.saleReturn.getId());
			this.saleWare.setCreatorId(this.customer.getId());
			this.saleWareList = this.saleWareService.select(this.saleWare);
			for (int i = 0; i < this.saleWareList.size(); i++) {
				Ware ware = new Ware();
				ware = (Ware) this.wareService
						.getModel(((SaleWare) this.saleWareList.get(i))
								.getWareId());
				if (ware != null) {
					Good good = (Good) this.goodService.getModel(ware
							.getGoodId());
					if (good != null)
						((SaleWare) this.saleWareList.get(i)).setGoodName(good
								.getName());
				}
			}
		} catch (RuntimeException e) {
			e.printStackTrace();
		}

		this.informationList = this.informationService.select(new Information());

		Area area = new Area();
		area.setLevel(2);
		this.areaList = this.areaService.select(area);
		for (int i = 0; i < this.areaList.size(); i++) {
			Area arer = new Area();
			arer.setParentId(((Area) this.areaList.get(i)).getId());
			arer.setLevel(3);
			List list = this.areaService.select(arer);
			if (list.size() > 0)
				((Area) this.areaList.get(i)).setAreaList(list);
		}

		return "results";
	}

	public void updateReturnSate() throws Exception {
		try {
			if (this.saleReturn == null) {
				this.saleReturn = new SaleReturn();
			}
			String id = this.saleReturn.getId();
			if (StringUtils.isNotBlank(id)) {
				this.saleReturn = ((SaleReturn) this.saleReturnService
						.getModel(id));
				this.saleReturn.setReceiveTime(new Date());
				this.saleReturn.setReturnState("2");
				this.saleReturnService.update(this.saleReturn);
				responseFlag(true);
			}
		} catch (RuntimeException e) {
			e.printStackTrace();
			responseFlag(false);
		}
	}

	public void changeReturnNumber() {
		HttpServletRequest request = getRequest();
		String countStr = request.getParameter("count");
		String goodId = request.getParameter("goodId");
		String saleorderid = request.getParameter("saleorderid");

		if (this.saleWare == null) {
			this.saleWare = new SaleWare();
		}
		this.saleWare.setSaleId(saleorderid);
		this.saleWare.setWareId(goodId);
		SaleWare ware = (SaleWare) this.saleWareService
				.selectOne(this.saleWare);
		if (countStr != null) {
			Integer count = Integer.valueOf(Integer.parseInt(countStr));
			if (count.intValue() <= ware.getOrderNumber().doubleValue())
				responseFlag(true);
			else
				responseFlag(false);
		}
	}

	public String pingjiaTwo() {
		HttpServletRequest request = getRequest();
		try {
			this.customer = getSessionCustomerInfo();

			if (this.saleOrder == null) {
				this.saleOrder = new SaleOrder();
			}
			this.saleOrder.setCustomerId(this.customer.getId());
			this.saleOrderList = this.saleOrderService.select(
					"SaleOrder.SaleOrder_comment", this.saleOrder);
			request.setAttribute("size", Integer.valueOf(this.saleOrderList
					.size()));
			if (this.saleOrderList.size() > 0) {
				for (int i = 0; i < this.saleOrderList.size(); i++) {
					List list = this.goodService
							.getSaleGoodList(((SaleOrder) this.saleOrderList
									.get(i)).getId());
					if (list.size() > 0)
						((SaleOrder) this.saleOrderList.get(i))
								.setGoodlist(list);
				}
			}

			String areasId = (String) request.getSession().getAttribute(
					"areasId");

			Good good = new Good();
			good.setProperty("5");
			good.setIsInventory("0");
			if (areasId != null)
				good.setAreasId(areasId);
			this.goodList1 = this.goodService.select("Good.Good_SY", good);
			this.advertiseList = this.advertiseService.getAdvertiseList();
			statisticsOrder();
		} catch (RuntimeException e) {
			e.printStackTrace();
		}

		this.informationList = this.informationService.select(new Information());
		statisticsOrder();
		return "pingjiaTwo";
	}

	public String lianmengSales() {
		this.customer = getSessionCustomerInfo();
		this.informationList = this.informationService.select(new Information());
		return "lianmengSales";
	}

	public String saleUnionOrderJson() throws Exception {
		List resultList = null;

		this.customer = getSessionCustomerInfo();
		try {
			if (this.saleOrder == null) {
				this.saleOrder = new SaleOrder();
			}

			Date time = new Date();
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(time);
			calendar.add(5, -30);
			Date newDate = calendar.getTime();
			String data = dateFormat.format(newDate);

			this.saleOrder.setCustomerId(this.customer.getId());
			if (this.saleOrder.getData().equals("0"))
				this.saleOrder.setData(data);
			else {
				this.saleOrder.setData(null);
			}

			resultList = this.saleOrderService.select(this.saleOrder);
			if (resultList.size() > 0)
				for (int i = 0; i < resultList.size(); i++) {
					List salelist = this.saleWareService
							.getWareBySaleId(((SaleOrder) resultList.get(i))
									.getId());
					if (salelist.size() > 0)
						((SaleOrder) resultList.get(i)).setWarelist(salelist);
				}
		} catch (RuntimeException e) {
			e.printStackTrace();
		}

		this.jsonMap = new HashMap();
		this.jsonMap.put("rows", resultList);
		return "success";
	}

	public String salesAnalysis() {
		this.customer = getSessionCustomerInfo();

		this.informationList = this.informationService
				.select(new Information());

		Area area = new Area();
		area.setLevel(2);
		this.areaList = this.areaService.select(area);
		for (int i = 0; i < this.areaList.size(); i++) {
			Area arer = new Area();
			arer.setParentId(((Area) this.areaList.get(i)).getId());
			arer.setLevel(3);
			List list = this.areaService.select(arer);
			if (list.size() > 0)
				((Area) this.areaList.get(i)).setAreaList(list);
		}

		statisticsOrder();

		return "salesAnalysis";
	}

	public String phone() {
		this.customer = getSessionCustomerInfo();

		this.informationList = this.informationService.select(new Information());
		this.advertiseList = this.advertiseService.getAdvertiseList();
		Area area = new Area();
		area.setLevel(2);
		this.areaList = this.areaService.select(area);
		for (int i = 0; i < this.areaList.size(); i++) {
			Area arer = new Area();
			arer.setParentId(((Area) this.areaList.get(i)).getId());
			arer.setLevel(3);
			List list = this.areaService.select(arer);
			if (list.size() > 0)
				((Area) this.areaList.get(i)).setAreaList(list);
		}

		statisticsOrder();
		return "phone";
	}
	public String phonepackage() {
		this.customer = getSessionCustomerInfo();
		this.informationList = this.informationService.select(new Information());
		statisticsOrder();
		return "phonepackage";
	}

	public void saveHeadImg() {
		try {
			HttpServletRequest request = getRequest();

			this.customer = getSessionCustomerInfo();

			String picId = request.getParameter("picId");
			String pic = request.getParameter("pic");
			if (!picId.equals("")) {
				Customer cus = (Customer) this.customerService
						.getModel(this.customer.getId());
				cus.setPicId(picId);
				cus.setPic(pic);
				this.customerService.update(cus);
				request.getSession().removeAttribute("loginCustomer");
				request.getSession().setAttribute("loginCustomer", cus);
				responseFlag(true);
			}
		} catch (Exception e) {
			e.printStackTrace();
			responseFlag(false);
		}
	}

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<Prepaid> getPrepaidList() {
		return this.prepaidList;
	}

	public void setPrepaidList(List<Prepaid> prepaidList) {
		this.prepaidList = prepaidList;
	}

	public void setPrepaidService(PrepaidService prepaidService) {
		this.prepaidService = prepaidService;
	}

	public List<SaleOrder> getSaleOrderList() {
		return this.saleOrderList;
	}

	public void setSaleOrderList(List<SaleOrder> saleOrderList) {
		this.saleOrderList = saleOrderList;
	}

	public void setSaleOrderService(SaleOrderService saleOrderService) {
		this.saleOrderService = saleOrderService;
	}

	public SaleOrder getSaleOrder() {
		return this.saleOrder;
	}

	public void setSaleOrder(SaleOrder saleOrder) {
		this.saleOrder = saleOrder;
	}

	public List<SaleWare> getSaleWareList() {
		return this.saleWareList;
	}

	public void setSaleWareList(List<SaleWare> saleWareList) {
		this.saleWareList = saleWareList;
	}

	public void setSaleWareService(SaleWareService saleWareService) {
		this.saleWareService = saleWareService;
	}

	public SaleWare getSaleWare() {
		return this.saleWare;
	}

	public void setSaleWare(SaleWare saleWare) {
		this.saleWare = saleWare;
	}

	public void setWareService(WareService wareService) {
		this.wareService = wareService;
	}

	public void setGoodService(GoodService goodService) {
		this.goodService = goodService;
	}

	public void setWareSpecificationValService(
			WareSpecificationValService wareSpecificationValService) {
		this.wareSpecificationValService = wareSpecificationValService;
	}

	public ApplyToCash getApplyToCash() {
		return this.applyToCash;
	}

	public void setApplyToCash(ApplyToCash applyToCash) {
		this.applyToCash = applyToCash;
	}

	public void setApplyToCashService(ApplyToCashService applyToCashService) {
		this.applyToCashService = applyToCashService;
	}

	public List<VipCoupon> getVipCouponList() {
		return this.vipCouponList;
	}

	public void setVipCouponList(List<VipCoupon> vipCouponList) {
		this.vipCouponList = vipCouponList;
	}

	public void setVipCouponService(VipCouponService vipCouponService) {
		this.vipCouponService = vipCouponService;
	}

	public List<ApplyToCash> getApplyToCashList() {
		return this.applyToCashList;
	}

	public void setApplyToCashList(List<ApplyToCash> applyToCashList) {
		this.applyToCashList = applyToCashList;
	}

	public VipCoupon getVipCoupon() {
		return this.vipCoupon;
	}

	public void setVipCoupon(VipCoupon vipCoupon) {
		this.vipCoupon = vipCoupon;
	}

	public void setFavoriteService(FavoriteService favoriteService) {
		this.favoriteService = favoriteService;
	}

	public Favorite getFavorite() {
		return this.favorite;
	}

	public void setFavorite(Favorite favorite) {
		this.favorite = favorite;
	}

	public WareCommentService getWareCommentService() {
		return this.wareCommentService;
	}

	public void setWareCommentService(WareCommentService wareCommentService) {
		this.wareCommentService = wareCommentService;
	}

	public List<WareComment> getWareCommentList() {
		return this.wareCommentList;
	}

	public void setWareCommentList(List<WareComment> wareCommentList) {
		this.wareCommentList = wareCommentList;
	}

	public Message getMessage() {
		return this.message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

	public List<Message> getMessageList() {
		return this.messageList;
	}

	public void setMessageList(List<Message> messageList) {
		this.messageList = messageList;
	}

	public void setMessageService(MessageService messageService) {
		this.messageService = messageService;
	}

	public List<GreetingCard> getGreetingCardList() {
		return this.greetingCardList;
	}

	public void setGreetingCardList(List<GreetingCard> greetingCardList) {
		this.greetingCardList = greetingCardList;
	}

	public GreetingCard getGreetingCard() {
		return this.greetingCard;
	}

	public void setGreetingCard(GreetingCard greetingCard) {
		this.greetingCard = greetingCard;
	}

	public void setGreetingCardService(GreetingCardService greetingCardService) {
		this.greetingCardService = greetingCardService;
	}

	public List<Information> getInformationList() {
		return this.informationList;
	}

	public void setInformationList(List<Information> informationList) {
		this.informationList = informationList;
	}

	public void setInformationService(InformationService informationService) {
		this.informationService = informationService;
	}

	public CusLoginAction getCusLoginAction() {
		return this.CusLoginAction;
	}

	public void setCusLoginAction(CusLoginAction cusLoginAction) {
		this.CusLoginAction = cusLoginAction;
	}

	public BrowseService getBrowseService() {
		return this.browseService;
	}

	public void setBrowseService(BrowseService browseService) {
		this.browseService = browseService;
	}

	public Browse getBrowse() {
		return this.browse;
	}

	public void setBrowse(Browse browse) {
		this.browse = browse;
	}

	public List<Browse> getBrowseList() {
		return this.browseList;
	}

	public void setBrowseList(List<Browse> browseList) {
		this.browseList = browseList;
	}

	public List<Good> getGoodList() {
		return this.goodList;
	}

	public void setGoodList(List<Good> goodList) {
		this.goodList = goodList;
	}

	public List<Good> getGoodList2() {
		return this.goodList2;
	}

	public void setGoodList2(List<Good> goodList2) {
		this.goodList2 = goodList2;
	}

	public GoodExtendService getGoodExtendService() {
		return this.goodExtendService;
	}

	public void setGoodExtendService(GoodExtendService goodExtendService) {
		this.goodExtendService = goodExtendService;
	}

	public List<Advertise> getAdvertiseList() {
		return this.advertiseList;
	}

	public void setAdvertiseList(List<Advertise> advertiseList) {
		this.advertiseList = advertiseList;
	}

	public AdvertiseService getAdvertiseService() {
		return this.advertiseService;
	}

	public void setAdvertiseService(AdvertiseService advertiseService) {
		this.advertiseService = advertiseService;
	}

	public List<Good> getGoodList1() {
		return this.goodList1;
	}

	public void setGoodList1(List<Good> goodList1) {
		this.goodList1 = goodList1;
	}

	public Integer getWarehousecount() {
		return this.warehousecount;
	}

	public void setWarehousecount(Integer warehousecount) {
		this.warehousecount = warehousecount;
	}

	public Information getInformation1() {
		return this.information1;
	}

	public void setInformation1(Information information1) {
		this.information1 = information1;
	}

	public Information getInformation2() {
		return this.information2;
	}

	public void setInformation2(Information information2) {
		this.information2 = information2;
	}

	public VipCouponWareService getVipCouponWareService() {
		return this.vipCouponWareService;
	}

	public void setVipCouponWareService(
			VipCouponWareService vipCouponWareService) {
		this.vipCouponWareService = vipCouponWareService;
	}

	public CustomerAddress getCustomerAddress() {
		return this.customerAddress;
	}

	public void setCustomerAddress(CustomerAddress customerAddress) {
		this.customerAddress = customerAddress;
	}

	public CustomerAddressService getCustomerAddressService() {
		return this.customerAddressService;
	}

	public void setCustomerAddressService(
			CustomerAddressService customerAddressService) {
		this.customerAddressService = customerAddressService;
	}

	public List<CustomerAddress> getAddressList() {
		return this.addressList;
	}

	public void setAddressList(List<CustomerAddress> addressList) {
		this.addressList = addressList;
	}

	public Area getArea() {
		return this.area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public List<Area> getAreaList() {
		return this.areaList;
	}

	public void setAreaList(List<Area> areaList) {
		this.areaList = areaList;
	}

	public AreaService getAreaService() {
		return this.areaService;
	}

	public void setAreaService(AreaService areaService) {
		this.areaService = areaService;
	}

	public void setSaleReturn(SaleReturn saleReturn) {
		this.saleReturn = saleReturn;
	}

	public void setSaleReturnService(SaleReturnService saleReturnService) {
		this.saleReturnService = saleReturnService;
	}

	public SaleReturn getSaleReturn() {
		return this.saleReturn;
	}

	public SaleReturnService getSaleReturnService() {
		return this.saleReturnService;
	}

	public void setSerialNumberService(SerialNumberService serialNumberService) {
		this.serialNumberService = serialNumberService;
	}

	public void setSaleReturnList(List<SaleReturn> saleReturnList) {
		this.saleReturnList = saleReturnList;
	}

	public List<SaleReturn> getSaleReturnList() {
		return this.saleReturnList;
	}

	public WareComment getWareComment() {
		return this.wareComment;
	}

	public void setWareComment(WareComment wareComment) {
		this.wareComment = wareComment;
	}
	
}