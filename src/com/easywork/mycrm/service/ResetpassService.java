package com.easywork.mycrm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.easywork.mycrm.persistence.Resetpass;
import com.easywork.mycrm.persistence.ResetpassMapper;

@Transactional
@Service
public class ResetpassService {
	@Autowired
	private ResetpassMapper resetpassMapper;

	public ResetpassMapper getResetpassMapper() {
		return resetpassMapper;
	}

}