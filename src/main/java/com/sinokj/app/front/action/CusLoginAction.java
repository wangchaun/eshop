package com.sinokj.app.front.action;

import com.sinokj.app.baseInfo.area.model.Area;
import com.sinokj.app.baseInfo.area.service.AreaService;
import com.sinokj.app.component.file.model.FileUpload;
import com.sinokj.app.component.file.service.FileUploadService;
import com.sinokj.app.customer.action.CustomerDao;
import com.sinokj.app.customer.model.Customer;
import com.sinokj.app.customer.service.CustomerService;
import com.sinokj.app.front.model.WareComment;
import com.sinokj.app.front.service.FrontGoodService;
import com.sinokj.app.front.service.VerifyKeyService;
import com.sinokj.app.front.service.WareCommentService;
import com.sinokj.app.good.good.model.Good;
import com.sinokj.app.good.good.service.GoodService;
import com.sinokj.app.good.goodBrand.model.GoodBrand;
import com.sinokj.app.good.goodBrand.service.GoodBrandService;
import com.sinokj.app.good.goodType.model.GoodType;
import com.sinokj.app.good.goodType.service.GoodTypeService;
import com.sinokj.app.good.groupgood.model.Groupgood;
import com.sinokj.app.good.groupgood.service.GroupgoodService;
import com.sinokj.app.store.advertise.model.Advertise;
import com.sinokj.app.store.advertise.service.AdvertiseService;
import com.sinokj.app.store.information.model.Information;
import com.sinokj.app.store.information.service.InformationService;
import com.sinokj.app.store.promote.model.Promote;
import com.sinokj.app.store.promote.service.PromoteService;
import com.sinokj.app.store.promotionActivity.model.PromotionActivity;
import com.sinokj.app.store.promotionActivity.model.PromotionActivityGood;
import com.sinokj.app.store.promotionActivity.service.PromotionActivityGoodService;
import com.sinokj.app.store.promotionActivity.service.PromotionActivityService;
import com.sinokj.code.struct.BaseAction;
import com.sinokj.code.util.DateConverter;
import com.sinokj.code.util.DateUtil;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
 
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
 
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import net.sf.json.JSONArray;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

public class CusLoginAction extends BaseAction {
	private static final long serialVersionUID = 2242763885608573292L;
	private static final Logger logger = Logger.getLogger(CusLoginAction.class);
	private Customer customer;
	private CustomerService customerService;
	private String errorInfo;
	private List<Information> informationList;
	private InformationService informationService;
	private List<Promote> promoteList;
	private PromoteService promoteService;
	private List<Advertise> advertiseList;
	private AdvertiseService advertiseService;
	private PromotionActivity promotionActivity;
	private List<PromotionActivity> promotionActivityList;
	private PromotionActivityService promotionActivityService;
	private List<GoodType> goodTypeList;
	private GoodTypeService goodTypeService;
	private List<Good> goodList;
	private GoodService goodService;
	private List<PromotionActivityGood> promotionActivityGoodList;
	private PromotionActivityGoodService promotionActivityGoodService;
	private List<FileUpload> promotionActivityPicList;
	private FileUploadService fileUploadService;
	private FrontGoodService frontGoodService;
	private List<Good> goodArrList1;
	private List<Good> goodArrList2;
	private List<Good> goodArrList3;
	private List<Good> goodArrList4;
	private List<Good> goodArrList5;
	private List<Good> goodList1;
	private List<Good> goodList2;
	private List<Good> goodBrandList;
	private List<Good> goodArrList6;
	private List<Good> goodArrList7;
	private List<Good> goodArrList8;
	private List<Good> goodArrList9;
	private List<Good> goodArrList10;
	private JSONArray resultTree;
	private List<GoodType> goodTypeArrList;
	private GoodType goodType;
	private Good good;
	private List<Good> goodsBydailyList1;
	private List<Good> goodsBydailyList2;
	private List<Good> goodsBydailyList3;
	private List<Good> goodsBydailyList4;
	private Promote promote;
	private GoodBrand goodBrand;
	private GoodBrandService goodBrandService;
	private Groupgood groupgood;
	private GroupgoodService groupgoodService;
	private Information information;
	private WareCommentService wareCommentService;
	private Area area;
	private List<Area> areaList;
	private AreaService areaService;
	private List<Information> inforlist;
	private List<GoodBrand> goodBrandList1;
	private List<GoodBrand> goodBrandList3;
	private String url;
	private ByteArrayInputStream imageStream;
	private String verifyCode;
	private VerifyKeyService verifyKeyService;
	private List<Good> goodBrowseList;
	private int imageNumber = 0;

