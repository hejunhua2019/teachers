package cn.com.yajiaotong.wface.dao.impl;

import org.springframework.stereotype.Repository;

import cn.com.yajiaotong.wface.dao.LoginHistoryDao;
import cn.com.yajiaotong.wface.entity.LoginHistory;

/**
 * 
 * @author TonyYuan
 * @email yuantao6699@hotmail.com
 */
@Repository("loginHistoryDao")
public class LoginHistoryDaoImpl extends WBaseDaoImpl<LoginHistory> implements LoginHistoryDao {
}