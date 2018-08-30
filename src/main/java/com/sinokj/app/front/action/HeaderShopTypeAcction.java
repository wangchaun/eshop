package com.sinokj.app.front.action;

import com.sinokj.app.baseInfo.area.model.Area;
import com.sinokj.app.baseInfo.area.service.AreaService;
import com.sinokj.app.customer.model.Customer;
import com.sinokj.app.front.browse.model.Browse;
import com.sinokj.app.front.browse.model.BrowseOthers;
import com.sinokj.app.front.browse.service.BrowseOthersService;
import com.sinokj.app.front.browse.service.BrowseService;
import com.sinokj.app.front.model.ShoppingCar;
import com.sinokj.app.front.service.FrontGoodService;
import com.sinokj.app.good.good.model.Good;
import com.sinokj.app.good.good.service.GoodService;
import com.sinokj.app.good.goodAttr.model.GoodAttr;
import com.sinokj.app.good.goodAttr.service.GoodAttrService;
import com.sinokj.app.good.goodBrand.model.GoodBrand;
import com.sinokj.app.good.goodBrand.service.GoodBrandService;
import com.sinokj.app.good.goodExtend.model.GoodExtend;
import com.sinokj.app.good.goodExtend.service.GoodExtendService;
import com.sinokj.app.good.goodKind.model.GoodKind;
import com.sinokj.app.good.goodKind.model.GoodKingVal;
import com.sinokj.app.good.goodKind.service.GoodKindService;
import com.sinokj.app.good.goodKind.service.GoodKingValService;
import com.sinokj.app.good.goodPrice.service.GoodPriceService;
import com.sinokj.app.good.goodType.model.GoodType;
import com.sinokj.app.good.goodType.service.GoodTypeService;
import com.sinokj.app.store.advertise.model.Advertise;
import com.sinokj.app.store.advertise.service.AdvertiseService;
import com.sinokj.app.store.information.model.Information;
import com.sinokj.app.store.information.service.InformationService;
import com.sinokj.code.struct.BaseAction;
import com.sinokj.code.util.PageInfo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;

