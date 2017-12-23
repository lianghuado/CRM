package com.easywork.mycrm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.easywork.mycrm.persistence.Department;
import com.easywork.mycrm.persistence.DepartmentMapper;

@Transactional
@Service
public class DepartmentService {
	@Autowired
	private DepartmentMapper departmentMapper;

	public DepartmentMapper getDepartmentMapper() {
		return departmentMapper;
	}
	
	public List<Department> listDept(){
		return departmentMapper.selectAll();		
	}

}