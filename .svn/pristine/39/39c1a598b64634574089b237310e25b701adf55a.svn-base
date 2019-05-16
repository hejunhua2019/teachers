package cn.com.yajiaotong.wface.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.com.yajiaotong.wface.dao.GroupDao;
import cn.com.yajiaotong.wface.dao.WBaseDao;
import cn.com.yajiaotong.wface.entity.Group;
import cn.com.yajiaotong.wface.service.GroupService;
import cn.com.yajiaotong.wface.statics.GroupStatics;
/**
 * 
 * @author TonyYuan
 * @email yuantao6699@hotmail.com
 */
@Service("groupService")
public class GroupServiceImpl extends WBaseServiceImpl<Group> implements GroupService{
	
//	private static Logger logger=Logger.getLogger(GroupServiceImpl.class);
	private GroupDao groupDao;

	@Resource(name="groupDao")
	@Override
	public void setBaseDao(WBaseDao<Group> baseDao) {
		super.setBaseDao(baseDao);
		this.groupDao = (GroupDao)baseDao;
	}

	@Override
	public List<Group> getSubGroup(Group group) {		
		return groupDao.getSubGroup(group);
	}

	@Override
	public void prepareSubGroup(Group group) {
		group.setSubGroups(getSubGroup(group));		
	}

	@Override
	public void prepareSubGroupCascade(Group group) {
		prepareSubGroup(group);
		for(Group g:group.getSubGroups()) {
			prepareSubGroupCascade(g);
		}		
	}
	
	

	@Override
	public void deleteSubGroup(Group group) {
		groupDao.deleteSubGroups(group);
	}

	//TODO: complete and test
	@Override
	public void deleteSubGroupCascade(Group group) {
		prepareSubGroupCascade(group);
		List<Long> ids = fetchIDsFromCascadeGroup(group);
		this.deleteAll(ids);
		
	}
	
	private List<Long> fetchIDsFromCascadeGroup(Group group){
		List<Long> currentLevelIDs = new ArrayList<>();
		List<Group> level1Groups = group.getSubGroups();
		for(Group g:level1Groups) {
			currentLevelIDs.add(g.getId());
		}
		for(Group g:level1Groups) {
			currentLevelIDs.addAll(fetchIDsFromCascadeGroup(g));
		}
		return currentLevelIDs;
	}

	@Override
	public List<Map<String, String>> getGroupTypeMap() {
		return GroupStatics.GROUP_TYPES;
	}
	
}