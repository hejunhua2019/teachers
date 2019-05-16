package cn.com.yajiaotong.wface.dao.impl;

import org.springframework.stereotype.Repository;

import cn.com.yajiaotong.wface.dao.UserGroupDao;
import cn.com.yajiaotong.wface.entity.UserGroup;

/**
 * 
 * @author TonyYuan
 * @email yuantao6699@hotmail.com
 */
@Repository("userGroupDao")
public class UserGroupDaoImpl extends WBaseDaoImpl<UserGroup> implements UserGroupDao {
}