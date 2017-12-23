package com.easywork.mycrm.persistence;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import tk.mybatis.mapper.common.Mapper;

public interface RightsMapper extends Mapper<Rights> {
	//菜单获取权限
	public List<Rights> listMenu (@Param("id")Integer id);
	//查看全部权限
	public List<Rights> listJobRight (@Param("id")Integer id);
	//根据rid获取全部二级权限
	public List<Rights> listTwoRight (@Param("rid")Integer rid);
}