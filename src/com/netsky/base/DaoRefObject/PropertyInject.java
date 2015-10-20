package com.netsky.base.DaoRefObject;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import jxl.Cell;
import jxl.Sheet;

import com.netsky.utils.base.DateFormatUtil;

/**
 * �Զ�ע���������ͨ����
 * 
 * @author Chiang 2009-12-28
 */
public class PropertyInject {

	/**
	 * ͨ��˽������set�����Զ�ע��request�����ݵ��������.
	 * Ҫ��request��keyֵΪ�����������ƵĴ�д,����request���в�ͬ������ͬ��������ʱ,��Ҫ��keyֵǰ���Ӷ�������
	 * 
	 * @param request
	 * @param o
	 *            ע�����
	 * @param index
	 *            ע������¼��request�����е�λ��
	 * @param fromCode
	 *            request ��ȡ�����ʽ,nullʱ��ת��
	 * @param targetCode
	 *            Ŀ������ʽ,nullʱ��ת��
	 * @return boolean set �Ƿ��ѶԴ���������ע��,��������ΪID����Ϊ��ע��.
	 * @throws Exception
	 */
	public static boolean inject(HttpServletRequest request, Object o, int index, String fromCode, String targetCode)
			throws Exception {
		boolean set = false;
		Class<?> clazz = o.getClass();
		String objectName = clazz.getName().substring(clazz.getName().lastIndexOf(".") + 1);
		Method method[] = clazz.getDeclaredMethods();
		for (int i = 0; i < method.length; i++) {
			Class<?> clazz1[] = method[i].getParameterTypes();
			if (clazz1.length == 1) {
				if (method[i].getName().indexOf("set") != -1) {
					String property[] = null;
					if (request.getParameterValues(method[i].getName().replaceFirst("set", "").toUpperCase()) != null
							&& request.getParameterValues(method[i].getName().replaceFirst("set", "").toUpperCase()).length > 0) {
						property = new String[] { request.getParameterValues(method[i].getName()
								.replaceFirst("set", "").toUpperCase())[index] };
					} else if (request.getParameterValues(objectName + "."
							+ method[i].getName().replaceFirst("set", "").toUpperCase()) != null
							&& request.getParameterValues(objectName + "."
									+ method[i].getName().replaceFirst("set", "").toUpperCase()).length > 0) {
						property = new String[] { request.getParameterValues(objectName + "."
								+ method[i].getName().replaceFirst("set", "").toUpperCase())[index] };
					}
					if (property != null) {
						if (invoke(o, method[i], property, fromCode, targetCode))
							set = true;
					}
				}
			}
		}
		return set;
	}

	/**
	 * ������һĳ����ֵд������ĳ������,Ҫ������������һ��
	 * 
	 * @param fatherObject
	 *            ����һ
	 * @param fatherProperty
	 *            ����һ�������� �����ִ�Сд
	 * @param o
	 *            �����
	 * @param perproty
	 *            ������������� �����ִ�Сд
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 */
	public static void injectNexus(Object fatherObject, String fatherProperty, Object o, String property)
			throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {
		setProperty(o, property, getProperty(fatherObject, fatherProperty));
	}

	/**
	 * ��ȡ�����е�����ֵ
	 * 
	 * @param o
	 * @param property
	 *            �������Ʋ����ִ�Сд
	 * @return Object ���
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 */
	public static Object getProperty(Object o, String property) throws IllegalArgumentException,
			IllegalAccessException, InvocationTargetException {
		if (o != null) {
			Field[] fields = o.getClass().getDeclaredFields();
			for (int i = 0; i < fields.length; i++) {
				if (fields[i].getName().equalsIgnoreCase(property)) {
					fields[i].setAccessible(true);
					return fields[i].get(o);
				}
			}
		}
		return "";
	}

	/**
	 * ��ֵ����������
	 * 
	 * @param o
	 * @param propertyName
	 *            ��������,�����ִ�Сд
	 * @param value
	 *            ����ֵ,��Ҫ����������һ��
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 */
	public static void setProperty(Object o, String propertyName, Object value) throws IllegalArgumentException,
			IllegalAccessException {
		Field[] fields = o.getClass().getDeclaredFields();
		for (int i = 0; i < fields.length; i++) {
			if (fields[i].getName().equalsIgnoreCase(propertyName)) {
				fields[i].setAccessible(true);
				fields[i].set(o, value);
				return;
			}
		}
	}

	/**
	 * �Դ�����󴴽��µ�ʵ���������ƶ�����������ֵ
	 * 
	 * @param o
	 *            Դ����
	 * @return Object �´�����ʵ��
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @throws InvocationTargetException
	 * @throws IllegalArgumentException
	 */
	public static Object cloneObject(Object o) throws InstantiationException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {
		Object newObject = o.getClass().newInstance();
		Field field[] = o.getClass().getDeclaredFields();
		for (int i = 0; i < field.length; i++) {
			injectNexus(o, field[i].getName(), newObject, field[i].getName());
		}
		return newObject;
	}

