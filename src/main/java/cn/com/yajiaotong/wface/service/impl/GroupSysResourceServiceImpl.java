package cn.com.yajiaotong.wface.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.com.yajiaotong.wface.dao.WBaseDao;
import cn.com.yajiaotong.wface.entity.GroupSysResource;
import cn.com.yajiaotong.wface.service.GroupSysResourceService;
/**
 * 
 * @author TonyYuan
 * @email yuantao6699@hotmail.com
 */
@Service("groupSysResourceService")
public class GroupSysResourceServiceImpl extends WBaseServiceImpl<GroupSysResource> implements GroupSysResourceService{
	
//	private static Logger logger=Logger.getLogger(GroupSysResourceServiceImpl.class);
//	private GroupSysResourceDao groupSysResourceDao;

	@Resource(name="groupSysResourceDao")
	@Override
	public void setBaseDao(WBaseDao<GroupSysResource> baseDao) {
		super.setBaseDao(baseDao);
//		this.groupSysResourceDao = (GroupSysResourceDao)baseDao;
	}
	
}