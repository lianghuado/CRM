package com.easywork.mycrm.persistence;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

public interface ConsultrecordMapper extends Mapper<Consultrecord> {
	//根据咨询师id查询咨询师的咨询记录条数
	public int selectRecordCountByCid(@Param("id")Integer id);
	//根据咨询师id查询咨询师咨询记录
	public List<Map<String, Object>> selectRecordByCid(@Param("id")Integer id);
	
	//根据部门id查询部门员工咨询的记录条数
	public int selectRecordCountByDid(@Param("did")Integer did);
	//根据部门id查询部门员工咨询的记录
	public List<Map<String, Object>> selectRecordByDid(@Param("did")Integer did);
}