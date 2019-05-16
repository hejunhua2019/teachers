package cn.com.yajiaotong.wface.service;

import java.util.List;
import java.util.Map;

import cn.com.yajiaotong.wface.entity.Group;

/**
 * 
 * @author TonyYuan
 * @email yuantao6699@hotmail.com
 */
public interface GroupService extends WBaseService<Group>  {
	
	/**
	 * 获取一个组的子组
	 * @param group
	 * @return
	 */
	public List<Group> getSubGroup(Group group);
	
	/**
	 * 对一个组对象装载一级子组
	 * @param group
	 */
	public void prepareSubGroup(Group group);
	
	/**
	 * 对一个组对象级联装置子组(即其子组的子组。。。如果有子组集合的话也会被准备好)
	 * @param group
	 */
	public void prepareSubGroupCascade(Group group);
	
	/**
	 * 删除一个组的直接子组
	 * @param group
	 */
	public void deleteSubGroup(Group group);
	
	/**
	 * 级联删除一个组的所有子组(子组的子组……都会被删除干净)
	 * @param group
	 */
	public void deleteSubGroupCascade(Group group);
	
	/**
	 * 获取组类型集合
	 * [{'name':name,'value':value},...]
	 * @return
	 */
	public List<Map<String,String>> getGroupTypeMap();
	
	
}