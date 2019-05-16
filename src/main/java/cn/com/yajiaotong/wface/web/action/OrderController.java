package cn.com.yajiaotong.wface.web.action;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.yajiaotong.wface.common.page.Page;
import cn.com.yajiaotong.wface.entity.Order;
import cn.com.yajiaotong.wface.service.OrderService;
import cn.com.yajiaotong.wface.service.WBaseService;
import cn.com.yajiaotong.wface.web.common.RespBody;

/**
 * 
 * @author hejunhua
 * @date 2019-4-13
 */
@Controller
@RequestMapping("order")
public class OrderController extends WBaseController<Order>{

	private OrderService orderService;

	@Resource(name="orderService")
	@Override
	public void setBaseService(WBaseService<Order> baseService) {
		this.baseService=baseService;
		this.orderService = (OrderService)baseService;
	}
	
	@RequestMapping("edit")
	@ResponseBody
	public RespBody edit(long id){
		Order order = this.orderService.findById(id);
		System.out.println(order.getMoney());
		return this.respBodyWriter.toSuccess(order);
	}
	
	@RequestMapping("find")
	@ResponseBody
	public RespBody find(Order order){
		List<Order> orders=this.orderService.find(order);
		System.out.println(orders.size());
		return this.respBodyWriter.toSuccess(orders);
	}
}
