package com.sinokj.code.service;

import com.sinokj.code.bean.Base;
import com.sinokj.code.ibatis.impl.PublicDAO;
import com.sinokj.code.util.PageInfo;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

public class BaseService<T> {
	private static final Logger logger = Logger.getLogger(BaseService.class);
	protected PublicDAO publicDAO;
	protected String nameSpace;
	protected String sqlIdPrefix;

	public void setPublicDAO(PublicDAO publicDAO) {
		this.publicDAO = publicDAO;
	}

	public BaseService() {
		Class clazz = getClass();
		Type genType = clazz.getGenericSuperclass();
		if ((genType instanceof ParameterizedType)) {
			Type[] params = ((ParameterizedType) genType)
					.getActualTypeArguments();

			if ((params != null) && (params.length > 0)) {
				clazz = (Class) params[0];
			}
		}

		String clazzName = clazz.getSimpleName();
		this.nameSpace = clazzName;
		this.sqlIdPrefix = (this.nameSpace + "." + this.nameSpace);
	}

	public String makeId() {
		return this.publicDAO.makeId();
	}

	public Object selectToT(String sqlId, Object param) {
		Object obj = (Object) this.publicDAO.selectToT(sqlId, param);
		return obj;
	}

	public Base insert(Base model) throws Exception {
		if (model == null) {
			throw new Exception("objParam is null!");
		}
		String id = model.getId();
		if (StringUtils.isEmpty(id)) {
			id = makeId();
			model.setId(id);
		}

		this.publicDAO.insert(this.sqlIdPrefix, model);

		return model;
	}

	public Base update(Base model) throws Exception {
		if (model == null) {
			throw new Exception("objParam is null!");
		}
		if (StringUtils.isBlank(model.getId())) {
			throw new Exception("id is null!");
		}

		this.publicDAO.update(this.sqlIdPrefix, model);

		return model;
	}

	public Object insertOrUpdate(String sqlId, Base model) {
		return this.publicDAO.insertOrUpdate(sqlId, model);
	}

	public void delete(String id) throws Exception {
		if (StringUtils.isBlank(id)) {
			throw new Exception("id is null!");
		}
		logger.info("delete model,sqlIdPrefix:" + this.sqlIdPrefix + ";id:"
				+ id);
		Map objParam = new HashMap();
		objParam.put("id", id);
		this.publicDAO.delete(this.sqlIdPrefix, objParam);
	}

	public Object getModel(String id) {
		Object t = null;

		logger.debug("selectOne model,sqlIdPrefix:" + this.sqlIdPrefix + ";id:"+ id);
		Map objParam = new HashMap();
		objParam.put("id", id);

		Object obj = this.publicDAO.selectOne(this.sqlIdPrefix, objParam);
		if (obj != null) {
			t = obj;
		}
		return t;
	}

	public List<T> select(Object objParam) {
		List list = this.publicDAO.select(this.sqlIdPrefix, objParam);
		return list;
	}

	public List<T> select(String str, Object objParam) {
		List list = this.publicDAO.select(str, objParam);
		return list;
	}

	public Object selectOne(Object objParam) {
		Object o = null;
		List list = select(objParam);
		if ((list != null) && (!list.isEmpty())) {
			o = list.get(0);
		}
		return o;
	}

	public List<T> pageList(PageInfo pageInfo, Object objParam,boolean isUseCache) {
		 
		logger.info("this.sqlIdPrefix:"+this.sqlIdPrefix);
		List result = null;

		if (pageInfo == null) {
			pageInfo = new PageInfo();
		}
			result = this.publicDAO.query(this.sqlIdPrefix, objParam, pageInfo);

		return result;
	}
}