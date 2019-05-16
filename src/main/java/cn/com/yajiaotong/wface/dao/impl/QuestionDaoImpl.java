package cn.com.yajiaotong.wface.dao.impl;

import org.springframework.stereotype.Repository;

import cn.com.yajiaotong.wface.dao.QuestionDao;
import cn.com.yajiaotong.wface.entity.Question;

/**
 * 
 * @author hejunhua
 * @date 2019-4-12
 */
@Repository("questionDao")
public class QuestionDaoImpl extends WBaseDaoImpl<Question> implements QuestionDao {
}