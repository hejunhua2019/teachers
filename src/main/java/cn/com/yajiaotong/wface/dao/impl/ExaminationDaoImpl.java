package cn.com.yajiaotong.wface.dao.impl;

import org.springframework.stereotype.Repository;

import cn.com.yajiaotong.wface.dao.ExaminationDao;
import cn.com.yajiaotong.wface.entity.Examination;

/**
 * 
 * @author hejunhua
 * @date 2019-4-12
 */
@Repository("examinationDao")
public class ExaminationDaoImpl extends WBaseDaoImpl<Examination> implements ExaminationDao {
}