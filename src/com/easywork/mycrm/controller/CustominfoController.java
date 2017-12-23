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
import com.easywork.mycrm.persistence.Custominfo;
import com.easywork.mycrm.persistence.Employee;
import com.easywork.mycrm.service.CustominfoService;

@Controller
@RequestMapping("/mycrm/Custominfo")
public class CustominfoController extends BaseController {
	@Autowired
	private CustominfoService custominfoService;
	//销售分配客户到销售跟进表
	@RequestMapping("/addSell")
	public void addSell(Integer cid,String statu,Integer eid,HttpServletResponse resp){
		int i = custominfoService.addSell(cid, statu, eid);
		if (i!=1) {
			super.print(resp, "fail");
			return;
		}
		super.print(resp, "success");
	}
	
	//销售或咨询查询所拥有的客户的开发信息
	@RequestMapping("/listDeve")
	@ResponseBody
	public MyPage<Map<String, Object>> listDeve(HttpServletRequest req,int curr,int limit){
		Employee e =(Employee) req.getSession().getAttribute("user");
		Integer id = e.getId();
		MyPage<Map<String, Object>> myPage = custominfoService.listDeve(id, curr, limit);
		return myPage;		
	}
	//修改指定的客户开发信息
	@RequestMapping("/modCustomInfo")
	public void modCustomInfo(HttpServletResponse resp,Integer id,String statu,Date plandate,String mark){
		int i = custominfoService.modCustomInfo(id, statu, plandate, mark);
		if (i!=1) {
			super.print(resp, "fail");
			return;
		}
		super.print(resp, "success");
	}
	//根据id查找客户开发信息
	@RequestMapping("/selectCinfoById")
	@ResponseBody
	public Custominfo selectCinfoById(Integer id){
		return custominfoService.selectCinfoById(id);		
	}
	
	//查看部门员工客户开发信息
	@RequestMapping("/listDeveByDid")
	@ResponseBody
	public MyPage<Map<String, Object>> listDeveByDid(HttpServletRequest req,int curr,int limit){
		Employee e =(Employee) req.getSession().getAttribute("user");
		Integer did = e.getDepartmentid();
		MyPage<Map<String, Object>> myPage = custominfoService.listDeveByDid(did, curr, limit);
		return myPage;		
	}
}