public class HeaderShopTypeAcction extends BaseAction {
	private static final Logger logger = Logger.getLogger(HeaderShopTypeAcction.class);
	private GoodType goodType;
	private GoodType goodTypeOne;
	private GoodType goodTypeTwo;
	private List<GoodType> goodTypeList;
	private GoodTypeService goodTypeService;
	private List<GoodBrand> goodBrandList;
	private GoodBrandService goodBrandService;
	private Good good;
	private String type;
	private String shoptypeName;
	private List<Good> GoodListSearch;
	private FrontGoodService frontGoodService;
	private String checkName;
	private BrowseService browseService;
	private List<Browse> browseList;
	private Browse browse;
	private Customer customer;
	private BrowseOthers browseOthers;
	private BrowseOthersService browseOthersService;
	private List<BrowseOthers> listOthers;
	private List<BrowseOthers> listOthers1;
	private List<BrowseOthers> listOthers2;
	private List<BrowseOthers> listOthers3;
	private GoodExtendService goodExtendService;
	private List<GoodKind> goodKindList;
	private GoodKindService goodKindService;
	private List<GoodAttr> GoodAttrList;
	private GoodAttrService goodAttrService;
	private List<GoodKingVal> kingvalList;
	private GoodKingValService goodKingValService;
	private PageInfo pageInfo;
	private ShoppingCar shoppingCar;
	private int shoppingCarSize;
	private List<Information> informationList;
	private InformationService informationService;
	private Area area;
	private List<Area> areaList;
	private AreaService areaService;
	private GoodService goodService;
	private GoodPriceService goodPriceService;
	private List<Advertise> advertiseList;
	private AdvertiseService advertiseService;
	public String shoptype() throws Exception {
		HttpServletRequest request = getRequest();
		HttpSession session = request.getSession();
		this.customer = getSessionCustomerInfo();
		Object obj = session.getAttribute("shoppingCar");
		Object object = (Integer) session.getAttribute("shoppingCarSize");
		if (obj != null)
			this.shoppingCar = ((ShoppingCar) obj);
		else {
			this.shoppingCar = new ShoppingCar();
		}
		if (object != null)
			this.shoppingCarSize = ((Integer) object).intValue();
		else {
			this.shoppingCarSize = 0;
		}
		if (this.good == null) {
			this.good = new Good();
		}

		if (this.good.getName() != null) {
			Good gb = new Good();
			gb.setName(this.good.getName());
		}

		if (this.good.getGoodTypeId() != null) {
			request.setAttribute("goodtypeid", this.good.getGoodTypeId());
		}
		if (this.good.getBrandId() != null) {
			request.setAttribute("goodBrandId", this.good.getBrandId());
		}

		if (this.customer != null) {
			if (this.browse == null)
				this.browse = new Browse();
			this.browse.setCustomerId(this.customer.getId());
			this.browseList = this.browseService.select(this.browse);
			if (this.browseList.size() > 0) {
				for (int i = 0; i < this.browseList.size(); i++) {
					GoodExtend goodExtend = this.goodExtendService
							.getByGoodId(((Browse) this.browseList.get(i))
									.getGoodId());
					if (goodExtend != null) {
						((Browse) this.browseList.get(i))
								.setIntroBrief(goodExtend.getIntroBrief());
					}
				}
			}
		}
		
		GoodBrand gb = new GoodBrand();
		gb.setLevel(Integer.valueOf(2));
		if (this.good.getGoodTypeId() != null) {
			GoodType gts = (GoodType) this.goodTypeService.getModel(this.good
					.getGoodTypeId());
			gb.setParentId(gts.getParentId());
		}
		//品牌
		goodBrandList = new ArrayList<GoodBrand>();

		GoodType goodtype = new GoodType();
		goodtype.setLevel(Integer.valueOf(1));
		goodtype.setName(shoptypeName);
		goodtype.setIsInventories("0");
		goodtype.setListShow("1");
		//根据名称查询类型，包括其子类型
		this.goodTypeList = this.goodTypeService.queryTypeTree(goodtype);
		for (int i = 0; i < this.goodTypeList.size(); i++) {
			Integer warehousecount = Integer.valueOf(0);
			Good gCount = new Good();
			gCount.setGoodTypeId(((GoodType) this.goodTypeList.get(i)).getId());
			//查询类型的数量
			warehousecount = (Integer) this.goodPriceService.selectToT(
					"Good.Good_count_goodTypeOne_query", gCount);
			if (warehousecount != null)
				((GoodType) this.goodTypeList.get(i))
						.setWarehousecount(warehousecount);
			else
				((GoodType) this.goodTypeList.get(i)).setWarehousecount(Integer
						.valueOf(0));
			if (((GoodType) this.goodTypeList.get(i)).getChildren().size() > 0) {
				for (int j = 0; j < ((GoodType) this.goodTypeList.get(i))
						.getChildren().size(); j++) {
					Integer warehousecount2 = Integer.valueOf(0);
					Good gCount2 = new Good();
					gCount2
							.setGoodTypeId(((GoodType) ((GoodType) this.goodTypeList
									.get(i)).getChildren().get(j)).getId());
					warehousecount2 = (Integer) this.goodPriceService
							.selectToT("Good.Good_count_goodTypeTwo_query",
									gCount2);
					((GoodType) ((GoodType) this.goodTypeList.get(i))
							.getChildren().get(j))
							.setWarehousecount(warehousecount2);
					if (warehousecount2 != null)
						((GoodType) ((GoodType) this.goodTypeList.get(i)).getChildren().get(j)).setWarehousecount(warehousecount2);
					else
						((GoodType) ((GoodType) this.goodTypeList.get(i)).getChildren().get(j)).setWarehousecount(Integer.valueOf(0));
				}
			}
			
			gb.setParentId(((GoodType) this.goodTypeList.get(i)).getId());
			//大类相关的品牌
			this.goodBrandList.addAll(this.goodBrandService.select(gb));
		}
		if (this.good.getGoodTypeId() != null) {
			GoodType gts = (GoodType) this.goodTypeService.getModel(this.good
					.getGoodTypeId());
			if (gts != null) {
				this.GoodAttrList = this.goodAttrService
						.getGoodAttrByGoodtypeId(gts.getParentId());
				this.kingvalList = this.goodKingValService
						.getKingValByGoodtypeId(gts.getParentId());
			}
		}


		if (this.good.getShoptypeName() != null)
			request.setAttribute("shoptypeNames", this.good.getShoptypeName());
		if (this.good.getName() != null) {
			request.setAttribute("typeNames", this.good.getName());
		}
		this.advertiseList = this.advertiseService.getAdvertiseList();
		this.informationList = this.informationService.select(new Information());
		return "GoodSearchSelect";
	}

