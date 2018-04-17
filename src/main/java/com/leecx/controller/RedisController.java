package com.leecx.controller;

import com.leecx.pojo.LeeJSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>Title:</p>
 * <p>Description:redis测试类</p>
 * <p>Copyright:Copyright (c) 2018</p>
 * <p>Company:东软集团股份有限公司</p>
 * CreateDate:2018/4/17 0017 下午 23:44
 * Author:段美林[duanml@neusoft.com]
 * Version:1.0
 */
@RestController
@RequestMapping("/redis")
public class RedisController {

	@Autowired
	private StringRedisTemplate strRedis;
	
	@RequestMapping("/test")
	public LeeJSONResult testRedis() {

		strRedis.opsForValue().set("test RedisController","hello test RedisController!!!");

		return LeeJSONResult.ok(strRedis.opsForValue().get("test RedisController"));
	}

}
