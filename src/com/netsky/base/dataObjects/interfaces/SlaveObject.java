package com.netsky.base.dataObjects.interfaces;

/**
 * �ϴ�������������Ӳ��ͨ�ýӿ�
 * 
 * @author Chiang 2009-08-18
 */
public interface SlaveObject {

	/**
	 * �����ļ���
	 * 
	 * @param FileName
	 *            �ļ���
	 */
	public void setFileName(String FileName);

	/**
	 * ���ñ�����ļ�·��
	 */
	public void setFilePatch(String FilePatch);

	/**
	 * ��ȡ��ǰ��id
	 */
	public Long getId();

	/**
	 * ��ȡ������ʶ
	 */
	public String getSlaveIdentifier();

	/**
	 * �����ļ���չ��
	 */
	public void setExt_name(String Ext_name);
	
	/**
	 * ��ȡ��������
	 * */
	public String getType();

}
