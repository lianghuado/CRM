package com.easywork.mycrm.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.easycore.utils.BaseController;
import com.easycore.utils.MyPage;
import com.easywork.mycrm.persistence.Rights;
import com.easywork.mycrm.service.RightsService;

@Controller
@RequestMapping("/mycrm/Rights")
public class RightsController extends BaseController {
	@Autowired
	private RightsService rightsService;
	
	//获取菜单列表
	public List<Map<String, Object>> listMenu(Integer id){		
		return null;
		
	}
	//获取所有权限类型为1的权限
	@RequestMapping("/listRight")
	@ResponseBody
	public List<Rights> listRight(){
		List<Rights> list = rightsService.listRight();		
		return 	list;	
	}
	//获取当前职位的权限信息
	@RequestMapping("/listJobRight")
	@ResponseBody
	public List<Rights> listJobRight(String id){
		System.out.println(id);		
		return rightsService.listJobRight(Integer.parseInt(id));		
	}
	//获取所有的权限,包含1和2
	@RequestMapping("/listAllRight")
	@ResponseBody
	public MyPage<Rights> listAllRight(int curr,int limit){			
		return rightsService.listAllRight(curr, limit);	
	}
	
	//根据id来删除权限
	@RequestMapping("/delRight")
	public void delRight(Integer id,HttpServletResponse resp){		
		int i = rightsService.delRight(id);	
		if (i!=1) {
			super.print(resp, "fail");
			return;
		}
		super.print(resp, "success");
	}
	//根据1级权限ID获取2级权限信息
	@RequestMapping("/listTwoRights")
	@ResponseBody
	public List<Rights> listTwoRights(Integer rid){
		return rightsService.listTwoRights(rid);
		
	}
	
	

}