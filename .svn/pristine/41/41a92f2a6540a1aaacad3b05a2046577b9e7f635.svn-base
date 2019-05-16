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
import cn.com.yajiaotong.wface.entity.GroupSysResource;
import cn.com.yajiaotong.wface.service.GroupSysResourceService;
import cn.com.yajiaotong.wface.service.WBaseService;
import cn.com.yajiaotong.wface.web.common.RespBody;

/**
 * 
 * @author TonyYuan
 * @email yuantao6699@hotmail.com
 */
@Controller
@RequestMapping("groupSysResource")
public class GroupSysResourceController extends WBaseController<GroupSysResource>{

	private GroupSysResourceService groupSysResourceService;

	@Resource(name="groupSysResourceService")
	@Override
	public void setBaseService(WBaseService<GroupSysResource> baseService) {
		this.baseService=baseService;
		this.groupSysResourceService = (GroupSysResourceService)baseService;
	}

	@RequestMapping("add")
	@ResponseBody
	public RespBody add(GroupSysResource groupSysResource){
		
		GroupSysResource qGroupSysResource = new GroupSysResource();
		qGroupSysResource.setCreateDate(null);
		qGroupSysResource.setModifyDate(null);
		qGroupSysResource.setGroupID(groupSysResource.getGroupID());
		qGroupSysResource.setSysResourceID(groupSysResource.getSysResourceID());
		List<GroupSysResource> u1 = groupSysResourceService.find(qGroupSysResource);		
		if(null!=u1&&u1.size()>0){
    		return(new RespBody(false, "duplicate groupSysResource！", null));
    	}
		groupSysResource.setLastOperator(getUID());
		this.groupSysResourceService.add(groupSysResource);
		return this.respBodyWriter.toSuccess(groupSysResource);
	}
	
	@RequestMapping("deleteUpdateAll")
	@ResponseBody
	public RespBody deleteUpdateAll3(String ids){
		String[] idsA = ids.split(",");
		List<Long> idsL = new ArrayList<Long>();
		for(String id:idsA){
			idsL.add(Long.parseLong(id));
		}
		this.groupSysResourceService.deleteUpdateAll(idsL,getUID());
		return this.respBodyWriter.toSuccess();
	}
	
	@RequestMapping("edit")
	@ResponseBody
	public RespBody edit(long id){
		GroupSysResource groupSysResource = this.groupSysResourceService.findById(id);
		return this.respBodyWriter.toSuccess(groupSysResource);
	}
	
	@RequestMapping("update")
	@ResponseBody
	public RespBody update(GroupSysResource groupSysResource){
		GroupSysResource qGroupSysResource = new GroupSysResource();
		qGroupSysResource.setCreateDate(null);
		qGroupSysResource.setModifyDate(null);
		qGroupSysResource.setGroupID(groupSysResource.getGroupID());
		qGroupSysResource.setSysResourceID(groupSysResource.getSysResourceID());
		List<GroupSysResource> u1 = groupSysResourceService.find(qGroupSysResource);		
		if(null!=u1&&u1.size()>0&&!(u1.size()==1&&u1.get(0).getId().equals(groupSysResource.getId()))){
    		return(new RespBody(false, "duplicate groupSysResource！", null));
    	}
		groupSysResource.setLastOperator(getUID());
		this.groupSysResourceService.update(groupSysResource);
		return this.respBodyWriter.toSuccess(groupSysResource);
	}
	
	@RequestMapping("manage")
	public String manage(){
		return "groupSysResource/manage";
	}
	
	@RequestMapping("listpage")
	@ResponseBody
	public Map<String,Object> listpage(int page,int rows,Long groupID,Long sysResourceID){
		GroupSysResource  qgroupSysResource=new GroupSysResource();
		if(null != groupID){
			qgroupSysResource.setGroupID(groupID);
		}
		if(null != sysResourceID){
			qgroupSysResource.setSysResourceID(sysResourceID);
		}
		Page p=new Page(page,rows);
		qgroupSysResource.setPage(p);
		List<GroupSysResource> list=this.groupSysResourceService.listPage(qgroupSysResource);
		
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        jsonMap.put("total",p.getTotalResult());//total键 存放总记录数，必须的 
        jsonMap.put("rows", list);//rows键 存放每页记录 list  
        
        return jsonMap;
	}
	
}
