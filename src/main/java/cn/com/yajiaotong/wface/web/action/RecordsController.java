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
import cn.com.yajiaotong.wface.entity.Records;
import cn.com.yajiaotong.wface.service.RecordsService;
import cn.com.yajiaotong.wface.service.WBaseService;
import cn.com.yajiaotong.wface.web.common.RespBody;

/**
 * 
 * @author hejunhua
 * @date 2019-04-30
 */
@Controller
@RequestMapping("records")
public class RecordsController extends WBaseController<Records>{

	private RecordsService recordsService;

	@Resource(name="recordsService")
	@Override
	public void setBaseService(WBaseService<Records> baseService) {
		this.baseService=baseService;
		this.recordsService = (RecordsService)baseService;
	}

	
	@RequestMapping("edit")
	@ResponseBody
	public RespBody edit(long id){
		Records records = this.recordsService.findById(id);
		System.out.println(records.getCourseDuration());
		return this.respBodyWriter.toSuccess(records);
	}
	
}
