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
import cn.com.yajiaotong.wface.entity.Examination;
import cn.com.yajiaotong.wface.service.ExaminationService;
import cn.com.yajiaotong.wface.service.WBaseService;
import cn.com.yajiaotong.wface.web.common.RespBody;

/**
 * 
 * @author hejunhua
 * @date 2019-4-12
 */
@Controller
@RequestMapping("examination")
public class ExaminationController extends WBaseController<Examination>{

	private ExaminationService examinationService;

	@Resource(name="examinationService")
	@Override
	public void setBaseService(WBaseService<Examination> baseService) {
		this.baseService=baseService;
		this.examinationService = (ExaminationService)baseService;
	}

	
	@RequestMapping("edit")
	@ResponseBody
	public RespBody edit(long id){
		Examination examination = this.examinationService.findById(id);
		System.out.println(examination.getName());
		return this.respBodyWriter.toSuccess(examination);
	}
	
}
