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

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import cn.com.yajiaotong.wface.common.page.Page;
import cn.com.yajiaotong.wface.entity.Question;
import cn.com.yajiaotong.wface.entity.Relation;
import cn.com.yajiaotong.wface.service.QuestionService;
import cn.com.yajiaotong.wface.service.WBaseService;
import cn.com.yajiaotong.wface.web.common.RespBody;

/**
 * 
 * @author hejunhua
 * @date 2019-4-12
 */
@Controller
@RequestMapping("question")
public class QuestionController extends WBaseController<Question>{

	private QuestionService questionService;

	@Resource(name="questionService")
	@Override
	public void setBaseService(WBaseService<Question> baseService) {
		this.baseService=baseService;
		this.questionService = (QuestionService)baseService;
	}
	
	@RequestMapping("edit")
	@ResponseBody
	public RespBody edit(long id){
		Question question = this.questionService.findById(id);
		System.out.println(question.getContent());
		return this.respBodyWriter.toSuccess(question);
	}
	
	@RequestMapping("find")
	@ResponseBody
	public RespBody find(Question question){
		List<Question> questions=this.questionService.find(question);
		System.out.println(questions.size());
		//处理成json格式
		for(int i=0;i<questions.size();i++) {
			String options=questions.get(i).getOptions();
			System.out.println(options);
			//JSONObject object = JSON.parseObject(options);
			//questions.get(i).setOptions(object);
		}
		return this.respBodyWriter.toSuccess(questions);
	}
	
}
