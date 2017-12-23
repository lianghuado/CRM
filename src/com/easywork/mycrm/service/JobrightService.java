package com.easywork.mycrm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.easywork.mycrm.persistence.Jobright;
import com.easywork.mycrm.persistence.JobrightMapper;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

@Transactional
@Service
public class JobrightService {
	@Autowired
	private JobrightMapper jobrightMapper;

	public JobrightMapper getJobrightMapper() {
		return jobrightMapper;
	}
	
	//删除某个职位的某个权限
	public int delR(Integer id,Integer right){
		Example exa = new Example(Jobright.class);
		Criteria crt = exa.createCriteria();
		crt.andCondition("jobinfoid=", id);
		crt.andCondition("rightid=", right);
		return jobrightMapper.deleteByExample(exa);
	}
		
}