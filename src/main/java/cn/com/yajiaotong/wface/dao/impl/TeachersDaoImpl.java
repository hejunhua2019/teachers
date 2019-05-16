package cn.com.yajiaotong.wface.dao.impl;

import org.springframework.stereotype.Repository;

import cn.com.yajiaotong.wface.dao.TeachersDao;
import cn.com.yajiaotong.wface.entity.Teachers;

/**
 * 
 * @author hejunhua
 * @date 2019-4-10
 */
@Repository("teachersDao")
public class TeachersDaoImpl extends WBaseDaoImpl<Teachers> implements TeachersDao {
}