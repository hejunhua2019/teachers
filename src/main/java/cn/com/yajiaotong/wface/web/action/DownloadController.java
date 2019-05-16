package cn.com.yajiaotong.wface.web.action; 


import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.ServletContextAware;

import cn.com.yajiaotong.wface.util.ConfigUtil;

@Controller
@RequestMapping("/download")
public class DownloadController{

	@RequestMapping(value="/download")
    public String downLoad(HttpServletRequest request,HttpServletResponse response){
    	System.out.println("获取下载文件路径");
    	String uploadpath = ConfigUtil.get("uploadpath").endsWith("/")?ConfigUtil.get("uploadpath"):ConfigUtil.get("uploadpath")+"/";
    	String path = uploadpath + request.getParameter("path");
    	File file = new File(path);
    	InputStream ins = null;
    	byte [] buffer = null;
    	try{
    		ins=new BufferedInputStream(new FileInputStream(path));
    	    buffer = new byte[ins.available()];
    	    ins.read(buffer);
    	    ins.close();
    	}catch (Exception e) {
			e.printStackTrace();
		}    	
	    response.reset();
	    response.addHeader("Content-Disposition", "attachment;filename=" + file.getName());
	    response.addHeader("Content-Length", "" + file.length());
	    OutputStream ous=null;
	    try {
	    	ous = new BufferedOutputStream(response.getOutputStream());
	    	response.setContentType("application/octet-stream");
		    ous.write(buffer);
		    ous.flush();
		    ous.close();
		} catch (Exception e) {
			e.printStackTrace();
		}	 
        return null;
    } 
	@RequestMapping(value="/downloadcsv")
    public String downLoadcsv(HttpServletRequest request,HttpServletResponse response){
    	System.out.println("获取下载文件路径");
    	String uploadpath = ConfigUtil.get("uploadpath").endsWith("/")?ConfigUtil.get("uploadpath"):ConfigUtil.get("uploadpath")+"/";
    	String path = uploadpath + request.getParameter("path");
    	File file = new File(path);
    	InputStream ins = null;
    	byte [] buffer = null;
    	try{
    		ins=new BufferedInputStream(new FileInputStream(path));
    	    buffer = new byte[ins.available()];
    	    ins.read(buffer);
    	    ins.close();
    	}catch (Exception e) {
			e.printStackTrace();
		}    	
	    response.reset();
	    response.setContentType("application/csv;charset=gb18030"); 
	    response.addHeader("Content-Disposition", "attachment;filename=" + file.getName());
	    response.addHeader("Content-Length", "" + file.length());
	    OutputStream ous=null;
	    try {
	    	ous = new BufferedOutputStream(response.getOutputStream());
	    	response.setContentType("application/octet-stream");
		    ous.write(buffer);
		    ous.flush();
		    ous.close();
		} catch (Exception e) {
			e.printStackTrace();
		}	 
        return null;
    } 
}
