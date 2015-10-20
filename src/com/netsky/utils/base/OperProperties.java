package com.netsky.utils.base;

import java.util.Properties;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream; 
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author ¿ÓœË”Ó
 * @desctiption :operate the Properties file ,
 * such as reading,writing there are
 * four constructor.
 */
public class OperProperties {

	/**
	 * put the key-value list in it.
	 */
	static Properties  container;

	
	/**
	 * @param: load the pfile 
	 * content into the container;
	 */
	public static void load(String pfile) throws FileNotFoundException,IOException{
		java.io.InputStream in = new BufferedInputStream(new FileInputStream(pfile));
		container = new Properties();
		container.load(in);
		in.close();
	}

	public static String getValue(String key) {
		return container.getProperty(key);
	}
	
	/**
	 * @param: store the content to pfile 
	 */
	public static void write(String pfile,String key,String value) throws FileNotFoundException,IOException{
		java.io.InputStream in = new BufferedInputStream(new FileInputStream(pfile));
		Properties t_pro = new Properties();
		t_pro.load(in);
		t_pro.setProperty(key, value);
		
		java.io.OutputStream out = new BufferedOutputStream(new FileOutputStream(pfile));
		t_pro.store(out,"set");
		out.close();
		in.close();
	}
}
