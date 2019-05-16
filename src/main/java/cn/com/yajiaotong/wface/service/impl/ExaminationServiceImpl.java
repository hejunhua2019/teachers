package cn.com.yajiaotong.wface.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.com.yajiaotong.wface.dao.WBaseDao;
import cn.com.yajiaotong.wface.entity.Examination;
import cn.com.yajiaotong.wface.service.ExaminationService;
/**
 * 
 * @author hejunhua
 * @date 2019-4-12
 */
@Service("examinationService")
public class ExaminationServiceImpl extends WBaseServiceImpl<Examination> implements ExaminationService{
	
//	private static Logger logger=Logger.getLogger(UserServiceImpl.class);
//	private UserDao userDao;

	@Resource(name="examinationDao")
	@Override
	public void setBaseDao(WBaseDao<Examination> baseDao) {
		super.setBaseDao(baseDao);
//		this.userDao = (UserDao)baseDao;
	}
	
}