	/**
	 * ��excel��Ϣд�����������
	 * 
	 * @param o
	 *            ��Ҫע��Ķ���
	 * @param columnIndex
	 *            ����ֶ���������Ϣ��key���ֶ����ƣ���o����������һ�¡�value��������
	 * @param sheet
	 *            excel������
	 * @param row
	 *            ��ǰ������
	 * @throws Exception
	 */
	public static boolean injectFromExcel(Object o, Map<?, ?> columnIndex, Sheet sheet, int row) throws Exception {
		boolean set = false;
		Class<?> clazz = o.getClass();
		Method method[] = clazz.getDeclaredMethods();
		for (int i = 0; i < method.length; i++) {
			Class<?> clazz1[] = method[i].getParameterTypes();
			if (clazz1.length == 1) {
				if (method[i].getName().indexOf("set") != -1) {
					String property[] = null;
					String colName = method[i].getName().replaceFirst("set", "").toUpperCase();
					Map<?, ?> colMap = (Map<?, ?>) columnIndex.get(colName);
					if (colMap != null) {
						int index = Integer.parseInt((String) colMap.get("$index"));
						Cell cell = sheet.getCell(index, row);
						if (cell.getContents() != null && cell.getContents().length() > 0) {
							property = new String[] { cell.getContents() };
						}
					}
					if (property != null) {
						if (invoke(o, method[i], property, null, null))
							set = true;
					}
				}
			}
		}
		return set;
	}

	/**
	 * ��ȡ��������
	 * 
	 * @param clazz
	 *            ��
	 * @param propertyName������,�����ִ�Сд
	 * 
	 * @return Class ��������
	 */
	public static Class<?> getPropertyType(Class<?> clazz, String propertyName) {
		Field[] fields = clazz.getDeclaredFields();
		for (int i = 0; i < fields.length; i++) {
			if (fields[i].getName().equalsIgnoreCase(propertyName)) {
				return fields[i].getType();
			}
		}
		return null;
	}

	/**
	 * ���Ʋ�ͬ��������ͬ����,��ͬ���͵�˽������,ͨ��get,set����
	 * 
	 * @param fatherObject
	 *            ������
	 * @param o
	 *            ����������
	 * @param notCopy[]
	 *            �����Ƶ���������
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 */
	public static void copyProperty(Object fatherObject, Object o, String notCopy[]) throws IllegalArgumentException,
			IllegalAccessException, InvocationTargetException {
		Field fatherField[] = fatherObject.getClass().getDeclaredFields();
		Field field[] = o.getClass().getDeclaredFields();
		for (int i = 0; i < fatherField.length; i++) {
			for (int j = 0; j < field.length; j++) {
				if (field[j].getName().equals(fatherField[i].getName())) {
					boolean copyflag = true;
					if (notCopy != null) {
						for (int k = 0; k < notCopy.length; k++) {
							if (notCopy[k].equals(field[j].getName())) {
								copyflag = false;
								break;
							}
						}
					}
					if (copyflag && fatherField[i].getType().getName().equals(field[i].getType().getName())) {
						injectNexus(fatherObject, fatherField[i].getName(), o, fatherField[i].getName());
					}
				}
			}
		}
	}

	/**
	 * ִ��bean��ָ��������֧�ֲ�������"java.lang.Integer"��"java.lang.Long"��"java.lang.String"��"java.lang.Double"��"java.util.Date"
	 * 
	 * @param o
	 *            ָ����bean
	 * @param method
	 *            ָ������
	 * @param property[]
	 *            ��������,����������˳����
	 * @param fromCode
	 *            String���ͱ������÷���ǰ����Ҫת��ʱָ����Դ����,Ϊnullʱ��ת��
	 * @param targetCode
	 *            String���ͱ������÷���ǰ����Ҫת��ʱָ����Ŀ�����,Ϊnullʱ��ת��
	 * 
	 * @return boolean ��ִ�з���������Ϊnull��Ϊ""ʱ����true����ִ�з�������Ϊ"setId"ʱ������false
	 * @throws Exception
	 * 
	 */
	public static boolean invoke(Object o, Method method, String property[], String fromCode, String targetCode)
			throws Exception {
		boolean set = false;
		/**
		 * ���ݷ����������͹���invoke����������Object[]
		 */
		Class<?> clazz[] = method.getParameterTypes();// ��ȡ�÷������в�������
		if (property == null || clazz.length != property.length) {
			throw new Exception("����������������������������ƥ�䣡");
		}
		Object[] object = new Object[clazz.length];
		for (int i = 0; i < clazz.length; i++) {
			if (property[i] != null) {
				if (clazz[i].getName().equals("java.lang.Integer")) {
					if (property[i].length() > 0) {
						object[i] = Integer.valueOf(property[i]);
					}
				} else if (clazz[i].getName().equals("java.lang.Long")) {
					if (property[i].length() > 0)
						object[i] = Long.valueOf(property[i]);
				} else if (clazz[i].getName().equals("java.lang.String")) {
					byte[] fromBytes;
					String targetStr;
					if (fromCode != null) {
						fromBytes = property[i].getBytes(fromCode);
					} else {
						fromBytes = property[i].getBytes();
					}
					if (targetCode != null) {
						targetStr = new String(fromBytes, targetCode);
					} else {
						targetStr = new String(fromBytes);
					}
					object[i] = targetStr;
				} else if (clazz[i].getName().equals("java.lang.Double")) {
					if (property[i].length() > 0)
						object[i] = Double.valueOf(property[i]);
				} else if (clazz[i].getName().equals("java.util.Date")) {
					if (property[i].length() > 0) {
						if (property[i].indexOf(":") == -1) {
							property[i] = property[i] + " 00:00:00";
						}else{
							if(property[i].split(" ").length > 0 && property[i].split(" ")[1].length() < 8){
								if(property[i].split(" ")[1].length() == 5){
									property[i] = property[i] + ":00";
								}else if(property[i].split(" ")[1].length() == 2){
									property[i] = property[i] + ":00:00";
								}
							}
						}
						object[i] = DateFormatUtil.FormatTimeString(property[i]);
					}
				}
				if (!method.getName().equalsIgnoreCase("setId") && property[i].length() > 0) {
					set = true;
				}
			}
		}
		method.invoke(o, object);
		return set;
	}
}
