package cn.com.yajiaotong.wface.util;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 不稳定的虚拟缓存
 * 存入缓存的对象如果有后续修改，或者从缓存中取出的对象有修改，会影响缓存中的数据
 * 最好是只存储一些常量
 * @author 东旭
 *
 */
public class VirtualCache {

	/**
     * 开发模式
     */
    private boolean isdev = false;
    
    /**
     * 清理缓存时间间隔,如果为0则不清理
     */
    long cleartimeinterval = 60l;
    
    static String ERROR_CLEAR= "VirtualCache定时清理异常";
    
    /**
     * 虚拟缓存
     */
    private Map<String,Object> cache = new ConcurrentHashMap<String, Object>();
    
    /**
     * 过期时间
     */
    private Map<String,Long> tasks = new ConcurrentHashMap<String,Long>();
    
    public VirtualCache(boolean isdev,long cleartimeinterval){
		this.isdev = isdev;
	    this.cleartimeinterval = cleartimeinterval;
	    this.clear();
    }
    
    /**
     * 定时清理
     * 
     */
    private void clear(){
    	new Thread(){
    		public void run() {
        		while(cleartimeinterval > 0l){
        			try {
        				Thread.sleep(cleartimeinterval * 1000l);
        			} catch (InterruptedException e) {
        				System.err.println(ERROR_CLEAR);
        				 if(isdev)
        					 e.printStackTrace();
        			}
        			for(Object key : tasks.keySet().toArray()){
        				Long timeout = tasks.get((String)key);
        				if(timeout <= System.currentTimeMillis())
        					delete((String)key);
        			}
        		}
        	}
    	}.start();
    }
    
    /**
     * 存入缓存
     * 如果timeout为0则不删除
     */
    public void set(String key,Object value,long timeout){
    	if(this.cache.containsKey(key) || this.tasks.containsKey(key)){
    		this.delete(key);
    	}
        this.cache.put(key, value);
        if(timeout > 0l)
        	this.tasks.put(key,timeout*1000l + System.currentTimeMillis());
        if(this.isdev)
        	System.out.println("缓存数据" + key + "已缓存");
    }
    
    /**
     * 获取缓存
     */
    public Object get(String key){
    	Long timeout = this.tasks.get(key);
		if(timeout != null && timeout <= System.currentTimeMillis())
			this.delete(key);
		if(this.isdev)
        	System.out.println("缓存数据" + key + "已取出");
		return this.cache.get(key);
    }

    /**
     * 删除缓存
     */
    public void delete(String key){
    	this.cache.remove(key);
    	this.tasks.remove(key);
    	if(this.isdev)
        	System.out.println("缓存数据" + key + "已删除");
    }
    
}
