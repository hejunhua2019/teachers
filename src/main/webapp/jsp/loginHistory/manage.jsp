<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://yajiaotong.com.cn/jstl/wface" prefix="wface" %>
<!DOCTYPE html>
<html>
	<head>
		<title>登陆历史管理</title>
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
			var datagridId="#listTable";
			var addOrEditDialogueId="#addoreditdlg";
			var addOrEditFormId="#addoreditfm";
			var addOrEditTitleId="#addoredittitle";
			var addTitle="新增登陆历史";
			var editTitle="编辑登陆历史";
			var deleteConfirmMessage="你确定要删除吗?";
			var noSelectedRowMessage="请选择记录行";
			var searchFormId="#searchForm";
			var pageSize=20;
			var listUrl="loginHistory/listpage";
			var updateUrl="loginHistory/update";
			var deleteUrl="loginHistory/deleteUpdateAll";
			var addUrl="loginHistory/add";
			var url;
							
			var loadSecondTab=false;
			$(function() {
				//页面加载的时候加载datagrid							
				//ajax获取数据
				$(datagridId).datagrid({  
					fitColumns:true,
					rownumbers : true,
					striped: true, 
					height:470,
					pagination : true,
					pageNumber : 1,
					pageList : [pageSize,pageSize*2,pageSize*3],
					pageSize : pageSize,
					pagePosition : 'bottom',
					singleSelect: false, //多选   
					nowrap:true,
					url:"loginHistory/listpage",
					columns:[[
						{field:'ck',title:'',checkbox:true,width:2},
						{field:'ip',title:'IP',width:60},
						{field:'date',title:'登陆日期',width:60,formatter:function(value,row,index){
							var result=value;
							if(typeof result === "string"){
								result = result.substring(0,10);
							}
							return value;
						}},
						{field:'userID',title:'用户ID',width:60}
					]],
					onLoadSuccess: function () {
						$(datagridId).datagrid('clearSelections'); //一定要加上这一句，要不然datagrid会记住之前的选择状态，删除时会出问题
					}					
				});			
			});
			
			//--------------------------登陆历史-------------------------------------
						
			//登陆历史添加
			function add(){				
				function switch2add(){
					$(addOrEditFormId).form("reset");//重置表单
					$("#date").val("1");
					$(addOrEditTitleId).html('新建登陆历史');
					url=addUrl;
				}
				switch2add();
				$(addOrEditDialogueId).dialog('open');
			}
			
			//登陆历史删除
			function removeAll(){
				var row = $(datagridId).datagrid('getChecked');
				if(row.length==0){
					showMessage("提示","请选择需要删除的数据");
					return;
				}
				var ids=[];
				var inum=0;
				for(var r in row){
					/*
					if(row[r]['id']=='1'){
						showMessage("提示","不能删除系统管理员！");
						return;
					}
					*/
					ids.push(row[r]['id']);
				}
				ids=ids.join(",");
				if (row){
					$.messager.confirm('提示',deleteConfirmMessage,function(r){
						if (r){
							$.get(deleteUrl,{ids:ids},function(result){
								if (result["success"]==true){
									$(datagridId).datagrid('reload'); // reload the loginHistory data
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
			
			//登陆历史修改
			function edit(){
				function switch2edit(){
					url=updateUrl;
					$(addOrEditFormId).form("reset");//重置表单
					$("#date").val("1");
					$("#addoredittitle").html('编辑登陆历史');
				}
				switch2edit();				
				
				var rows = $(datagridId).datagrid('getSelections');
				if (rows.length == 0) {
					$.messager.alert('提示', "请选择你要更新的登陆历史", 'info');
					return;
				}
				if (rows.length > 1) {
					$.messager.alert('提示', "只能选择一个登陆历史进行更新", 'info');
					return;
				}
								
				var row = $(datagridId).datagrid('getSelected');
				if (row){
					$.get("loginHistory/edit",{id:row.id},function(result){
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
			
			//登陆历史保存
			function save(mydialogueId,myFormId){
				//addition check logics
				//...				
				
				
				$.ajax({
					url: url,
					data: getFormJson( myFormId),
					type: "post",
					dataType: "json",
					beforeSend: function(){
						$('#date').val('1');
						return $( myFormId).form( 'validate' );						
					},
					success: function (result){
						if (result[ "success"]== true){
							$( mydialogueId).dialog( 'close'); // close the dialog
							$( datagridId).datagrid( 'reload'); // reload the loginHistory data
						} else {
							showMessage( "提示",result[ "message"]);
						}
					}
				});
				
			}		
			
			//登陆历史搜索
			function doSearch(){
				$(datagridId).datagrid('reload',getFormJson( searchFormId));
			}
			
			function isSupportLocalStroage(){
				try{
					return 'localStorage' in window && window['localStorage']!=null;
				}catch(e){
					return false;
				}
			}	
			//关闭小窗口
			function lCloseDialog(){
				$("#date").val("1");
				$('#addoreditdlg').dialog('close');				
			}
			
		</script>
	</head>
	<body>

		<div  class="easyui-panel"  title="登陆历史管理" >			
			<!-- 记住这里的url不需要sitemesh装饰 -->    
			<!-- 列表 -->
			<table id="listTable" data-options="border:false,toolbar:'#toolbar_listTable'">
			</table>
	    
			<!-- 列表上面的按钮和搜索条件  -->
			<div id="toolbar_listTable" style="padding:5px;height:auto">
				<div style="margin-bottom:5px"></div>
				<form action="" id="searchForm">
					<div>
						用户ID: <input name="userID" style="width:60px">
						<a class="easyui-linkbutton" iconCls="icon-search" onclick="javascript:doSearch()">查询</a>
						<c:if test="${true || wface:contains(upList,'46') }">
							<a class="easyui-linkbutton" iconCls="icon-add" onclick="javascript:add()">新增登陆历史</a>
						</c:if>
						<c:if test="${true || wface:contains(upList,'47') }">
							<a class="easyui-linkbutton" iconCls="icon-edit" onclick="javascript:edit()">修改登陆历史</a>
						</c:if>
						<c:if test="${true || wface:contains(upList,'48') }">
							<a class="easyui-linkbutton" iconCls="icon-remove" onclick="javascript:removeAll()">删除登陆历史</a>
						</c:if>
					</div>
				</form>
			</div>
			
			<!----------------------------------------- 修改弹出框 ------------------------------------------------------->
			<div id="addoreditdlg" title="  " class="easyui-dialog" data-options="draggable:true,resizable:true" style="width:500px;height:430px;padding:10px 20px" closed="true" buttons="#addoreditdlg-buttons">
				<!-- 修改 -->
				<div class="ftitle" id ="addoredittitle"></div>
				<form id="addoreditfm" method="post" novalidate>
					<div class="fitem">
						<label>IP:</label>
						<input id="ip" name="ip" class="easyui-validatebox" required="true"  ><br/>
						<label>登陆日期:</label>
						<input id="date" name="date" required="true" class="easyui-validatebox easyui-datetimebox" ><br/>
						<!-- 
						<input id="date" name="date" class="easyui-validatebox" required="true"  ><br/>
						 -->
						<label>用户ID:</label>
						<input id="userID" name="userID" class="easyui-validatebox" required="true"  ><br/>
					</div>					
					<input type="hidden" name="id"/>
				</form>
			</div>
		
			<!-- 编辑对话框里的保存和取消按钮 -->
			<div id="addoreditdlg-buttons">
				<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" onclick="save('#addoreditdlg','#addoreditfm')">保存</a>
				<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:lCloseDialog() ">取消</a>
			</div>
		</div>	
	</body>
</html>
