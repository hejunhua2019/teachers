package cn.com.yajiaotong.wface.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.com.yajiaotong.wface.dao.WBaseDao;
import cn.com.yajiaotong.wface.entity.Services;
import cn.com.yajiaotong.wface.service.ServicesService;
/**
 * 
 * @author hejunhua
 * @date 2019-4-17
 */
@Service("servicesService")
public class ServicesServiceImpl extends WBaseServiceImpl<Services> implements ServicesService{
	
//	private static Logger logger=Logger.getLogger(UserServiceImpl.class);
//	private UserDao userDao;

	@Resource(name="servicesDao")
	@Override
	public void setBaseDao(WBaseDao<Services> baseDao) {
		super.setBaseDao(baseDao);
//		this.userDao = (UserDao)baseDao;
	}
	
}