<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://yajiaotong.com.cn/jstl/wface" prefix="wface" %>
<!DOCTYPE html>
<html>
	<head>
		<title>组管理</title>
		<meta http-equiv="content-type" content="text/html; charset=UTF-8"/>
		<style type="text/css">
			#fm{
				margin:0;
				padding:10px 30px;
			}
			.ftitle{
				font-size:14px;
				font-weight:bold;
				padding:5px 0;
				margin-bottom:10px;
				border-bottom:1px solid #ccc;
			}
			.fitem{
				margin-bottom:5px;
			}
			.fitem label{
				display:inline-block;
				width:130px;
			}
		</style>
		<script type="text/javascript">
			var treeViewId="#tt";
			var treeComboID="#pGID";
			var addOrEditDialogueId="#addoreditdlg";
			var addOrEditFormId="#addoreditfm";
			var addOrEditTitleId="#addoredittitle";
			var addTitle="新增组";
			var editTitle="编辑组";
			var deleteConfirmMessage="你确定要删除本组及其子组吗?";
			var noSelectedRowMessage="请选择记录行";
			var searchFormId="#searchForm";
			var pageSize=20;
			var listUrl="group/listpage";
			var updateUrl="group/update";
			var deleteCascadeUrl="group/deleteCascade";
			var addUrl="group/add";
			var treeUrl="group/wholeTree";
			var typeUrl = "group/groupTypes";
			var url;
			var currentTreeVeiwGroupID="-1";
			
							
			var loadSecondTab=false;
			$(function() {
				//组类型初始化
				$.ajax({
	         		url: typeUrl,
	         		success: function(response) {
	         			console.log(response);
	         			var selectDom = $("#type");
	             		for(var i=0;i<response.length;i++){
	             			var option = $("<option/>");
	             			option.val(response[i].value);
	             			option.text(response[i].name);
	             			selectDom.append(option);
	             		}
	         		}
	     		});
				//初始化上级组树形下拉框
				$('#pGID').combotree({
					url: treeUrl,
					required: true
				});
				//树界面初始化
				$('#tt').tree({
					url:treeUrl,
					 onContextMenu: function(e,node){
						e.preventDefault();
						$(this).tree('select',node.target);
						currentTreeVeiwGroupID = node.id;
						//隐藏根节点的删除、修改
						if(currentTreeVeiwGroupID==-1){
							$("#modifyCurrentGroupItem").hide();
							$("#removeCurrentGroupItem").hide();
						}else{
							$("#modifyCurrentGroupItem").show();
							$("#removeCurrentGroupItem").show();
						}
						$('#mm').menu('show',{
							left: e.pageX,
							top: e.pageY
						});
					},
					animate:true
				});
			});
			
			//--------------------------组-------------------------------------					
			
			//组保存
			function save(mydialogueId,myFormId){
				//addition check logics
				//...				
				
				
				$.ajax({
					url: url,
					data: getFormJson( myFormId),
					type: "post",
					dataType: "json",
					beforeSend: function(){
						return $( myFormId).form( 'validate' );						
					},
					success: function (result){
						if (result[ "success"]== true){
							$( mydialogueId).dialog( 'close'); // close the dialog
							$( treeViewId).tree( 'reload'); // reload the group data
							$( treeComboID).combotree( 'reload'); // reload the group combo data
						} else {
							showMessage( "提示",result[ "message"]);
						}
					}
				});
				
			}		
			
			//组搜索
			function doSearch(){
				$(datagridId).datagrid('reload',getFormJson( searchFormId));
			}			

			//添加子组
			function addSubGroup(){
				function switch2add(){
					$(addOrEditFormId).form("reset");//重置表单
					$(addOrEditTitleId).html('添加子组');
					url=addUrl;				
					//设置初始值
					$('#pGID').combotree('setValue', currentTreeVeiwGroupID);
				}
				switch2add();
				$(addOrEditDialogueId).dialog('open');
			}
			
			//修改本组
			function modifyCurrentGroup(){
				function switch2edit(){
					url=updateUrl;
					$(addOrEditFormId).form("reset");//重置表单
					$("#addoredittitle").html('编辑组');
				}
				switch2edit();				
				
				
				if (currentTreeVeiwGroupID){
					$.get("group/edit",{id:currentTreeVeiwGroupID},function(result){
						if (result["success"]==true){							
							$(addOrEditFormId).form('load',result["result"]);	
							//extra field init logics
							//...							
							
							$(addOrEditDialogueId).dialog('open');							
						} else {
							showMessage("提示",result["message"]);
						}
					});
				}else{
					showMessage("提示",noSelectedRowMessage);
				}
			}
			//删除本组
			function removeCurrentGroup(){
				
				if (currentTreeVeiwGroupID){
					$.messager.confirm('提示',deleteConfirmMessage,function(r){
						if (r){
							$.get(deleteCascadeUrl,{id:currentTreeVeiwGroupID},function(result){
								if (result["success"]==true){
									$( treeViewId).tree( 'reload'); // reload the group data
									$( treeComboID).combotree( 'reload'); // reload the group combo data
								} else {
									showMessage("提示",result["message"]);
								}
							});
						}
					});
				}else{
					showMessage("提示",noSelectedRowMessage);
				}
			}
			//管理组员
			function manageGroupMembers(){
				alert("开发中……");
			}
			
		</script>
	</head>
	<body>

		<div  class="easyui-panel"  title="组管理" >			
			<!-- 记住这里的url不需要sitemesh装饰 -->    
			<!-- 树形界面  -->
			
	    	<ul id="tt">
	    	</ul>
			
			
			<!----------------------------------------- 修改弹出框 ------------------------------------------------------->
			<div id="addoreditdlg" title="  " class="easyui-dialog" data-options="draggable:true,resizable:true" style="width:500px;height:430px;padding:10px 20px" closed="true" buttons="#addoreditdlg-buttons">
				<!-- 修改 -->
				<div class="ftitle" id ="addoredittitle"></div>
				<form id="addoreditfm" method="post" novalidate>
					<div class="fitem">
						<label>名称:</label>
						<input id="name" name="name" class="easyui-validatebox" required="true"  ><br/><br/>
						<label>类型:</label>
						<!-- 
						<input id="type" name="type" class="easyui-validatebox" required="true"  ><br/>
						 -->
						 <select id="type" name="type" class="easyui-validatebox" required="true" style="width:158px;">
						 </select><br/><br/>
						<label>父类ID:</label>
						<input id="pGID" name="pGID" class="easyui-validatebox" required="true"  ><br/>
					</div>					
					<input type="hidden" name="id"/>
				</form>
			</div>
		
			<!-- 编辑对话框里的保存和取消按钮 -->
			<div id="addoreditdlg-buttons">
				<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" onclick="save('#addoreditdlg','#addoreditfm')">保存</a>
				<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#addoreditdlg').dialog('close')">取消</a>
			</div>
		</div>
		<div id="mm" class="easyui-menu" style="width:120px;">
			<div onclick="addSubGroup()" data-options="iconCls:'icon-add'">添加子组</div>
			<div id="modifyCurrentGroupItem" onclick="modifyCurrentGroup()" data-options="iconCls:'icon-edit'">修改本组</div>
			<div id="removeCurrentGroupItem" onclick="removeCurrentGroup()" data-options="iconCls:'icon-remove'">删除本组</div>
			<div class="menu-sep"></div>
			<div onclick="manageGroupMembers()" data-options="iconCls:'icon-search'">管理组员</div>
		</div>
	</body>
</html>
