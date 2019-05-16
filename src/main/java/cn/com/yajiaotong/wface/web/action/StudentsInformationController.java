package cn.com.yajiaotong.wface.web.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.yajiaotong.wface.entity.StudentsInformation;
import cn.com.yajiaotong.wface.entity.Services;
import cn.com.yajiaotong.wface.service.StudentsInformationService;
import cn.com.yajiaotong.wface.service.WBaseService;
import cn.com.yajiaotong.wface.web.common.RespBody;

/**
 * 
 * @author hejunhua
 * @date 2019-03-15
 */
@Controller
@RequestMapping("studentsInformation")
public class StudentsInformationController extends WBaseController<StudentsInformation>{

    private StudentsInformationService studentsInformationService;
	
	@Resource(name="studentsInformationService")
	@Override
	public void setBaseService(WBaseService<StudentsInformation> baseService) {
		this.baseService=baseService;
		this.studentsInformationService = (StudentsInformationService)baseService;
	}
	
	@RequestMapping("add")
	@ResponseBody
	public RespBody add(StudentsInformation studentsInformation){
		
		studentsInformation.setLastOperator(getUID());
		this.studentsInformationService.add(studentsInformation);
		return this.respBodyWriter.toSuccess(studentsInformation);
	}
}
