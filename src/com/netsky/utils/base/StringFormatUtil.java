package com.netsky.utils.base;

/**
 * ��ʽ���ַ���
 * 
 * @author Chiang
 */
	public class StringFormatUtil {

	/**
	 * ��ʽ���ַ���,Ĭ�Ϸ���""
	 * 
	 * @param str
	 */
	public static String format(String str) {
		if (str == null) {
			return "";
		} else {
			return str;
		}
	}

	/**
	 * ��ʽ���ַ���,Ĭ�Ϸ���""
	 * 
	 * @param str
	 */
	public static String format(Integer str) {
		if (str == null) {
			return "";
		} else {
			return str.toString();
		}
	}

	/**
	 * ��ʽ���ַ���,Ĭ�Ϸ���""
	 * 
	 * @param str
	 */
	public static String format(Double str) {
		if (str == null) {
			return "";
		} else {
			return str.toString();
		}
	}

	/**
	 * ��ʽ���ַ���,Ĭ�Ϸ���defaultStr
	 * 
	 * @param str
	 * @param defaultStr
	 */
	public static String format(Integer str, String defaultStr) {
		if (str == null) {
			return defaultStr;
		} else {
			return str.toString();
		}
	}

	/**
	 * ��ʽ���ַ���,Ĭ�Ϸ���defaultStr
	 * 
	 * @param str
	 * @param defaultStr
	 */
	public static String format(Double str, String defaultStr) {
		if (str == null) {
			return defaultStr;
		} else {
			return str.toString();
		}
	}

	/**
	 * ��ʽ���ַ���,Ĭ�Ϸ���defaultStr
	 * 
	 * @param str
	 * @param defaultStr
	 */
	public static String format(String str, String defaultStr) {
		if (str == null || str.trim().equals(""))
			return defaultStr;

		return str;
	}

	/**
	 * method:subString
	 * 
	 * @description ��Դ�ַ�����ȡָ������,������ �ȼ�1���1�ķ���,���ȶԽ�ȡ�� ���ֽ�����[tmp_part_byte]
	 *              ��1�����µ��ַ���[tmp_str] ���ٶ�[tmp_str]��ȥ���һ���ַ�.
	 * 
	 * @param str
	 *            Դ�ַ���
	 * @param length
	 *            ָ���ĳ���
	 * @return ��ȡ����ַ���
	 * @throws Exception
	 *             String
	 * @author lee.xiangyu
	 */
	public static String subString(String str, int length) throws Exception {

		byte[] tmp_all_byte = null;
		if (str == null || length < 0) {
			return "";
		}
		tmp_all_byte = str.getBytes();
		if (tmp_all_byte.length <= length) {
			return str;
		} else {
			byte[] tmp_part_byte = new byte[length + 1];
			for (int i = 0; i < length + 1; i++) {
				tmp_part_byte[i] = tmp_all_byte[i];
			}
			String tmp_str = new String(tmp_part_byte, "GBK");
			tmp_str = tmp_str.substring(0, tmp_str.length() - 1);
			return tmp_str;
		}
	}

	/**
	 * method:getStrWithSuffix
	 * 
	 * @param str
	 *            Դ�ַ���
	 * @param length
	 *            ָ���ĳ���
	 * @param suffix
	 *            ��׺
	 * @return
	 * @throws Exception
	 *             String
	 * @author lee.xiangyu
	 */
	public static String getStrWithSuffix(String str, int length, String suffix)
			throws Exception {

		byte[] tmp_all_byte = null;
		if (str == null || length < 0) {
			return "";
		}
		tmp_all_byte = str.getBytes();
		if (tmp_all_byte.length <= length) {
			return str;
		} else {
			return subString(str, length) + suffix;
		}
	}

	/**
	 * method:getStrWithSuffix
	 * 
	 * @param str
	 *            Դ�ַ���
	 * @param length
	 *            ָ���ĳ���
	 * @return
	 * @throws Exception
	 *             String
	 * @author lee.xiangyu
	 */
	public static String getStrWithSuffix(String str, int length)
			throws Exception {
		return getStrWithSuffix(str, length, "...");
	}

	/**
	 * method:toUtf8String
	 * 
	 * @param s
	 * @return String
	 */
	public static String toUtf8String(String str) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (c >= 0 && c <= 255) {
				sb.append(c);
			} else {
				byte[] b;
				try {
					b = Character.toString(c).getBytes("utf-8");
				} catch (Exception ex) {
					b = new byte[0];
				}
				for (int j = 0; j < b.length; j++) {
					int k = b[j];
					if (k < 0)
						k += 256;
					sb.append("%" + Integer.toHexString(k).toUpperCase());
				}
			}
		}
		return sb.toString();
	}

	/**
	 * method:getStrWithComma
	 * 
	 * @param str
	 * @return String
	 */
	public static String getStrWithComma(String str) {

		int index = str.lastIndexOf(".");
		if (index < 0)
			index = str.length();
		for (int i = index; i > 3; i -= 3) {
			str = str.substring(0, i - 3) + ","
					+ str.substring(i - 3, str.length());
		}
		return str;
	}

	
		/**
		 * method:four_char
		 * @param str
		 * @param _num
		 * @return String
		 */
	public static String getCompleteString(String str,int _num){
		
			StringBuffer num=new StringBuffer("");
		    if(str==null||str.equals("")){
		       for(int k=0;k<_num;k++){num.append("0"); }
		          return num.toString();
		    } 
		    
		    for(int i=0;i<_num-str.length();i++){
		      num.append("0");	
		    }
		    num.append(str);
		    return num.toString();
		}
	
	/**
	 *��������������['aa','bb','cc']
	 * @param sourceStr [aa,bb,cc || aa,'bb',cc, ...]
	 * @return ������ַ���
	 */
	public static String formatStrWithName(String sourceStr){
		
		if(sourceStr == null || sourceStr.equals(""))
			return "'x'";
		
		/**
		 * �ж����һ���ַ��Ƿ�Ϊ����
		 */
		int s = sourceStr.lastIndexOf(",");
		if(sourceStr.length()-1 == s){
			sourceStr = sourceStr.substring(0,sourceStr.length()-1);
		}
		
		/**
		 * �����ַ����е�����
		 */
		sourceStr = sourceStr.replace("'", "");
		sourceStr = "'" + sourceStr.replace(",", "','") + "'";
		
		/**
		 * �����ַ����еĿո�
		 */
		sourceStr = sourceStr.replace(" ", "");
		
		return sourceStr;
	}
	
	/**
	 *��������������[1,2,3]
	 * @param sourceStr [1,2,3, || 1,'2',3, ...]
	 * @return ������ַ���
	 */
	public static String formatStrWithID(String sourceStr){
		
		if(sourceStr == null || sourceStr.equals(""))
			return "'x'";
		
		/**
		 * �ж����һ���ַ��Ƿ�Ϊ����
		 */
		int s = sourceStr.lastIndexOf(",");
		if(sourceStr.length()-1 == s){
			sourceStr = sourceStr.substring(0,sourceStr.length()-1);
		}
		
		/**
		 * �����ַ����е�����
		 */
		sourceStr = sourceStr.replace("'", "");
		
		/**
		 * �����ַ����еĿո�
		 */
		sourceStr = sourceStr.replace(" ", "");
		
		return sourceStr;
	}
		
	public static void main(String[] args) {
		try {
			Class clazz = Class.forName("com.netsky.base.service.QueryService");
			System.out.println(clazz.getSimpleName());
		} catch (Exception e) {

		}
	}
}
