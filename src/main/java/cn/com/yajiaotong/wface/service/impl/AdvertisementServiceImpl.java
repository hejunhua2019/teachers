package cn.com.yajiaotong.wface.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.com.yajiaotong.wface.dao.WBaseDao;
import cn.com.yajiaotong.wface.entity.Advertisement;
import cn.com.yajiaotong.wface.service.AdvertisementService;
/**
 * 
 * @author hejunhua
 * @date 2019-4-15
 */
@Service("advertisementService")
public class AdvertisementServiceImpl extends WBaseServiceImpl<Advertisement> implements AdvertisementService{
	
//	private static Logger logger=Logger.getLogger(UserServiceImpl.class);
//	private UserDao userDao;

	@Resource(name="advertisementDao")
	@Override
	public void setBaseDao(WBaseDao<Advertisement> baseDao) {
		super.setBaseDao(baseDao);
//		this.userDao = (UserDao)baseDao;
	}
	
}