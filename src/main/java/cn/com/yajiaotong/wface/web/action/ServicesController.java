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
import cn.com.yajiaotong.wface.entity.Services;
import cn.com.yajiaotong.wface.service.ServicesService;
import cn.com.yajiaotong.wface.service.WBaseService;
import cn.com.yajiaotong.wface.web.common.RespBody;

/**
 * 
 * @author hejunhua
 * @date 2019-4-17
 */
@Controller
@RequestMapping("services")
public class ServicesController extends WBaseController<Services>{

	private ServicesService servicesService;

	@Resource(name="servicesService")
	@Override
	public void setBaseService(WBaseService<Services> baseService) {
		this.baseService=baseService;
		this.servicesService = (ServicesService)baseService;
	}
	
	@RequestMapping("edit")
	@ResponseBody
	public RespBody edit(long id){
		Services services = this.servicesService.findById(id);
		System.out.println(services.getPhone());
		return this.respBodyWriter.toSuccess(services);
	}
	
	@RequestMapping("update")
	@ResponseBody
	public RespBody update(Services services){
		
		Services qservices = new Services();
		qservices.setCreateDate(null);
		qservices.setModifyDate(null);
		qservices.setName(services.getName());
		List<Services> u1 = servicesService.find(qservices);
		if(null!=u1&&u1.size()>0&&u1.get(0).getId().equals(services.getId())){
			System.out.println("更新同一个客服对象!");
    		return(new RespBody(false, "duplicate services！", null));
    	}
		services.setLastOperator(getUID());
		this.servicesService.update(services);
		System.out.println("更新成功!");
		return this.respBodyWriter.toSuccess(services);
	}

	
}
