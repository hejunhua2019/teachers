package cn.com.yajiaotong.wface.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.com.yajiaotong.wface.dao.WBaseDao;
import cn.com.yajiaotong.wface.entity.Students;
import cn.com.yajiaotong.wface.service.StudentsService;
/**
 * 
 * @author hejunhua
 * @date 2019-4-10
 */
@Service("studentsService")
public class StudentsServiceImpl extends WBaseServiceImpl<Students> implements StudentsService{
	
//	private static Logger logger=Logger.getLogger(UserServiceImpl.class);
//	private UserDao userDao;

	@Resource(name="studentsDao")
	@Override
	public void setBaseDao(WBaseDao<Students> baseDao) {
		super.setBaseDao(baseDao);
//		this.userDao = (UserDao)baseDao;
	}
	
}