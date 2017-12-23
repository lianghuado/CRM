package com.easywork.mycrm.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.easycore.utils.MyPage;
import com.easywork.mycrm.persistence.Employee;
import com.easywork.mycrm.persistence.EmployeeMapper;
import com.github.pagehelper.PageHelper;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

@Transactional
@Service
public class EmployeeService {
	@Autowired
	private EmployeeMapper employeeMapper;

	public EmployeeMapper getEmployeeMapper() {
		return employeeMapper;
	}

	// 登录
	public Employee loginBynameAndPass(String username, String pass) {
		return employeeMapper.loginByNameAndPass(username, pass);
	}

	// 查询员工并分页
	public MyPage<Employee> listEmp(String id, String realname, int curr, int limit) {
		Example exa = new Example(Employee.class);
		Criteria crt = exa.createCriteria();
		crt.andCondition("workstatu=", "1");
		if (id != null && !"".equals(id)) {
			crt.andCondition("id=", id);
		}
		if (realname != null && !"".equals(realname)) {
			crt.andCondition("realname=", realname);
		}
		return MyPage.selectByExampleAndPage(employeeMapper, exa, curr, limit);
	}

	// 查询管理员并分页
	public MyPage<Employee> listAdmin(int curr, int limit) {
		Example exa = new Example(Employee.class);
		Criteria crt = exa.createCriteria();
		crt.andCondition("workstatu=", "1");
		crt.andCondition("jobinfoid=", "2");
		return MyPage.selectByExampleAndPage(employeeMapper, exa, curr, limit);
	}

	// 删除管理员
	public void delAdmin(String id) {
		Example exa = new Example(Employee.class);
		Criteria crt = exa.createCriteria();
		crt.andCondition("id=", id);
		employeeMapper.deleteByExample(exa);
	}

	// 添加管理员
	public void addAdmin(Employee e) {
		employeeMapper.insertSelective(e);
	}

	// 添加普通用户
	public void addEmp(Employee e) {
		employeeMapper.insertSelective(e);
	}

	// 查询普通员工
	// 并分页
	public MyPage<Employee> listCommEmp(String id,String realname,int curr, int limit) {
		Example exa = new Example(Employee.class);
		Criteria crt = exa.createCriteria();
		crt.andCondition("workstatu=", "1");
		if (id != null && !"".equals(id)) {
			crt.andCondition("id=", id);
		}
		if (realname != null && !"".equals(realname)) {
			crt.andCondition("realname=", realname);
		}
		crt.andCondition("jobinfoid!=", "1");
		crt.andCondition("jobinfoid!=", "2");		
		return MyPage.selectByExampleAndPage(employeeMapper, exa, curr, limit);
	}
	
	//把员工转换成离职状态
	public void delCommEmp(String id){
		Integer i = Integer.parseInt(id);
		Example exa = new Example(Employee.class);
		Criteria crt = exa.createCriteria();		
		crt.andCondition("workstatu=", "1");
		if (id != null && !"".equals(id)) {			
			crt.andCondition("id=", i);
		}
		Employee e = employeeMapper.selectByPrimaryKey(i);
		e.setWorkstatu("0");
		employeeMapper.updateByExampleSelective(e, exa);
	}
	//根据用户名,寻找员工
	public List<Employee> selectEmpByName(String username,String email,String phoneno){		
		Example exa = new Example(Employee.class);
		Criteria crt = exa.createCriteria();		
		crt.andCondition("workstatu=", "1");
		if (username != null && !"".equals(username)) {			
			crt.andCondition("username=", username);
		}		
		if (phoneno != null && !"".equals(phoneno)) {			
			crt.andCondition("phoneno=", phoneno);
		}		
		return employeeMapper.selectByExample(exa);		
	}
	//重置密码
	public int resetPass(Employee e){
		Example exa = new Example(Employee.class);
		Criteria crt = exa.createCriteria();
		crt.andCondition("id=",e.getId());
		crt.andCondition("workstatu=", "1");
		return employeeMapper.updateByExample(e, exa);
	}
	
	//分页员工
	public MyPage<Map<String, Object>> showEmp(String id,String dname,int curr, int limit){				
		int count = employeeMapper.selectCountByIdAndDname(id, dname);
		PageHelper.startPage(curr,limit);
		List<Map<String, Object>> list = employeeMapper.showEmp(id, dname);
		MyPage<Map<String, Object>> myPage=new MyPage<>(count,limit,list);
		return myPage;
		
	}
	//查询所有销售人员
	public List<Map<String, Object>> listSell(){
		return employeeMapper.listSell();
	}
	//查询所有咨询人员
	public List<Map<String, Object>> listConsult(){
		return employeeMapper.listConsult();
	}
	//根据员工职位id来查询员工
	public List<Employee> listEmpByJobid(Integer id){
		Example exa = new Example(Employee.class);
		Criteria crt = exa.createCriteria();
		crt.andCondition("jobinfoid=", id);
		return employeeMapper.selectByExample(exa);
	}
	//主管查询本部门所有的员工信息
	public MyPage<Map<String, Object>> showEmpByDept(Integer did,int curr,int limit){
		int count = employeeMapper.selectCountByDept(did);
		PageHelper.startPage(curr, limit);
		List<Map<String, Object>> list = employeeMapper.selectEmpByDept(did);
		MyPage<Map<String, Object>> myPage = new MyPage<>(count, limit, list);
		return myPage;		
	}
	
	
	

}