	public String productPage3Json() throws Exception {
	
		List<Good> resultList = null;
		int pageSize = 16;
		if (this.pageInfo == null) {
			this.pageInfo = new PageInfo();
		}
		this.pageInfo.setPageSize(pageSize);
		if (this.pageInfo.getPageIndex() <= 1)
			this.pageInfo.setPageIndex(1);
		else {
			this.pageInfo.setPageIndex(this.pageInfo.getPageIndex());
		}
		if (this.good == null) {
			this.good = new Good();
		}

		if (this.good.getFilesPage3() != null) {
			String[] con = new String['È'];
			con = this.good.getFilesPage3().split(",");
			this.good.setSearproptPage3(con);
		}
		if (this.good.getBrandseaPage3() != null) {
			String[] cons = new String['È'];
			cons = this.good.getBrandseaPage3().split(",");
			this.good.setSearbrandPage3(cons);
		}
		if ((this.good.getBrandseaPage3() != null)
				&& (this.good.getFilesPage3() != null)) {
			this.good.setSearproptbrandPage3("searproptbrand");
			this.good.setFilesPage3("");
			this.good.setBrandseaPage3("");
		}
		if ((this.good.getBrandseaPage3() != null)
				|| (this.good.getFilesPage3() != null)) {
			this.good.setTypeidPage(this.good.getTypeidPage3());
			this.good.setTypeidPage3(null);
		}

		this.good.setIsInventory("0");
        this.good.setState("s");
		resultList = this.frontGoodService.pageList(this.pageInfo, this.good,
				true);
		if (this.good.getSortVal() != null) {
			if (this.good.getSortVal().equals("recommend")) {
				this.good.setSortVal("recommend");
				resultList = this.frontGoodService.pageList(this.pageInfo,
						this.good, true);
			} else if (this.good.getSortVal().equals("")) {
				this.good.setSortVal("ascPrice");
				resultList = this.frontGoodService.pageList(this.pageInfo,
						this.good, true);
			} else if (this.good.getSortVal().equals("createTime")) {
				this.good.setSortVal("createTime");
				resultList = this.frontGoodService.pageList(this.pageInfo,
						this.good, true);
			} else if (this.good.getSortVal().equals("salesVolume")) {
				this.good.setSortVal("salesVolume");
				resultList = this.frontGoodService.pageList(this.pageInfo,
						this.good, true);
			} else if (this.good.getSortVal().equals("sort")) {
				this.good.setSortVal("sort");
				resultList = this.frontGoodService.pageList(this.pageInfo,
						this.good, true);
			}
		}
		if (resultList.size() > 0) {
			for (int i = 0; i < resultList.size(); i++) {
				GoodExtend goodExtend = this.goodExtendService
						.getByGoodId(((Good) resultList.get(i)).getId());
				if (goodExtend != null) {
					((Good) resultList.get(i)).setIntroBrief(goodExtend
							.getIntroBrief());
				}
			}
		}

		if ((this.pageInfo.getCount() > 0)
				&& (this.pageInfo.getCount() % pageSize != 0))
			this.pageInfo.setPageCount(this.pageInfo.getCount() / pageSize + 1);
		else {
			this.pageInfo.setPageCount(this.pageInfo.getCount() / pageSize);
		}
		if (resultList == null) {
			resultList = new ArrayList<Good>();
		}
		this.jsonMap = new HashMap<String,Object>();
		this.jsonMap.put("rows", resultList);
		this.jsonMap.put("pageInfo", this.pageInfo);
		return "success";
	}

