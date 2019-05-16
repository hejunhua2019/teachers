package cn.com.yajiaotong.wface.dao.impl;

import org.springframework.stereotype.Repository;

import cn.com.yajiaotong.wface.dao.StudentsDao;
import cn.com.yajiaotong.wface.entity.Students;

/**
 * 
 * @author hejunhua
 * @edate 2019-4-10
 */
@Repository("studentsDao")
public class StudentsDaoImpl extends WBaseDaoImpl<Students> implements StudentsDao {
}