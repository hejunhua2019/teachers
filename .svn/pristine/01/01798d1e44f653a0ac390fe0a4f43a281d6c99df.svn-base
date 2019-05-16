package cn.com.yajiaotong.wface.enumtype;

import java.util.HashMap;
import java.util.Map;

/**
 * 缓存同步标识
 * @author meizhiwen
 *
 */
public enum CacheSync {

	未同步(0,"未同步"),
	已同步(1,"已同步");
	
	private int name;
	
	private String description;
	
	public int getName() {
		return name;
	}

	public void setName(int name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	private static Map<Integer,CacheSync> nameMap;
	
	private static Map<String,CacheSync> descMap;
	
	static{
		nameMap=new HashMap<Integer,CacheSync>();
		descMap=new HashMap<String,CacheSync>();
		
		for (CacheSync vs : CacheSync.values()) {
			nameMap.put(vs.name, vs);
			descMap.put(vs.description, vs);
		}
	}
	
	private CacheSync(int name,String description){
		this.name=name;
		this.description=description;
	}
	
	public static CacheSync getVideoStatusByName(int name){
		return nameMap.get(name);
	}
	
	public static CacheSync getVideoStatusByDesc(String description){
		return descMap.get(description);
	}
}
