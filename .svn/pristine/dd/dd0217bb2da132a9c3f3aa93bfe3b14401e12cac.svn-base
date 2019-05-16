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
import cn.com.yajiaotong.wface.entity.LoginHistory;
import cn.com.yajiaotong.wface.service.LoginHistoryService;
import cn.com.yajiaotong.wface.service.WBaseService;
import cn.com.yajiaotong.wface.web.common.RespBody;

/**
 * 
 * @author TonyYuan
 * @email yuantao6699@hotmail.com
 */
@Controller
@RequestMapping("loginHistory")
public class LoginHistoryController extends WBaseController<LoginHistory>{

	private LoginHistoryService loginHistoryService;

	@Resource(name="loginHistoryService")
	@Override
	public void setBaseService(WBaseService<LoginHistory> baseService) {
		this.baseService=baseService;
		this.loginHistoryService = (LoginHistoryService)baseService;
	}

	@RequestMapping("add")
	@ResponseBody
	public RespBody add(LoginHistory loginHistory){
		
		LoginHistory qLoginHistory = new LoginHistory();
		qLoginHistory.setCreateDate(null);
		qLoginHistory.setModifyDate(null);		
		loginHistory.setLastOperator(getUID());
		this.loginHistoryService.add(loginHistory);
		return this.respBodyWriter.toSuccess(loginHistory);
	}
	
	@RequestMapping("deleteUpdateAll")
	@ResponseBody
	public RespBody deleteUpdateAll3(String ids){
		String[] idsA = ids.split(",");
		List<Long> idsL = new ArrayList<Long>();
		for(String id:idsA){
			idsL.add(Long.parseLong(id));
		}
		this.loginHistoryService.deleteUpdateAll(idsL,getUID());
		return this.respBodyWriter.toSuccess();
	}
	
	@RequestMapping("edit")
	@ResponseBody
	public RespBody edit(long id){
		LoginHistory loginHistory = this.loginHistoryService.findById(id);
		return this.respBodyWriter.toSuccess(loginHistory);
	}
	
	@RequestMapping("update")
	@ResponseBody
	public RespBody update(LoginHistory loginHistory){
		LoginHistory qLoginHistory = new LoginHistory();
		qLoginHistory.setCreateDate(null);
		qLoginHistory.setModifyDate(null);		
		loginHistory.setLastOperator(getUID());
		this.loginHistoryService.update(loginHistory);
		return this.respBodyWriter.toSuccess(loginHistory);
	}
	
	@RequestMapping("manage")
	public String manage(){
		return "loginHistory/manage";
	}
	
	@RequestMapping("listpage")
	@ResponseBody
	public Map<String,Object> listpage(int page,int rows,Long userID){
		LoginHistory  qloginHistory=new LoginHistory();
		if(null != userID){
			qloginHistory.setUserID(userID);
		}
		Page p=new Page(page,rows);
		qloginHistory.setPage(p);
		List<LoginHistory> list=this.loginHistoryService.listPage(qloginHistory);
		
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        jsonMap.put("total",p.getTotalResult());//total键 存放总记录数，必须的 
        jsonMap.put("rows", list);//rows键 存放每页记录 list  
        
        return jsonMap;
	}
	
}
