package com.netsky.utils.base;
import java.util.Map;

import com.netsky.base.baseObject.SharedCfgData;
import com.netsky.utils.base.convertUtil;
import com.netsky.utils.base.OperProperties;


/**
 * @author lee.xiangyu
 * @desc create dataObjects[java] from ta06,ta07
 * 		 create hibernate configure file[java.hbm] from dataObjects
 * 		 write [java.hbm] to applicationContext-hibernate.xml
 */
public class CreateDoUtil {
	
	/**
	 * @param paramMap
	 * @desc create dataObjects[java] from ta06,ta07
	 */
	public void createDoJava(Map paramMap) throws Exception{
		
		Long ta06_id = (Long)paramMap.get("ta06_id");
		Long ta07_id = (Long)paramMap.get("ta07_id");
		
		/*
		 * 获得WEB根目录
		 */
		Map<String,String> cfgMap = SharedCfgData.getMap();
		String gys_cfg_uri = cfgMap.get("baseConfig.properties");
		OperProperties op = new OperProperties();
		op.load(gys_cfg_uri);
	}
	
	/**
	 * @desc create hibernate configure file[java.hbm] from dataObjects
	 */
	public void java2Xml(Map paramMap) throws Exception{
		
	}
	
	/**
	 * @desc write [java.hbm] to applicationContext-hibernate.xml
	 */
	public void xml2Cfg(Map paramMap) throws Exception{
		
	}
}
