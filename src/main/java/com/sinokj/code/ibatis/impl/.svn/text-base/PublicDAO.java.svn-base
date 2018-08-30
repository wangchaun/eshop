package com.sinokj.code.ibatis.impl;

import com.sinokj.code.bean.Base;
import com.sinokj.code.ibatis.AbstractDao;
import com.sinokj.code.ibatis.BaseSqlMapDaoSupport;
import com.sinokj.code.util.GUIDHelper;
import com.sinokj.code.util.PageHelp;
import com.sinokj.code.util.PageInfo;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

public class PublicDAO extends BaseSqlMapDaoSupport implements AbstractDao {
	protected static final Logger logger = Logger.getLogger(PublicDAO.class);
	private static final String SELECT = "_select";
	private static final String QUERY = "_query_select";
	private static final String COUNT_SELECT = "_count_query_select";
	private static final String ID = "id";

	public String makeId() {
		return GUIDHelper.genRandomGUID();
	}

	public Object selectToT(String sqlId, Object param) {
		Object obj = getSqlMapClientTemplate().queryForObject(sqlId + "_ToT",param);
		return obj;
	}

	public Object selectOne(String sqlId, Object param) {
		Object obj = null;
		List list = select(sqlId, param);
		if ((list != null) && (!list.isEmpty())) {
			obj = list.get(0);
		}
		return obj;
	}

	public Object insert(String sqlId, Object objParam) {
		return getSqlMapClientTemplate().insert(sqlId + "_insert", objParam);
	}

	public int update(String sqlId, Object objParam) {
		return getSqlMapClientTemplate().update(sqlId + "_update", objParam);
	}

	public int deletePic(String sqlId, Object objParam) {
		return getSqlMapClientTemplate().update(sqlId + "_deletePic", objParam);
	}

	public Object insertOrUpdate(String sqlId, Base objParam) {
		String id = objParam.getId();

		if (StringUtils.isBlank(id)) {
			id = makeId();
			objParam.setId(id);
			insert(sqlId, objParam);
		} else {
			update(sqlId, objParam);
		}

		return objParam;
	}

	public int updateByMap(String sqlId, Map objParam) {
		return getSqlMapClientTemplate().update(sqlId + "_update", objParam);
	}

	public int delete(String sqlId, Object objParam) {
		return getSqlMapClientTemplate().delete(sqlId + "_delete", objParam);
	}

	public List query(String sqlId, Object objParam, PageInfo pageInfo) {
		return select(sqlId, objParam, pageInfo, false, true);
	}

	public List queryByCache(String sqlId, Object objParam, PageInfo pageInfo) {
		return select(sqlId, objParam, pageInfo, false, false);
	}

	private List select(String sqlId, Object objParam, PageInfo pageInfo,boolean isSelect, boolean isUseCache) {
		 
		List list = null;
         
		String sqlIdTemp = sqlId + "_query_select";
       
		int skip = 0;
		int max = 0;
		if (pageInfo != null) {
			skip = (pageInfo.getPageIndex() - 1) * pageInfo.getPageSize();//跳跃数
			max = pageInfo.getPageSize();//每页的记录数
		}
        /*内置分页*/
		if (max == 0){
			list = getSqlMapClientTemplate().queryForList(sqlIdTemp, objParam);}
		else {
			 
			list = getSqlMapClientTemplate().queryForList(sqlIdTemp, objParam,skip, max);
		}
		if ((pageInfo != null) && (!isSelect)) {
			int count = 0;
			if (isUseCache) {
				String countSqlId = sqlId + "_count_query_select";
				Integer countI = (Integer) getSqlMapClientTemplate().queryForObject(countSqlId, objParam);
				count = countI.intValue();
			} else {
				count = PageHelp.getTotalElements().intValue();
				PageHelp.clean();
			}
			pageInfo.setCount(count);
		}
		return list;
	}
	/****************************Good_SY_select*******************/
	public List select(String sqlId, Object objParam) {
		return getSqlMapClientTemplate().queryForList(sqlId + "_select",objParam);
	}

	public void flushDataCache() {
		getSqlMapClientTemplate().getSqlMapClient().flushDataCache();
	}

	public void flushDataCache(String sqlId) {
		getSqlMapClientTemplate().getSqlMapClient().flushDataCache(
				sqlId + "_Cache");
	}

	public long getSeqId(String seqName) {
		return ((Long) getSqlMapClientTemplate().queryForObject("getSequence",
				seqName)).longValue();
	}

	public Timestamp getSysDate() {
		return (Timestamp) getSqlMapClientTemplate().queryForObject(
				"getSysDate");
	}

	public List selectBySqlMapId(String sqlId, Object objParam, int skip,
			int max) {
		if (max == 0) {
			return getSqlMapClientTemplate().queryForList(sqlId, objParam);
		}
		return getSqlMapClientTemplate().queryForList(sqlId, objParam, skip,
				max);
	}

	public Object selectFirstRowBySqlMapId(String sqlId, Object objParam) {
		List lstResult = selectBySqlMapId(sqlId, objParam, 0, 0);
		if ((lstResult != null) && (lstResult.size() > 0)) {
			return lstResult.get(0);
		}
		return null;
	}

	public List dynSqlQry(String sqlText) {
		List list = getSqlMapClientTemplate().queryForList("dynInfoSql",
				sqlText);
		return list;
	}

	public String dynSingleInfoQry(String sqlText) {
		String strValue = null;
		List lst = getSqlMapClientTemplate().queryForList("dynSingleRowSql",
				sqlText);
		if (lst.size() > 0) {
			HashMap hm = (HashMap) lst.get(0);
			Iterator it = hm.entrySet().iterator();
			if (it.hasNext()) {
				Map.Entry entry = (Map.Entry) it.next();
				strValue = entry.getValue().toString();
			}
		}
		return strValue;
	}

	public String dynMultiInfoQry(String sqlText) {
		String strValue = null;
		List lst = getSqlMapClientTemplate().queryForList("dynMultiRowSql",
				sqlText);
		for (int i = 0; i < lst.size(); i++) {
			HashMap hm = (HashMap) lst.get(i);
			Iterator it = hm.entrySet().iterator();

			if (it.hasNext()) {
				Map.Entry entry = (Map.Entry) it.next();
				if (strValue == null)
					strValue = entry.getValue().toString();
				else {
					strValue = strValue + "," + entry.getValue().toString();
				}
			}
		}
		return strValue;
	}

	public Object callProcedureBySqlMapId(String sqlId, Object param) {
		return getSqlMapClientTemplate().queryForObject(sqlId, param);
	}
}

/*
 * 
 * 
 */