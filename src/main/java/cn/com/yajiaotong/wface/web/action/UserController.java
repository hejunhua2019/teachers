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
import cn.com.yajiaotong.wface.entity.User;
import cn.com.yajiaotong.wface.service.UserService;
import cn.com.yajiaotong.wface.service.WBaseService;
import cn.com.yajiaotong.wface.web.common.RespBody;

/**
 * 
 * @author TonyYuan
 * @email yuantao6699@hotmail.com
 */
@Controller
@RequestMapping("user")
public class UserController extends WBaseController<User>{

	private UserService userService;

	@Resource(name="userService")
	@Override
	public void setBaseService(WBaseService<User> baseService) {
		this.baseService=baseService;
		this.userService = (UserService)baseService;
	}

	@RequestMapping("add")
	@ResponseBody
	public RespBody add(User user){
		
		User qUser = new User();
		qUser.setCreateDate(null);
		qUser.setModifyDate(null);
		qUser.setAccount(user.getAccount());
		qUser.setPassword(user.getPassword());
		List<User> u1 = userService.find(qUser);		
		if(null!=u1&&u1.size()>0){
    		return(new RespBody(false, "duplicate user！", null));
    	}
		user.setLastOperator(getUID());
		this.userService.add(user);
		return this.respBodyWriter.toSuccess(user);
	}
	
	@RequestMapping("deleteUpdateAll")
	@ResponseBody
	public RespBody deleteUpdateAll3(String ids){
		String[] idsA = ids.split(",");
		List<Long> idsL = new ArrayList<Long>();
		for(String id:idsA){
			idsL.add(Long.parseLong(id));
		}
		this.userService.deleteUpdateAll(idsL,getUID());
		return this.respBodyWriter.toSuccess();
	}
	
	@RequestMapping("edit")
	@ResponseBody
	public RespBody edit(long id){
		User user = this.userService.findById(id);
		System.out.println(user.getAccount());
		return this.respBodyWriter.toSuccess(user);
	}
	
	@RequestMapping("update")
	@ResponseBody
	public RespBody update(User user){
		User qUser = new User();
		qUser.setCreateDate(null);
		qUser.setModifyDate(null);
		/*
		qUser.setName(user.getName());
		List<User> u1 = userService.find(qUser);		
		if(null!=u1&&u1.size()>0&&!(u1.size()==1&&u1.get(0).getId().equals(user.getId()))){
    		return(new RespBody(false, "duplicate user！", null));
    	}*/
		user.setLastOperator(getUID());
		this.userService.update(user);
		return this.respBodyWriter.toSuccess(user);
	}
	
	@RequestMapping("manage")
	public String manage(){
		return "user/manage";
	}
	
	@RequestMapping("listpage")
	@ResponseBody
	public Map<String,Object> listpage(int page,int rows,String account){
		User  quser=new User();
		if(StringUtils.isNotBlank(account)){
			quser.setAccount(account+"%");
		}
		Page p=new Page(page,rows);
		quser.setPage(p);
		List<User> list=this.userService.listPage(quser);
		
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        jsonMap.put("total",p.getTotalResult());//total键 存放总记录数，必须的 
        jsonMap.put("rows", list);//rows键 存放每页记录 list  
        
        return jsonMap;
	}
	
}