	public String index() throws Exception {

		GoodType goodtype = new GoodType();
		goodtype.setLevel(Integer.valueOf(1));
		goodtype.setListShow("1");
		this.goodTypeList = this.goodTypeService.queryTypeTree(goodtype);

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		this.good = new Good();
		this.good.setIsInventory("3");
		this.good.setIndexShow("1");
		this.good.setSortVal("sort");
		this.good.setState("s");
		this.good.setEndhdTime(dateFormat.format(new Date()));
		this.goodArrList1 = this.goodService.select("Good.Good_SY", this.good);
       
		this.good = new Good();
		this.good.setIsInventory("2");
		this.good.setIndexShow("1");
		this.good.setSortVal("sort");
		this.good.setState("s");
		this.good.setEndhdTime(dateFormat.format(new Date()));
		this.goodArrList2 = this.goodService.select("Good.Good_SY", this.good);
        
		this.good = new Good();
		/*this.good.setFzproperty("1");*/
		this.good.setProperty("1");
		this.good.setIsInventory("0");
		this.good.setIndexShow("1");
		this.good.setState("s");
		this.good.setSortVal("sort");
		this.goodArrList4 = this.goodService.select("Good.Good_SY", this.good);

		this.goodBrand = new GoodBrand();
		this.goodBrand.setLevel(Integer.valueOf(2));
		this.goodBrand.setIsSele("0");
		this.goodBrandList3 = this.goodBrandService.select(this.goodBrand);

		this.goodBrand = new GoodBrand();
		this.goodBrand.setLevel(Integer.valueOf(2));
		this.goodBrand.setIsSele("1");
		this.goodBrandList1 = this.goodBrandService.select(this.goodBrand);

		this.good = new Good();
		this.good.setFzproperty("3");
		this.good.setIsInventory("0");
		this.good.setState("s");
		this.goodList1 = this.goodService.select("Good.Good_SY", this.good);
		this.customer = getSessionCustomerInfo();
		if (this.customer != null) {
			this.good = new Good();
			this.good.setCustomerId(this.customer.getId());
			this.goodBrowseList = this.goodService.select("Good.Good_SY2",
					this.good);
		}

		Advertise advertise = new Advertise();
		this.advertiseList = this.advertiseService.getByPlaceAdvertiseList(advertise);

		Information infor = new Information();
		infor.setType("0");
		this.inforlist = this.informationService.select(infor);

		this.informationList = this.informationService.select(new Information());

		return "index";
	}

	public String getTypeofGoodJsonYingYe() throws Exception {
		 
		this.good = new Good();	 
		this.good.setProperty("1");
		this.good.setIsInventory("0");
		this.good.setIndexShow("1");
		this.good.setState("s");
		this.good.setSortVal("sort");
		this.goodArrList4 = this.goodService.select("Good.Good_SY", this.good); 
		if (this.goodArrList4 == null) {
			this.goodArrList4  = new ArrayList();
		}
		this.jsonMap = new HashMap();
		this.jsonMap.put("rows", this.goodArrList4 );
		return "success";
	}
	public String getTypeofGoodJson() throws Exception {
		HttpServletRequest request = getRequest();
		String areasId = (String) request.getSession().getAttribute("areasId");
		if (this.good == null) {
			this.good = new Good();
		}
		if (((this.good.getSalesVolume() == null) || (this.good
				.getSalesVolume().equals("")))
				&& ((this.good.getCommentValue() == null) || (this.good
						.getCommentValue().equals("")))) {
			this.good.setSalesVolume("1");
		}
		this.good.setLevel(Integer.valueOf(2));
		this.good.setAreasId(areasId);
		this.good.setIsInventory("0");
		this.goodList2 = this.goodService.select("Good.Good_SYgoodType",
				this.good);
		for (int j = 0; j < this.goodList2.size(); j++) {
			WareComment wareComment = this.wareCommentService
					.getWareCommentByGoodId(((Good) this.goodList2.get(j))
							.getId());
			if (wareComment != null) {
				((Good) this.goodList2.get(j)).setCommentLevel(wareComment
						.getLevel());
			}
		}
		if (this.goodList2 == null) {
			this.goodList2 = new ArrayList();
		}
		this.jsonMap = new HashMap();
		this.jsonMap.put("rows", this.goodList2);
		return "success";
	}

	public String getPromotionBrandsJson() {
		if (this.goodBrand == null) {
			this.goodBrand = new GoodBrand();
		}
		this.goodBrand.setGoodTypeId(this.goodType.getId());
		this.goodBrand.setLevel(Integer.valueOf(2));

		this.goodBrand.setBrand("热门品牌");
		List list = this.goodBrandService.select("GoodBrand.GoodBrandByType2",
				this.goodBrand);
		if (this.promote == null) {
			this.promote = new Promote();
		}
		this.promote.setGoodTypeId(this.goodType.getId());
		this.promoteList = this.promoteService.select(this.promote);
		this.jsonMap = new HashMap();
		this.jsonMap.put("rows", list);
		this.jsonMap.put("Arrs", this.promoteList);
		return "success";
	}

