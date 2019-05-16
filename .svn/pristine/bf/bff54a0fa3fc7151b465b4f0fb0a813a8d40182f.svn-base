package cn.com.yajiaotong.wface.util;

import java.util.ArrayList;
import java.util.List;

import cn.com.yajiaotong.wface.entity.TreeNode;

public class JsonTreeFactory {
	public static List<TreeNode> buildtree(List<TreeNode> nodes,int id){
		List<TreeNode> treeNodes=new ArrayList<TreeNode>();
		for (TreeNode treeNode : nodes) {
			TreeNode node=new TreeNode();
			node.setId(treeNode.getId());
			node.setText(treeNode.getText()); 
			node.setPid(treeNode.getPid());//添加PID
			if(id==treeNode.getPid()){
				node.setChildren(buildtree(nodes, node.getId()));
				treeNodes.add(node);
			}			
		}
		
		return treeNodes;
	}
}
