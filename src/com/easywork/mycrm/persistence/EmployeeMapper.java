package com.easywork.mycrm.persistence;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

public interface EmployeeMapper extends Mapper<Employee> {
	//登录
	public Employee loginByNameAndPass(@Param("username")String username,@Param("pass")String pass);
	//获取所有的员工
	public List<Map<String, Object>> showEmp(@Param("id")String id,@Param("dname")String dname);
	//获取所有员工的记录条数
	public int selectCountByIdAndDname(@Param("id")String id,@Param("dname")String dname);
	//获取所有的销售人员
	public List<Map<String, Object>> listSell();
	//获取所有的咨询人员
	public List<Map<String, Object>> listConsult();
	//查询部门所有人数
	public int selectCountByDept(@Param("did")Integer did);
	//查询部门所有员工
	public List<Map<String, Object>> selectEmpByDept(@Param("did")Integer did);
}