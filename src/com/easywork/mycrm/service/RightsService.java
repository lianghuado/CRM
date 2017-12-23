package com.easywork.mycrm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.druid.sql.visitor.functions.Right;
import com.easycore.utils.MyPage;
import com.easywork.mycrm.persistence.Employee;
import com.easywork.mycrm.persistence.Rights;
import com.easywork.mycrm.persistence.RightsMapper;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;



@Transactional
@Service
public class RightsService {
	@Autowired
	private RightsMapper rightsMapper;

	public RightsMapper getRightsMapper() {
		return rightsMapper;
	}
	//获取当前职位的所有权限
	public List<Rights> listMenu(Integer id){
		List<Rights> list = rightsMapper.listMenu(id);
		return list;		
	}
	//获取所有的权限类型为1的权限
	public List<Rights> listRight(){
		Example exa =new Example(Rights.class);
		Criteria crt = exa.createCriteria();	
		crt.andCondition("rightType=1");		
		return rightsMapper.selectByExample(exa);
	}
	//获取当前工作岗位的所有权限
	public List<Rights> listJobRight(Integer id){
		return rightsMapper.listJobRight(id);
	}
	//获取所有的权限
	public MyPage<Rights> listAllRight(int curr,int limit){										
		return MyPage.selectAllByPage(rightsMapper, curr, limit);
	}
	//删除权限
	public int delRight(Integer id){
		Example exa =new Example(Rights.class);
		Criteria crt = exa.createCriteria();
		System.out.println(id);
		crt.andCondition("rid=",id);
		int i = rightsMapper.deleteByExample(exa);		
		return 	i;	
	}
	//根据1级权限id获取当前所有二级权限
	public List<Rights> listTwoRights(Integer rid){
		return rightsMapper.listTwoRight(rid);
	}
				
}


