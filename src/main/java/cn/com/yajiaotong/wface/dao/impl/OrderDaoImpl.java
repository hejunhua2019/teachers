package cn.com.yajiaotong.wface.dao.impl;

import org.springframework.stereotype.Repository;

import cn.com.yajiaotong.wface.dao.OrderDao;
import cn.com.yajiaotong.wface.entity.Order;

/**
 * 
 * @author hejunhua
 * @date 2019-4-13
 */
@Repository("orderDao")
public class OrderDaoImpl extends WBaseDaoImpl<Order> implements OrderDao {
}