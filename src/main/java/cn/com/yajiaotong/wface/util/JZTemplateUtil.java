package cn.com.yajiaotong.wface.util;


import java.util.Map;

import org.beetl.core.Configuration;
import org.beetl.core.GroupTemplate;
import org.beetl.core.Template;
import org.beetl.core.resource.StringTemplateResourceLoader;

public class JZTemplateUtil {
	
	private static GroupTemplate gt;
	
	public static String parse(String src,Map<String,Object> datas){
		if(gt==null){
			try{
				StringTemplateResourceLoader resourceLoader = new StringTemplateResourceLoader();
				Configuration cfg = Configuration.defaultConfiguration();
				cfg.setStatementStart("[>_");
				cfg.setStatementEnd("]");
				gt = new GroupTemplate(resourceLoader, cfg);
				gt.registerFunctionPackage("t", new JZDynamicFieldUtil());
			}catch(Exception e){
				e.printStackTrace();
				return null;
			}
		}
		try{
			Template t = gt.getTemplate(src);
			for(String key:datas.keySet()){
				t.binding(key, datas.get(key));
			}
			return t.render();
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}

	public static void main(String[] args) {
//		try{
//			StringTemplateResourceLoader resourceLoader = new StringTemplateResourceLoader();
//			Configuration cfg = Configuration.defaultConfiguration();
//			cfg.setStatementStart("[>_");
//			cfg.setStatementEnd("_]");
//			GroupTemplate gt = new GroupTemplate(resourceLoader, cfg);
//			gt.registerFunctionPackage("t", new JZDynamicFieldUtil());
//			Template t = gt.getTemplate("[>_ if(CONDITION){ _] hello,${NAME} [>_ }else{ _] hello1,${NAME},${t.money(MONEY)} [>_ } _] ");
//			t.binding("CONDITION", false);
//			t.binding("NAME", "beetl");
//			t.binding("MONEY", "200000");
//			String str = t.render();
//			System.out.println(str);
//		}catch(Exception e){
//			e.printStackTrace();
//		}
		//String src = "[>_ if(CONDITION){ ] hello,${NAME} [>_ }else{ ] hello1,${NAME},${t.money(MONEY)} [>_ } ] ";
		String src="[>_ if(OPEN_SIGN=='1'){ ]欢迎开通账号${t.hideTail(CIFNO,1,t.strlength(CIFNO)-6,'*')}${t.hideTail(ACCOUNT_SUFIX,5,t.strlength(ACCOUNT_SUFIX),'*')}的短信服务，我们为您持家理财助一臂之力，愿您事业腾达，财源滚滚。[>_ }else{ ]您的账户${t.hideTail(CIFNO,1,t.strlength(CIFNO)-6,'*')}${t.hideTail(ACCOUNT_SUFIX,5,t.strlength(ACCOUNT_SUFIX),'*')}的短信服务已取消，感谢您的使用，希望有机会再次为您服务！[>_ } ]";
		Map<String,Object> datas = new java.util.HashMap<String,Object>(){/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

		{
			put("OPEN_SIGN", 0);
			put("CIFNO", "123456789");
			put("ACCOUNT_SUFIX", "abcdegfhijklmnopq");
		}};
		System.out.println(JZTemplateUtil.parse(src, datas));
	}

}
