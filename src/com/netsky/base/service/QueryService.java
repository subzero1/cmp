package com.netsky.base.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import com.netsky.base.DaoRefObject.QueryBuilder;
import com.netsky.base.DaoRefObject.ResultObject;



/**
 * ��ѯ����ӿ�
 * 
 * @author Chiang 2009-3-11
 */
public interface QueryService {

	/**
	 * ͨ��queryBuilder��ѯ.
	 * 
	 * @param queryBuilder
	 * @return ResultObject
	 */
	public ResultObject search(QueryBuilder queryBuilder);

	/**
	 * ͨ��hsql��ѯ
	 * 
	 * @param HSql
	 * @return ResultObject
	 */
	public ResultObject search(String HSql);

	/**
	 * ͨ��queryBuilder��ѯ.
	 * 
	 * @param queryBuilder
	 * @return List
	 */
	public List<?> searchList(QueryBuilder queryBuilder);
	
	/**
	 * ͨ��Class ��� ���ж���List
	 * @param clazz
	 * @return
	 */
	public List<?> searchList(Class<?> clazz);
	
	/**
	 * ͨ��hsql��ѯ
	 * 
	 * @param HSql
	 * @return List
	 */
	public List<?> searchList(String HSql);

	/**
	 * ͨ��hsql��ѯ
	 * 
	 * @param HSql
	 * @return List
	 */
	public List<?> searchList( String queryString, Object[] values);
	
	/**
	 * ͨ��id��ѯ.
	 * 
	 * @param clazz
	 * @param id
	 * @return Object
	 */
	public Object searchById(Class<?> clazz, Serializable id);

	/**
	 * ��ҳ��ѯ.
	 * 
	 * @param queryBuilder
	 * @param page
	 *            ��ǰҳ,��1��ʼ
	 * @param pageSize
	 *            ÿҳ��¼����
	 * @return ResultObject
	 */
	public ResultObject searchByPage(QueryBuilder queryBuilder, int page, int pageSize);

	/**
	 * ��ҳ��ѯ.
	 * 
	 * @param HSql
	 * @param page
	 *            ��ǰҳ,��1��ʼ
	 * @param pageSize
	 *            ÿҳ��¼����
	 * @return ResultObject
	 */
	public ResultObject searchByPage(String HSql, int page, int pageSize);
	
	public HibernateTemplate getHibernateTemplate();
	
}
