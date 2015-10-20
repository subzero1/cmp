package com.netsky.test.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


/**
 * @description:
 * 文档抄送
 * @class name:com.netsky.base.flow.controller.MakeCopy
 * @author Administrator Aug 5, 2011
 */
@Controller
public class Test {
	/**
	 * 数据对应操作类
	 */
	
	/**
	 * 日志处理类
	 */
	private  Logger log = Logger.getLogger(this.getClass());

	/**
	 * 表单抄送
	 * @param request
	 * @param response
	 * @param session
	 * @return ModelAndView
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/index.do")
	public ModelAndView makeCopy(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception{
		//初始化ApplicationContext
		
		ModelMap modelMap = new ModelMap();
		Map paraMap = new HashMap();
		response.getWriter().print("test OK");
		return null;
	}
}
