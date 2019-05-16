package cn.com.yajiaotong.wface.util;

public class EmayCache {
	
	static VirtualCache vc = new VirtualCache(false, 60l);
	
	/**
     * 存入缓存
     * timeout  单位 秒
     */
    public static void set(String key,Object value,long timeout){
    	vc.set(key, value, timeout);
    }
    
    /**
     * 存入缓存
     * timeout = 0
     */
    public static void set(String key,Object value){
    	vc.set(key, value, 0);
    }
    
    /**
     * 获取缓存
     */
    public static Object get(String key){
    	if(key == null)
    		return null;
    	return vc.get(key);
    }

    /**
     * 删除缓存
     */
    public static void delete(String key){
    	if(key == null){
    		return;
    	}
    	vc.delete(key);
    }

}
