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
import cn.com.yajiaotong.wface.entity.Prototype;
import cn.com.yajiaotong.wface.service.PrototypeService;
import cn.com.yajiaotong.wface.service.WBaseService;
import cn.com.yajiaotong.wface.web.common.RespBody;

/**
 * 
 * @author TonyYuan
 * @email yuantao6699@hotmail.com
 */
@Controller
@RequestMapping("prototype")
public class PrototypeController extends WBaseController<Prototype>{

	private PrototypeService prototypeService;

	@Resource(name="prototypeService")
	@Override
	public void setBaseService(WBaseService<Prototype> baseService) {
		this.baseService=baseService;
		this.prototypeService = (PrototypeService)baseService;
	}

	@RequestMapping("add")
	@ResponseBody
	public RespBody add(Prototype prototype){
		
		Prototype qPrototype = new Prototype();
		qPrototype.setCreateDate(null);
		qPrototype.setModifyDate(null);
		qPrototype.setName(prototype.getName());
		List<Prototype> u1 = prototypeService.find(qPrototype);		
		if(null!=u1&&u1.size()>0){
    		return(new RespBody(false, "duplicate prototype！", null));
    	}
		prototype.setLastOperator(getUID());
		this.prototypeService.add(prototype);
		return this.respBodyWriter.toSuccess(prototype);
	}
	
	@RequestMapping("deleteUpdateAll")
	@ResponseBody
	public RespBody deleteUpdateAll3(String ids){
		String[] idsA = ids.split(",");
		List<Long> idsL = new ArrayList<Long>();
		for(String id:idsA){
			idsL.add(Long.parseLong(id));
		}
		this.prototypeService.deleteUpdateAll(idsL,getUID());
		return this.respBodyWriter.toSuccess();
	}
	
	@RequestMapping("edit")
	@ResponseBody
	public RespBody edit(long id){
		Prototype prototype = this.prototypeService.findById(id);
		return this.respBodyWriter.toSuccess(prototype);
	}
	
	@RequestMapping("update")
	@ResponseBody
	public RespBody update(Prototype prototype){
		Prototype qPrototype = new Prototype();
		qPrototype.setCreateDate(null);
		qPrototype.setModifyDate(null);
		qPrototype.setName(prototype.getName());
		List<Prototype> u1 = prototypeService.find(qPrototype);		
		if(null!=u1&&u1.size()>0&&!(u1.size()==1&&u1.get(0).getId().equals(prototype.getId()))){
    		return(new RespBody(false, "duplicate prototype！", null));
    	}
		prototype.setLastOperator(getUID());
		this.prototypeService.update(prototype);
		return this.respBodyWriter.toSuccess(prototype);
	}
	
	@RequestMapping("manage")
	public String manage(){
		return "prototype/manage";
	}
	
	@RequestMapping("listpage")
	@ResponseBody
	public Map<String,Object> listpage(int page,int rows,String name){
		Prototype  qprototype=new Prototype();
		if(StringUtils.isNotBlank(name)){
			qprototype.setName(name+"%");
		}
		Page p=new Page(page,rows);
		qprototype.setPage(p);
		List<Prototype> list=this.prototypeService.listPage(qprototype);
		
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        jsonMap.put("total",p.getTotalResult());//total键 存放总记录数，必须的 
        jsonMap.put("rows", list);//rows键 存放每页记录 list  
        
        return jsonMap;
	}
	
}
