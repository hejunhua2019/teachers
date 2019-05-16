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
import cn.com.yajiaotong.wface.entity.TrafficPolice;
import cn.com.yajiaotong.wface.service.TrafficPoliceService;
import cn.com.yajiaotong.wface.service.WBaseService;
import cn.com.yajiaotong.wface.web.common.RespBody;

/**
 * 
 * @author TonyYuan
 * @email yuantao6699@hotmail.com
 */
@Controller
@RequestMapping("trafficPolice")
public class TrafficPoliceController extends WBaseController<TrafficPolice>{

	private TrafficPoliceService trafficPoliceService;

	@Resource(name="trafficPoliceService")
	@Override
	public void setBaseService(WBaseService<TrafficPolice> baseService) {
		this.baseService=baseService;
		this.trafficPoliceService = (TrafficPoliceService)baseService;
	}

	@RequestMapping("add")
	@ResponseBody
	public RespBody add(TrafficPolice trafficPolice){
		
		TrafficPolice qTrafficPolice = new TrafficPolice();
		qTrafficPolice.setCreateDate(null);
		qTrafficPolice.setModifyDate(null);
		qTrafficPolice.setName(trafficPolice.getName());
		List<TrafficPolice> u1 = trafficPoliceService.find(qTrafficPolice);		
		if(null!=u1&&u1.size()>0){
    		return(new RespBody(false, "duplicate trafficPolice！", null));
    	}
		trafficPolice.setLastOperator(getUID());
		this.trafficPoliceService.add(trafficPolice);
		return this.respBodyWriter.toSuccess(trafficPolice);
	}
	
	@RequestMapping("deleteUpdateAll")
	@ResponseBody
	public RespBody deleteUpdateAll3(String ids){
		String[] idsA = ids.split(",");
		List<Long> idsL = new ArrayList<Long>();
		for(String id:idsA){
			idsL.add(Long.parseLong(id));
		}
		this.trafficPoliceService.deleteUpdateAll(idsL,getUID());
		return this.respBodyWriter.toSuccess();
	}
	
	@RequestMapping("edit")
	@ResponseBody
	public RespBody edit(long id){
		TrafficPolice trafficPolice = this.trafficPoliceService.findById(id);
		return this.respBodyWriter.toSuccess(trafficPolice);
	}
	
	@RequestMapping("update")
	@ResponseBody
	public RespBody update(TrafficPolice trafficPolice){
		TrafficPolice qTrafficPolice = new TrafficPolice();
		qTrafficPolice.setCreateDate(null);
		qTrafficPolice.setModifyDate(null);
		qTrafficPolice.setName(trafficPolice.getName());
		List<TrafficPolice> u1 = trafficPoliceService.find(qTrafficPolice);		
		if(null!=u1&&u1.size()>0&&!(u1.size()==1&&u1.get(0).getId().equals(trafficPolice.getId()))){
    		return(new RespBody(false, "duplicate trafficPolice！", null));
    	}
		trafficPolice.setLastOperator(getUID());
		this.trafficPoliceService.update(trafficPolice);
		return this.respBodyWriter.toSuccess(trafficPolice);
	}
	
	@RequestMapping("manage")
	public String manage(){
		return "trafficPolice/manage";
	}
	
	@RequestMapping("listpage")
	@ResponseBody
	public Map<String,Object> listpage(int page,int rows,String name,String policeID,Long userID,Long departmentID){
		TrafficPolice  qtrafficPolice=new TrafficPolice();
		if(StringUtils.isNotBlank(name)){
			qtrafficPolice.setName(name+"%");
		}
		if(StringUtils.isNotBlank(policeID)){
			qtrafficPolice.setPoliceID(policeID+"%");
		}
		if(null != userID){
			qtrafficPolice.setUserID(userID);
		}
		if(null != departmentID){
			qtrafficPolice.setUserID(departmentID);
		}
		Page p=new Page(page,rows);
		qtrafficPolice.setPage(p);
		List<TrafficPolice> list=this.trafficPoliceService.listPage(qtrafficPolice);
		
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        jsonMap.put("total",p.getTotalResult());//total键 存放总记录数，必须的 
        jsonMap.put("rows", list);//rows键 存放每页记录 list  
        
        return jsonMap;
	}
	
}
