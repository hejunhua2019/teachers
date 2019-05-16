package cn.com.yajiaotong.wface.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.com.yajiaotong.wface.dao.WBaseDao;
import cn.com.yajiaotong.wface.entity.Order;
import cn.com.yajiaotong.wface.service.OrderService;
/**
 * 
 * @author hejunhua
 * @date 2019-4-13
 */
@Service("orderService")
public class OrderServiceImpl extends WBaseServiceImpl<Order> implements OrderService{
	
//	private static Logger logger=Logger.getLogger(UserServiceImpl.class);
//	private UserDao userDao;

	@Resource(name="orderDao")
	@Override
	public void setBaseDao(WBaseDao<Order> baseDao) {
		super.setBaseDao(baseDao);
//		this.userDao = (UserDao)baseDao;
	}
	
}