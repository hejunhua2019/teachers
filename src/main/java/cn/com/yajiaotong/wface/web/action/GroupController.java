package cn.com.yajiaotong.wface.web.action;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.yajiaotong.wface.common.page.Page;
import cn.com.yajiaotong.wface.entity.Group;
import cn.com.yajiaotong.wface.service.GroupService;
import cn.com.yajiaotong.wface.service.WBaseService;
import cn.com.yajiaotong.wface.web.common.RespBody;

/**
 * 
 * @author TonyYuan
 * @email yuantao6699@hotmail.com
 */
@Controller
@RequestMapping("group")
public class GroupController extends WBaseController<Group>{

	private GroupService groupService;

	@Resource(name="groupService")
	@Override
	public void setBaseService(WBaseService<Group> baseService) {
		this.baseService=baseService;
		this.groupService = (GroupService)baseService;
	}

	@RequestMapping("add")
	@ResponseBody
	public RespBody add(Group group){
		
		Group qGroup = new Group();
		qGroup.setCreateDate(null);
		qGroup.setModifyDate(null);
		qGroup.setName(group.getName());
		List<Group> u1 = groupService.find(qGroup);		
		if(null!=u1&&u1.size()>0){
    		return(new RespBody(false, "duplicate group！", null));
    	}
		group.setLastOperator(getUID());
		this.groupService.add(group);
		return this.respBodyWriter.toSuccess(group);
	}
	
	@RequestMapping("deleteUpdateAll")
	@ResponseBody
	public RespBody deleteUpdateAll3(String ids){
		String[] idsA = ids.split(",");
		List<Long> idsL = new ArrayList<Long>();
		for(String id:idsA){
			idsL.add(Long.parseLong(id));
		}
		this.groupService.deleteUpdateAll(idsL,getUID());
		return this.respBodyWriter.toSuccess();
	}
	
	@RequestMapping("edit")
	@ResponseBody
	public RespBody edit(long id){
		Group group = this.groupService.findById(id);
		return this.respBodyWriter.toSuccess(group);
	}
	
	@RequestMapping("update")
	@ResponseBody
	public RespBody update(Group group){
		Group qGroup = new Group();
		qGroup.setCreateDate(null);
		qGroup.setModifyDate(null);
		qGroup.setName(group.getName());
		List<Group> u1 = groupService.find(qGroup);		
		if(null!=u1&&u1.size()>0&&!(u1.size()==1&&u1.get(0).getId().equals(group.getId()))){
    		return(new RespBody(false, "duplicate group！", null));
    	}
		group.setLastOperator(getUID());
		this.groupService.update(group);
		return this.respBodyWriter.toSuccess(group);
	}
	
	@RequestMapping("manage")
	public String manage(){
		return "group/manage";
	}
	
	@RequestMapping("treeView")
	public String treeView(){
		return "group/tree";
	}
	
	@RequestMapping("listpage")
	@ResponseBody
	public Map<String,Object> listpage(int page,int rows,String name,Integer type,Long pGID){
		Group  qgroup=new Group();
		if(StringUtils.isNotBlank(name)){
			qgroup.setName(name+"%");
		}
		if(null!=type){
			qgroup.setType(type);
		}
		if(null!=pGID){
			qgroup.setpGID(pGID);
		}
		Page p=new Page(page,rows);
		qgroup.setPage(p);
		List<Group> list=this.groupService.listPage(qgroup);
		
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        jsonMap.put("total",p.getTotalResult());//total键 存放总记录数，必须的 
        jsonMap.put("rows", list);//rows键 存放每页记录 list  
        
        return jsonMap;
	}
	
	@RequestMapping("tree")
	@ResponseBody
	public List<Map<String,Object>> tree(){
		List<Map<String,Object>> level1Nodes = new ArrayList<>();
		//顶层组demo
		for(int i=0;i<6;i++) {
			Map<String, Object> node1 = new HashMap<String, Object>(); 
			node1.put("id",""+i);
			node1.put("text", "组"+i);
			node1.put("state", i==0?"open":"closed");
			node1.put("iconCls", "icon-group");
			level1Nodes.add(node1);
			//二级组demo
			List<Map<String,Object>> level2Nodes = new ArrayList<>();
			for(int j=0;j<6;j++) {
				Map<String, Object> node2 = new HashMap<String, Object>(); 
				node2.put("id",""+i+j);
				node2.put("text", "组"+i+j);
				node2.put("state", "open");
				node2.put("iconCls", "icon-group");
				level2Nodes.add(node2);
				node1.put("children", level2Nodes);
			}
		}	
       
        return level1Nodes;
	}
	
	@RequestMapping("wholeTree")
	@ResponseBody
	public List<Map<String,Object>> wholeTree(){
		
		List<Map<String,Object>> nodes = new ArrayList<>();
		
		Group topGroup = new Group();
		topGroup.setId(-1l);
		topGroup.setName("全部分组");
		groupService.prepareSubGroupCascade(topGroup);
		//构建节点
		Map<String,Object> baseNode = new HashMap<>();
		nodes.add(baseNode);
		buildSubNodes(topGroup,baseNode,true);	
       
        return nodes;
	}
	
	private void buildSubNodes(Group g,Map<String,Object> node,boolean open){
		node.put("id",g.getId());
		node.put("text", g.getName());		
		node.put("iconCls", "icon-group");
		List<Group> subGroups = g.getSubGroups();
		List<Map<String,Object>> subNodes = new ArrayList<>();		
		for(Group subGroup:subGroups) {
			Map<String,Object> subNode = new HashMap<>();
			subNodes.add(subNode);
			buildSubNodes(subGroup,subNode,false);
		}
		if(subNodes.size()>0) {
			node.put("state",open?"open":"closed");
			node.put("children", subNodes);
		}
	}
	
	@RequestMapping("subTree")
	@ResponseBody
	public List<Map<String,Object>> subTree(Long id){
		
		Group topGroup = groupService.findById(id);
		groupService.prepareSubGroupCascade(topGroup);
		//构建全部分组节点
		
		
		List<Map<String,Object>> level1Nodes = new ArrayList<>();
		//顶层组demo
		for(int i=0;i<6;i++) {
			Map<String, Object> node1 = new HashMap<String, Object>(); 
			node1.put("id",""+i);
			node1.put("text", "组"+i);
			node1.put("state", i==0?"open":"closed");
			node1.put("iconCls", "icon-group");
			level1Nodes.add(node1);
			//二级组demo
			List<Map<String,Object>> level2Nodes = new ArrayList<>();
			for(int j=0;j<6;j++) {
				Map<String, Object> node2 = new HashMap<String, Object>(); 
				node2.put("id",""+i+j);
				node2.put("text", "组"+i+j);
				node2.put("state", "open");
				node2.put("iconCls", "icon-group");
				level2Nodes.add(node2);
				node1.put("children", level2Nodes);
			}
		}	
       
        return level1Nodes;
	}
	
	@RequestMapping("groupTypes")
	@ResponseBody
	public List<Map<String,String>> groupTypes(){		
		return groupService.getGroupTypeMap();
	}
	
	@RequestMapping("deleteCascade")
	@ResponseBody
	public RespBody deleteCascade(Long id){
		Group group = new Group();
		group.setId(id);
		groupService.deleteSubGroupCascade(group);
		groupService.delete(id);		
		return this.respBodyWriter.toSuccess();
	}
}