	public String getGoodtypeAllGood() {
		try {
			if (this.goodType == null) {
				this.goodType = new GoodType();
			} else if (this.goodType.getId() != null) {
				List list = this.goodService.getGoodsByGoodType(this.goodType.getId());

				if (list.size() > 0) {
					for (int i = 0; i < list.size(); i++) {
						if ((((Good) list.get(i)).getName() != null)
								&& (((Good) list.get(i)).getName().length() > 20)) {
							((Good) list.get(i)).setName(((Good) list.get(i))
									.getName().substring(0, 20));
						}

					}

					JSONArray jsarry = new JSONArray();
					jsarry = JSONArray.fromObject(list);
					this.resultTree = jsarry;
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "success";
	}

	public String getpropertyAllGood() {
		try {
			if (this.good == null) {
				this.good = new Good();
			} else if (this.good.getProperty() != null) {
				List list = this.goodService.getGoodpropertyList(this.good
						.getProperty());

				if (list.size() > 0) {
					for (int i = 0; i < list.size(); i++) {
						if (((Good) list.get(i)).getEndSaleTime() != null) {
							SimpleDateFormat at = new SimpleDateFormat(
									"yyyy-MM-dd hh:mm:ss");
							((Good) list.get(i)).setEndDate(at
									.format(((Good) list.get(i))
											.getEndSaleTime()));
						}
						if ((((Good) list.get(i)).getName() != null)
								&& (((Good) list.get(i)).getName().length() > 20)) {
							((Good) list.get(i)).setName(((Good) list.get(i))
									.getName().substring(0, 20));
						}

					}

					JSONArray jsarry = new JSONArray();
					jsarry = JSONArray.fromObject(list);
					this.resultTree = jsarry;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "success";
	}

	public String getPromotejson() {
		List resultList = null;
		try {
			if (this.promote == null) {
				this.promote = new Promote();
			}
			resultList = this.promoteService.select("Promote.Promote_proL",
					this.promote);
		} catch (Exception e) {
			logger.error("error occur when list promote", e);
		}
		if (resultList == null) {
			resultList = new ArrayList();
		}
		this.jsonMap = new HashMap();
		this.jsonMap.put("rows", resultList);
		return "success";
	}

	public String getselBrandjson() {
		List resultList = null;
		try {
			if (this.goodBrand == null) {
				this.goodBrand = new GoodBrand();
			}
			if (this.goodBrand.getGoodTypeId() != null) {
				this.goodType = ((GoodType) this.goodTypeService
						.getModel(this.goodBrand.getGoodTypeId()));
				this.goodBrand.setLevel(this.goodType.getLevel());
			}
			resultList = this.goodBrandService.select(
					"GoodBrand.GoodBrandByType", this.goodBrand);
		} catch (Exception e) {
			logger.error("error occur when list goodBrand", e);
		}
		if (resultList == null) {
			resultList = new ArrayList();
		}
		this.jsonMap = new HashMap();
		this.jsonMap.put("rows", resultList);
		return "success";
	}

	public String getselGoodjson() {
		List resultList = null;
		try {
			if (this.good == null) {
				this.good = new Good();
			}
			if (this.good.getGoodTypeId() != null) {
				this.goodType = ((GoodType) this.goodTypeService
						.getModel(this.good.getGoodTypeId()));
				this.good.setLevel(this.goodType.getLevel());
			}
			this.good.setBeginSaleTime(new Date());
			resultList = this.goodService.select("Good.Good_sel", this.good);
		} catch (Exception e) {
			logger.error("error occur when list good", e);
		}
		if (resultList == null) {
			resultList = new ArrayList();
		}
		this.jsonMap = new HashMap();
		this.jsonMap.put("rows", resultList);
		return "success";
	}

	public String frontLogin() {
		this.promoteList = this.promoteService.select(new Promote());

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

		return "frontLogin";
	}

	public void login() {
		this.informationList = this.informationService.select(new Information());

		Customer loginCustomer = getSessionCustomerInfo();
		HttpServletRequest request = getRequest();

		if (loginCustomer != null) {
			request.setAttribute("loginCustomer", loginCustomer);
			responseFlag(true);
		} else if (this.customer == null) {
			responseFlag(false);
		} else {
			String username = this.customer.getCode();
			Pattern p = Pattern
					.compile("^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1}))+\\d{8})$");
			Matcher m = p.matcher(username);
			if (m.matches()) {
				System.out.println("手机号码登录");
				String mobile = username;
				String pwd = this.customer.getPwd();
				try {
					boolean isValid = this.customerService.isSystemCustomerBymobile(mobile, pwd).booleanValue();
					if (isValid) {
						this.customer.setMobile(username);
						this.customer.setCode(null);
						this.customer = ((Customer) this.customerService.selectOne(this.customer));
						if ("s".equals(this.customer.getState())) {
							 
							loginCustomer = this.customer;
							request.getSession().setAttribute("loginCustomer",loginCustomer);
							responseFlag(true);
						} else if ("c".equals(this.customer.getState())) {
							responseFlag("notConfirm");
						}
					} else {
						responseFlag(false);
					}
				} catch (Exception e) {
					if (this.customer != null)
						logger.error("error occur when user login !account:"
								+ mobile, e);
					else {
						logger.error("error occur when user login !customerUser is null",e);
					}
					responseFlag(false);
				}
			} else if (username.indexOf("@") != -1) {
				System.out.println("邮箱登录");
				String email = username;
				String pwd = this.customer.getPwd();
				try {
					boolean isValid = this.customerService.isSystemCustomerByEmail(email, pwd).booleanValue();
					if (isValid) {
						this.customer.setEmail(email);
						this.customer.setCode(null);
						this.customer = ((Customer) this.customerService.selectOne(this.customer));
						if ("s".equals(this.customer.getState())) {
							logger.info("user:" + email + ",login successed!");
							loginCustomer = this.customer;
							request.getSession().setAttribute("loginCustomer",
									loginCustomer);
							responseFlag(true);
						} else if ("c".equals(this.customer.getState())) {
							responseFlag("notConfirm");
						}
					} else {
						responseFlag(false);
					}
				} catch (Exception e) {
					if (this.customer != null)
						logger.error("error occur when user login !account:"+ email, e);
					else {
						logger.error("error occur when user login !customerUser is null",e);
					}
					responseFlag(false);
				}
			} else {
				 
				String code = username;
				String pwd = this.customer.getPwd();
				try {
				String state=new CustomerDao().getState(code);
				if(state.equals("2")){//未注册
					responseFlag("account");
				}else if(state.equals("1")){//冻结帐号
					responseFlag("pendingAudit");
				}else if(state.equals("0")){//帐号通过
				
					 if (this.customerService.isSystemCustomer(code, pwd).booleanValue()) {
							 
							this.customer.setCode(username);
							this.customer = ((Customer) this.customerService.selectOne(this.customer));
							
							if(this.customer.getState().equals("s")){
							  loginCustomer = this.customer;
							  request.getSession().setAttribute("loginCustomer",loginCustomer);
							  responseFlag(true);
							}else{
							  responseFlag("c");	
							}
					} else {
						responseFlag("pw");
					}}
				} catch (Exception e) {
					if (this.customer != null)
						logger.error("error occur when user login !account:"+ code, e);
					else {
						logger.error("error occur when user login !customerUser is null",	e);
					}
					responseFlag(false);
				}
			}
		}
	}

	public void loginV() {
		this.informationList = this.informationService.select(new Information());

		Customer loginCustomer = getSessionCustomerInfo();
		HttpServletRequest request = getRequest();

		if (loginCustomer != null) {

			request.setAttribute("loginCustomer", loginCustomer);
			responseFlag(true);
		} else if (this.customer == null) {
			responseFlag(false);
		} else {
			String username = this.customer.getCode();
			Pattern p = Pattern.compile("^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1}))+\\d{8})$");
			Matcher m = p.matcher(username);
			if (m.matches()) {
				System.out.println("手机号码登录");
				String mobile = username;
				String pwd = this.customer.getPwd();
				try {
					if (this.customerService.getCustomerByMobile(mobile) == null) {
						responseFlag("mobile");
					} else if (this.customerService.isSystemCustomerBymobile(
							mobile, pwd).booleanValue()) {
						this.customer.setMobile(username);
						this.customer.setCode(null);
						this.customer = ((Customer) this.customerService
								.selectOne(this.customer));
						if ("s".equals(this.customer.getState())) {
							logger.info("user:" + mobile + ",login successed!");
							loginCustomer = this.customer;
							request.getSession().setAttribute("loginCustomer",
									loginCustomer);

							responseFlag(true);
						} else if ("c".equals(this.customer.getState())) {
							responseFlag("notConfirm");
						} else {
							responseFlag(false);
						}
					} else {
						responseFlag("pw");
					}

				} catch (Exception e) {
					if (this.customer != null)
						logger.error("error occur when user login !account:"
								+ mobile, e);
					else {
						logger.error("error occur when user login !customerUser is null",e);
					}
					responseFlag(false);
				}
			} else if (username.indexOf("@") != -1) {
				System.out.println("邮箱登录");
				String email = username;
				String pwd = this.customer.getPwd();
				try {
					if (this.customerService.getCustomerByEmail(email) == null) {
						responseFlag("email");
					} else if (this.customerService.isSystemCustomerByEmail(email, pwd).booleanValue()) {
						this.customer.setEmail(email);
						this.customer.setCode(null);
						this.customer = ((Customer) this.customerService
								.selectOne(this.customer));
						if ("s".equals(this.customer.getState())) {
							logger.info("user:" + email + ",login successed!");
							loginCustomer = this.customer;
							request.getSession().setAttribute("loginCustomer",
									loginCustomer);
							responseFlag(true);
						} else if ("c".equals(this.customer.getState())) {
							responseFlag("notConfirm");
						}
					} else {
						responseFlag("pw");
					}

				} catch (Exception e) {
					if (this.customer != null)
						logger.error("error occur when user login !account:"
								+ email, e);
					else {
						logger.error("error occur when user login !customerUser is null",e);
					}
					responseFlag(false);
				}
			} else {
				 
				String code = username;
				String pwd = this.customer.getPwd();
				try {
				 if (this.customerService.isSystemCustomer(code, pwd).booleanValue()) {

						this.customer.setCode(username);
						this.customer = ((Customer) this.customerService.selectOne(this.customer));
						if(this.customer.getState().equals("s")){
						  loginCustomer = this.customer;
						  request.getSession().setAttribute("loginCustomer",loginCustomer);
						  responseFlag(true);
						}else{
						  responseFlag("c");
						}
				} else {
					responseFlag("pw");
				}
				} catch (Exception e) {
				    logger.error("loginV={}",e);
					responseFlag(false);
				}
			}
		}
	}

	public String product() {
		return "loginSucc";
	}

	public String zhuce() {
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

		String securityCode = VerifyKeyService.getSecurityCode();
		String[] secStrings = new String[2];
		secStrings[1] = securityCode;
		String templateurl = getRequest().getSession().getServletContext().getRealPath("/");
		File file = new File(templateurl + "verifyKey");
		if (!file.exists())
			file.mkdir();

		try {
			ImageIO.write(VerifyKeyService.createImage(securityCode), "jpg",
					new File(templateurl + "verifyKey/verifyKey.jpg"));
			ImageIO.write(VerifyKeyService.createImage(securityCode), "jpg",
					new File(templateurl + "verifyKey/verifyKey"
							+ this.imageNumber + ".jpg"));

			getRequest().getSession().setAttribute("security_code", secStrings);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return "zhuce";
	}

	public void verifyCode() {
		String[] secStrings = (String[]) getRequest().getSession()
				.getAttribute("security_code");
	 

		if (secStrings[0] == null) {
			if ((this.verifyCode != null)
					&& (secStrings[1].equals(this.verifyCode))) {
				System.out.println("true");
				responseFlag(true);
			} else {
				System.out.println("false");
				responseFlag(false);
			}
		} else if ((this.verifyCode != null)
				&& (secStrings[0].equals(this.verifyCode))) {
			System.out.println("true");
			responseFlag(true);
		} else {
			System.out.println("false");
			responseFlag(false);
		}
	}

	public void changeImage() {
		String[] secStrings = (String[]) getRequest().getSession()
				.getAttribute("security_code");
		secStrings[0] = secStrings[1];

		secStrings[1] = VerifyKeyService.getSecurityCode();

		System.out.println(secStrings[0] + "::::::::::;;;;;;;;;;;;;;;:"
				+ secStrings[1]);

		String templateurl = getRequest().getSession().getServletContext()
				.getRealPath("/");
		try {
			System.out.println("------------------------------------------");

			if (this.imageNumber > 1) {
				File file = new File(templateurl + "verifyKey/verifyKey"
						+ (this.imageNumber - 2) + ".jpg");
				if (file.exists())
					file.delete();
			}

			ImageIO.write(VerifyKeyService.createImage(secStrings[1]), "jpg",
					new File(templateurl + "verifyKey/verifyKey"
							+ this.imageNumber + ".jpg"));
			getRequest().getSession().setAttribute("security_code", secStrings);

			System.out.println("---------------" + this.imageNumber
					+ "-----------------securityCode:" + secStrings[0]);

			responseFlag(true);
		} catch (IOException e) {
			e.printStackTrace();
			responseFlag(false);
		}
	}

	public String qyregister() {
		this.informationList = this.informationService
				.select(new Information());
		return "qyregister";
	}

	public void checkUser() {
		if (this.customer == null)
			this.customer = new Customer();
		try {
			if (this.customerService.getCustomer(this.customer) == null) {
				System.out.println("true");
				responseFlag(true);
			} else {
				System.out.println("false");
				responseFlag(false);
			}
		} catch (Exception e) {
			e.printStackTrace();
			responseFlag(false);
		}
	}
    /*获取ip*/
	public String getIpAddr(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
		ip = request.getHeader("Proxy-Client-IP");
		}
		if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
		ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
		ip = request.getRemoteAddr();
		}
		return ip;
	}
	 
	public void registerUser() {
		HttpServletRequest request = getRequest();
		if (this.customer == null)
			this.customer = new Customer();
		 
		try {
			if (StringUtils.isBlank(this.customer.getId())) {
				this.customer.setState("s");
				this.customer.setType("0");
				this.customer.setIsPinlessemail("0");
				this.customer.setIsPinlessmobile("0");
				this.customer.setCreateTime(new Date());
				this.customer.setCredits(Double.valueOf(0.0D));
				this.customer.setPayables(Double.valueOf(0.0D));
				this.customer.setName(this.customer.getCode());
                this.customer.setCredit(0);
                this.customer.setClintIp(getIpAddr(request));
                this.customer.setAgree("我已经阅读并同意《网上商城用户协议书》");
				this.customerService.insert(this.customer);
				request.setAttribute("loginCustomer", this.customer);
				request.getSession().setAttribute("loginCustomer",this.customer);
			}
			responseFlag(true);
		} catch (Exception e) {
			e.printStackTrace();
			responseFlag(false);
		}
	}

	public String registerSucc() {
		this.informationList = this.informationService
				.select(new Information());
		return "registerSucc";
	}

	public String loginOut() {
		Customer loginCustomer = getSessionCustomerInfo();
		if (loginCustomer != null) {
			logger.info(loginCustomer.getCode() + " logout!");
			HttpServletRequest request = getRequest();
			request.getSession().removeAttribute("loginCustomer");
			request.getSession().removeAttribute("shoppingCar");
			request.getSession().removeAttribute("shoppingCarSize");
		}
		return "loginOut";
	}

	public void validationLogin() {
		Customer loginCustomer = getSessionCustomerInfo();
		if (loginCustomer != null)
			responseFlag(true);
		else
			responseFlag(false);
	}

	public void checkCodes() throws Exception {
		if (this.customer == null) {
			this.customer = new Customer();
		}
		this.customer = this.customerService.getCustomer(this.customer);
		if (this.customer != null)
			responseFlag(true);
	}

	public void checkEmail() throws Exception {
		if (this.customer == null) {
			this.customer = new Customer();
		}
		this.customer = this.customerService.getCustomer(this.customer);
		if (this.customer != null)
			responseFlag(true);
	}

	public void checkEmai() {
		if (this.customer == null)
			this.customer = new Customer();
		try {
			if (this.customerService.getCustomer(this.customer) == null) {
				System.out.println("true");
				responseFlag(true);
			} else {
				System.out.println("false");
				responseFlag(false);
			}
		} catch (Exception e) {
			e.printStackTrace();
			responseFlag(false);
		}
	}
	/**用户忘记密码*/
    public String forgetPassword(){
    	return "forget";
    }
	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public CustomerService getCustomerService() {
		return this.customerService;
	}

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	public String getErrorInfo() {
		return this.errorInfo;
	}

	public void setErrorInfo(String errorInfo) {
		this.errorInfo = errorInfo;
	}

	public List<Information> getInformationList() {
		return this.informationList;
	}

	public void setInformationList(List<Information> informationList) {
		this.informationList = informationList;
	}

	public InformationService getInformationService() {
		return this.informationService;
	}

	public void setInformationService(InformationService informationService) {
		this.informationService = informationService;
	}

	public List<Promote> getPromoteList() {
		return this.promoteList;
	}

	public void setPromoteList(List<Promote> promoteList) {
		this.promoteList = promoteList;
	}

	public PromoteService getPromoteService() {
		return this.promoteService;
	}

	public void setPromoteService(PromoteService promoteService) {
		this.promoteService = promoteService;
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

	public List<PromotionActivity> getPromotionActivityList() {
		return this.promotionActivityList;
	}

	public void setPromotionActivityList(
			List<PromotionActivity> promotionActivityList) {
		this.promotionActivityList = promotionActivityList;
	}

	public PromotionActivity getPromotionActivity() {
		return this.promotionActivity;
	}

	public void setPromotionActivity(PromotionActivity promotionActivity) {
		this.promotionActivity = promotionActivity;
	}

	public PromotionActivityService getPromotionActivityService() {
		return this.promotionActivityService;
	}

	public void setPromotionActivityService(
			PromotionActivityService promotionActivityService) {
		this.promotionActivityService = promotionActivityService;
	}

	public List<GoodType> getGoodTypeList() {
		return this.goodTypeList;
	}

	public void setGoodTypeList(List<GoodType> goodTypeList) {
		this.goodTypeList = goodTypeList;
	}

	public GoodTypeService getGoodTypeService() {
		return this.goodTypeService;
	}

	public void setGoodTypeService(GoodTypeService goodTypeService) {
		this.goodTypeService = goodTypeService;
	}

	public List<Good> getGoodList() {
		return this.goodList;
	}

	public void setGoodList(List<Good> goodList) {
		this.goodList = goodList;
	}

	public GoodService getGoodService() {
		return this.goodService;
	}

	public void setGoodService(GoodService goodService) {
		this.goodService = goodService;
	}

	public List<PromotionActivityGood> getPromotionActivityGoodList() {
		return this.promotionActivityGoodList;
	}

	public void setPromotionActivityGoodList(
			List<PromotionActivityGood> promotionActivityGoodList) {
		this.promotionActivityGoodList = promotionActivityGoodList;
	}

	public PromotionActivityGoodService getPromotionActivityGoodService() {
		return this.promotionActivityGoodService;
	}

	public void setPromotionActivityGoodService(
			PromotionActivityGoodService promotionActivityGoodService) {
		this.promotionActivityGoodService = promotionActivityGoodService;
	}

	public List<FileUpload> getPromotionActivityPicList() {
		return this.promotionActivityPicList;
	}

	public void setPromotionActivityPicList(
			List<FileUpload> promotionActivityPicList) {
		this.promotionActivityPicList = promotionActivityPicList;
	}

	public FileUploadService getFileUploadService() {
		return this.fileUploadService;
	}

	public void setFileUploadService(FileUploadService fileUploadService) {
		this.fileUploadService = fileUploadService;
	}

	public FrontGoodService getFrontGoodService() {
		return this.frontGoodService;
	}

	public void setFrontGoodService(FrontGoodService frontGoodService) {
		this.frontGoodService = frontGoodService;
	}

	public GoodType getGoodType() {
		return this.goodType;
	}

	public void setGoodType(GoodType goodType) {
		this.goodType = goodType;
	}

	public List getGoodArrList1() {
		return this.goodArrList1;
	}

	public void setGoodArrList1(List goodArrList1) {
		this.goodArrList1 = goodArrList1;
	}

	public List getGoodArrList2() {
		return this.goodArrList2;
	}

	public void setGoodArrList2(List goodArrList2) {
		this.goodArrList2 = goodArrList2;
	}

	public List getGoodArrList3() {
		return this.goodArrList3;
	}

	public void setGoodArrList3(List goodArrList3) {
		this.goodArrList3 = goodArrList3;
	}

	public List getGoodArrList4() {
		return this.goodArrList4;
	}

	public void setGoodArrList4(List goodArrList4) {
		this.goodArrList4 = goodArrList4;
	}

	public List<Good> getGoodsBydailyList1() {
		return this.goodsBydailyList1;
	}

	public void setGoodsBydailyList1(List<Good> goodsBydailyList1) {
		this.goodsBydailyList1 = goodsBydailyList1;
	}

	public List<Good> getGoodsBydailyList2() {
		return this.goodsBydailyList2;
	}

	public void setGoodsBydailyList2(List<Good> goodsBydailyList2) {
		this.goodsBydailyList2 = goodsBydailyList2;
	}

	public List<Good> getGoodsBydailyList3() {
		return this.goodsBydailyList3;
	}

	public void setGoodsBydailyList3(List<Good> goodsBydailyList3) {
		this.goodsBydailyList3 = goodsBydailyList3;
	}

	public List<Good> getGoodsBydailyList4() {
		return this.goodsBydailyList4;
	}

	public void setGoodsBydailyList4(List<Good> goodsBydailyList4) {
		this.goodsBydailyList4 = goodsBydailyList4;
	}

	public List<GoodType> getGoodTypeArrList() {
		return this.goodTypeArrList;
	}

	public void setGoodTypeArrList(List<GoodType> goodTypeArrList) {
		this.goodTypeArrList = goodTypeArrList;
	}

	public List<Good> getGoodArrList6() {
		return this.goodArrList6;
	}

	public void setGoodArrList6(List<Good> goodArrList6) {
		this.goodArrList6 = goodArrList6;
	}

	public List<Good> getGoodArrList7() {
		return this.goodArrList7;
	}

	public void setGoodArrList7(List<Good> goodArrList7) {
		this.goodArrList7 = goodArrList7;
	}

	public List<Good> getGoodArrList8() {
		return this.goodArrList8;
	}

	public void setGoodArrList8(List<Good> goodArrList8) {
		this.goodArrList8 = goodArrList8;
	}

	public List<Good> getGoodArrList9() {
		return this.goodArrList9;
	}

	public void setGoodArrList9(List<Good> goodArrList9) {
		this.goodArrList9 = goodArrList9;
	}

	public List<Good> getGoodArrList10() {
		return this.goodArrList10;
	}

	public void setGoodArrList10(List<Good> goodArrList10) {
		this.goodArrList10 = goodArrList10;
	}

	public JSONArray getResultTree() {
		return this.resultTree;
	}

	public void setResultTree(JSONArray resultTree) {
		this.resultTree = resultTree;
	}

	public Good getGood() {
		return this.good;
	}

	public void setGood(Good good) {
		this.good = good;
	}

	public Promote getPromote() {
		return this.promote;
	}

	public void setPromote(Promote promote) {
		this.promote = promote;
	}

	public GoodBrand getGoodBrand() {
		return this.goodBrand;
	}

	public void setGoodBrand(GoodBrand goodBrand) {
		this.goodBrand = goodBrand;
	}

	public void setGoodBrandService(GoodBrandService goodBrandService) {
		this.goodBrandService = goodBrandService;
	}

	public Groupgood getGroupgood() {
		return this.groupgood;
	}

	public void setGroupgood(Groupgood groupgood) {
		this.groupgood = groupgood;
	}

	public void setGroupgoodService(GroupgoodService groupgoodService) {
		this.groupgoodService = groupgoodService;
	}

	public Information getInformation() {
		return this.information;
	}

	public void setInformation(Information information) {
		this.information = information;
	}

	public List getGoodBrandList() {
		return this.goodBrandList;
	}

	public void setGoodBrandList(List goodBrandList) {
		this.goodBrandList = goodBrandList;
	}

	public WareCommentService getWareCommentService() {
		return this.wareCommentService;
	}

	public void setWareCommentService(WareCommentService wareCommentService) {
		this.wareCommentService = wareCommentService;
	}

	public GoodBrandService getGoodBrandService() {
		return this.goodBrandService;
	}

	public GroupgoodService getGroupgoodService() {
		return this.groupgoodService;
	}

	public List<Good> getGoodArrList5() {
		return this.goodArrList5;
	}

	public void setGoodArrList5(List<Good> goodArrList5) {
		this.goodArrList5 = goodArrList5;
	}

	public List getGoodList1() {
		return this.goodList1;
	}

	public void setGoodList1(List goodList1) {
		this.goodList1 = goodList1;
	}

	public List<Good> getGoodList2() {
		return this.goodList2;
	}

	public void setGoodList2(List<Good> goodList2) {
		this.goodList2 = goodList2;
	}

	public List<Area> getAreaList() {
		return this.areaList;
	}

	public void setAreaList(List<Area> areaList) {
		this.areaList = areaList;
	}

	public void setAreaService(AreaService areaService) {
		this.areaService = areaService;
	}

	public Area getArea() {
		return this.area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public AreaService getAreaService() {
		return this.areaService;
	}

	public List<Information> getInforlist() {
		return this.inforlist;
	}

	public void setInforlist(List<Information> inforlist) {
		this.inforlist = inforlist;
	}

	public List<GoodBrand> getGoodBrandList1() {
		return this.goodBrandList1;
	}

	public void setGoodBrandList1(List<GoodBrand> goodBrandList1) {
		this.goodBrandList1 = goodBrandList1;
	}

	public List<GoodBrand> getGoodBrandList3() {
		return this.goodBrandList3;
	}

	public void setGoodBrandList3(List<GoodBrand> goodBrandList3) {
		this.goodBrandList3 = goodBrandList3;
	}

	public ByteArrayInputStream getImageStream() {
		return this.imageStream;
	}

	public void setImageStream(ByteArrayInputStream imageStream) {
		this.imageStream = imageStream;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getVerifyCode() {
		return this.verifyCode;
	}

	public void setVerifyCode(String verifyCode) {
		this.verifyCode = verifyCode;
	}

	public int getImageNumber() {
		return this.imageNumber;
	}

	public VerifyKeyService getVerifyKeyService() {
		return this.verifyKeyService;
	}

	public void setVerifyKeyService(VerifyKeyService verifyKeyService) {
		this.verifyKeyService = verifyKeyService;
	}

	public List<Good> getGoodBrowseList() {
		return this.goodBrowseList;
	}

	public void setImageNumber(int imageNumber) {
		this.imageNumber = imageNumber;
	}

	public void setGoodBrowseList(List<Good> goodBrowseList) {
		this.goodBrowseList = goodBrowseList;
	}
}