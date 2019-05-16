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
import org.springframework.web.multipart.MultipartFile;

import cn.com.yajiaotong.wface.entity.Teachers;
import cn.com.yajiaotong.wface.entity.Records;
import cn.com.yajiaotong.wface.service.TeachersService;
import cn.com.yajiaotong.wface.service.WBaseService;
import cn.com.yajiaotong.wface.web.common.RespBody;

/**
 * 
 * @author hejunhua
 * @date 2019-4-10
 */
@Controller
@RequestMapping("teachers")
public class TeachersController extends WBaseController<Teachers>{

	private TeachersService teachersService;

	@Resource(name="teachersService")
	@Override
	public void setBaseService(WBaseService<Teachers> baseService) {
		this.baseService=baseService;
		this.teachersService = (TeachersService)baseService;
	}
	
	@RequestMapping("edit")
	@ResponseBody
	public RespBody edit(long id){
		Teachers teacher = this.teachersService.findById(id);
		System.out.println(teacher.getName());
		return this.respBodyWriter.toSuccess(teacher);
	}
	
	@RequestMapping("finds")
	@ResponseBody
	public RespBody finds(Teachers teachers){
		List<Teachers> teacher=this.teachersService.find(teachers);
		System.out.println(teacher.size());
		System.out.println(teacher.get(0).getName());
		return this.respBodyWriter.toSuccess(teacher);
	}
	
	//两表连接分页
	@RequestMapping("listpage")
	@ResponseBody
	public Map<String,Object> listpage(int currentPage,int showCount, String name ){
		//查询所有的老师信息
		Teachers  teachers=new Teachers();
		if(StringUtils.isNotBlank(name)){
		   teachers.setName(name);
		}
		List<Teachers> teacheres = new ArrayList<Teachers>();
		teacheres=this.teachersService.listPage(teachers);
		System.out.println(teacheres.size());
		//分页
		//
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put("page", teacheres);//page键 存放每页记录  
	   return jsonMap;
	}
	
	@RequestMapping("add")
	@ResponseBody
	public RespBody add(Teachers teachers, MultipartFile  pic1){
		
		Teachers  qteachers=new Teachers();
		qteachers.setCreateDate(null);
		qteachers.setModifyDate(null);
		qteachers.setName(teachers.getName());
		List<Teachers>  t1=teachersService.find(qteachers);
		if(null!=t1&&t1.size()>0) {
			return(new RespBody(false, "duplicate teachers！", null));
		}
		//转换图片格式 :MultipartFile --> byte
		//byte[] b1 = pic1.getBytes();
		//将转换后的byte[]存入到advertisement类中byte[]字段
		//advertisement.setPicture(b1);
		//teachers.setHeadPicture(b1);
		teachers.setLastOperator(getUID());
		this.teachersService.add(teachers);
		System.out.println("插入成功!");
		return this.respBodyWriter.toSuccess(teachers);
	}
	
}
