package cn.com.yajiaotong.wface.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.com.yajiaotong.wface.dao.WBaseDao;
import cn.com.yajiaotong.wface.entity.Course;
import cn.com.yajiaotong.wface.service.CourseService;
/**
 * 
 * @author hejunhua
 * @date 2019-4-10
 */
@Service("courseService")
public class CourseServiceImpl extends WBaseServiceImpl<Course> implements CourseService{
	
//	private static Logger logger=Logger.getLogger(UserServiceImpl.class);
//	private UserDao userDao;

	@Resource(name="courseDao")
	@Override
	public void setBaseDao(WBaseDao<Course> baseDao) {
		super.setBaseDao(baseDao);
//		this.userDao = (UserDao)baseDao;
	}
	
}