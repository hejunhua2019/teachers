package cn.com.yajiaotong.wface.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.com.yajiaotong.wface.dao.GroupDao;
import cn.com.yajiaotong.wface.entity.Group;

/**
 * 
 * @author TonyYuan
 * @email yuantao6699@hotmail.com
 */
@Repository("groupDao")
public class GroupDaoImpl extends WBaseDaoImpl<Group> implements GroupDao {

	@Override
	public List<Group> getSubGroup(Group group) {
		Group qGroup = new Group();
		qGroup.setpGID(group.getId());
		return this.find(qGroup, null);
	}

	@Override
	public void deleteSubGroups(Group group) {
		getSqlSession().delete(mapperName+".deleteSubGroups",group.getId());		
	}

	
}