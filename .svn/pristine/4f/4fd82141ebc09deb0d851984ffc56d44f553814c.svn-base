package cn.com.yajiaotong.wface.util;

import java.util.Date;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.WebBindingInitializer;

public class MyWebBinding implements WebBindingInitializer {

	@Override
	public void initBinder(WebDataBinder binder) {
		//1. 使用spring自带的CustomDateEditor
		//SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		//binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
		
		//2. 自定义的PropertyEditorSupport
		binder.registerCustomEditor(Date.class, new DateConvertEditor());
	}

}
