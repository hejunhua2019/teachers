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
import cn.com.yajiaotong.wface.entity.SysResource;
import cn.com.yajiaotong.wface.service.SysResourceService;
import cn.com.yajiaotong.wface.service.WBaseService;
import cn.com.yajiaotong.wface.web.common.RespBody;

/**
 * 
 * @author TonyYuan
 * @email yuantao6699@hotmail.com
 */
@Controller
@RequestMapping("sysResource")
public class SysResourceController extends WBaseController<SysResource>{

	private SysResourceService sysResourceService;

	@Resource(name="sysResourceService")
	@Override
	public void setBaseService(WBaseService<SysResource> baseService) {
		this.baseService=baseService;
		this.sysResourceService = (SysResourceService)baseService;
	}

	@RequestMapping("add")
	@ResponseBody
	public RespBody add(SysResource sysResource){
		
		SysResource qSysResource = new SysResource();
		qSysResource.setCreateDate(null);
		qSysResource.setModifyDate(null);
		qSysResource.setName(sysResource.getName());
		List<SysResource> u1 = sysResourceService.find(qSysResource);		
		if(null!=u1&&u1.size()>0){
    		return(new RespBody(false, "duplicate sysResource！", null));
    	}
		qSysResource.setName(null);
		qSysResource.setCode(sysResource.getCode());
		u1 = sysResourceService.find(qSysResource);		
		if(null!=u1&&u1.size()>0){
    		return(new RespBody(false, "duplicate sysResource！", null));
    	}
		
		sysResource.setLastOperator(getUID());
		this.sysResourceService.add(sysResource);
		return this.respBodyWriter.toSuccess(sysResource);
	}
	
	@RequestMapping("deleteUpdateAll")
	@ResponseBody
	public RespBody deleteUpdateAll3(String ids){
		String[] idsA = ids.split(",");
		List<Long> idsL = new ArrayList<Long>();
		for(String id:idsA){
			idsL.add(Long.parseLong(id));
		}
		this.sysResourceService.deleteUpdateAll(idsL,getUID());
		return this.respBodyWriter.toSuccess();
	}
	
	@RequestMapping("edit")
	@ResponseBody
	public RespBody edit(long id){
		SysResource sysResource = this.sysResourceService.findById(id);
		return this.respBodyWriter.toSuccess(sysResource);
	}
	
	@RequestMapping("update")
	@ResponseBody
	public RespBody update(SysResource sysResource){
		SysResource qSysResource = new SysResource();
		qSysResource.setCreateDate(null);
		qSysResource.setModifyDate(null);
		qSysResource.setName(sysResource.getName());
		List<SysResource> u1 = sysResourceService.find(qSysResource);		
		if(null!=u1&&u1.size()>0&&!(u1.size()==1&&u1.get(0).getId().equals(sysResource.getId()))){
    		return(new RespBody(false, "duplicate sysResource！", null));
    	}
		sysResource.setLastOperator(getUID());
		this.sysResourceService.update(sysResource);
		return this.respBodyWriter.toSuccess(sysResource);
	}
	
	@RequestMapping("manage")
	public String manage(){
		return "sysResource/manage";
	}
	
	@RequestMapping("listpage")
	@ResponseBody
	public Map<String,Object> listpage(int page,int rows,String name,String code){
		SysResource  qsysResource=new SysResource();
		if(StringUtils.isNotBlank(name)){
			qsysResource.setName(name+"%");
		}
		if(StringUtils.isNotBlank(code)){
			qsysResource.setCode(code+"%");
		}
		Page p=new Page(page,rows);
		qsysResource.setPage(p);
		List<SysResource> list=this.sysResourceService.listPage(qsysResource);
		
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        jsonMap.put("total",p.getTotalResult());//total键 存放总记录数，必须的 
        jsonMap.put("rows", list);//rows键 存放每页记录 list  
        
        return jsonMap;
	}
	
}
