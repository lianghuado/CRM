package com.easywork.mycrm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.easycore.utils.BaseController;
import com.easywork.mycrm.persistence.Department;
import com.easywork.mycrm.service.DepartmentService;

@Controller
@RequestMapping("/mycrm/Department")
public class DepartmentController extends BaseController {
	@Autowired
	private DepartmentService departmentService;
	@RequestMapping("/listDept")
	@ResponseBody
	public List<Department> listDept(){
		return departmentService.listDept();
		
	}

}