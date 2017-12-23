package com.easywork.mycrm.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.easycore.utils.BaseController;
import com.easywork.mycrm.persistence.Jobinfo;
import com.easywork.mycrm.service.JobinfoService;

@Controller
@RequestMapping("/mycrm/Jobinfo")
public class JobinfoController extends BaseController {
	@Autowired
	private JobinfoService jobinfoService;
	
	//获取职位
	@RequestMapping("/listJob")
	@ResponseBody
	public List<Jobinfo> listJob(){
		return jobinfoService.listJob();
		
	}
	//获取分派的职业
	@RequestMapping("/listDispaterJob")
	@ResponseBody
	public List<Jobinfo> listDispaterJob(){		
		return jobinfoService.listDispaterJob();
		
	}
	//添加工作职位
	@RequestMapping("/addjob")
	public void addjob(String job,Integer dept,Integer rights,String right2s,HttpServletResponse resp){
		jobinfoService.addjob(job,dept,rights,right2s);
		super.print(resp, "success");
	}

}