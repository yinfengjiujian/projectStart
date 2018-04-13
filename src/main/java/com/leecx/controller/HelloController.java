package com.leecx.controller;

import java.util.Date;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leecx.pojo.LeeJSONResult;
import com.leecx.pojo.Resource;
import com.leecx.pojo.User;

@RestController
public class HelloController {
	
	@Value("${com.neusoft.duanml}")
	private String openSourceName;
	
	@Autowired
	private Resource resource;
	
	@RequestMapping("/hello")
	public String hello() {
		return "Hello Spring Boot!";
	}
	
	@RequestMapping("/getUserJSON")
	public User getUserJSON() {
		User u = new User();
		u.setName("duanml");
		u.setAge(18);
		return u;
	}
	
	@RequestMapping("/getUser")
	public LeeJSONResult getUser() {
		User u = new User();
		u.setName("duanml");
		u.setAge(18);
		u.setBirthday(new Date());
		u.setPassword("123222");
		u.setDesc("Hello Word!");
		return LeeJSONResult.ok(u);
	}
	
	@RequestMapping("/hotrelease")
	public String hotrelease() {
		return "hotrelease is Run============";
	}
	
	@RequestMapping("/openSourceName")
	public String openSourceName() {
		System.out.println(openSourceName);
		return openSourceName;
	}
	
	@RequestMapping("/getResource")
	public LeeJSONResult getResource() {
		System.out.println(resource.getName());
		System.out.println(resource.getWebsite());
		System.out.println(resource.getLanguage());
		
		Resource bean = new Resource();
		BeanUtils.copyProperties(resource, bean);
		return LeeJSONResult.ok(bean);
	}
}
