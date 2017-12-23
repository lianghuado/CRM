package com.easywork.mycrm.persistence;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import tk.mybatis.mapper.common.Mapper;

public interface JrtwoMapper extends Mapper<Jrtwo> {
	public List<String> listR(@Param("jobinfoid")Integer jobinfoid);
}