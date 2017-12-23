package com.easywork.mycrm.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.easycore.utils.BaseController;
import com.easywork.mycrm.service.JobinfoService;

@Controller
@RequestMapping("/demo")
public class DemoController extends BaseController {
	
	@Autowired
	JobinfoService jobinfoService;
	
	@RequestMapping("/view")
	public String view() {
		return "/proj/view";
	}
	//修改客户信息(跳转页面)
	@RequestMapping("/change")
	public String change() {
		return "/proj/changeCus";
	}
	//修改客户开发信息(跳转页面)
	@RequestMapping("/mod")
	public String mod() {
		return "/proj/modcusDeve";
	}
	
	//修改客户开发信息(跳转页面)
	@RequestMapping("/modCon")
	public String modCon() {
			return "/proj/modConsult";
	}

	@RequestMapping("/tabOrPop/{view}")
	public String tabOrPop(@PathVariable("view") String view) {
		return "/proj/" + view;
	}
	

}