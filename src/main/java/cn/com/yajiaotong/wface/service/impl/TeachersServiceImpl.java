package cn.com.yajiaotong.wface.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.com.yajiaotong.wface.dao.WBaseDao;
import cn.com.yajiaotong.wface.entity.Teachers;
import cn.com.yajiaotong.wface.service.TeachersService;
/**
 * 
 * @author hejunhua
 * @date 2019-4-10
 */
@Service("teachersService")
public class TeachersServiceImpl extends WBaseServiceImpl<Teachers> implements TeachersService{
	
//	private static Logger logger=Logger.getLogger(UserServiceImpl.class);
//	private UserDao userDao;

	@Resource(name="teachersDao")
	@Override
	public void setBaseDao(WBaseDao<Teachers> baseDao) {
		super.setBaseDao(baseDao);
//		this.userDao = (UserDao)baseDao;
	}
	
}