package cn.com.yajiaotong.wface.web.action;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.yajiaotong.wface.common.page.Page;
import cn.com.yajiaotong.wface.entity.Course;
import cn.com.yajiaotong.wface.entity.Courses;
import cn.com.yajiaotong.wface.entity.Relation;
import cn.com.yajiaotong.wface.entity.Services;
import cn.com.yajiaotong.wface.entity.Students;
import cn.com.yajiaotong.wface.entity.Teachers;
import cn.com.yajiaotong.wface.service.CourseService;
import cn.com.yajiaotong.wface.service.RelationService;
import cn.com.yajiaotong.wface.service.StudentsService;
import cn.com.yajiaotong.wface.service.TeachersService;
import cn.com.yajiaotong.wface.service.WBaseService;
import cn.com.yajiaotong.wface.web.common.RespBody;

/**
 * 
 * @author hejunhua
 * @date 2019-4-11
 */
@Controller
@RequestMapping("relation")
public class RelationController extends WBaseController<Relation>{

	private RelationService relationService;
	
	@Autowired
	private StudentsService studentsService;
	
	@Autowired
	private TeachersService teachersService;
	
	@Autowired
	private CourseService courseService;

	@Resource(name="relationService")
	@Override
	public void setBaseService(WBaseService<Relation> baseService) {
		this.baseService=baseService;
		this.relationService = (RelationService)baseService;
	}
	
	@RequestMapping("edit")
	@ResponseBody
	public RespBody edit(long id){
		Relation relation = this.relationService.findById(id);
		System.out.println(relation.getCoursesId());
		return this.respBodyWriter.toSuccess(relation);
	}
	@RequestMapping("find")
	@ResponseBody
	public RespBody find(Relation relation){
		List<Relation> relations=this.relationService.find(relation);
		System.out.println(relations.size());
		return this.respBodyWriter.toSuccess(relations);
	}
	@RequestMapping("finds")
	@ResponseBody
	public RespBody finds(String coursesId){
		Relation  relation=new Relation();
		relation.setCoursesId(coursesId);
		List<Relation> relations=this.relationService.find(relation);
		System.out.println(relations.size());
		return this.respBodyWriter.toSuccess(relations);
	}
	//多表连接分页
	@RequestMapping("listpage")
	@ResponseBody
	public Map<String,Object> listpage(int currentPage,int showCount, String nickName,String mobile){
		//根据nickName,mobile参数条件查出某个学员
		Students students=new Students();
		if(StringUtils.isNotBlank(nickName)){
			students.setNickName(nickName);
		}
		if(StringUtils.isNotBlank(mobile)){
			students.setMobile(mobile);
		}
		List<Students> studentses = new ArrayList<Students>();
		studentses=this.studentsService.find(students);
		long studentsId=studentses.get(0).getId();
		//分页
		Page page = null;
		Relation relation=new Relation();
		List<Relation> relations = new ArrayList<Relation>();
		List<Relation> relationes = new ArrayList<Relation>();
		int total;
		if (currentPage!= 0) {  
		//设置Relation对象studentsId参数
		 relation.setStudentsId("00000"+String.valueOf(studentsId));
		 relations=this.relationService.find(relation);
		 System.out.println(relations.size());
		 total=relations.size();//总记录数
		 if (currentPage <= 0) {
				
			  currentPage = 1;
			
		   }
		 if (showCount > total){
				
			 showCount = total;
			
		  }
		 int currentResult=getCurrentResult(currentPage,showCount);
		 for( int i = 0 ; i < showCount; i++) {
			 if(currentResult>=total) {
				 break;
			 }
			
			 relationes.add(relations.get(i+currentResult));
			 if(relationes.size()<=0) {
				 break;
			 }
			 /*if(((relationes.size())+showCount)>=total) {
				 break;
			 }*/
			 if((i+currentResult)>=5) {
				 break;
			 }
			}
	   }
		 Map<String, Object> jsonMap = new HashMap<String, Object>();
		 jsonMap.put("total",relations.size());//total键 存放总记录数，必须的 
		 jsonMap.put("page", relationes);//page键 存放每页记录  
		 return jsonMap;
	}
	
