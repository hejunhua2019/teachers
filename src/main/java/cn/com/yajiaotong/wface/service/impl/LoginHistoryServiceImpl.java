package cn.com.yajiaotong.wface.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.com.yajiaotong.wface.dao.WBaseDao;
import cn.com.yajiaotong.wface.entity.LoginHistory;
import cn.com.yajiaotong.wface.service.LoginHistoryService;
/**
 * 
 * @author TonyYuan
 * @email yuantao6699@hotmail.com
 */
@Service("loginHistoryService")
public class LoginHistoryServiceImpl extends WBaseServiceImpl<LoginHistory> implements LoginHistoryService{
	
//	private static Logger logger=Logger.getLogger(LoginHistoryServiceImpl.class);
//	private LoginHistoryDao loginHistoryDao;

	@Resource(name="loginHistoryDao")
	@Override
	public void setBaseDao(WBaseDao<LoginHistory> baseDao) {
		super.setBaseDao(baseDao);
//		this.loginHistoryDao = (LoginHistoryDao)baseDao;
	}
	
}