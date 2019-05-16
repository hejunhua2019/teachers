package cn.com.yajiaotong.wface.dao.impl;

import org.springframework.stereotype.Repository;

import cn.com.yajiaotong.wface.dao.CoursesDao;
import cn.com.yajiaotong.wface.entity.Courses;

/**
 * 
 * @author hejunhua
 * @date 2019-4-10
 */
@Repository("coursesDao")
public class CoursesDaoImpl extends WBaseDaoImpl<Courses> implements CoursesDao {
}