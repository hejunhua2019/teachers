package cn.com.yajiaotong.wface.dao.impl;

import org.springframework.stereotype.Repository;

import cn.com.yajiaotong.wface.dao.UserDao;
import cn.com.yajiaotong.wface.entity.User;

/**
 * 
 * @author TonyYuan
 * @email yuantao6699@hotmail.com
 */
@Repository("userDao")
public class UserDaoImpl extends WBaseDaoImpl<User> implements UserDao {
}