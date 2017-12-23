package com.easywork.mycrm.controller;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.easycore.utils.BaseController;
import com.easycore.utils.MyPage;
import com.easywork.mycrm.persistence.Consultrecord;
import com.easywork.mycrm.persistence.Employee;
import com.easywork.mycrm.service.ConsultrecordService;

@Controller
@RequestMapping("/mycrm/Consultrecord")
public class ConsultrecordController extends BaseController {
	@Autowired
	private ConsultrecordService consultrecordService;
	//销售助理分配顾客至咨询师
	@RequestMapping("/addCRecord")
	public void addCRecord(Integer cid,String statu,Integer eid,HttpServletResponse resp){	
		int i = consultrecordService.addCRecord(cid, statu, eid);
		if (i!=1) {
			super.print(resp, "fail");
			return;
		}
		super.print(resp, "success");
	}
	//咨询师查询自己所有的咨询记录
	@RequestMapping("/listRecord")
	@ResponseBody
	public MyPage<Map<String, Object>> listRecord(HttpServletRequest req,int curr,int limit){
		Employee e =(Employee)req.getSession().getAttribute("user");
		Integer id = e.getId();
		MyPage<Map<String, Object>> myPage = consultrecordService.listRecord(id, curr, limit);
		return myPage;		
	}
	//咨询师根据指定的记录id查询记录
	@RequestMapping("/selectRecordById")
	@ResponseBody
	public Consultrecord selectRecordById(Integer id){
		return consultrecordService.selectRecordById(id);		
	}
	//根据咨询记录id修改咨询记录
	@RequestMapping("/modConRecord")
	public void modConRecord(HttpServletResponse resp,Integer id,String consultstatu,Date consultdate,String result){
		int i = consultrecordService.modConRecord(id, consultstatu, consultdate, result);
		if (i!=1) {
			super.print(resp, "fail");
			return;
		}
		super.print(resp, "success");
	}
	
	//部门主管查询部门员工的客户咨询状态
	@RequestMapping("/listDeptRe")
	@ResponseBody
	public MyPage<Map<String, Object>> listDeptRe(HttpServletRequest req,int curr,int limit){
		Employee e =(Employee) req.getSession().getAttribute("user");
		Integer i = e.getDepartmentid();
		MyPage<Map<String, Object>> myPage = consultrecordService.listDeptRe(i, curr, limit);
		return myPage;		
	}
}