	 //多表连接分页1
	@RequestMapping("listpages")
	@ResponseBody
	public Map<String,Object> listpages(int currentPage,int showCount, String name){
		//根据name参数条件查出某些教师
		Teachers teachers=new Teachers();
		if(StringUtils.isNotBlank(name)){
			teachers.setName(name);;
		}
		List<Teachers>  teacheres = new ArrayList<Teachers>();
		teacheres=this.teachersService.find(teachers);
		//循环列表
		List<Long>  list=new ArrayList<Long>();
		if(teacheres.size()>0) {
		 for( int i = 0 ; i < teacheres.size(); i++) {
		  // long teachersId=teacheres.get(i).getId();//得到某个老师的ID
		   list.add(teacheres.get(i).getId());//得到某个老师的ID
		 }
		}
		//分页
		Page page = null;
		Relation relation=new Relation();
		List<Relation> relations = new ArrayList<Relation>();
		List<Relation> relationse = new ArrayList<Relation>();
		//设置Relation对象teachersId参数
		for( int i = 0 ; i < list.size(); i++) {
		  relation.setTeachersId("00"+String.valueOf(list.get(i)));
		  relations=this.relationService.listPage(relation);
		  relationse.addAll(relations);
		}
		System.out.println(relationse.size());
		//List<Relation> relations = new ArrayList<Relation>();
		//List<Relation> relationse = new ArrayList<Relation>();
		List<Relation> relationes = new ArrayList<Relation>();
		int total;
		if (currentPage!= 0) { 
			
			// relations=this.relationService.listPage(relation);
			// System.out.println(relations.size());
			 total=relationse.size();//总记录数
			 if (currentPage <= 0) {
					
				  currentPage = 1;
				
			   }
			 if (showCount > total){
					
				 showCount = total;
				
			  }
			 int currentResult=getCurrentResult(currentPage,showCount);
			 for( int i = 0 ; i < showCount; i++) {
				 if(currentResult>=total) {
					 break;
				 }
				
				 relationes.add(relationse.get(i+currentResult));
				 if(relationes.size()<=0) {
					 break;
				 }
				 if((i+currentResult)>=5) {
					 break;
				 }
			 }
		}
		 Map<String, Object> jsonMap = new HashMap<String, Object>();
		 jsonMap.put("total",relationse.size());//total键 存放总记录数，必须的 
		 jsonMap.put("page", relationes);//page键 存放每页记录  
		 return jsonMap;
	}
		
	//多表连接删除
	@RequestMapping("delete")
	@ResponseBody
	public RespBody delete(long studentsId){
		//删除某个学员信息
		this.studentsService.delete(studentsId);
		System.out.println("id:"+studentsId+"删除成功!");
		//删除某个学员所报的课程信息
		this.courseService.delete(studentsId);
		System.out.println("id:"+studentsId+"删除成功!");
		//删除关系中间表
		this.relationService.delete(studentsId);
        System.out.println("id:"+studentsId+"删除成功!");
		return this.respBodyWriter.toSuccess();
	}
	
	@RequestMapping("edits")
	@ResponseBody
	public RespBody finds(Relation relation){
		List<Relation> relations=this.relationService.find(relation);
		System.out.println(relations.size());
		return this.respBodyWriter.toSuccess(relations);
	}
	
	//多表连接更新
	@RequestMapping("update")
	@ResponseBody
	public RespBody update(long studentsId,Students students,Course course){
		
		//更新学员信息
		students.setId(studentsId);
		this.studentsService.update(students);
		System.out.println("更新成功!");
		//更新课程信息
	    List<Course> courses=this.courseService.find(course);//根据学员ID得到某些课程
		long courseId=courses.get(0).getId();//得到某个课程ID
		course.setId(courseId);//设置课程参数ID
		//course.setStudentsId("00000"+String.valueOf(studentsId));//设置课程参数学员ID		
		this.courseService.update(course);//根据某个课程ID更新某个课程名字
		System.out.println("更新成功!");
		return this.respBodyWriter.toSuccess(course);
	}
	
	//分页当前记录起始索引
	public int getCurrentResult(int currentPage,int showCount) {
		int currentResult=(currentPage - 1) *showCount;
		return currentResult;
	}

}
