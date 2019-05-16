package cn.com.yajiaotong.wface.web.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.yajiaotong.wface.entity.Courses;
import cn.com.yajiaotong.wface.service.CoursesService;
import cn.com.yajiaotong.wface.service.WBaseService;
import cn.com.yajiaotong.wface.web.common.RespBody;

/**
 * 
 * @author hejunhua
 * @date 2019-4-10
 */
@Controller
@RequestMapping("courses")
public class CoursesController extends WBaseController<Courses>{

	private CoursesService coursesService;

	@Resource(name="coursesService")
	@Override
	public void setBaseService(WBaseService<Courses> baseService) {
		this.baseService=baseService;
		this.coursesService = (CoursesService)baseService;
	}
	
	@RequestMapping("edit")
	@ResponseBody
	public RespBody edit(long id){
		Courses courses = this.coursesService.findById(id);
		System.out.println(courses.getSummary());
		return this.respBodyWriter.toSuccess(courses);
	}
	
	@RequestMapping("finds")
	@ResponseBody
	public RespBody finds(Courses courses){
		List<Courses> course=this.coursesService.find(courses);
		System.out.println(course.size());
		return this.respBodyWriter.toSuccess(course);
	}
	
}
