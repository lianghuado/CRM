package com.easywork.mycrm.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ddf.EscherColorRef.SysIndexSource;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class MyInterceptor implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object arg2) throws Exception {		
		String ref = req.getHeader("referer");
		// 禁止直接url访问
		if (null == ref || "".equals(ref.trim())){
			req.getRequestDispatcher("/web-view/proj/fail.jsp").forward(req, resp);
			return false;
		}
		String path = req.getServletPath();
		System.out.println(path);
		String[] sp = path.split("/");	
		Object user = req.getSession().getAttribute("user");
		List<String> listR =(List<String>) req.getSession().getAttribute("listR");
		System.out.println("数组长度"+sp.length);
		if (user==null) {
			req.getRequestDispatcher("/web-view/proj/fail.jsp").forward(req, resp);
			return false;
		}
		for (String s : listR) {			
			if (s.equals(sp[3])) {
				return true;
			}
		}
		req.getRequestDispatcher("/web-view/proj/fail.jsp").forward(req, resp);
		return false;
		
	}

}
