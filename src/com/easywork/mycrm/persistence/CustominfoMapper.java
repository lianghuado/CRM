package com.easywork.mycrm.persistence;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import tk.mybatis.mapper.common.Mapper;

public interface CustominfoMapper extends Mapper<Custominfo> {
	//查找销售或咨询人员跟单记录总条数
	public int selectCountByFid(@Param("id")Integer id);
	//查询自己所有的跟单记录
	public List<Map<String, Object>> listCinfo(@Param("id")Integer id);
	//查找整个部门人员的客户开发记录总条数
	public int selectCountByDid(@Param("did")Integer did);
	//查找整个部门的所有员工的客户开发记录
	public List<Map<String, Object>> listCinfoByDid(@Param("did")Integer did);
		
	
}