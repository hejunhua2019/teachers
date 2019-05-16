package cn.com.yajiaotong.wface.enumtype;

import java.util.HashMap;
import java.util.Map;

/**
 * 权限类型
 * @author meizhiwen
 *
 */
public enum PermissionType {

	超级管理员权限(1,"超级管理员权限"),
	员工权限(2,"员工权限"),
	系统管理(3,"系统管理"),
	组织机构管理(4,"组织机构管理"),
	统计报表(5,"统计报表");
	
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

	private static Map<Integer,PermissionType> nameMap;
	
	private static Map<String,PermissionType> descMap;
	
	static{
		nameMap=new HashMap<Integer,PermissionType>();
		descMap=new HashMap<String,PermissionType>();
		
		for (PermissionType vs : PermissionType.values()) {
			nameMap.put(vs.name, vs);
			descMap.put(vs.description, vs);
		}
	}
	
	private PermissionType(int name,String description){
		this.name=name;
		this.description=description;
	}
	
	public static PermissionType getVideoStatusByName(int name){
		return nameMap.get(name);
	}
	
	public static PermissionType getVideoStatusByDesc(String description){
		return descMap.get(description);
	}
}
