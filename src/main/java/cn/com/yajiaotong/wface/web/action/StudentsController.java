package cn.com.yajiaotong.wface.web.action;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.httpclient.util.URIUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import cn.com.yajiaotong.wface.common.page.Page;
import cn.com.yajiaotong.wface.entity.Students;
import cn.com.yajiaotong.wface.entity.User;
import cn.com.yajiaotong.wface.service.StudentsService;
import cn.com.yajiaotong.wface.service.WBaseService;
import cn.com.yajiaotong.wface.web.common.RespBody;

/**
 * 
 * @author hejunhua
 * @date 2019-4-10
 */
@Controller
@RequestMapping("students")
public class StudentsController extends WBaseController<Students>{

	private StudentsService studentsService;
	

	@Resource(name="studentsService")
	@Override
	public void setBaseService(WBaseService<Students> baseService) {
		this.baseService=baseService;
		this.studentsService = (StudentsService)baseService;
	}
	
	@RequestMapping("edit")
	@ResponseBody
	public RespBody edit(long id){
		Students students = this.studentsService.findById(id);
		System.out.println(students.getEmail());
		return this.respBodyWriter.toSuccess(students);
	}
	
	@RequestMapping("update")
	@ResponseBody
	public RespBody update(long id,String realName,String sex,String education,String mobile){
		
		Students students=new Students();
		if(realName!=null&&realName!="") {
			students.setRealName(realName);
		}
		if(sex!=null&&sex!="") {
			students.setSex(sex.charAt(0));
		}
		if(education!=null&&education!="") {
			students.setEducation(education);
		}
		if(mobile!=null&&mobile!="") {
			students.setMobile(mobile);
		}
		students.setId(id);
		students.setLastOperator(getUID());
		this.studentsService.update(students);
		System.out.println("更新成功！");
		return this.respBodyWriter.toSuccess(students);
	}
	
	@RequestMapping("login")
	@ResponseBody
	public Map<String,Object> login(String appId,String secret,String js_code){
		
	    Map<String, Object> jsonMap = new HashMap<String, Object>();
		//插入一条学员记录
		Students studentes=new Students();
		if(StringUtils.isNotBlank(appId)){
			studentes.setAppId(appId);
		}
		if(StringUtils.isNotBlank(secret)){
			studentes.setSecret(secret);
		}
		/*if(StringUtils.isNotBlank(js_code)){
			studentes.setJs_code(js_code);
		}*/
		List<Students> u1 = studentsService.find(studentes);
		/*if(null!=u1&&u1.size()>0){
			jsonMap.put("warning:","duplicate Students！");
    		return jsonMap;
    	}*/
		///long studentsId=0;
		studentes.setId(10000L);//设置学员ID
		if(null!=u1&&u1.size()<=0) {
			//long studentsId=10000;//学员ID
			//studentes.setId(10000L);//设置学员ID
			this.studentsService.add(studentes);
			System.out.println("插入成功!");
		}
		//产生一个随机数
		//int x=(int)(Math.random()*10000);//产生一个10000以内的整数
		//设置学员ID
		//studentes.setId(Long.valueOf(String.valueOf(x)));
		//this.studentsService.add(studentes);
		/*long studentsId=10000;//学员ID
		studentes.setId(studentsId);//设置学员ID
		this.studentsService.add(studentes);
		System.out.println("插入成功!");*/
		//调用第三方接口
		String requestUrl = "https://api.weixin.qq.com/sns/jscode2session";	//请求地址 https://api.weixin.qq.com/sns/jscode2session
		 Map<String,String> requestUrlParam = new HashMap<String,String>();
	        requestUrlParam.put("appid",appId);	//开发者设置中的appId
	        requestUrlParam.put("secret",secret);	//开发者设置中的appSecret
	        requestUrlParam.put("js_code",js_code);	//小程序调用wx.login返回的code
	        requestUrlParam.put("grant_type", "authorization_code");	//默认参数 
		//发送post请求读取调用微信 https://api.weixin.qq.com/sns/jscode2session 接口获取openid用户唯一标识
         String authorization=sendPost(requestUrl, requestUrlParam);
         System.out.println(authorization);
         //取出openid
         JSONObject jsonObject = JSON.parseObject(authorization);
         Students  student=new Students();
         int longStatus=0;//登录状态
         String openId=null;//返回小程序前端的openId
        // String studentsId=String.valueOf(x);//学员ID
        // long studentsId=10000;//学员ID
         int courseDuration=0;//学员播放课程章节视频学习时长
         int completeNumbers=0;//学员完成作业数
         if(jsonObject.get("openid")!=null&&jsonObject.get("openid")!="") {
        	 Object  openid=jsonObject.get("openid");
        	 openId=openid.toString();
        	// studentes.setId(openId);//设置openid值
        	//设置openid值
        	 //studentes.setId(studentsId);//学员ID
        	 //this.studentsService.add(studentes);
     		//返回登录状态数据
        	 student.setJs_code(js_code);
        	 List<Students> students=this.studentsService.find(student);
             longStatus=students.get(0).getLockStatus();
             courseDuration=students.get(0).getCourseDuration();
             completeNumbers=students.get(0).getCompleteNumbers(); 
             //
         }
         jsonMap.put("studentsId", studentes.getId());
		 jsonMap.put("openId",openId);//openId键 存放openId 
		 jsonMap.put("longStatus", longStatus);//longStatus键 存放登录状态  
         jsonMap.put("courseDuration", courseDuration);
         jsonMap.put("completeNumbers", completeNumbers);
		 return jsonMap;
	}
	

