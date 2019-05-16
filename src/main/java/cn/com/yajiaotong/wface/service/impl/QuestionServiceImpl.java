package cn.com.yajiaotong.wface.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.com.yajiaotong.wface.dao.WBaseDao;
import cn.com.yajiaotong.wface.entity.Question;
import cn.com.yajiaotong.wface.service.QuestionService;
/**
 * 
 * @author hejunhua
 * @date 2019-4-12
 */
@Service("questionService")
public class QuestionServiceImpl extends WBaseServiceImpl<Question> implements QuestionService{
	
//	private static Logger logger=Logger.getLogger(UserServiceImpl.class);
//	private UserDao userDao;

	@Resource(name="questionDao")
	@Override
	public void setBaseDao(WBaseDao<Question> baseDao) {
		super.setBaseDao(baseDao);
//		this.userDao = (UserDao)baseDao;
	}
	
}