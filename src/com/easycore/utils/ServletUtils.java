package com.easycore.utils;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.alibaba.fastjson.JSON;

public class ServletUtils {

	// 输出指定string
	public static void print(HttpServletResponse resp, String content) {
		resp.setCharacterEncoding("UTF-8");
		PrintWriter out = null;
		try {
			out = resp.getWriter();
			out.print(content);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 输出json化的实体/实体集合/map/map集合
	public static void printJson(HttpServletResponse resp, Object content) {
		resp.setCharacterEncoding("UTF-8");
		PrintWriter out = null;
		try {
			out = resp.getWriter();
			out.print(JSON.toJSONString(content));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 获取Application(ServletContext)对象
	public static ServletContext getApp(HttpServletRequest req) {
		return req.getServletContext();
	}

	// 设置Application(ServletContext)对象val
	public static void setAppVal(HttpServletRequest req, String name, Object val) {
		ServletContext app = req.getServletContext();
		app.setAttribute(name, val);
	}

	// 获取Application(ServletContext)对象val
	public static Object getAppVal(HttpServletRequest req, String name) {
		ServletContext app = req.getServletContext();
		Object obj = app.getAttribute(name);
		return null == obj ? "" : obj;
	}

	// 设置HttpSession对象val
	public static void setSessionVal(HttpServletRequest req, String name,
			Object val) {
		HttpSession ss = req.getSession();
		ss.setAttribute(name, val);
	}

	// 获取HttpSession对象val
	public static Object getSessionVal(HttpServletRequest req, String name) {
		HttpSession ss = req.getSession();
		Object obj = ss.getAttribute(name);
		return null == obj ? "" : obj;
	}

}
