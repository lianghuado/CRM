package com.easywork.mycrm.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.easycore.utils.BaseController;
import com.easywork.mycrm.persistence.Jobright;
import com.easywork.mycrm.service.JobrightService;

@Controller
@RequestMapping("/mycrm/Jobright")
public class JobrightController extends BaseController {
	@Autowired
	private JobrightService jobrightService;
	
	//删除职位的某个权限
	@RequestMapping("/delRight")
	public void delRight(Integer id,Integer right,HttpServletResponse resp){
		System.out.println("jobright"+id+right);
		int i = jobrightService.delR(id, right);		
		if (i<1) {
			super.print(resp, "fail");
			return;
		}
		super.print(resp, "success");
	}

}