package cn.com.yajiaotong.wface.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


/**
 * 
 * @author meizhiwen
 *
 */
public class U {

	private static final Logger logger = LoggerFactory.getLogger(U.class);
	/**
	 * 将数据库查出来的List<BaseEntity>>数据结构转换成List
	 * @param list
	 * @param keyName
	 * @return
	 */
	public static List<String> parseListMapToList(List list,String keyName) {
		List<String> strList = new ArrayList<String>();
		if(list!=null&&!list.isEmpty()&&list.size()>0){
			for (Object o : list) {
				Map map =(Map)o;
				try {
					String value=map.get(keyName).toString();
					strList.add(value);
				} catch (Exception e) {
					logger.error("",e);
				}
			}
		}
		return strList;
	}
	
	public static String nvl(Object o) {
		if(o==null){
			return "";
		}
		if(StringUtils.isNotBlank(o.toString())){
			return o.toString();
		}
		return "";
	}
	
	public static String nvl(String o) {
		if (!StringUtils.isBlank(o)) {
			return o.trim();
		}
		return "";
	}
	
	public static int nvl(String o,int defaultValue) {
		if (!StringUtils.isBlank(o)) {
			return Integer.parseInt(o);
		}
		return defaultValue;
	}
	
	public static HttpSession getSession(){
		ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        if (attr == null) {
        	throw new RuntimeException("ServletRequestAttributes is null");
        }
        HttpSession session = attr.getRequest().getSession(false);
        if (session == null) {
        	throw new RuntimeException("session is null");
        }
        return session;
	}
	
	public static Long getUserId(){
		HttpSession session=getSession();
		Object o=session.getAttribute(C.UID);
		if(o!=null){
			return Long.parseLong(o.toString());
		}
		throw new RuntimeException("userId is null");
	}
	
	public static String getUserName(){
		HttpSession session=getSession();
		Object o=session.getAttribute(C.UNAME);
		if(o!=null){
			return o.toString();
		}
		throw new RuntimeException("userName is null");
	} 
	
	public static boolean validateUserIdNull(){
		HttpSession session=getSession();
		Object o=session.getAttribute(C.UID);
		if(o!=null){
			return true;
		}
		return false;
	}
}
