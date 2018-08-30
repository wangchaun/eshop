package com.sinokj.app.good.goodType.action;

import com.sinokj.app.component.file.service.FileUploadService;
import com.sinokj.app.component.serialNumber.service.SerialNumberService;
import com.sinokj.app.good.goodBrand.model.GoodBrand;
import com.sinokj.app.good.goodBrand.service.GoodBrandService;
import com.sinokj.app.good.goodType.model.GoodType;
import com.sinokj.app.good.goodType.service.GoodTypeService;
import com.sinokj.app.system.user.model.SysUser;
import com.sinokj.code.struct.BaseAction;
import com.sinokj.code.util.ConfigUtil;
import com.sinokj.code.util.PageInfo;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

 

public class GoodTypeAction extends BaseAction {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(GoodTypeAction.class);
	private GoodTypeService goodTypeService;
	private SerialNumberService serialNumberService;
	private GoodBrandService goodBrandService;
	private GoodType goodType;
	private List<GoodType> goodTypeList;
	private FileUploadService fileUploadService;

	public String list() {
		String maxLevel = ConfigUtil.getGoodTypeLevel();
		getRequest().setAttribute("maxLevel", maxLevel);
		return "list_goodType";
	}

	public String listJson() {
	    
		if (this.goodType == null) {
			this.goodType = new GoodType();
		}
		String parentId = this.goodType.getParentId();
		 
		if (StringUtils.isNotBlank(parentId)) {
			GoodType type = (GoodType) this.goodTypeService.getModel(parentId);
			Integer parentLevel = type.getLevel();
			this.goodType.setLevel(Integer.valueOf(parentLevel.intValue() + 1));
		}
		logger.info("start to list GoodsType information");
		List<GoodType> typeList = null;
		int totalRows = 0;
		try {
			PageInfo pageInfo = createPageInfo();

			typeList = this.goodTypeService.select(new GoodType());

			if (typeList == null) {
				typeList = new ArrayList<GoodType>();
			}
			totalRows = pageInfo.getCount();
		} catch (Exception e) {
			logger.info("error occur when listing GoodsType information");
			e.printStackTrace();
		}
		this.jsonMap = new HashMap<String, Object>();
		this.jsonMap.put("total", Integer.valueOf(totalRows));
		this.jsonMap.put("rows", typeList);
		this.goodType = new GoodType();
		logger.info("finish list all GoodsType data!");
		return "success";
	}

	public String findType() throws UnsupportedEncodingException {
		HttpServletRequest request = getRequest();
		if (this.goodType == null) {
			this.goodType = new GoodType();
		}
		String typeName = this.goodType.getName();
		if (typeName != null) {
			typeName = URLDecoder.decode(typeName, "UTF-8");
			this.goodType.setName(typeName);
		}
		String parentId = this.goodType.getParentId();
		if (StringUtils.isNotBlank(parentId)) {
			GoodType type = (GoodType) this.goodTypeService.getModel(parentId);
			Integer parentLevel = type.getLevel();
			this.goodType.setLevel(Integer.valueOf(parentLevel.intValue() + 1));
		}
		logger.info("start to list GoodsType information");
		int totalRows = 0;
		PageInfo pageInfo = createPageInfo();
		this.goodTypeList = this.goodTypeService.pageList(pageInfo,
				this.goodType, true);
		if (this.goodTypeList == null) {
			this.goodTypeList = new ArrayList();
		}
		totalRows = pageInfo.getCount();
		request.setAttribute("totalRows", Integer.valueOf(totalRows));
		return "find_goodType";
	}
    
	public String edit() {
		HttpServletRequest request = getRequest();
		try {
			logger.info("start to select GoodsType information");
			SysUser loginMain = getSessionUserInfo();
			if (this.goodType == null) {
				this.goodType = new GoodType();
			}
          
			if (StringUtils.isNotBlank(this.goodType.getId())) {
				this.goodType = ((GoodType) this.goodTypeService.getModel(this.goodType.getId()));

				initModel(false, this.goodType, loginMain);
				if (this.goodType.getLevel().intValue() == 1)
					request.setAttribute("Level", this.goodType.getLevel());
			} else {
				initModel(true, this.goodType, loginMain);

				String parentId = this.goodType.getParentId();
				if ((StringUtils.isNotBlank(parentId)) && (parentId != null)) {
					GoodType type = (GoodType) this.goodTypeService.getModel(parentId);
					String parentName = type.getName();
					this.goodType.setLevel(Integer.valueOf(type.getLevel().intValue() + 1));
					this.goodType.setDeliveryId(type.getDeliveryId());
				this.goodType.setDeliveryName(type.getDeliveryName());
					request.setAttribute("parentName", parentName);
				} else {
					request.setAttribute("Level", this.goodType.getLevel());
				}
			}
		} catch (Exception e) {
			logger.error("eror occur when select goodType information", e);
		}
		logger.info("!!!!!!!!!!!!!!!!!!!!!!");
		return "edit_goodType";
	}
 
