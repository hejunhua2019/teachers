package cn.com.yajiaotong.wface.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.com.yajiaotong.wface.dao.WBaseDao;
import cn.com.yajiaotong.wface.entity.SysResource;
import cn.com.yajiaotong.wface.service.SysResourceService;
/**
 * 
 * @author TonyYuan
 * @email yuantao6699@hotmail.com
 */
@Service("sysResourceService")
public class SysResourceServiceImpl extends WBaseServiceImpl<SysResource> implements SysResourceService{
	
//	private static Logger logger=Logger.getLogger(SysResourceServiceImpl.class);
//	private SysResourceDao sysResourceDao;

	@Resource(name="sysResourceDao")
	@Override
	public void setBaseDao(WBaseDao<SysResource> baseDao) {
		super.setBaseDao(baseDao);
//		this.sysResourceDao = (SysResourceDao)baseDao;
	}
	
}