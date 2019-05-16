package cn.com.yajiaotong.wface.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.com.yajiaotong.wface.dao.WBaseDao;
import cn.com.yajiaotong.wface.entity.Relation;
import cn.com.yajiaotong.wface.service.RelationService;
/**
 * 
 * @author hejunhua
 * @date 2019-4-11
 */
@Service("relationService")
public class RelationServiceImpl extends WBaseServiceImpl<Relation> implements RelationService{
	
//	private static Logger logger=Logger.getLogger(UserServiceImpl.class);
//	private UserDao userDao;

	@Resource(name="relationDao")
	@Override
	public void setBaseDao(WBaseDao<Relation> baseDao) {
		super.setBaseDao(baseDao);
//		this.userDao = (UserDao)baseDao;
	}
	
}