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
import cn.com.yajiaotong.wface.entity.Course;
import cn.com.yajiaotong.wface.service.CourseService;
import cn.com.yajiaotong.wface.service.WBaseService;
import cn.com.yajiaotong.wface.web.common.RespBody;

/**
 * 
 * @author hejunhua
 * @date 2019-4-10
 */
@Controller
@RequestMapping("course")
public class CourseController extends WBaseController<Course>{

	private CourseService courseService;

	@Resource(name="courseService")
	@Override
	public void setBaseService(WBaseService<Course> baseService) {
		this.baseService=baseService;
		this.courseService = (CourseService)baseService;
	}
	
	@RequestMapping("edit")
	@ResponseBody
	public RespBody edit(long id){
		Course course = this.courseService.findById(id);
		System.out.println(course.getCourseName());
		return this.respBodyWriter.toSuccess(course);
	}
	
	@RequestMapping("find")
	@ResponseBody
	public RespBody find(Course course){
		List<Course> courses=this.courseService.find(course);
		System.out.println(courses.size());
		return this.respBodyWriter.toSuccess(courses);
	}
	
	@RequestMapping("finds")
	@ResponseBody
	public RespBody finds(Course course){
		List<Course> courses=this.courseService.find(course);
		System.out.println(courses.size());
		return this.respBodyWriter.toSuccess(courses);
	}
	
	//两表连接分页
	@RequestMapping("listpage")
	@ResponseBody
	public Map<String,Object> listpage(int currentPage,int showCount, String name, String courseName ){
				//根据nickName,mobile参数条件查出某个学员
				/*Students students=new Students();
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
					 if(((relationes.size())+showCount)>=total) {
						 break;
					 }
					 if((i+currentResult)>=5) {
						 break;
					 }
					}
			   }
				 Map<String, Object> jsonMap = new HashMap<String, Object>();
				 jsonMap.put("total",relations.size());//total键 存放总记录数，必须的 
				 jsonMap.put("page", relationes);//page键 存放每页记录  
				 return jsonMap;*/
			//查询所有的老师信息
			/*Teachers  teachers=new Teachers();
			if(StringUtils.isNotBlank(name)){
			   teachers.setName(name);
			}
			List<Teachers> teacheres = new ArrayList<Teachers>();
			teacheres=this.teachersService.listPage(teachers);
			System.out.println(teacheres.size());*/
		 
			//分页
			//查询所有的课程信息
		    Course  course=new 	Course();
		    List<Course> courses = new ArrayList<Course>();
		    courses=this.courseService.listPage(course);
		    System.out.println(courses.size());
			Map<String, Object> jsonMap = new HashMap<String, Object>();
			jsonMap.put("page", courses);//page键 存放每页记录  
		   return jsonMap;
	}
}
