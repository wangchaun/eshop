package com.sinokj.app.good.phone;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import jxl.Sheet;
import jxl.Workbook;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;

import com.sinokj.app.common.Static;
import com.sinokj.app.customer.model.Customer;
import com.sinokj.app.customer.service.CustomerService;
import com.sinokj.app.good.good.model.Good;
import com.sinokj.app.good.good.service.GoodService;
import com.sinokj.app.good.goodSpecification.model.GoodSpecificationVal;
import com.sinokj.app.good.ware.model.Ware;
import com.sinokj.app.good.ware.service.WareService;
import com.sinokj.app.store.advertise.model.Advertise;
import com.sinokj.app.store.advertise.service.AdvertiseService;
import com.sinokj.app.store.information.model.Information;
import com.sinokj.app.store.information.service.InformationService;
import com.sinokj.app.system.user.model.SysUser;
import com.sinokj.code.struct.BaseAction;
import com.sinokj.code.util.DateUtil;
import com.sinokj.code.util.PageInfo;

public class PhoneAction extends BaseAction {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(PhoneAction.class);
	private Phone phone;
	private PhoneService phoneService;
	private List<Information> informationList;
	private InformationService informationService;
	private Good good;
	private Ware ware;
	private GoodService goodService;
	private WareService wareService;
	private List<Advertise> advertiseList;
	private AdvertiseService advertiseService;
	private List<GoodSpecificationVal> reversions;
	private File[] fileupload;
	private String[] fileuploadFileName;
	private CustomerService customerService;
	private Customer customer;
	/*遍历所有客户，放在这里 很无奈*/
	public String listJson(){
		 logger.info("start to list Customer information");   
	     if (this.customer == null) {
	       this.customer = new Customer();
	     }  
	     SysUser loginMan = getSessionUserInfo();
	     String warehouseId = loginMan.getWarehouseId();
	     if (warehouseId != null) {
	       this.customer.setWarehouseId(warehouseId);
	     }
	     
	     List<Customer> list = null;
	     int totalRows = 0;
	     try {
	       PageInfo pageInfo = createPageInfo();
	       list = this.customerService.pageList(pageInfo, this.customer, true);
	       if (list == null) {
	         list = new ArrayList<Customer>();
	       }
	       totalRows = pageInfo.getCount();
	     }
	     catch (Exception e) {
	       logger.info("eror occur when listing Customer information");
	       e.printStackTrace();
	     }
	     this.jsonMap = new HashMap<String,Object>();
	     this.jsonMap.put("total", Integer.valueOf(totalRows));
	     this.jsonMap.put("rows", list);
	     logger.info("finish list all Customer data!");
	 
	     return "success";
	   }
	public String phone_json() {
		logger.info("start list phones!");
		List<Phone> phones = null;
		int totalRows = 0;
		try {
			PageInfo pageInfo = createPageInfo();

			if (this.phone == null) {
				this.phone = new Phone();
			}
			if (this.ware == null) {
				this.ware = new Ware();
			}
			String wareId = this.ware.getId();
			String telPhone = this.phone.getTelphone();
			this.phone.setWareId(wareId);
			this.phone.setTelphone(telPhone);
			this.phone.setIsBuy("n");
			phones = this.phoneService.pageList(pageInfo, this.phone, true);
			totalRows = pageInfo.getCount();

		} catch (Exception e) {
			e.printStackTrace();
			logger.error("error occur when list phones", e);
		}
		if (phones == null) {
			phones = new ArrayList<Phone>();
		}
		this.jsonMap = new HashMap<String, Object>();
		this.jsonMap.put("total", Integer.valueOf(totalRows));
		this.jsonMap.put("rows", phones);

		logger.info("finish list all data!");
		return "success";
	}
	/*根据选中号码来修改时间*/
	public  void getStateByPhone(){
		if (this.phone == null) {
			this.phone = new Phone();
		}
		String telphone=this.phone.getTelphone();
		this.phone.setTelphone(telphone);
		List<Phone> phones=this.phoneService.select(this.phone);
		this.phone=phones.get(0);
		Date temp=this.phone.getModifyTime();
		boolean flag=getState(temp);
		if(flag){
			try {
				this.phone.setModifyTime(new Date());
				this.phoneService.update(this.phone);
				responseFlag(flag);
			} catch (Exception e) {
				responseFlag(false);	
				e.printStackTrace();
			}
		}else{
		 responseFlag(flag);
		}
	}
	/*根据时间差是否为15分钟，若是的话，则返回true，否则返回false*/
	public boolean getState(Date temp){
		long now=System.currentTimeMillis();
		long current=temp.getTime()+900000;
		if(now>current){
			return true;
		}
		return false;
	}
    /*选中的手机号码*/
	public String selectPhone() {
		this.informationList = this.informationService.select(new Information());
		if (this.ware == null) {
			this.ware = new Ware();
		}
		String goodId = this.good.getId();
		String wareId = this.ware.getId();
		this.good = new Good();
		this.good.setId(goodId);
		List<Good> listgood = this.goodService.select("Good.Good_SY", this.good);

		if ((listgood != null) && (listgood.size() > 0))
			this.good = ((Good) listgood.get(0));
		this.ware = ((Ware) this.wareService.getModel(wareId));
		this.advertiseList = this.advertiseService.getAdvertiseList();
		return "selectPhone";
	}
     
