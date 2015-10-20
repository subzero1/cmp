package com.netsky.base.serviceImp;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Service;

import com.netsky.base.Dao.Dao;
import com.netsky.base.DaoRefObject.QueryBuilder;
import com.netsky.base.DaoRefObject.ResultObject;
import com.netsky.base.service.QueryService;



/**
 * ��ѯ����ʵ����
 * 
 * @author Chiang 2009-03-11
 */
@Service("queryService")
public class QueryServiceImpl implements QueryService {

	@Autowired
	private Dao dao;

	public Dao getDao() {
		return dao;
	}

	public void setDao(Dao dao) {
		this.dao = dao;
	}

	public ResultObject search(QueryBuilder queryBuilder) {
		return new ResultObject(dao.search(queryBuilder), queryBuilder.getClazz());
	}

	public ResultObject search(String HSql) {
		return new ResultObject(dao.search(HSql), HSql);
	}

	public List<?> searchList(QueryBuilder queryBuilder) {
		return dao.search(queryBuilder);
	}

	public Object searchById(Class<?> clazz, Serializable id) {
		return dao.getObject(clazz, id);
	}

	public ResultObject searchByPage(QueryBuilder queryBuilder, int page, int pageSize) {
		return dao.searchByPage(queryBuilder, page, pageSize);
	}

	public ResultObject searchByPage(String HSql, int page, int pageSize) {
		return dao.searchByPage(HSql, page, pageSize);
	}

	public List<?> searchList(Class<?> clazz) {
		return dao.getObjects(clazz);
	}

	public HibernateTemplate getHibernateTemplate() {
		return dao.getHibernateTemplate();
	}

	public List<?> searchList(String HSql) {
		return dao.search(HSql);
	}

	public List<?> searchList(String queryString, Object[] values) {
		return dao.search(queryString,values);
	}

}
