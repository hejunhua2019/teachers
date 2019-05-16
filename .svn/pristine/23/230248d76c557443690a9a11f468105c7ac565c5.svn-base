package cn.com.yajiaotong.wface.enumtype;

import java.util.HashMap;
import java.util.Map;

/**
 * 用户类型
 * @author meizhiwen
 *
 */
public enum UserType {

	自行注册(0,"自行注册"),
	正式用户(1,"正式用户");
	
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

	private static Map<Integer,UserType> nameMap;
	
	private static Map<String,UserType> descMap;
	
	static{
		nameMap=new HashMap<Integer,UserType>();
		descMap=new HashMap<String,UserType>();
		
		for (UserType vs : UserType.values()) {
			nameMap.put(vs.name, vs);
			descMap.put(vs.description, vs);
		}
	}
	
	private UserType(int name,String description){
		this.name=name;
		this.description=description;
	}
	
	public static UserType getVideoStatusByName(int name){
		return nameMap.get(name);
	}
	
	public static UserType getVideoStatusByDesc(String description){
		return descMap.get(description);
	}
}
