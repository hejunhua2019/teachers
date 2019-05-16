package cn.com.yajiaotong.wface.dao.impl;

import org.springframework.stereotype.Repository;

import cn.com.yajiaotong.wface.dao.ServicesDao;
import cn.com.yajiaotong.wface.entity.Services;

/**
 * 
 * @author hejunhua
 * @email 2019-4-17
 */
@Repository("servicesDao")
public class ServicesDaoImpl extends WBaseDaoImpl<Services> implements ServicesDao {
}