	public void save() {
		logger.info("start to save goodType information");
		HttpServletRequest request = getRequest();
		String prefix = "";
		String appType = "GoodType";
		try {
			if (this.goodType == null) {
				this.goodType = new GoodType();
			}
			if (this.goodType.getLevel() == null) {
				this.goodType.setLevel(Integer.valueOf(1));
			}

			String picId = request.getParameter("picId");
			String pic = request.getParameter("pic");
			this.goodType.setPicId(picId);
			this.goodType.setPic(pic);

			int typeNum = this.goodTypeService.count().intValue();
			this.goodType.setSort(Integer.valueOf(typeNum));

			if (StringUtils.isBlank(this.goodType.getCode())) {
				String parentId = this.goodType.getParentId();
				if ((StringUtils.isNotBlank(parentId)) && (parentId != null)) {
					GoodType type = (GoodType) this.goodTypeService
							.getModel(parentId);

					prefix = type.getCode();
					appType = type.getName();
				}
				String code = this.serialNumberService.getSerialNumberNoDate(
						prefix, appType, 3);
				this.goodType.setCode(code);
			}
			if (StringUtils.isBlank(this.goodType.getId())) {
				this.goodType.setId(this.goodTypeService.makeId());
				this.goodType.setModifyTime(new Date());

				this.goodType.setIsParent("0");
				String parentId = this.goodType.getParentId();
				if ((parentId != null) && (StringUtils.isNotBlank(parentId))) {
					GoodType type = (GoodType) this.goodTypeService.getModel(parentId);
					type.setIsParent("1");
					this.goodTypeService.update(type);
				}

				this.goodTypeService.insert(this.goodType);
			} else {
				this.goodTypeService.update(this.goodType);
			}

			if (StringUtils.isBlank(this.goodType.getParentId())) {
				GoodBrand goodBrand = (GoodBrand) this.goodBrandService
						.getModel(this.goodType.getId());
				if (goodBrand == null) {
					goodBrand = new GoodBrand();
					goodBrand.setId(this.goodType.getId());
					goodBrand.setCode(this.goodType.getCode());
					goodBrand.setName(this.goodType.getName());
					goodBrand.setLevel(this.goodType.getLevel());
					goodBrand.setRemark(this.goodType.getRemark());
					goodBrand.setCreateTime(this.goodType.getCreateTime());
					goodBrand.setCreatorId(this.goodType.getCreatorId());
					goodBrand.setCreatorName(this.goodType.getCreatorName());
					int brandNumber = this.goodBrandService.count().intValue();
					goodBrand.setSort(Integer.valueOf(brandNumber));

					this.goodBrandService.insert(goodBrand);
				} else {
					goodBrand.setName(this.goodType.getName());
					goodBrand.setCode(this.goodType.getCode());
					goodBrand.setRemark(this.goodType.getRemark());
					this.goodBrandService.update(goodBrand);
				}
			}

			if (StringUtils.isNotBlank(picId)) {
				this.fileUploadService
						.updateAppId(picId, this.goodType.getId());
			}
			responseFlag(true);
		} catch (Exception e) {
			responseFlag(false);
			logger.error("eror occur when inserting goodType information", e);
		}
	}

	public void delete() {
		logger.info("start to delete goodType information");
		logger.info("========================================");
		try {
			if (this.goodType == null) {
				this.goodType = new GoodType();
			}
			this.goodType = ((GoodType) this.goodTypeService.getModel(this.goodType.getId()));
             
			if (this.goodType.getLevel().intValue() == 1) {
				this.goodBrandService.delete(this.goodType.getId());
			}

			this.goodTypeService.delete(this.goodType);
			responseFlag(true);
		} catch (Exception e) {
			logger.error("eror occur when deleting goodType information", e);
			responseFlag(false);
		}
	}

	public void checkCode() {
		if (this.goodType == null) {
			this.goodType = new GoodType();
		}
		if (StringUtils.isNotBlank(this.goodType.getCode())) {
			try {
				this.goodType = this.goodTypeService.getByCode(this.goodType
						.getCode());
			} catch (Exception e) {
				logger.error("error occur when get goodType by code", e);
			}
			if (this.goodType == null)
				responseFlag(true);
			else
				responseFlag(false);
		} else {
			responseFlag(false);
		}
	}

	public GoodType getgoodType() {
		return this.goodType;
	}

	public void setgoodType(GoodType goodType) {
		this.goodType = goodType;
	}

	public void setSerialNumberService(SerialNumberService serialNumberService) {
		this.serialNumberService = serialNumberService;
	}

	public void setGoodTypeService(GoodTypeService goodTypeService) {
		this.goodTypeService = goodTypeService;
	}

	public void setGoodBrandService(GoodBrandService goodBrandService) {
		this.goodBrandService = goodBrandService;
	}

	public List<GoodType> getGoodTypeList() {
		return this.goodTypeList;
	}

	public void setGoodTypeList(List<GoodType> goodTypeList) {
		this.goodTypeList = goodTypeList;
	}

	public void setFileUploadService(FileUploadService fileUploadService) {
		this.fileUploadService = fileUploadService;
	}

	public GoodType getGoodType() {
		return goodType;
	}

	public void setGoodType(GoodType goodType) {
		this.goodType = goodType;
	}

	public static Logger getLogger() {
		return logger;
	}

	public GoodTypeService getGoodTypeService() {
		return goodTypeService;
	}

	public SerialNumberService getSerialNumberService() {
		return serialNumberService;
	}

	public GoodBrandService getGoodBrandService() {
		return goodBrandService;
	}

	public FileUploadService getFileUploadService() {
		return fileUploadService;
	}
}

/*
 * 
 * 
 */