	/* 选择手机版本号 */
	public String revesion() {
		reversions = new PhoneDao().getRevesion();
		return "success2";
	}

	/* 上传数据 */
	public String editExcelDate() {
		HttpServletRequest request = getRequest();
		HttpSession session = request.getSession();
		String code = request.getParameter("code");
		session.setAttribute("code", code);
		return "upload_excel";
	}
    
	public void getExcelDate() {
		HttpServletRequest request = getRequest();
		HttpSession session = request.getSession();
		String code = (String) session.getAttribute("code");
		try {
			PhoneDao dao = new PhoneDao();
			String wareId = dao.getByRevesion(code);
			String filePaht = request.getParameter("fileBrowser");
			File file = new File(filePaht);
			Workbook book = Workbook.getWorkbook(file);
			if (book != null) {
				Sheet sheet = book.getSheet(0);

				int rows = sheet.getRows();

				for (int i = 1; i < rows; i++) {
					try {
						this.phone = new Phone();
						this.phone.setId(this.phoneService.makeId());
						this.phone.setWareId(wareId);
						this.phone.setPhoneFee(sheet.getCell(2, i).getContents());
						this.phone.setPrice(Double.valueOf(sheet.getCell(1, i).getContents()));
						this.phone.setIsBuy(sheet.getCell(3, i).getContents());
						this.phone.setTelphone(sheet.getCell(0, i).getContents());
						this.phoneService.insert(this.phone);
					} catch (Exception e) {
						e.printStackTrace();
						responseFlag(false);
					}

				}
				responseFlag(true);
				session.removeAttribute("code");
				book.close();
			} else {
				responseFlag(false);
			}

		} catch (Exception e) {
			e.printStackTrace();
			responseFlag(false);
		}

	}

	/* 上传文件 */
	public String upload() throws Exception {

		HttpServletRequest request = getRequest();
		String folderPath = Static.APACHE_CONTEXT_PATH + Static.FILE_PATH;
		Date now = new Date();
		String nowStr = DateUtil.date2Str(now, "yyyyMMdd");
		now = DateUtil.str2Date(nowStr, "yyyyMMdd");

		folderPath = folderPath + "/excel/" + nowStr;

		logger.info("relativePath:" + folderPath);
		String fileName = "";
		String topath = "";
		boolean isOk = true;
		if ((this.fileupload != null) && (this.fileupload.length > 0)) {
			logger.info("fileupload.length:" + this.fileupload.length);

			File savedir = new File(folderPath);
			if (!savedir.exists()) {
				savedir.mkdirs();
			}

			for (int i = 0; i < this.fileupload.length; i++) {
				fileName = this.fileuploadFileName[i];
				String postfix = fileName
						.substring(fileName.lastIndexOf(".") + 1);
				logger.info("uploadFileName[" + i + "]=" + fileName);

				String id = fileName.substring(0, fileName.lastIndexOf("."));
				String fileNewName = id + "." + postfix;
				File savefile = new File(savedir, fileNewName);
				topath = savedir.getPath() + "/" + fileNewName;
				logger.info("save file:" + fileNewName + " to folder:"
						+ savedir.getPath());
				try {
					FileUtils.copyFile(this.fileupload[i], savefile);

					StringBuffer relativePath = new StringBuffer();
					relativePath.append(Static.FILE_PATH).append("/").append(
							this.appType).append("/").append(nowStr)
							.append("/").append(id).append(".").append(postfix);
				} catch (Exception e) {
					if (isOk) {
						isOk = false;
					}
					logger.error("error when copyFile,savefile:" + savefile, e);
				}
			}
		} else {
			logger.warn("fileupload is null or fileupload.length <=0");
			isOk = false;
		}
		request.setAttribute("topath", topath);
		request.setAttribute("fileName", fileName);
		request.setAttribute("isOk", Boolean.valueOf(isOk));
		return "edit_excelDate";
	}

	public void setPhoneService(PhoneService phoneService) {
		this.phoneService = phoneService;
	}

	public Phone getPhone() {
		return phone;
	}

	public void setPhone(Phone phone) {
		this.phone = phone;
	}

	public List<Information> getInformationList() {
		return informationList;
	}

	public void setInformationList(List<Information> informationList) {
		this.informationList = informationList;
	}

	public InformationService getInformationService() {
		return informationService;
	}

	public void setInformationService(InformationService informationService) {
		this.informationService = informationService;
	}

	public Good getGood() {
		return good;
	}

	public void setGood(Good good) {
		this.good = good;
	}

	public Ware getWare() {
		return ware;
	}

	public void setWare(Ware ware) {
		this.ware = ware;
	}

	public GoodService getGoodService() {
		return goodService;
	}

	public void setGoodService(GoodService goodService) {
		this.goodService = goodService;
	}

	public WareService getWareService() {
		return wareService;
	}

	public void setWareService(WareService wareService) {
		this.wareService = wareService;
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

	public List<GoodSpecificationVal> getReversions() {
		return reversions;
	}

	public void setReversions(List<GoodSpecificationVal> reversions) {
		this.reversions = reversions;
	}

	public File[] getFileupload() {
		return fileupload;
	}

	public void setFileupload(File[] fileupload) {
		this.fileupload = fileupload;
	}

	public String[] getFileuploadFileName() {
		return fileuploadFileName;
	}

	public void setFileuploadFileName(String[] fileuploadFileName) {
		this.fileuploadFileName = fileuploadFileName;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

}
