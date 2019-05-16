package cn.com.yajiaotong.wface.dao.impl;

import org.springframework.stereotype.Repository;

import cn.com.yajiaotong.wface.dao.CourseDao;
import cn.com.yajiaotong.wface.entity.Course;

/**
 * 
 * @author hejunhua
 * @date 2019-4-10
 */
@Repository("courseDao")
public class CourseDaoImpl extends WBaseDaoImpl<Course> implements CourseDao {
}