package cn.com.yajiaotong.wface.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.com.yajiaotong.wface.dao.WBaseDao;
import cn.com.yajiaotong.wface.entity.User;
import cn.com.yajiaotong.wface.service.UserService;
/**
 * 
 * @author TonyYuan
 * @email yuantao6699@hotmail.com
 */
@Service("userService")
public class UserServiceImpl extends WBaseServiceImpl<User> implements UserService{
	
//	private static Logger logger=Logger.getLogger(UserServiceImpl.class);
//	private UserDao userDao;

	@Resource(name="userDao")
	@Override
	public void setBaseDao(WBaseDao<User> baseDao) {
		super.setBaseDao(baseDao);
//		this.userDao = (UserDao)baseDao;
	}
	
}