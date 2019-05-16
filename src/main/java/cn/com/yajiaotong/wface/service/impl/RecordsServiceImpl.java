package cn.com.yajiaotong.wface.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.com.yajiaotong.wface.dao.WBaseDao;
import cn.com.yajiaotong.wface.entity.Records;
import cn.com.yajiaotong.wface.service.RecordsService;
/**
 * 
 * @author hejunhua
 * @date 2019-04-30
 */
@Service("recordsService")
public class RecordsServiceImpl extends WBaseServiceImpl<Records> implements RecordsService{
	
//	private static Logger logger=Logger.getLogger(UserServiceImpl.class);
//	private UserDao userDao;

	@Resource(name="recordsDao")
	@Override
	public void setBaseDao(WBaseDao<Records> baseDao) {
		super.setBaseDao(baseDao);
//		this.userDao = (UserDao)baseDao;
	}
	
}