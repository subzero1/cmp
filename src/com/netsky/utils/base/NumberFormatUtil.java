package com.netsky.utils.base;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * ��ȷ���������
 * 
 * @author Chiang 2009-3-16
 */
public class NumberFormatUtil {

	/**
	 * Ĭ�ϳ�������С��λ��
	 */
	private static final int DEFULT_DIV_SCAL = 2;

	/**
	 * Ĭ���������뱣��С��λ�� 2
	 */
	private static final int DEFULT_ROUND_SCAL = 2;

	private NumberFormatUtil() {

	}
	
	private static  char HanDigiStr[] = new char[] { '��', 'Ҽ', '��', '��',
			'��', '��', '½', '��', '��', '��' };

	private static String HanDiviStr[] = new String[] { "", "ʰ", "��",
			"Ǫ", "��", "ʰ", "��", "Ǫ", "��", "ʰ", "��", "Ǫ", "��", "ʰ", "��", "Ǫ",
			"��", "ʰ", "��", "Ǫ", "��", "ʰ", "��", "Ǫ", "��", "ʰ", "��", "Ǫ", "��",
			"ʰ", "��", "Ǫ" };	

	/**
	 * �ӷ�����.
	 * 
	 * @param number1
	 *            ������
	 * @param number2
	 *            ����
	 * @return double ���������ĺ�
	 */
	public static double addToDouble(double number1, double number2) {
		return addToDouble(Double.toString(number1), Double.toString(number2));
	}

	/**
	 * �ӷ�����.
	 * 
	 * @param number1
	 *            ������
	 * @param number2
	 *            ����
	 * @return double ���������ĺ�
	 */
	public static double addToDouble(String number1, String number2) {
		return new BigDecimal(number1).add(new BigDecimal(number2)).doubleValue();
	}

	/**
	 * �ӷ�����.
	 * 
	 * @param number1
	 *            ������
	 * @param number2
	 *            ����
	 * @return String ���������ĺ�
	 */
	public static String addToString(String number1, String number2) {
		return new BigDecimal(number1).add(new BigDecimal(number2)).toString();
	}

	/**
	 * �ӷ�����.
	 * 
	 * @param number1
	 *            ������
	 * @param number2
	 *            ����
	 * @return String ���������ĺ�
	 */
	public static String addToString(double number1, double number2) {
		return addToString(Double.toString(number1), Double.toString(number2));
	}

	/**
	 * ��������.
	 * 
	 * @param number1
	 *            ������
	 * @param number2
	 *            ����
	 * @return double ���������Ĳ�
	 */
	public static double subToDouble(String number1, String number2) {
		return new BigDecimal(number1).subtract(new BigDecimal(number2)).doubleValue();
	}

	/**
	 * ��������.
	 * 
	 * @param number1
	 *            ������
	 * @param number2
	 *            ����
	 * @return double ���������Ĳ�
	 */
	public static double subToDouble(double number1, double number2) {
		return subToDouble(Double.toString(number1), Double.toString(number2));
	}

	/**
	 * ��������.
	 * 
	 * @param number1
	 *            ������
	 * @param number2
	 *            ����
	 * @return String ���������Ĳ�
	 */
	public static String subToString(String number1, String number2) {
		return new BigDecimal(number1).subtract(new BigDecimal(number2)).toString();
	}

	/**
	 * ��������.
	 * 
	 * @param number1
	 *            ������
	 * @param number2
	 *            ����
	 * @return String ���������Ĳ�
	 */
	public static String subToString(double number1, double number2) {
		return subToString(Double.toString(number1), Double.toString(number2));
	}

	/**
	 * �˷�����.
	 * 
	 * @param number1
	 *            ������
	 * @param number2
	 *            ����
	 * @return double ���������Ļ�
	 */
	public static double mulToDouble(String number1, String number2) {
		return new BigDecimal(number1).multiply(new BigDecimal(number2)).doubleValue();
	}

	/**
	 * �˷�����.
	 * 
	 * @param number1
	 *            ������
	 * @param number2
	 *            ����
	 * @return double ���������Ļ�
	 */
	public static double mulToDouble(double number1, double number2) {
		return mulToDouble(Double.toString(number1), Double.toString(number2));
	}

