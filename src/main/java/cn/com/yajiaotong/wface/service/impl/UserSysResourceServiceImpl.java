package cn.com.yajiaotong.wface.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.com.yajiaotong.wface.dao.WBaseDao;
import cn.com.yajiaotong.wface.entity.UserSysResource;
import cn.com.yajiaotong.wface.service.UserSysResourceService;
/**
 * 
 * @author TonyYuan
 * @email yuantao6699@hotmail.com
 */
@Service("userSysResourceService")
public class UserSysResourceServiceImpl extends WBaseServiceImpl<UserSysResource> implements UserSysResourceService{
	
//	private static Logger logger=Logger.getLogger(UserSysResourceServiceImpl.class);
//	private UserSysResourceDao userSysResourceDao;

	@Resource(name="userSysResourceDao")
	@Override
	public void setBaseDao(WBaseDao<UserSysResource> baseDao) {
		super.setBaseDao(baseDao);
//		this.userSysResourceDao = (UserSysResourceDao)baseDao;
	}
	
}