	@RequestMapping("finds")
	@ResponseBody
	public RespBody finds(Students students){
		List<Students> student=this.studentsService.find(students);
		System.out.println(student.size());
		System.out.println(student.get(0).getEmail());
		return this.respBodyWriter.toSuccess(student);
	}
	
	@RequestMapping("listpage")
	@ResponseBody
	public Map<String,Object> listpage(int currentPage,int showCount, String content){
		
		Students students=new Students();
		if(StringUtils.isNotBlank(content)){
			students.setContent(content+"%");
		}
		Page page = null;
		List<Students> studentses = new ArrayList<Students>();
		studentses=this.studentsService.find(students);
		int totalCount =studentses.size(); //总记录数
		 if (currentPage!= 0) {  
			 int currentResult=getCurrentResult(currentPage,showCount);
			 page = new Page(currentResult,showCount);
			 students.setStart(currentResult);//当前记录起始索引
			 students.setSize(showCount);//当前记录结束索引
			 studentses=this.studentsService.listPage(students);
			 studentses.size();
			 
		 }
		 Map<String, Object> jsonMap = new HashMap<String, Object>();
		 jsonMap.put("total",totalCount);//total键 存放总记录数，必须的 
		 jsonMap.put("page", studentses);//page键 存放每页记录  
		 return jsonMap;
	}
	
	//分页当前记录起始索引
	public int getCurrentResult(int currentPage,int showCount) {
		int currentResult=(currentPage - 1) *showCount;
		return currentResult;
	}
	
	/**
	 * 向指定 URL 发送POST方法的请求
	 * 
	 * @param url 发送请求的 URL
	 * @param param 请求参数
	 * @return 所代表远程资源的响应结果
	 */
	public static String sendPost(String url, Map<String, ?> paramMap) {
        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";
        
        String param = "";
		Iterator<String> it = paramMap.keySet().iterator();
		
		while(it.hasNext()) {
			String key = it.next();
			param += key + "=" + paramMap.get(key) + "&";
		}
		
        try {
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            URLConnection conn = realUrl.openConnection();
            // 设置通用的请求属性
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("Accept-Charset", "utf-8");
            conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            // 获取URLConnection对象对应的输出流
            out = new PrintWriter(conn.getOutputStream());
            // 发送请求参数
            out.print(param);
            // flush输出流的缓冲
            out.flush();
            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
        	//log.error(e.getMessage(), e);
        	System.out.println(e.getMessage());
        }
      //使用finally块来关闭输出流、输入流
        finally{
            try{
                if(out!=null){
                    out.close();
                }
                if(in!=null){
                    in.close();
                }
            }
            catch(IOException ex){
                ex.printStackTrace();
            }
        }
        return result;
	}
}
