package cn.com.yajiaotong.wface.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.com.yajiaotong.wface.dao.WBaseDao;
import cn.com.yajiaotong.wface.entity.UserGroup;
import cn.com.yajiaotong.wface.service.UserGroupService;
/**
 * 
 * @author TonyYuan
 * @email yuantao6699@hotmail.com
 */
@Service("userGroupService")
public class UserGroupServiceImpl extends WBaseServiceImpl<UserGroup> implements UserGroupService{
	
//	private static Logger logger=Logger.getLogger(UserGroupServiceImpl.class);
//	private UserGroupDao userGroupDao;

	@Resource(name="userGroupDao")
	@Override
	public void setBaseDao(WBaseDao<UserGroup> baseDao) {
		super.setBaseDao(baseDao);
//		this.userGroupDao = (UserGroupDao)baseDao;
	}
	
}