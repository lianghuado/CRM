package com.easywork.mycrm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.easycore.utils.MyPage;
import com.easywork.mycrm.persistence.Custom;
import com.easywork.mycrm.persistence.CustomMapper;
import com.easywork.mycrm.persistence.Employee;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

@Transactional
@Service
public class CustomService {
	@Autowired
	private CustomMapper customMapper;

	public CustomMapper getCustomMapper() {
		return customMapper;
	}
	
	//查询顾客,分页
	public MyPage<Custom> listCustom(String name,String inviteName,int curr,int limit){
		Example exa =new Example(Custom.class);
		Criteria crt = exa.createCriteria();
		if (name!=null && !"".equals(name)) {
			crt.andCondition("name=",name);
		}
		if (inviteName!=null && !"".equals(inviteName)) {
			crt.andCondition("invitename=",inviteName);
		}
		return MyPage.selectByExampleAndPage(customMapper, exa, curr, limit);
		
	}
	//添加客户
	public int addCus(Custom c){		
		return customMapper.insert(c);		
	}
	//修改客户
	public int modifyCus(Custom c){
		Custom custom = customMapper.selectByPrimaryKey(c);
		custom.setEducation(c.getEducation());
		custom.setEmail(c.getEmail());
		custom.setPhoneno(c.getPhoneno());
		custom.setQq(c.getQq());
		custom.setCustomstatu(c.getCustomstatu());
		return customMapper.updateByPrimaryKey(custom);		
	}	
	//根据id查询客户
	public Custom selectById(Integer id){
		Custom c=new Custom();
		c.setId(id);
		return customMapper.selectByPrimaryKey(c);
	}
	//查询所有客户信息
	public List<Custom> listAllCus(){
		return customMapper.selectAll();
	}
	//插入客户信息
	public void inCus(Custom c){
		customMapper.insert(c);
	}

}