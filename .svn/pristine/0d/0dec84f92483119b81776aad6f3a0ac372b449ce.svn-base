package cn.com.yajiaotong.wface.web.action;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.yajiaotong.wface.entity.WBaseEntity;
import cn.com.yajiaotong.wface.service.WBaseService;
import cn.com.yajiaotong.wface.util.C;
import cn.com.yajiaotong.wface.web.common.RespBody;
import cn.com.yajiaotong.wface.web.common.RespBodyBuilder;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

/**
 * 
 * @author tonyyuan
 * @email yuantao6699@hotmail.com
 * @param <T>
 */
public abstract class WBaseController<T extends WBaseEntity> {
	
    @Autowired
    protected RespBodyBuilder respBodyWriter = new RespBodyBuilder();
    
    @Autowired
    protected HttpServletRequest req;
    
    protected WBaseService<T> baseService;
    
    public abstract void setBaseService(WBaseService<T> baseService);
    
	@RequestMapping("delete")
    @ResponseBody
    public RespBody delete(long id){
    	this.baseService.delete(id);
    	return this.respBodyWriter.toSuccess();
    }
    
    @RequestMapping("deleteAll")
    @ResponseBody
    public RespBody deleteAll(String ids){
    	String[] idsA = ids.split(",");
    	List<Long> idsL = new ArrayList<Long>();
    	for(String id:idsA){
    		idsL.add(Long.parseLong(id));
    	}
    	this.baseService.deleteAll(idsL);
    	return this.respBodyWriter.toSuccess();
    }
    
    protected Long getUID(){
    	return (Long)req.getSession().getAttribute(C.UID); 
    }
    
    protected Long getDepID(){
    	return (Long)req.getSession().getAttribute(C.DEPTID); 
    }

}
