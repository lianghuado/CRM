package com.easywork.mycrm.controller;

import java.util.List;
import java.util.Map;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.easycore.utils.BaseController;
import com.easycore.utils.MailUtils;
import com.easycore.utils.MyPage;
import com.easywork.mycrm.persistence.Employee;
import com.easywork.mycrm.persistence.Rights;
import com.easywork.mycrm.service.EmployeeService;
import com.easywork.mycrm.service.JrtwoService;
import com.easywork.mycrm.service.RightsService;

@Controller
@RequestMapping("/mycrm/Employee")
public class EmployeeController extends BaseController {
	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private RightsService rightsService;
	@Autowired
	private JrtwoService jrtwoService;

	// 登录,同时生成菜单
	@RequestMapping("/login")
	public void login(String username, String pass, HttpServletResponse resp, HttpServletRequest req) {
		if (username == null || pass == null) {
			super.print(resp, "fail");
			return;
		}
		String md5str = super.getMD5str(pass);
		Employee user = employeeService.loginBynameAndPass(username, md5str);
		if (user==null) {
			super.print(resp, "fail");
			return;
		}
		Integer id = user.getJobinfoid();
		Integer jobinfoid = user .getJobinfoid();
		System.out.println(jobinfoid);
		List<String> listR = jrtwoService.listR(jobinfoid);
		List<Rights> list = rightsService.listMenu(id);
		super.setSessionVal(req, "user", user);
		super.setSessionVal(req, "list", list);
		super.setSessionVal(req, "listR", listR);
		super.print(resp, "success");
	}

	// 查看所有的员工
	@RequestMapping("/listEmp")
	@ResponseBody
	public MyPage<Employee> listEmp(String id, String realname, int curr, int limit) {
		return employeeService.listEmp(id, realname, curr, limit);
	}

	// 查看所有的管理员
	@RequestMapping("/listAdmin")
	@ResponseBody
	public MyPage<Employee> listAdmin(int curr, int limit) {
		return employeeService.listAdmin(curr, limit);
	}

	// 删除管理员
	@RequestMapping("/delAdmin")
	public void delAdmin(String id, HttpServletResponse resp) {
		employeeService.delAdmin(id);
		super.print(resp, "1");
	}

	// 添加管理员
	@RequestMapping("/addAdmin")
	public void addAdmin(HttpServletResponse resp, String username, String pass, String nickname, String realname,
			String phoneno, String officetel) {
		Employee e = new Employee();
		e.setUsername(username);
		String md5str = super.getMD5str(pass);
		e.setPass(md5str);
		e.setNickname(nickname);
		e.setRealname(realname);
		e.setPhoneno(phoneno);
		e.setOfficetel(officetel);
		e.setDepartmentid(1);
		e.setJobinfoid(2);
		e.setWorkstatu("1");
		employeeService.addAdmin(e);
		super.print(resp, "success");
	}

	// 添加普通用户
	@RequestMapping("/addEmp")
	public void addEmp(HttpServletResponse resp, Integer deptid, Integer jobid, String username, String pass,
			String nickname, String realname, String phoneno, String officetel) {
		Employee e = new Employee();
		e.setUsername(username);
		String md5str = super.getMD5str(pass);
		e.setPass(md5str);
		e.setNickname(nickname);
		e.setRealname(realname);
		e.setPhoneno(phoneno);
		e.setOfficetel(officetel);
		e.setDepartmentid(deptid);
		e.setJobinfoid(jobid);
		e.setWorkstatu("1");
		employeeService.addEmp(e);
		super.print(resp, "success");
	}

	// 查看所有普通的员工
	@RequestMapping("/listCommEmp")
	@ResponseBody
	public MyPage<Employee> listCommEmp(String id, String realname, int curr, int limit) {
		return employeeService.listCommEmp(id, realname, curr, limit);
	}

	// 将普通用户转换成离职状态
	@RequestMapping("/delCommEmp")
	public void delCommEmp(String id, HttpServletResponse resp) {
		employeeService.delCommEmp(id);
		super.print(resp, "success");
	}

	// 重置普通用户的密码
	@RequestMapping("/resetPass")
	public void resetPass(String username, String email, String phoneno, HttpServletResponse resp)
			throws MessagingException {
		List<Employee> list = employeeService.selectEmpByName(username, email, phoneno);
		if (list.isEmpty()) {
			super.print(resp, "fail");
			return;
		}
		Employee e = list.get(0);
		e.setPass("202cb962ac59075b964b07152d234b70");
		int i = employeeService.resetPass(e);
		if (i != 1) {
			super.print(resp, "fail");
			return;
		}
		MailUtils.sendHtmlMail(email, "密码是123", email);
		super.print(resp, "success");

	}

	// 完整版员工
	@RequestMapping("/showEmp")
	@ResponseBody
	public MyPage<Map<String, Object>> showEmp(String id, String dname, int curr, int limit) {
		return employeeService.showEmp(id, dname, curr, limit);

	}

	// 销售助理查询所有销售人员
	@RequestMapping("/selectSell")
	@ResponseBody
	public List<Map<String, Object>> selectSell() {
		System.out.println(1);
		return employeeService.listSell();
	}

	// 销售助理查询所有咨询人员
	@RequestMapping("/selectConsult")
	@ResponseBody
	public List<Map<String, Object>> selectConsult() {
		return employeeService.listConsult();
	}
	//根据员工职位id来查询员工
	@RequestMapping("/listEmpByJobid")
	@ResponseBody
	public List<Employee> listEmpByJobid(Integer id){
		return employeeService.listEmpByJobid(id);		
	}
	
	//部门主管查看部门员工信息
	// 完整版员工
	@RequestMapping("/showEmpByDept")
	@ResponseBody
	public MyPage<Map<String, Object>> showEmpByDept(HttpServletRequest req,int curr, int limit) {
		Employee e =(Employee) super.getSessionVal(req, "user");
		Integer did = e.getDepartmentid();
		MyPage<Map<String, Object>> myPage = employeeService.showEmpByDept(did, curr, limit);
		return myPage;

	}

}