package cn.com.yajiaotong.wface.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.com.yajiaotong.wface.dao.WBaseDao;
import cn.com.yajiaotong.wface.entity.Citizen;
import cn.com.yajiaotong.wface.service.CitizenService;

/**
 * 
 * @author HeJunHua
 */
@Service("citizenService")
public class CitizenServiceImpl extends WBaseServiceImpl<Citizen> implements CitizenService{

	//	private CitizenDao citizenDao;

	@Resource(name="citizenDao")
	@Override
	public void setBaseDao(WBaseDao<Citizen> baseDao) {
		super.setBaseDao(baseDao);
//		this.citizenDao = (CitizenDao)baseDao;
	}

}
