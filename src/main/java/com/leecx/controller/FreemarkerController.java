package com.leecx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ftl")
public class FreemarkerController {

	@RequestMapping("/freemaker")
	public String index(ModelMap modelMap){
		modelMap.put("name", "duanml");
		return "freemarker/index";
	}
	
	@RequestMapping("/center")
	public String center(ModelMap modelMap){
		modelMap.put("name", "duanml");
		return "freemarker/center/center";
	}
}