	/**
	 * �˷�����.
	 * 
	 * @param number1
	 *            ������
	 * @param number2
	 *            ����
	 * @return String ���������Ļ�
	 */
	public static String mulToString(String number1, String number2) {
		return new BigDecimal(number1).multiply(new BigDecimal(number2)).toString();
	}

	/**
	 * �˷�����.
	 * 
	 * @param number1
	 *            ������
	 * @param number2
	 *            ����
	 * @return String ���������Ļ�
	 */
	public static String mulToString(double number1, double number2) {
		return mulToString(Double.toString(number1), Double.toString(number2));
	}

	/**
	 * �������㣬Ĭ�ϱ���С�����2λ DEFULT_DIV_SCAL = 2.
	 * 
	 * @param number1
	 *            ������
	 * @param number2
	 *            ����
	 * @return String
	 */
	public static String divToString(String number1, String number2) {
		return new BigDecimal(number1).divide(new BigDecimal(number2), DEFULT_DIV_SCAL, BigDecimal.ROUND_HALF_UP).toString();
	}

	/**
	 * �������㣬Ĭ�ϱ���С�����2λ DEFULT_DIV_SCAL = 2.
	 * 
	 * @param number1
	 *            ������
	 * @param number2
	 *            ����
	 * @return String
	 */
	public static String divToString(double number1, double number2) {
		return divToString(Double.toString(number1), Double.toString(number2));
	}

	/**
	 * �������㣬Ĭ�ϱ���С�����2λ DEFULT_DIV_SCAL = 2.
	 * 
	 * @param number1
	 *            ������
	 * @param number2
	 *            ����
	 * @return double
	 */
	public static double divToDouble(String number1, String number2) {
		return new BigDecimal(number1).divide(new BigDecimal(number2), DEFULT_DIV_SCAL, BigDecimal.ROUND_HALF_UP).doubleValue();
	}

	/**
	 * �������㣬Ĭ�ϱ���С�����2λ DEFULT_DIV_SCAL = 2.
	 * 
	 * @param number1
	 *            ������
	 * @param number2
	 *            ����
	 * @return double
	 */
	public static double divToDouble(double number1, double number2) {
		return divToDouble(Double.toString(number1), Double.toString(number2));
	}

	/**
	 * �������㣬����scalλС����
	 * 
	 * @param number1
	 *            ������
	 * @param number2
	 *            ����
	 * @param scal
	 *            ����С����λ��
	 * @return double
	 */
	public static double divToDouble(String number1, String number2, int scal) {
		return new BigDecimal(number1).divide(new BigDecimal(number2), scal, BigDecimal.ROUND_HALF_UP).doubleValue();
	}

	/**
	 * �������㣬����scalλС����
	 * 
	 * @param number1
	 *            ������
	 * @param number2
	 *            ����
	 * @param scal
	 *            ����С����λ��
	 * @return double
	 */
	public static double divToDouble(double number1, double number2, int scal) {
		return divToDouble(Double.toString(number1), Double.toString(number2), scal);
	}

	/**
	 * �������㣬����scalλС����
	 * 
	 * @param number1
	 *            ������
	 * @param number2
	 *            ����
	 * @param scal
	 *            ����С����λ��
	 * @return String
	 */
	public static String divToString(String number1, String number2, int scal) {
		return new BigDecimal(number1).divide(new BigDecimal(number2), scal, BigDecimal.ROUND_HALF_UP).toString();
	}

	/**
	 * �������㣬����scalλС����
	 * 
	 * @param number1
	 *            ������
	 * @param number2
	 *            ����
	 * @param scal
	 *            ����С����λ��
	 * @return String
	 */
	public static String divToString(double number1, double number2, int scal) {
		return divToString(Double.toString(number1), Double.toString(number2), scal);
	}

	/**
	 * Ĭ�ϱ���С�������λ DEFULT_DIV_SCAL = 2
	 * 
	 * @param number
	 * @return String
	 */
	public static String roundToString(String number) {
		return new BigDecimal(number).divide(new BigDecimal("1"), DEFULT_ROUND_SCAL, BigDecimal.ROUND_HALF_UP).toString();
	}

