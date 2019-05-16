package cn.com.yajiaotong.wface.web.tag;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * el自定义函数
 * @author meizhiwen
 *
 */
public class CollectionTag{
	
	private static final Logger logger=LoggerFactory.getLogger(CollectionTag.class);
	
	public static boolean contains(Collection c,String o){
		logger.info("============CollectionTag contains invoke=============");
		if(c instanceof List){
			if(c.contains(o)){
				return true;
			}
		}else if(c instanceof Map){
			if(((Map) c).containsKey(o)){
				return true;
			}
		}
		return false;
	}
}
