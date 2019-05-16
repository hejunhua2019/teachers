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
import cn.com.yajiaotong.wface.entity.UserGroup;
import cn.com.yajiaotong.wface.service.UserGroupService;
import cn.com.yajiaotong.wface.service.WBaseService;
import cn.com.yajiaotong.wface.web.common.RespBody;

/**
 * 
 * @author TonyYuan
 * @email yuantao6699@hotmail.com
 */
@Controller
@RequestMapping("userGroup")
public class UserGroupController extends WBaseController<UserGroup>{

	private UserGroupService userGroupService;

	@Resource(name="userGroupService")
	@Override
	public void setBaseService(WBaseService<UserGroup> baseService) {
		this.baseService=baseService;
		this.userGroupService = (UserGroupService)baseService;
	}

	@RequestMapping("add")
	@ResponseBody
	public RespBody add(UserGroup userGroup){
		
		UserGroup qUserGroup = new UserGroup();
		qUserGroup.setCreateDate(null);
		qUserGroup.setModifyDate(null);
		qUserGroup.setUserID(userGroup.getUserID());
		qUserGroup.setGroupID(userGroup.getGroupID());
		List<UserGroup> u1 = userGroupService.find(qUserGroup);		
		if(null!=u1&&u1.size()>0){
    		return(new RespBody(false, "duplicate userGroup！", null));
    	}
		userGroup.setLastOperator(getUID());
		this.userGroupService.add(userGroup);
		return this.respBodyWriter.toSuccess(userGroup);
	}
	
	@RequestMapping("deleteUpdateAll")
	@ResponseBody
	public RespBody deleteUpdateAll3(String ids){
		String[] idsA = ids.split(",");
		List<Long> idsL = new ArrayList<Long>();
		for(String id:idsA){
			idsL.add(Long.parseLong(id));
		}
		this.userGroupService.deleteUpdateAll(idsL,getUID());
		return this.respBodyWriter.toSuccess();
	}
	
	@RequestMapping("edit")
	@ResponseBody
	public RespBody edit(long id){
		UserGroup userGroup = this.userGroupService.findById(id);
		return this.respBodyWriter.toSuccess(userGroup);
	}
	
	@RequestMapping("update")
	@ResponseBody
	public RespBody update(UserGroup userGroup){
		UserGroup qUserGroup = new UserGroup();
		qUserGroup.setCreateDate(null);
		qUserGroup.setModifyDate(null);
		qUserGroup.setUserID(userGroup.getUserID());
		qUserGroup.setGroupID(userGroup.getGroupID());
		List<UserGroup> u1 = userGroupService.find(qUserGroup);		
		if(null!=u1&&u1.size()>0&&!(u1.size()==1&&u1.get(0).getId().equals(userGroup.getId()))){
    		return(new RespBody(false, "duplicate userGroup！", null));
    	}
		userGroup.setLastOperator(getUID());
		this.userGroupService.update(userGroup);
		return this.respBodyWriter.toSuccess(userGroup);
	}
	
	@RequestMapping("manage")
	public String manage(){
		return "userGroup/manage";
	}
	
	@RequestMapping("listpage")
	@ResponseBody
	public Map<String,Object> listpage(int page,int rows,Long userID,Long groupID){
		UserGroup  quserGroup=new UserGroup();
		if(null != userID){
			quserGroup.setUserID(userID);
		}
		if(null != groupID){
			quserGroup.setGroupID(groupID);
		}
		Page p=new Page(page,rows);
		quserGroup.setPage(p);
		List<UserGroup> list=this.userGroupService.listPage(quserGroup);
		
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        jsonMap.put("total",p.getTotalResult());//total键 存放总记录数，必须的 
        jsonMap.put("rows", list);//rows键 存放每页记录 list  
        
        return jsonMap;
	}
	
}