	/**
	 * Ĭ�ϱ���С�������λ DEFULT_DIV_SCAL = 2
	 * 
	 * @param number
	 * @param str
	 *            numberΪ0ʱ�����ַ���
	 * @return String
	 */
	public static String roundToString(String number, String str) {
		if (number != null && Double.parseDouble(number) != 0.0)
			return new BigDecimal(number).divide(new BigDecimal("1"), DEFULT_ROUND_SCAL, BigDecimal.ROUND_HALF_UP).toString();
		else
			return str;
	}

	/**
	 * Ĭ�ϱ���С�������λ DEFULT_DIV_SCAL = 2
	 * 
	 * @param number
	 * @return String
	 */
	public static String roundToString(double number) {
		return roundToString(Double.toString(number));
	}

	/**
	 * Ĭ�ϱ���С�������λ DEFULT_DIV_SCAL = 2
	 * 
	 * @param number
	 * @param str
	 *            numberΪ0ʱ�����ַ���
	 * @return String
	 */
	public static String roundToString(double number, String str) {
		if (number != 0.0)
			return roundToString(Double.toString(number));
		else
			return str;
	}

	/**
	 * Ĭ�ϱ���С�������λ DEFULT_DIV_SCAL = 2
	 * 
	 * @param number
	 * @return String
	 */
	public static String roundToString(Double number) {
		if (number != null)
			return roundToString(number.toString());
		else
			return roundToString("0");
	}

	/**
	 * Ĭ�ϱ���С�������λ DEFULT_DIV_SCAL = 2
	 * 
	 * @param number
	 * @param str
	 *            ��numberΪ�ջ���Ϊ0ʱ�����ַ�
	 * @return String
	 */
	public static String roundToString(Double number, String str) {
		if (number != null && number.doubleValue() != 0.0)
			return roundToString(number.toString());
		else
			return str;
	}

	/**
	 * Ĭ�ϱ���С�������λ DEFULT_DIV_SCAL = 2
	 * 
	 * @param number
	 * @return double
	 */
	public static double roundToDouble(String number) {
		return new BigDecimal(number).divide(new BigDecimal("1"), DEFULT_ROUND_SCAL, BigDecimal.ROUND_HALF_UP).doubleValue();
	}

	/**
	 * Ĭ�ϱ���С�������λ DEFULT_DIV_SCAL = 2
	 * 
	 * @param number
	 * @return String
	 */
	public static double roundToDouble(double number) {
		return roundToDouble(Double.toString(number));
	}

	/**
	 * Ĭ�ϱ���С�������λ DEFULT_DIV_SCAL = 2
	 * 
	 * @param number
	 * @return String
	 */
	public static double roundToDouble(Double number) {
		if (number != null)
			return roundToDouble(number.toString());
		else
			return 0;
	}

	/**
	 * ����С�����scalλ
	 * 
	 * @param number
	 * @param scal
	 * @return String
	 */
	public static String roundToString(String number, int scal) {
		return new BigDecimal(number).divide(new BigDecimal("1"), scal, BigDecimal.ROUND_HALF_UP).toString();
	}

	/**
	 * ����С�����scalλ
	 * 
	 * @param number
	 * @param scal
	 * @return String
	 */
	public static String roundToString(double number, int scal) {
		return roundToString(Double.toString(number), scal);
	}

	/**
	 * ����С�����scalλ
	 * 
	 * @param number
	 * @param scal
	 * @return String
	 */
	public static String roundToString(Double number, int scal) {
		if (number != null)
			return roundToString(number.toString(), scal);
		else
			return roundToString("0", scal);
	}

	/**
	 * ����С�����scalλ
	 * 
	 * @param number
	 * @param scal
	 * @return double
	 */
	public static double roundToDouble(String number, int scal) {
		return new BigDecimal(number).divide(new BigDecimal("1"), scal, BigDecimal.ROUND_HALF_UP).doubleValue();
	}

	/**
	 * ����С�����scalλ
	 * 
	 * @param number
	 * @param scal
	 * @return String
	 */
	public static double roundToDouble(double number, int scal) {
		return roundToDouble(Double.toString(number), scal);
	}

	/**
	 * ����С�����scalλ
	 * 
	 * @param number
	 * @param scal
	 * @return String
	 */
	public static double roundToDouble(Double number, int scal) {
		if (number != null)
			return roundToDouble(number.toString(), scal);
		else
			return 0;
	}

	/**
	 * ȡ��,��4��5��
	 * 
	 * @param number
	 * @return String
	 */
	public static String subScal(String number) {
		if (number != null) {
			return number = number.substring(0, number.indexOf("."));
		} else {
			return "";
		}
	}
	

