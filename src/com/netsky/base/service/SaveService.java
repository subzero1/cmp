package com.netsky.base.service;

import java.io.Serializable;

import org.hibernate.Session;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.netsky.base.dataObjects.interfaces.BlobObject;

/**
 * �������ӿ�
 * 
 * @author Chiang
 */
public interface SaveService {

	/**
	 * �洢blob�ֶ�
	 * 
	 * @param BlobObject
	 * @param InputStream
	 * @return Object ������.
	 */
	public Object saveBlob(BlobObject blobObject, MultipartHttpServletRequest multipartRequest) throws Exception;

	/**
	 * �洢blob�ֶ�
	 * 
	 * @param BlobObject[]
	 * @param InputStream
	 * @return Object[] ������.
	 */
	public Object[] saveBlobs(BlobObject[] blobObject, MultipartHttpServletRequest multipartRequest) throws Exception;

	/**
	 * �洢blob�ֶ�
	 * 
	 * @param BlobObject[]
	 * @param InputStream
	 * @return Object[] ������.
	 */
	public Object[] saveBlobs(BlobObject blobObject, MultipartHttpServletRequest multipartRequest) throws Exception;

	/**
	 * �������
	 * 
	 * @param Object
	 * @return Object
	 */
	public Object save(Object object);

	/**
	 * �������
	 * 
	 * @param Object
	 * @return Object
	 */
	public Object[] save(Object[] object) throws Exception;

	/**
	 * ʹ��hsql����
	 * 
	 * @param String
	 *            hsql
	 */
	public void updateByHSql(String HSql);
	
	/**
	 * ʹ�ô�������hsql ��������
	 * 
	 * @param String
	 *            hsql
	 */
	public int updateByHSql(String HSql, Object[] objs);

	/**
	 * ����idɾ���־û�����
	 * 
	 * @param Class
	 *            clazz �־û�����Class
	 * @param Serializable
	 *            id
	 */
	public void removeObject(Class<?> clazz, Serializable id);
	
	/**
	 * ɾ���־û�����
	 * 
	 * @param Object
	 *            �־û�����Object
	 */
	public void removeObject(Object o);
	
	/**
	 * ���hibernate session
	 * 
	 * @return Session session
	 */
	public Session getHiberbateSession();
	
	/**
	 * hibernate �ص�ִ�С�
	 * @param action
	 * @return
	 */
	public Object excute( org.springframework.orm.hibernate3.HibernateCallback action );
	

}
