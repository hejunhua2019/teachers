package cn.com.yajiaotong.wface.util;

import java.io.File;
import java.io.IOException;
import java.util.Properties;
/**
 * 获取config.properties配置文件内容
 * @author yigh
 *
 */
public class ConfigUtil {
	private static Properties prop;
	
	static {
		init();
	}
	private static void init(){
		prop = new Properties();
		try {
			prop.load(ConfigUtil.class.getResourceAsStream("/config.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 获取系统参数
	 * @return 配置信息
	 */
	public static String get(String key){
		if (prop == null) 
			init();
		String val = prop.getProperty(key);
		return val;	
	}
	/**
	 * 获取文件夹路径
	 * @param key
	 * @return
	 */
	public static String getFileDirPath(String key){
		String val = get(key);
		return val != null && !"".equals(val) ? val +File.separator : null;
	}
}
