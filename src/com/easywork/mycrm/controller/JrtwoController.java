package com.easywork.mycrm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.easycore.utils.BaseController;
import com.easywork.mycrm.persistence.Jrtwo;
import com.easywork.mycrm.service.JrtwoService;

@Controller
@RequestMapping("/mycrm/Jrtwo")
public class JrtwoController extends BaseController {
	@Autowired
	private JrtwoService jrtwoService;

}