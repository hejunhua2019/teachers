package cn.com.yajiaotong.wface.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.com.yajiaotong.wface.dao.WBaseDao;
import cn.com.yajiaotong.wface.entity.TrafficPolice;
import cn.com.yajiaotong.wface.service.TrafficPoliceService;
/**
 * 
 * @author TonyYuan
 * @email yuantao6699@hotmail.com
 */
@Service("trafficPoliceService")
public class TrafficPoliceServiceImpl extends WBaseServiceImpl<TrafficPolice> implements TrafficPoliceService{
	
//	private static Logger logger=Logger.getLogger(TrafficPoliceServiceImpl.class);
//	private TrafficPoliceDao trafficPoliceDao;

	@Resource(name="trafficPoliceDao")
	@Override
	public void setBaseDao(WBaseDao<TrafficPolice> baseDao) {
		super.setBaseDao(baseDao);
//		this.trafficPoliceDao = (TrafficPoliceDao)baseDao;
	}
	
}