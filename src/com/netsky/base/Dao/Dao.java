package com.netsky.base.Dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.netsky.base.DaoRefObject.QueryBuilder;
import com.netsky.base.DaoRefObject.ResultObject;


/**
 * ����Dao�ӿ���
 * 
 * @author Chiang 2009-3-11
 */
public interface Dao {

	/**
	 * ����򱣴�־û�����
	 * 
	 * @param o
	 * @return Object ���½��.
	 */
	public Object saveObject(Object o);

	/**
	 * ����򱣴�־û�����
	 * 
	 * @param o
	 * @return Object ���½��.
	 */
	public Object[] saveObject(Object[] o) throws Exception;

	/**
	 * ����id��ȡ�־û�����
	 * 
	 * @param clazz
	 *            �־û�����Class
	 * @param id
	 *            ��������
	 * @return Object ���ز�ѯ�������.
	 */
	public Object getObject(Class<?> clazz, Serializable id);

	/**
	 * ��ȡ���ж���
	 * 
	 * @param clazz
	 *            �־û�����Class
	 * @return List ���м�¼
	 */
	public List<?> getObjects(Class<?> clazz);

	/**
	 * ����idɾ���־û�����
	 * 
	 * @param clazz
	 *            �־û�����Class
	 * @param id
	 */
	public void removeObject(Class<?> clazz, Serializable id);

	/**
	 * ɾ���־û�����
	 * 
	 * @param o
	 *            �־û�����Object
	 */
	public void removeObject(Object o);

	/**
	 * ͨ��querybuilder��ѯ����
	 * 
	 * @param queryBuilder
	 * @return List
	 */
	public List<?> search(QueryBuilder queryBuilder);

	/**
	 * ͨ��hsql��ѯ
	 * 
	 * @param HSql
	 * @return ResultObject
	 */
	public List<?> search(String HSql);
	
	/**
	 * ͨ��hsql��ѯ�����Եò�����
	 * @author wind 2010.1.15
	 * method:search
	 * @param queryString
	 * @param values
	 * @return List<?>
	 */
	public List<?> search( String queryString, Object[] values);

	/**
	 * ͨ��hsql��������
	 * 
	 * @param HSql
	 */
	public void update(String HSql);
	
	/**
	 * ͨ��hsql�������������ݿ�	
	 * @param Hsql
	 * @param objs
	 * @return int
	 */
	public int update(String Hsql,Object[] objs);

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

	/**
	 * ���hibernate session
	 *  2010.01.11 �Ƹ�ǿ�޸ģ�getHiberbateSessionn�ĳ�getHibernateSession
	 * @return Session session
	 */
	public Session getHibernateSession();
	
	/**
	 * ��� HibernateTemplate
	 *  2010.01.11 �Ƹ�ǿ����
	 * @return
	 */
	public HibernateTemplate getHibernateTemplate();

}
