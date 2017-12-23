package com.easywork.mycrm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.easywork.mycrm.persistence.Jrtwo;
import com.easywork.mycrm.persistence.JrtwoMapper;

@Transactional
@Service
public class JrtwoService {
	@Autowired
	private JrtwoMapper jrtwoMapper;

	public JrtwoMapper getJrtwoMapper() {
		return jrtwoMapper;
	}
	//获取所有的2级(能实现的权限)信息
	public List<String>  listR(Integer jobinfoid){
		return jrtwoMapper.listR(jobinfoid);
		
	}

}