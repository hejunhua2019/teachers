package cn.com.yajiaotong.wface.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.com.yajiaotong.wface.dao.WBaseDao;
import cn.com.yajiaotong.wface.entity.Department;
import cn.com.yajiaotong.wface.service.DepartmentService;
/**
 * 
 * @author TonyYuan
 * @email yuantao6699@hotmail.com
 */
@Service("departmentService")
public class DepartmentServiceImpl extends WBaseServiceImpl<Department> implements DepartmentService{
	
//	private static Logger logger=Logger.getLogger(DepartmentServiceImpl.class);
//	private DepartmentDao departmentDao;

	@Resource(name="departmentDao")
	@Override
	public void setBaseDao(WBaseDao<Department> baseDao) {
		super.setBaseDao(baseDao);
//		this.departmentDao = (DepartmentDao)baseDao;
	}
	
}