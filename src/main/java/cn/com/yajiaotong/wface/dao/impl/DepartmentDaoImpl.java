package cn.com.yajiaotong.wface.dao.impl;

import org.springframework.stereotype.Repository;

import cn.com.yajiaotong.wface.dao.DepartmentDao;
import cn.com.yajiaotong.wface.entity.Department;

/**
 * 
 * @author TonyYuan
 * @email yuantao6699@hotmail.com
 */
@Repository("departmentDao")
public class DepartmentDaoImpl extends WBaseDaoImpl<Department> implements DepartmentDao {
	public DepartmentDaoImpl(){
		super();
		this.setMapperName("department");
	}
}