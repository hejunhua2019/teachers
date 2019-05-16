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
import cn.com.yajiaotong.wface.entity.Citizen;
import cn.com.yajiaotong.wface.service.CitizenService;
import cn.com.yajiaotong.wface.service.WBaseService;
import cn.com.yajiaotong.wface.web.common.RespBody;

/**
 * 
 * @author HeJunHua
 */
@Controller
@RequestMapping("citizen")
public class CitizenController extends WBaseController<Citizen>{
   
	private CitizenService  citizenService;
	
	@Resource(name="citizenService")
	@Override
	public void setBaseService(WBaseService<Citizen> baseService) {
		this.baseService=baseService;
		this.citizenService = (CitizenService)baseService;
		
	}
	
	@RequestMapping("add")
	@ResponseBody
	public RespBody add(Citizen citizen){
		
		Citizen  citizena=new Citizen();
		citizena.setCreateDate(null);
		citizena.setModifyDate(null);
		citizena.setName(citizen.getName());
		citizena.setCredentialsType(citizen.getCredentialsType());
		citizena.setCredentialsNo(citizen.getCredentialsNo());
		List<Citizen> u1 = citizenService.find(citizena);	
		if(null!=u1&&u1.size()>0){
    		return(new RespBody(false, "duplicate citizen！", null));
    	}
		citizen.setLastOperator(getUID());
		this.citizenService.add(citizen);
		return this.respBodyWriter.toSuccess(citizen);
	}
	
	@RequestMapping("deleteUpdateAll")
	@ResponseBody
	public RespBody deleteUpdateAll3(String ids){
		String[] idsA = ids.split(",");
		List<Long> idsL = new ArrayList<Long>();
		for(String id:idsA){
			idsL.add(Long.parseLong(id));
		}
		this.citizenService.deleteUpdateAll(idsL,getUID());
		return this.respBodyWriter.toSuccess();
	}
	
	@RequestMapping("edit")
	@ResponseBody
	public RespBody edit(long id){
		Citizen citizen = this.citizenService.findById(id);
		return this.respBodyWriter.toSuccess(citizen);
	}
	
	@RequestMapping("update")
	@ResponseBody
	public RespBody update(Citizen citizen){
		
		Citizen  citizena=new Citizen();
		citizena.setCreateDate(null);
		citizena.setModifyDate(null);
		citizena.setName(citizen.getName());
		citizena.setCredentialsType(citizen.getCredentialsType());
		citizena.setCredentialsNo(citizen.getCredentialsNo());
		List<Citizen> u1 = citizenService.find(citizena);				
		if(null!=u1&&u1.size()>0&&!(u1.size()==1&&u1.get(0).getId().equals(citizen.getId()))){
    		return(new RespBody(false, "duplicate citizen！", null));
    	}
		citizen.setLastOperator(getUID());
		this.citizenService.update(citizen);
		return this.respBodyWriter.toSuccess(citizen);
	}
	
	@RequestMapping("manage")
	public String manage(){
		return "citizen/manage";
	}
	
	@RequestMapping("listpage")
	@ResponseBody
	public Map<String,Object> listpage(int page,int rows,String name){
		Citizen  citizena=new Citizen();
		if(StringUtils.isNotBlank(name)){
			citizena.setName(name+"%");
		}
		Page p=new Page(page,rows);
		citizena.setPage(p);
		List<Citizen> list=this.citizenService.listPage(citizena);
		
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        jsonMap.put("total",p.getTotalResult());//total键 存放总记录数，必须的 
        jsonMap.put("rows", list);//rows键 存放每页记录 list  
        
        return jsonMap;
	}
	
	

}
