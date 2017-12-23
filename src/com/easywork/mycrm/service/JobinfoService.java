package com.easywork.mycrm.service;

import java.util.List;

import org.omg.CORBA.PRIVATE_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.easywork.mycrm.persistence.Jobinfo;
import com.easywork.mycrm.persistence.JobinfoMapper;
import com.easywork.mycrm.persistence.Jobright;
import com.easywork.mycrm.persistence.JobrightMapper;
import com.easywork.mycrm.persistence.Jrtwo;
import com.easywork.mycrm.persistence.JrtwoMapper;
import com.easywork.mycrm.persistence.Rights;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

@Transactional
@Service
public class JobinfoService {
	@Autowired
	private JobinfoMapper jobinfoMapper;
	@Autowired
	private JobrightMapper jobrightMapper;

	public JobinfoMapper getJobinfoMapper() {
		return jobinfoMapper;
	}

	public JobrightMapper getJobrightMapper() {
		return jobrightMapper;
	}
	@Autowired
	private JrtwoMapper jrtwoMapper;

	public JrtwoMapper getJrtwoMapper() {
		return jrtwoMapper;
	}

	// 增加职位,并添加权限
	public void addjob(String job, Integer dept, Integer rights, String right2s) {
		Jobinfo jobinfo = new Jobinfo();
		jobinfo.setJob(job);
		jobinfo.setDepartmentid(dept);
		jobinfoMapper.insert(jobinfo);
		Jobinfo jb = jobinfoMapper.selectOne(jobinfo);
		Integer id = jb.getId();//获取职位编号
		Jobright jr = new Jobright();
		jr.setJobinfoid(id);
		jr.setRightid(rights);
		jobrightMapper.insert(jr);	
		String[] sp = right2s.trim().split(",");
		for (String rid : sp) {
			Jrtwo jrt = new Jrtwo();
			jrt.setJobinfoid(id);
			jrt.setRightid(Integer.parseInt(rid));
			jrtwoMapper.insert(jrt);
			
		}
	}

	// 获取所有的职位信息
	public List<Jobinfo> listJob() {
		return jobinfoMapper.selectAll();
	}

	// 获取分派的职业信息
	public List<Jobinfo> listDispaterJob() {
		Example exa = new Example(Jobinfo.class);
		Criteria crt = exa.createCriteria();
		crt.andCondition("id in(3,5,8)");
		List<Jobinfo> list = jobinfoMapper.selectByExample(exa);
		return list;
	}

}