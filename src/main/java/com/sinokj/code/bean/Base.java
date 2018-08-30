package com.sinokj.code.bean;

import java.io.Serializable;
import java.util.Date;

import org.apache.struts2.json.annotations.JSON;
 

public class Base implements Serializable {
	private String id;
	private String code;
	private String name;
	private String parentId;
	private String workFlowId;
	private String creatorId;
	private String creatorName;
	private Date createTime;
	private String modifierId;
	private String modifierName;
	private Date modifyTime;
	private String state;
	private String appType;
	private Integer flowState;
	private Integer sort;
	private String rangeStr;

	public String getCreatorId() {
		return this.creatorId;
	}

	public void setCreatorId(String creatorId) {
		this.creatorId = creatorId;
	}

	public String getCreatorName() {
		return this.creatorName;
	}

	public void setCreatorName(String creatorName) {
		this.creatorName = creatorName;
	}

	@JSON(format = "yyyy-MM-dd HH:mm:ss")
	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getModifierId() {
		return this.modifierId;
	}

	public void setModifierId(String modifierId) {
		this.modifierId = modifierId;
	}

	public String getModifierName() {
		return this.modifierName;
	}

	public void setModifierName(String modifierName) {
		this.modifierName = modifierName;
	}

	@JSON(format = "yyyy-MM-dd HH:mm:ss")
	public Date getModifyTime() {
		return this.modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	@JSON(name = "_state")
	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getSort() {
		return this.sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public Integer getFlowState() {
		return this.flowState;
	}

	public void setFlowState(Integer flowState) {
		this.flowState = flowState;
	}

	public String getWorkFlowId() {
		return this.workFlowId;
	}

	public void setWorkFlowId(String workFlowId) {
		this.workFlowId = workFlowId;
	}

	@JSON(name = "_parentId")
	public String getParentId() {
		return this.parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getAppType() {
		return this.appType;
	}

	public void setAppType(String appType) {
		this.appType = appType;
	}

	public String getRangeStr() {
		return this.rangeStr;
	}

	public void setRangeStr(String rangeStr) {
		this.rangeStr = rangeStr;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
