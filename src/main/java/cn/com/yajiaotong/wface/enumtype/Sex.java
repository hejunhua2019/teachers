package cn.com.yajiaotong.wface.enumtype;

import java.util.HashMap;
import java.util.Map;

/**
 * 性别
 * @author meizhiwen
 *
 */
public enum Sex {

	男(0,"男"),
	女(1,"女");
	
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

	private static Map<Integer,Sex> nameMap;
	
	private static Map<String,Sex> descMap;
	
	static{
		nameMap=new HashMap<Integer,Sex>();
		descMap=new HashMap<String,Sex>();
		
		for (Sex vs : Sex.values()) {
			nameMap.put(vs.name, vs);
			descMap.put(vs.description, vs);
		}
	}
	
	private Sex(int name,String description){
		this.name=name;
		this.description=description;
	}
	
	public static Sex getVideoStatusByName(int name){
		return nameMap.get(name);
	}
	
	public static Sex getVideoStatusByDesc(String description){
		return descMap.get(description);
	}
}