	/**
	 * ����ת��д�����֣�
	 * @param number
	 * @return
	 */
	private static String toCapitalization(String source) {
	
		char JF[] = new char[] { '��', '��' };
		
		char[] cs = source.toCharArray();
		StringBuffer sb = new StringBuffer();
		int len = cs.length;
		int zerolen = 0;
		for (int i = cs.length; i > 0; i--) {
			int num = Integer.parseInt(cs[len - i] + "");
			if (num != 0) {
				if (zerolen != 0) {
					sb.append(HanDigiStr[0]);
				}
				sb.append(HanDigiStr[num]).append(HanDiviStr[i - 1]);
				zerolen = 0;
			} else {
				zerolen++;
				String s = HanDiviStr[i - 1];
				if (zerolen % 4 == 0 && !"��".equals(s)) {
					continue;
				}
				if ((i - 1) % 4 == 0) {
					sb.append(HanDiviStr[i - 1]);
					zerolen = 0;
				}
			}
		}
		if (sb.length() == 0) {
			sb.append("��");
		}
		return sb.toString();
	}

	/**
	 * �����Сдת��д
	 * @param val
	 * @return
	 */
	public static String NumToRMBStr(Double val) {
		String SignStr = "";
		String TailStr = "";
		long fraction, integer;
		
		if (val < 0) {
			val = -val;
			SignStr = "��";
		}
		if (val > 99999999999999.999 || val < -99999999999999.999)
			return "��ֵλ������!";
		// �������뵽��
		long temp = Math.round(val * 100);
		integer = temp / 100;
		fraction = temp % 100;
		int jiao = (int) (fraction / 10);
		int fen = (int)(fraction % 10);
		if (fraction == 0) {
			TailStr = "��";
		} else {
			if (jiao >0||fen > 0){
				TailStr += HanDigiStr[jiao];
				TailStr += "��";
			}
			
			if(fen > 0){
				TailStr += HanDigiStr[fen];
				TailStr += "��";
			}
		}

		// ��һ�п����ڷ�������ڳ��ϣ�0.03ֻ��ʾ�����֡������ǡ���Ԫ���֡�
		if( integer ==0 ) return SignStr+TailStr;

		return SignStr + toCapitalization(String.valueOf(integer)) + "Ԫ"
				+ TailStr;
	}
		
	/**
	 * �ж��ַ����ǲ���Ϊ����
	 * @param val
	 * @return
	 */
	public static boolean isNumeric(String str){
		for (int i = str.length();--i>=0;){   
		   if (!Character.isDigit(str.charAt(i))){
			   return false;
		   }
		}
		return true;
	}
	
	/**
	 * ����������ת�����й�����
	 * @param val
	 * @return
	 */
	public static String alb_to_cha(String str){
		 HashMap<Integer, String> hashMap = new HashMap<Integer, String>();
		 hashMap.put(0, "��");
		 hashMap.put(1, "һ");
		 hashMap.put(2, "��");
		 hashMap.put(3, "��");
		 hashMap.put(4, "��");
		 hashMap.put(5, "��");
		 hashMap.put(6, "��");
		 hashMap.put(7, "��");
		 hashMap.put(8, "��");
		 hashMap.put(9, "��");
		 StringBuffer cha_num = new StringBuffer();

		 for (int i=0;i<str.length();i++) {
			 int a = str.charAt(i);
			 cha_num.append(hashMap.get(a-48));
		 }
		return cha_num.toString();
	}
	
	/**
	 * ����0��end��Χ��number����������ظ�
	 * @param val
	 * @return List<Integer>
	 */
	public static List<Integer> random(int end,int number){
		List<Integer> nums = new ArrayList<Integer>();
		while(nums.size()<number){
			int str = (int)(Math.random()*end);
			if(!nums.contains(str)){
				nums.add(str);
			}
		}
		return nums;
	}
	/**
	 * Double ��������ȡ��
	 * @param num ��Ҫ��ʽ��������
	 * @return str С�����λ��
	 */
	public static double myround(double num,int str){
		BigDecimal b = new BigDecimal(num);
		num = b.setScale(str, BigDecimal.ROUND_HALF_UP).doubleValue();
		return num;
	}
}
