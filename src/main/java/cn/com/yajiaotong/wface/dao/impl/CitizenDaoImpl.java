package cn.com.yajiaotong.wface.dao.impl;

import org.springframework.stereotype.Repository;

import cn.com.yajiaotong.wface.dao.CitizenDao;
import cn.com.yajiaotong.wface.entity.Citizen;

/**
 * 
 * @author HeJunHua
 */
@Repository("citizenDao")
public class CitizenDaoImpl extends WBaseDaoImpl<Citizen> implements CitizenDao{

}
