package cn.com.yajiaotong.wface.dao;

import java.util.List;

import cn.com.yajiaotong.wface.entity.Group;
/**
 * 
 * @author TonyYuan
 * @email yuantao6699@hotmail.com
 */
public interface GroupDao extends WBaseDao<Group>{
	/**
	 * 获取一个组的一级子组列表
	 * @param group
	 * @return
	 */
	public List<Group> getSubGroup(Group group);
	
	/**
	 * 删除一个组的一级子组
	 * @param group
	 */
	public void deleteSubGroups(Group group);
	
	
}