	public String getSecondGoods() throws Exception {
		HttpServletRequest request = getRequest();
		this.customer = getSessionCustomerInfo();
		if (this.good == null) {
			this.good = new Good();
		}
		if (this.goodType == null)
			this.goodType = new GoodType();
		else {
			request.setAttribute("goodtypeid", this.goodType.getId());
		}

		GoodType type = (GoodType) this.goodTypeService.getModel(this.goodType
				.getId());
		request.removeAttribute("goodtypeid");
		if (type.getLevel().intValue() == 1) {
			this.good.setParentId(type.getId());
			this.goodType.setParentId(type.getId());
			request.setAttribute("goodtypeid", this.goodType.getId());
		}
		if (type.getLevel().intValue() == 2) {
			GoodType gtype = this.goodTypeService.getLevelTypeNo(type.getId());
			this.good.setParentId(gtype.getId());
			this.goodType.setParentId(gtype.getId());
			request.setAttribute("goodtypeid", this.goodType.getId());
		}
		if (type.getLevel().intValue() == 3) {
			GoodType gtype = this.goodTypeService.getLevelTypeNo(type.getId());
			this.good.setParentId(gtype.getId());
			this.goodType.setParentId(gtype.getId());
			request.setAttribute("goodtypeid", this.goodType.getId());
		}

		if (this.goodType.getParentId() != null) {
			GoodType gt = (GoodType) this.goodTypeService
					.getModel(this.goodType.getParentId());
			if (gt != null) {
				this.GoodAttrList = this.goodAttrService
						.getGoodAttrByGoodtypeId(gt.getId());
				this.kingvalList = this.goodKingValService
						.getKingValByGoodtypeId(gt.getId());
			}

		}

		GoodType g = new GoodType();
		g.setParentId(this.goodType.getParentId());
		this.goodTypeList = this.goodTypeService.select(g);
		this.goodTypeOne = ((GoodType) this.goodTypeService
				.getModel(this.goodType.getParentId()));
		this.goodTypeTwo = ((GoodType) this.goodTypeService
				.getModel(this.goodType.getId()));

		if (this.goodType.getId() != null) {
			this.goodBrandList = this.goodBrandService
					.getGoodBrandListPage3(this.goodType.getId());
		} else {
			GoodBrand gb = new GoodBrand();
			gb.setLevel(Integer.valueOf(2));
			this.goodBrandList = this.goodBrandService.select(gb);
		}

		if (this.customer != null) {
			if (this.browse == null)
				this.browse = new Browse();
			this.browse.setCustomerId(this.customer.getId());
			this.browseList = this.browseService.select(this.browse);
			if (this.browseList.size() > 0) {
				for (int i = 0; i < this.browseList.size(); i++) {
					GoodExtend goodExtend = this.goodExtendService
							.getByGoodId(((Browse) this.browseList.get(i))
									.getId());
					if (goodExtend != null) {
						((Browse) this.browseList.get(i))
								.setIntroBrief(goodExtend.getIntroBrief());
					}

				}

			}

		}

		this.informationList = this.informationService.select(new Information());
		this.advertiseList = this.advertiseService.getAdvertiseList();
		return "second";
	}

