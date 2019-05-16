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
import cn.com.yajiaotong.wface.entity.UserSysResource;
import cn.com.yajiaotong.wface.service.UserSysResourceService;
import cn.com.yajiaotong.wface.service.WBaseService;
import cn.com.yajiaotong.wface.web.common.RespBody;

/**
 * 
 * @author TonyYuan
 * @email yuantao6699@hotmail.com
 */
@Controller
@RequestMapping("userSysResource")
public class UserSysResourceController extends WBaseController<UserSysResource>{

	private UserSysResourceService userSysResourceService;

	@Resource(name="userSysResourceService")
	@Override
	public void setBaseService(WBaseService<UserSysResource> baseService) {
		this.baseService=baseService;
		this.userSysResourceService = (UserSysResourceService)baseService;
	}

	@RequestMapping("add")
	@ResponseBody
	public RespBody add(UserSysResource userSysResource){
		
		UserSysResource qUserSysResource = new UserSysResource();
		qUserSysResource.setCreateDate(null);
		qUserSysResource.setModifyDate(null);
		qUserSysResource.setUserID(userSysResource.getUserID());
		qUserSysResource.setSysResourceID(userSysResource.getSysResourceID());
		List<UserSysResource> u1 = userSysResourceService.find(qUserSysResource);		
		if(null!=u1&&u1.size()>0){
    		return(new RespBody(false, "duplicate userSysResource！", null));
    	}
		userSysResource.setLastOperator(getUID());
		this.userSysResourceService.add(userSysResource);
		return this.respBodyWriter.toSuccess(userSysResource);
	}
	
	@RequestMapping("deleteUpdateAll")
	@ResponseBody
	public RespBody deleteUpdateAll3(String ids){
		String[] idsA = ids.split(",");
		List<Long> idsL = new ArrayList<Long>();
		for(String id:idsA){
			idsL.add(Long.parseLong(id));
		}
		this.userSysResourceService.deleteUpdateAll(idsL,getUID());
		return this.respBodyWriter.toSuccess();
	}
	
	@RequestMapping("edit")
	@ResponseBody
	public RespBody edit(long id){
		UserSysResource userSysResource = this.userSysResourceService.findById(id);
		return this.respBodyWriter.toSuccess(userSysResource);
	}
	
	@RequestMapping("update")
	@ResponseBody
	public RespBody update(UserSysResource userSysResource){
		UserSysResource qUserSysResource = new UserSysResource();
		qUserSysResource.setCreateDate(null);
		qUserSysResource.setModifyDate(null);
		qUserSysResource.setUserID(userSysResource.getUserID());
		qUserSysResource.setSysResourceID(userSysResource.getSysResourceID());
		List<UserSysResource> u1 = userSysResourceService.find(qUserSysResource);		
		if(null!=u1&&u1.size()>0&&!(u1.size()==1&&u1.get(0).getId().equals(userSysResource.getId()))){
    		return(new RespBody(false, "duplicate userSysResource！", null));
    	}
		userSysResource.setLastOperator(getUID());
		this.userSysResourceService.update(userSysResource);
		return this.respBodyWriter.toSuccess(userSysResource);
	}
	
	@RequestMapping("manage")
	public String manage(){
		return "userSysResource/manage";
	}
	
	@RequestMapping("listpage")
	@ResponseBody
	public Map<String,Object> listpage(int page,int rows,Long userID,Long sysResourceID){
		UserSysResource  quserSysResource=new UserSysResource();
		if(null != userID){
			quserSysResource.setUserID(userID);
		}
		if(null != sysResourceID){
			quserSysResource.setSysResourceID(sysResourceID);
		}
		Page p=new Page(page,rows);
		quserSysResource.setPage(p);
		List<UserSysResource> list=this.userSysResourceService.listPage(quserSysResource);
		
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        jsonMap.put("total",p.getTotalResult());//total键 存放总记录数，必须的 
        jsonMap.put("rows", list);//rows键 存放每页记录 list  
        
        return jsonMap;
	}
	
}
