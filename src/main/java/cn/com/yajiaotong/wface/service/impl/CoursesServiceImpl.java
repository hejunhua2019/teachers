package cn.com.yajiaotong.wface.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.com.yajiaotong.wface.dao.WBaseDao;
import cn.com.yajiaotong.wface.entity.Courses;
import cn.com.yajiaotong.wface.service.CoursesService;
/**
 * 
 * @author hejunhua
 * @date 2019-4-10
 */
@Service("coursesService")
public class CoursesServiceImpl extends WBaseServiceImpl<Courses> implements CoursesService{
	
//	private static Logger logger=Logger.getLogger(UserServiceImpl.class);
//	private UserDao userDao;

	@Resource(name="coursesDao")
	@Override
	public void setBaseDao(WBaseDao<Courses> baseDao) {
		super.setBaseDao(baseDao);
//		this.userDao = (UserDao)baseDao;
	}
	
}