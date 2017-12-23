package com.easywork.mycrm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.easycore.utils.BaseController;
import com.easywork.mycrm.persistence.Resetpass;
import com.easywork.mycrm.service.ResetpassService;

@Controller
@RequestMapping("/mycrm/Resetpass")
public class ResetpassController extends BaseController {
	@Autowired
	private ResetpassService resetpassService;

}