	public String productPage2Json() throws Exception {
		List resultList = null;

		int pageSize = 16;
		if (this.pageInfo == null) {
			this.pageInfo = new PageInfo();
		}
		this.pageInfo.setPageSize(pageSize);
		if (this.pageInfo.getPageIndex() <= 1)
			this.pageInfo.setPageIndex(1);
		else {
			this.pageInfo.setPageIndex(this.pageInfo.getPageIndex());
		}
		if (this.good == null) {
			this.good = new Good();
		}
		if (this.good.getFiles() != null) {
			String[] con = new String['È'];
			con = this.good.getFiles().split(",");
			this.good.setSearpropt(con);
		}
		if (this.good.getBrandsea() != null) {
			String[] cons = new String['È'];
			cons = this.good.getBrandsea().split(",");
			this.good.setSearbrand(cons);
		}
		if ((this.good.getBrandsea() != null) && (this.good.getFiles() != null)) {
			this.good.setSearproptbrand("searproptbrand");
			this.good.setFiles("");
			this.good.setBrandsea("");
		}
		if ((this.good.getBrandsea() == null) && (this.good.getFiles() == null)) {
			this.good.setTypeId(this.good.getTypesId());
			this.good.setTypesId(null);
		}

		this.good.setIsInventory("0");
		this.good.setState("s");
		resultList = this.frontGoodService.pageList(this.pageInfo, this.good,
				true);
		if (this.checkName != null) {
			if (this.checkName.equals("recommend")) {
				this.good.setSortVal("recommend");
				resultList = this.frontGoodService.pageList(this.pageInfo,
						this.good, true);
			} else if (this.checkName.equals("")) {
				this.good.setSortVal("ascPrice");
				resultList = this.frontGoodService.pageList(this.pageInfo,
						this.good, true);
			} else if (this.checkName.equals("createTime")) {
				this.good.setSortVal("createTime");
				resultList = this.frontGoodService.pageList(this.pageInfo,
						this.good, true);
			} else if (this.checkName.equals("salesVolume")) {
				this.good.setSortVal("salesVolume");
				resultList = this.frontGoodService.pageList(this.pageInfo,
						this.good, true);
			} else if (this.checkName.equals("sort")) {
				this.good.setSortVal("sort");
				resultList = this.frontGoodService.pageList(this.pageInfo,
						this.good, true);
			}
		}
		if (resultList.size() > 0) {
			for (int i = 0; i < resultList.size(); i++) {
				GoodExtend goodExtend = this.goodExtendService
						.getByGoodId(((Good) resultList.get(i)).getId());
				if (goodExtend != null) {
					((Good) resultList.get(i)).setIntroBrief(goodExtend
							.getIntroBrief());
				}
			}

		}

		if ((this.pageInfo.getCount() > 0)
				&& (this.pageInfo.getCount() % pageSize != 0))
			this.pageInfo.setPageCount(this.pageInfo.getCount() / pageSize + 1);
		else {
			this.pageInfo.setPageCount(this.pageInfo.getCount() / pageSize);
		}
		if (resultList == null) {
			resultList = new ArrayList();
		}
		this.jsonMap = new HashMap();
		this.jsonMap.put("rows", resultList);
		this.jsonMap.put("pageInfo", this.pageInfo);
		return "success";
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

	public List<GoodBrand> getGoodBrandList() {
		return this.goodBrandList;
	}

	public void setGoodBrandList(List<GoodBrand> goodBrandList) {
		this.goodBrandList = goodBrandList;
	}

	public GoodBrandService getGoodBrandService() {
		return this.goodBrandService;
	}

	public void setGoodBrandService(GoodBrandService goodBrandService) {
		this.goodBrandService = goodBrandService;
	}

	public Good getGood() {
		return this.good;
	}

	public void setGood(Good good) {
		this.good = good;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getShoptypeName() {
		return this.shoptypeName;
	}

	public void setShoptypeName(String shoptypeName) {
		this.shoptypeName = shoptypeName;
	}

	public List<Good> getGoodListSearch() {
		return this.GoodListSearch;
	}

	public void setGoodListSearch(List<Good> goodListSearch) {
		this.GoodListSearch = goodListSearch;
	}

	public FrontGoodService getFrontGoodService() {
		return this.frontGoodService;
	}

	public void setFrontGoodService(FrontGoodService frontGoodService) {
		this.frontGoodService = frontGoodService;
	}

	public String getCheckName() {
		return this.checkName;
	}

	public void setCheckName(String checkName) {
		this.checkName = checkName;
	}

	public GoodType getGoodType() {
		return this.goodType;
	}

	public void setGoodType(GoodType goodType) {
		this.goodType = goodType;
	}

	public GoodType getGoodTypeOne() {
		return this.goodTypeOne;
	}

	public void setGoodTypeOne(GoodType goodTypeOne) {
		this.goodTypeOne = goodTypeOne;
	}

	public GoodType getGoodTypeTwo() {
		return this.goodTypeTwo;
	}

	public void setGoodTypeTwo(GoodType goodTypeTwo) {
		this.goodTypeTwo = goodTypeTwo;
	}

	public BrowseService getBrowseService() {
		return this.browseService;
	}

	public void setBrowseService(BrowseService browseService) {
		this.browseService = browseService;
	}

	public List<Browse> getBrowseList() {
		return this.browseList;
	}

	public void setBrowseList(List<Browse> browseList) {
		this.browseList = browseList;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Browse getBrowse() {
		return this.browse;
	}

	public void setBrowse(Browse browse) {
		this.browse = browse;
	}

	public BrowseOthers getBrowseOthers() {
		return this.browseOthers;
	}

	public void setBrowseOthers(BrowseOthers browseOthers) {
		this.browseOthers = browseOthers;
	}

	public BrowseOthersService getBrowseOthersService() {
		return this.browseOthersService;
	}

	public void setBrowseOthersService(BrowseOthersService browseOthersService) {
		this.browseOthersService = browseOthersService;
	}

	public List<BrowseOthers> getListOthers() {
		return this.listOthers;
	}

	public void setListOthers(List<BrowseOthers> listOthers) {
		this.listOthers = listOthers;
	}

	public List<BrowseOthers> getListOthers1() {
		return this.listOthers1;
	}

	public void setListOthers1(List<BrowseOthers> listOthers1) {
		this.listOthers1 = listOthers1;
	}

	public List<BrowseOthers> getListOthers2() {
		return this.listOthers2;
	}

	public void setListOthers2(List<BrowseOthers> listOthers2) {
		this.listOthers2 = listOthers2;
	}

	public List<BrowseOthers> getListOthers3() {
		return this.listOthers3;
	}

	public void setListOthers3(List<BrowseOthers> listOthers3) {
		this.listOthers3 = listOthers3;
	}

	public GoodExtendService getGoodExtendService() {
		return this.goodExtendService;
	}

	public void setGoodExtendService(GoodExtendService goodExtendService) {
		this.goodExtendService = goodExtendService;
	}

	public List<GoodKind> getGoodKindList() {
		return this.goodKindList;
	}

	public void setGoodKindList(List<GoodKind> goodKindList) {
		this.goodKindList = goodKindList;
	}

	public GoodKindService getGoodKindService() {
		return this.goodKindService;
	}

	public void setGoodKindService(GoodKindService goodKindService) {
		this.goodKindService = goodKindService;
	}

	public List<GoodAttr> getGoodAttrList() {
		return this.GoodAttrList;
	}

	public void setGoodAttrList(List<GoodAttr> goodAttrList) {
		this.GoodAttrList = goodAttrList;
	}

	public GoodAttrService getGoodAttrService() {
		return this.goodAttrService;
	}

	public void setGoodAttrService(GoodAttrService goodAttrService) {
		this.goodAttrService = goodAttrService;
	}

	public List<GoodKingVal> getKingvalList() {
		return this.kingvalList;
	}

	public void setKingvalList(List<GoodKingVal> kingvalList) {
		this.kingvalList = kingvalList;
	}

	public GoodKingValService getGoodKingValService() {
		return this.goodKingValService;
	}

	public void setGoodKingValService(GoodKingValService goodKingValService) {
		this.goodKingValService = goodKingValService;
	}

	public PageInfo getPageInfo() {
		return this.pageInfo;
	}

	public void setPageInfo(PageInfo pageInfo) {
		this.pageInfo = pageInfo;
	}

	public ShoppingCar getShoppingCar() {
		return this.shoppingCar;
	}

	public void setShoppingCar(ShoppingCar shoppingCar) {
		this.shoppingCar = shoppingCar;
	}

	public int getShoppingCarSize() {
		return this.shoppingCarSize;
	}

	public void setShoppingCarSize(int shoppingCarSize) {
		this.shoppingCarSize = shoppingCarSize;
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

	public GoodService getGoodService() {
		return this.goodService;
	}

	public void setGoodService(GoodService goodService) {
		this.goodService = goodService;
	}

	public GoodPriceService getGoodPriceService() {
		return this.goodPriceService;
	}

	public void setGoodPriceService(GoodPriceService goodPriceService) {
		this.goodPriceService = goodPriceService;
	}

	public List<Advertise> getAdvertiseList() {
		return advertiseList;
	}

	public void setAdvertiseList(List<Advertise> advertiseList) {
		this.advertiseList = advertiseList;
	}

	public AdvertiseService getAdvertiseService() {
		return advertiseService;
	}

	public void setAdvertiseService(AdvertiseService advertiseService) {
		this.advertiseService = advertiseService;
	}
}