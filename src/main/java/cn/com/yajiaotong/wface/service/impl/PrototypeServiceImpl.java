package cn.com.yajiaotong.wface.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.com.yajiaotong.wface.dao.WBaseDao;
import cn.com.yajiaotong.wface.entity.Prototype;
import cn.com.yajiaotong.wface.service.PrototypeService;
/**
 * 
 * @author TonyYuan
 * @email yuantao6699@hotmail.com
 */
@Service("prototypeService")
public class PrototypeServiceImpl extends WBaseServiceImpl<Prototype> implements PrototypeService{
	
//	private static Logger logger=Logger.getLogger(PrototypeServiceImpl.class);
//	private PrototypeDao prototypeDao;

	@Resource(name="prototypeDao")
	@Override
	public void setBaseDao(WBaseDao<Prototype> baseDao) {
		super.setBaseDao(baseDao);
//		this.prototypeDao = (PrototypeDao)baseDao;
	}
	
}