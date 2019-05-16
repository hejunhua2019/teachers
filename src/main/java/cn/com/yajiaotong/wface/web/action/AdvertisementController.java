package cn.com.yajiaotong.wface.web.action;


import java.io.IOException;
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

import cn.com.yajiaotong.wface.common.page.Page;
import cn.com.yajiaotong.wface.entity.Advertisement;
import cn.com.yajiaotong.wface.entity.Services;
import cn.com.yajiaotong.wface.service.AdvertisementService;
import cn.com.yajiaotong.wface.service.WBaseService;
import cn.com.yajiaotong.wface.web.common.RespBody;

/**
 * 
 * @author hejunhua
 * @date 2019-4-15
 */
@Controller
@RequestMapping("advertisement")
public class AdvertisementController extends WBaseController<Advertisement>{

	private AdvertisementService advertisementService;

	@Resource(name="advertisementService")
	@Override
	public void setBaseService(WBaseService<Advertisement> baseService) {
		this.baseService=baseService;
		this.advertisementService = (AdvertisementService)baseService;
	}

	@RequestMapping("edit")
	@ResponseBody
	public RespBody edit(long id){
		Advertisement advertisement = this.advertisementService.findById(id);
		System.out.println(advertisement.getName());
		return this.respBodyWriter.toSuccess(advertisement);
	}
	@RequestMapping("add")
	@ResponseBody
	public RespBody add(Advertisement advertisement,MultipartFile  pic1) throws IOException{
		
		/*User qUser = new User();
		qUser.setCreateDate(null);
		qUser.setModifyDate(null);
		qUser.setAccount(user.getAccount());
		qUser.setPassword(user.getPassword());
		List<User> u1 = userService.find(qUser);		
		if(null!=u1&&u1.size()>0){
    		return(new RespBody(false, "duplicate user！", null));
    	}
		user.setLastOperator(getUID());
		this.userService.add(user);
		return this.respBodyWriter.toSuccess(user);*/
		
		
/*		//上传图片
        user.setID(UUID.randomUUID().toString());//设置id
        //user还有其他属性，jsp提交的时候已经写入到user，不用再set
        
        //转换图片格式 :MultipartFile --> byte
        byte[] b1 = pic1.getBytes();
<span style="white-space:pre">	</span>byte[] b2 = pic2.getBytes();
<span style="white-space:pre">	</span>byte[] b3 = pic3.getBytes();<span style="white-space:pre">	</span>
        user.setUploadPhoto1_Byte(b1); //将转换后的byte[]存入到user类中byte[]字段
        user.setUploadPhoto2_Byte(b2);
        user.setUploadPhoto3_Byte(b3);
 
        registerMapper.addUser(user);*/
		
		//转换图片格式 :MultipartFile --> byte
		//byte[] b1 = pic1.getBytes();
		//将转换后的byte[]存入到advertisement类中byte[]字段
		//advertisement.setPicture(b1);
		advertisement.setLastOperator(getUID());
		this.advertisementService.add(advertisement);
		System.out.println(advertisement+"插入成功!");
		return this.respBodyWriter.toSuccess(advertisement);
		
	}
	@RequestMapping("delete")
	@ResponseBody
	public RespBody delete(long id){
        this.advertisementService.delete(id);
        System.out.println("id:"+id+"删除成功!");
		return this.respBodyWriter.toSuccess();
	}
}
