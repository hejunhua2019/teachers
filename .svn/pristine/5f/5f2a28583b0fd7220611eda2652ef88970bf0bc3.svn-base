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
import cn.com.yajiaotong.wface.entity.Department;
import cn.com.yajiaotong.wface.service.DepartmentService;
import cn.com.yajiaotong.wface.service.WBaseService;
import cn.com.yajiaotong.wface.web.common.RespBody;

/**
 * 
 * @author TonyYuan
 * @email yuantao6699@hotmail.com
 */
@Controller
@RequestMapping("department")
public class DepartmentController extends WBaseController<Department>{

	private DepartmentService departmentService;

	@Resource(name="departmentService")
	@Override
	public void setBaseService(WBaseService<Department> baseService) {
		this.baseService=baseService;
		this.departmentService = (DepartmentService)baseService;
	}

	@RequestMapping("add")
	@ResponseBody
	public RespBody add(Department department){
		
		Department qDepartment = new Department();
		qDepartment.setCreateDate(null);
		qDepartment.setModifyDate(null);
		qDepartment.setGroupID(department.getGroupID());
		List<Department> u1 = departmentService.find(qDepartment);		
		if(null!=u1&&u1.size()>0){
    		return(new RespBody(false, "duplicate department！", null));
    	}
		department.setLastOperator(getUID());
		this.departmentService.add(department);
		return this.respBodyWriter.toSuccess(department);
	}
	
	@RequestMapping("deleteUpdateAll")
	@ResponseBody
	public RespBody deleteUpdateAll3(String ids){
		String[] idsA = ids.split(",");
		List<Long> idsL = new ArrayList<Long>();
		for(String id:idsA){
			idsL.add(Long.parseLong(id));
		}
		this.departmentService.deleteUpdateAll(idsL,getUID());
		return this.respBodyWriter.toSuccess();
	}
	
	@RequestMapping("edit")
	@ResponseBody
	public RespBody edit(long id){
		Department department = this.departmentService.findById(id);
		return this.respBodyWriter.toSuccess(department);
	}
	
	@RequestMapping("update")
	@ResponseBody
	public RespBody update(Department department){
		Department qDepartment = new Department();
		qDepartment.setCreateDate(null);
		qDepartment.setModifyDate(null);
		qDepartment.setGroupID(department.getGroupID());
		List<Department> u1 = departmentService.find(qDepartment);		
		if(null!=u1&&u1.size()>0&&!(u1.size()==1&&u1.get(0).getId().equals(department.getId()))){
    		return(new RespBody(false, "duplicate department！", null));
    	}
		department.setLastOperator(getUID());
		this.departmentService.update(department);
		return this.respBodyWriter.toSuccess(department);
	}
	
	@RequestMapping("manage")
	public String manage(){
		return "department/manage";
	}
	
	@RequestMapping("listpage")
	@ResponseBody
	public Map<String,Object> listpage(int page,int rows,String addr,Long groupID){
		Department  qdepartment=new Department();
		if(StringUtils.isNotBlank(addr)){
			qdepartment.setAddr(addr+"%");
		}
		if(null != groupID){
			qdepartment.setGroupID(groupID);
		}
		Page p=new Page(page,rows);
		qdepartment.setPage(p);
		List<Department> list=this.departmentService.listPage(qdepartment);
		
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        jsonMap.put("total",p.getTotalResult());//total键 存放总记录数，必须的 
        jsonMap.put("rows", list);//rows键 存放每页记录 list  
        
        return jsonMap;
	}
	
}
