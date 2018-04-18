package com.leecx.mapper;

import java.util.List;

import com.leecx.pojo.SysUser;

/**
 * <p>Title:</p>
 * <p>Description:自定义接口Mapper</p>
 * <p>Copyright:Copyright (c) 2018</p>
 * <p>Company:东软集团股份有限公司</p>
 * CreateDate:2018/4/15 0015 上午 2:16
 * Author:段美林[duanml@neusoft.com]
 * Version:1.0
 */
public interface SysUserMapperCustom {
	
	List<SysUser> queryUserSimplyInfoById(String id);
}