<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://yajiaotong.com.cn/jstl/wface" prefix="wface" %>
<!DOCTYPE html>
<html>
 <head>
    <title>部门统计</title>
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
		width:80px;
		}
	 </style>
     <script type="text/javascript">
     var datagridId="#tt";
     var adddialogueId="#dlg";
     var editdialogueId="#updatedlg";
     var addFormId="#fm";
     var editFormId="#updatefm";
     var addTitle="新增频道";
     var editTitle="编辑频道";
     var deleteConfirmMessage="你确定要删除吗?";
     var noSelectedRowMessage="你没有选择行";
     var searchFormId="#searchForm";
     var pageSize=5;
     var listUrl="${pageContext.request.contextPath}/dpstats/listpage";
     var listUrl2="${pageContext.request.contextPath}/dpstats/listpage2";
     var listUrl3="${pageContext.request.contextPath}/dpstats/listpage3";
     var url;
     var ulisturl1;
     var ulisturl2;
     var ulisturl3;
     $(function() {
    	 //页面加载的时候加载datagrid
    	 showsmsst();//加载短信已发送
    	 showmmsst();//加载短信已发送
    	 showupst();
    	 //myinit();
    });
    
    var url; 
    
    function showsmsst(){ 
    $(datagridId).datagrid({
    	 		/* title: '用户管理', //标题 */
	            method: 'post',
	            iconCls: 'icon-edit', //图标
	            singleSelect: false, //多选   
	            //checkOnSelect:false,
	            height: 300, //高度
	            fitColumns: true, //自动调整各列，用了这个属性，下面各列的宽度值就只是一个比例。
	            striped: true, //奇偶行颜色不同
	            collapsible: true,//可折叠
	            url:listUrl, //数据来源
	            sortName: 'dpid', //排序的列
	            sortOrder: 'desc', //倒序
	            pageNumber: 1,//当设置了 pagination 特性时，初始化页码。
	            pageList : [pageSize,pageSize*2,pageSize*3],
    		    pageSize : pageSize, //当设置了 pagination 特性时，初始化页面尺寸的选择列表。
	            remoteSort: true, //服务器端排序
	            idField: 'dpid', //主键字段
	            queryParams: {}, //查询条件
	            pagination: true, //显示分页
	            rownumbers: true, //显示行号
    		    columns:[[
    		    			//{field: 'ck', checkbox: true, width: 2}, //显示复选框
		                    {field: 'dpid', title: '部门ID', width: 20, sortable: true,  hidden: true, 
		                        formatter: function (value, row, index) {
		                            return row.dpid;
		                        }
		                    },
		                    {field:'departmentname',title:'部门名称',width:100, sortable: true,
    							formatter: function (value, row, index) {
		                            return row.departmentname;
		                        }
    						},
    						{field:'submitcount',title:'提交成功数量',width:100, sortable: true,
    							formatter: function (value, row, index) {
		                            return row.submitcount;
		                        }
    						},
    						{field:'totalcount',title:'提交总量',width:100, sortable: true, 
    							formatter: function (value, row, index) {
		                            return row.totalcount;
		                        }
    						},
    						{field:'successcount',title:'状态成功数量',width:100, sortable: true, 
    							formatter: function (value, row, index) {
		                            return row.successcount;
		                        }
    						},
    						{field:'failcount',title:'状态失败功数量',width:100, sortable: true, 
    							formatter: function (value, row, index) {
		                            return row.failcount;
		                        }
    						},
					
    						{field:'cuozuo',title:'查看员工',width:100,
    							formatter:function(value,row,index){
    							if(row.dpid=='0'){
    								return '';
    							}  							
    							var btn = '<a onclick="toshowuserlist1('+row.dpid+')" href="javascript:void(0)">查看员工</a>';  
                				return btn;
    						}}
    				    ]],
					onLoadSuccess: function (data) {
		                $(datagridId).datagrid('clearSelections'); //一定要加上这一句，要不然datagrid会记住之前的选择状态，删除时会出问题
		                var chart = new FusionCharts("./swf/FCF_MSLine.swf", "myChartId"  
	                    , "800", "480","0","0");  
			            chart.setDataXML(data.xmldata);  
			            chart.render("graph");
		            }
    	 });
    }
    
    function showmmsst(){ 
    $("#tt2").datagrid({
    	 		/* title: '用户管理', //标题 */
	            method: 'post',
	            iconCls: 'icon-edit', //图标
	            singleSelect: false, //多选   
	            //checkOnSelect:false,
	            height: 300, //高度
	            fitColumns: true, //自动调整各列，用了这个属性，下面各列的宽度值就只是一个比例。
	            striped: true, //奇偶行颜色不同
	            collapsible: true,//可折叠
	            url:listUrl2, //数据来源
	            sortName: 'dpid', //排序的列
	            sortOrder: 'desc', //倒序
	            pageNumber: 1,//当设置了 pagination 特性时，初始化页码。
	            pageList : [pageSize,pageSize*2,pageSize*3],
    		    pageSize : pageSize, //当设置了 pagination 特性时，初始化页面尺寸的选择列表。
	            remoteSort: true, //服务器端排序
	            idField: 'dpid', //主键字段
	            queryParams: {}, //查询条件
	            pagination: true, //显示分页
	            rownumbers: true, //显示行号
    		    columns:[[
    		    			//{field: 'ck', checkbox: true, width: 2}, //显示复选框
		                    {field: 'dpid', title: '部门ID', width: 20, sortable: true,  hidden: true, 
		                        formatter: function (value, row, index) {
		                            return row.dpid;
		                        }
		                    },
		                    {field:'departmentname',title:'部门名称',width:100, sortable: true,
    							formatter: function (value, row, index) {
		                            return row.departmentname;
		                        }
    						},
    						{field:'count',title:'提交成功数量',width:100, sortable: true,
    							formatter: function (value, row, index) {
		                            return row.count;
		                        }
    						},
    						{field:'submitcount',title:'提交总量',width:100, sortable: true, 
    							formatter: function (value, row, index) {
		                            return row.submitcount;
		                        }
    						},
    						{field:'successcount',title:'状态成功数量',width:100, sortable: true, 
    							formatter: function (value, row, index) {
		                            return row.successcount;
		                        }
    						},
    						{field:'failcount',title:'状态失败功数量',width:100, sortable: true, 
    							formatter: function (value, row, index) {
		                            return row.failcount;
		                        }
    						},
					
    						{field:'cuozuo',title:'查看员工',width:100,
    							formatter:function(value,row,index){
    							if(row.dpid=='0'){
    								return '';
    							}  							
    							var btn = '<a onclick="toshowuserlist2('+row.dpid+')" href="javascript:void(0)">查看员工</a>';  
                				return btn;
    						}}
    				    ]],
    			 	
					onLoadSuccess: function (data) {
		                $("#tt2").datagrid('clearSelections'); //一定要加上这一句，要不然datagrid会记住之前的选择状态，删除时会出问题
		                var chart = new FusionCharts("./swf/FCF_MSLine.swf", "myChartId2"  
	                    , "800", "480","0","0");  
			            chart.setDataXML(data.xmldata);  
			            chart.render("graph2");
		            }
    	 });
    }    
    
    function showupst(){ 
    $("#tt3").datagrid({
    	 		/* title: '用户管理', //标题 */
	            method: 'post',
	            iconCls: 'icon-edit', //图标
	            singleSelect: false, //多选   
	            //checkOnSelect:false,
	            height: 300, //高度
	            fitColumns: true, //自动调整各列，用了这个属性，下面各列的宽度值就只是一个比例。
	            striped: true, //奇偶行颜色不同
	            collapsible: true,//可折叠
	            url:listUrl3, //数据来源
	            sortName: 'dpid', //排序的列
	            sortOrder: 'desc', //倒序
	            pageNumber: 1,//当设置了 pagination 特性时，初始化页码。
	            pageList : [pageSize,pageSize*2,pageSize*3],
    		    pageSize : pageSize, //当设置了 pagination 特性时，初始化页面尺寸的选择列表。
	            remoteSort: true, //服务器端排序
	            idField: 'dpid', //主键字段
	            queryParams: {}, //查询条件
	            pagination: true, //显示分页
	            rownumbers: true, //显示行号
    		    columns:[[
    		    			//{field: 'ck', checkbox: true, width: 2}, //显示复选框
		                    {field: 'dpid', title: '部门ID', width: 20, sortable: true,  hidden: true, 
		                        formatter: function (value, row, index) {
		                            return row.dpid;
		                        }
		                    },
		                    {field:'departmentname',title:'部门名称',width:100, sortable: true,
    							formatter: function (value, row, index) {
		                            return row.departmentname;
		                        }
    						},
    						{field:'submitcount',title:'短信上行成功数量',width:100, sortable: true,
    							formatter: function (value, row, index) {
		                            return row.submitcount;
		                        }
    						},
    						{field:'cuozuo',title:'查看员工',width:100,
    							formatter:function(value,row,index){
    							if(row.dpid=='0'){
    								return '';
    							}  							
    							var btn = '<a onclick="toshowuserlist3('+row.dpid+')" href="javascript:void(0)">查看员工</a>';  
                				return btn;
    						}}
    				    ]],
					onLoadSuccess: function (data) {
		                $("#tt3").datagrid('clearSelections'); //一定要加上这一句，要不然datagrid会记住之前的选择状态，删除时会出问题
		                var chart = new FusionCharts("./swf/FCF_MSLine.swf", "myChartId3"  
	                    , "800", "480","0","0");  
			            chart.setDataXML(data.xmldata);  
			            chart.render("graph3");
		            }
    	 });
    }
    
    function toshowuserlist1(a){ 
    	$(datagridId).datagrid('clearSelections');
    	$("#addsource").dialog("open").dialog('setTitle', '员工已发送详情');
    	$("#queryuser1Form").form("clear");
    	ulisturl1 = "${pageContext.request.contextPath}/dpstats/userlistpage1?dpid=" + a;
    	showuserlist1();
    }
    function toshowuserlist2(a){ 
    	$("#tt2").datagrid('clearSelections');
    	$("#addsource2").dialog("open").dialog('setTitle', '员工已发送详情');
    	$("#queryuser2Form").form("clear");
    	ulisturl2 = "${pageContext.request.contextPath}/dpstats/userlistpage2?dpid=" + a;
    	showuserlist2();
    }
    function toshowuserlist3(a){ 
    	$("#tt3").datagrid('clearSelections');
    	$("#addsource3").dialog("open").dialog('setTitle', '员工已发送详情');
    	$("#queryuser3Form").form("clear");
    	ulisturl3 = "${pageContext.request.contextPath}/dpstats/userlistpage3?dpid=" + a;
    	showuserlist3();
    }
    
    function showuserlist1(){ 
    $("#userlist1").datagrid({
    	 		/* title: '用户管理', //标题 */
	            method: 'post',
	            iconCls: 'icon-edit', //图标
	            singleSelect: false, //多选   
	            //checkOnSelect:false,
	            height: 300, //高度
	            fitColumns: true, //自动调整各列，用了这个属性，下面各列的宽度值就只是一个比例。
	            striped: true, //奇偶行颜色不同
	            collapsible: true,//可折叠
	            url:ulisturl1, //数据来源
	            sortName: 'user_id', //排序的列
	            sortOrder: 'desc', //倒序
	            pageNumber: 1,//当设置了 pagination 特性时，初始化页码。
	            pageList : [pageSize,pageSize*2,pageSize*3],
    		    pageSize : pageSize, //当设置了 pagination 特性时，初始化页面尺寸的选择列表。
	            remoteSort: true, //服务器端排序
	            idField: 'user_id', //主键字段
	            queryParams: {}, //查询条件
	            pagination: true, //显示分页
	            rownumbers: true, //显示行号
    		    columns:[[
    		    			//{field: 'ck', checkbox: true, width: 2}, //显示复选框
		                    {field: 'user_id', title: '用户ID', width: 20, sortable: true,  hidden: true, 
		                        formatter: function (value, row, index) {
		                            return row.user_id;
		                        }
		                    },
		                    {field:'userName',title:'员工名称',width:100, sortable: true,
    							formatter: function (value, row, index) {
		                            return row.userName;
		                        }
    						},
    						{field:'submitcount',title:'提交成功数量',width:100, sortable: true,
    							formatter: function (value, row, index) {
		                            return row.submitcount;
		                        }
    						},
    						{field:'totalcount',title:'提交总量',width:100, sortable: true, 
    							formatter: function (value, row, index) {
		                            return row.totalcount;
		                        }
    						},
    						{field:'successcount',title:'状态成功数量',width:100, sortable: true, 
    							formatter: function (value, row, index) {
		                            return row.successcount;
		                        }
    						},
    						{field:'failcount',title:'状态失败功数量',width:100, sortable: true, 
    							formatter: function (value, row, index) {
		                            return row.failcount;
		                        }
    						}
    				    ]],
    			 	
					onLoadSuccess: function () {
		                $("#userlist1").datagrid('clearSelections'); //一定要加上这一句，要不然datagrid会记住之前的选择状态，删除时会出问题
		            }
    	 });
    }
    
    function showuserlist2(){ 
    $("#userlist2").datagrid({
    	 		/* title: '用户管理', //标题 */
	            method: 'post',
	            iconCls: 'icon-edit', //图标
	            singleSelect: false, //多选   
	            //checkOnSelect:false,
	            height: 300, //高度
	            fitColumns: true, //自动调整各列，用了这个属性，下面各列的宽度值就只是一个比例。
	            striped: true, //奇偶行颜色不同
	            collapsible: true,//可折叠
	            url:ulisturl2, //数据来源
	            sortName: 'user_id', //排序的列
	            sortOrder: 'desc', //倒序
	            pageNumber: 1,//当设置了 pagination 特性时，初始化页码。
	            pageList : [pageSize,pageSize*2,pageSize*3],
    		    pageSize : pageSize, //当设置了 pagination 特性时，初始化页面尺寸的选择列表。
	            remoteSort: true, //服务器端排序
	            idField: 'user_id', //主键字段
	            queryParams: {}, //查询条件
	            pagination: true, //显示分页
	            rownumbers: true, //显示行号
    		    columns:[[
    		    			//{field: 'ck', checkbox: true, width: 2}, //显示复选框
		                    {field: 'user_id', title: '用户ID', width: 20, sortable: true,  hidden: true, 
		                        formatter: function (value, row, index) {
		                            return row.user_id;
		                        }
		                    },
		                    {field:'userName',title:'员工名称',width:100, sortable: true,
    							formatter: function (value, row, index) {
		                            return row.userName;
		                        }
    						},
    						{field:'count',title:'提交成功数量',width:100, sortable: true,
    							formatter: function (value, row, index) {
		                            return row.count;
		                        }
    						},
    						{field:'submitcount',title:'提交总量',width:100, sortable: true, 
    							formatter: function (value, row, index) {
		                            return row.submitcount;
		                        }
    						},
    						{field:'successcount',title:'状态成功数量',width:100, sortable: true, 
    							formatter: function (value, row, index) {
		                            return row.successcount;
		                        }
    						},
    						{field:'failcount',title:'状态失败功数量',width:100, sortable: true, 
    							formatter: function (value, row, index) {
		                            return row.failcount;
		                        }
    						}
    				    ]],
    			 	
					onLoadSuccess: function () {
		                $("#userlist2").datagrid('clearSelections'); //一定要加上这一句，要不然datagrid会记住之前的选择状态，删除时会出问题
		            }
    	 });
    }
    
    
	function showuserlist3(){ 
    $("#userlist3").datagrid({
    	 		/* title: '用户管理', //标题 */
	            method: 'post',
	            iconCls: 'icon-edit', //图标
	            singleSelect: false, //多选   
	            //checkOnSelect:false,
	            height: 300, //高度
	            fitColumns: true, //自动调整各列，用了这个属性，下面各列的宽度值就只是一个比例。
	            striped: true, //奇偶行颜色不同
	            collapsible: true,//可折叠
	            url:ulisturl3, //数据来源
	            sortName: 'user_id', //排序的列
	            sortOrder: 'desc', //倒序
	            pageNumber: 1,//当设置了 pagination 特性时，初始化页码。
	            pageList : [pageSize,pageSize*2,pageSize*3],
    		    pageSize : pageSize, //当设置了 pagination 特性时，初始化页面尺寸的选择列表。
	            remoteSort: true, //服务器端排序
	            idField: 'user_id', //主键字段
	            queryParams: {}, //查询条件
	            pagination: true, //显示分页
	            rownumbers: true, //显示行号
    		    columns:[[
    		    			//{field: 'ck', checkbox: true, width: 2}, //显示复选框
		                    {field: 'user_id', title: '用户ID', width: 20, sortable: true,  hidden: true, 
		                        formatter: function (value, row, index) {
		                            return row.user_id;
		                        }
		                    },
		                    {field:'userName',title:'员工名称',width:100, sortable: true,
    							formatter: function (value, row, index) {
		                            return row.userName;
		                        }
    						},
    						{field:'submitcount',title:'短信上行成功数量',width:100, sortable: true,
    							formatter: function (value, row, index) {
		                            return row.submitcount;
		                        }
    						}
    				    ]],
    			 	
					onLoadSuccess: function () {
		                $("#userlist3").datagrid('clearSelections'); //一定要加上这一句，要不然datagrid会记住之前的选择状态，删除时会出问题
		            }
    	 });
    }

    
    //新建
    function addrow() {
        $("#addsource").dialog("open").dialog('setTitle', '新建文件夹');
        $("#fm").form("clear");
        url = "${pageContext.request.contextPath}/sms/addgro";
        document.getElementById("hidtype").value = "submit";
    }
    //更新
    function updaterow() {
        var rows = $(datagridId).datagrid('getSelections');
        //这里有一个jquery easyui datagrid的一个小bug，必须把主键单独列出来，要不然不能多选
        if (rows.length == 0) {
            $.messager.alert('提示', "请选择你要更新的文件夹", 'info');
            return;
        }
        if (rows.length > 1) {
            $.messager.alert('提示', "只能选择一个文件夹进行更新", 'info');
            return;
        }
        $("#addsource").dialog("open").dialog('setTitle', '用户更新');
        $("#fm").form("load", rows[0]);
        url = "${pageContext.request.contextPath}/sms/addgro";
    }

    //删除
    function deleterow() {
        var rows = $(datagridId).datagrid('getSelections');
        //这里有一个jquery easyui datagrid的一个小bug，必须把主键单独列出来，要不然不能多选
        if (rows.length == 0) {
            $.messager.alert('提示', "请选择你要删除的文件夹", 'info');
            return;
        }
        $.messager.confirm('提示', '同时删除文件夹内所有短信，确定要删除吗?', function (result) {
            if (result) {
                var rows = $(datagridId).datagrid('getSelections');
                var ps = "";
                $.each(rows, function (i, n) {
                    if (i == 0)
                        ps += "?id=" + n.id;
                    else
                        ps += "&id=" + n.id;
                });
                $.post('${pageContext.request.contextPath}/sms/delgro' + ps, function (data) {
                    $(datagridId).datagrid('reload');
                    textUrl = "${pageContext.request.contextPath}/sms/listpaget";
    				reloadtext();
                    $.messager.alert('提示', data.mes, 'info');
                });
            }
        });
    }
    
	function sharerow() {
        var rows = $(datagridId).datagrid('getSelections');
        //这里有一个jquery easyui datagrid的一个小bug，必须把主键单独列出来，要不然不能多选
        if (rows.length == 0) {
            $.messager.alert('提示', "请选择你要分享的文件夹", 'info');
            return;
        }
        if (rows.length > 1) {
            $.messager.alert('提示', "只能选择一个文件夹分享", 'info');
            return;
        }
        $("#addsource3").dialog("open").dialog('setTitle', '用户更新');
        showuserlist();
        var v1 = rows[0].id;
        $("#fm3 input[name='smsgroid']").val(v1); 
        
        url = "${pageContext.request.contextPath}/sms/addshare";
    }
    
    
    //新建
    function addtext() {
    	var rows = $(datagridId).datagrid('getSelections');
        //这里有一个jquery easyui datagrid的一个小bug，必须把主键单独列出来，要不然不能多选
        if (rows.length == 0) {
            $.messager.alert('提示', "请选择需要添加短信的的文件夹", 'info');
            return;
        }
        if (rows.length > 1) {
            $.messager.alert('提示', "只能选择一个文件夹添加短信", 'info');
            return;
        }
    
        $("#addsource2").dialog("open").dialog('setTitle', '新建短信');
        $("#fm2").form("clear");
        var v = rows[0].id; 
        $("#fm2 input[name='groupid']").val(v); 
        url = "${pageContext.request.contextPath}/sms/addtxt";
        document.getElementById("hidtype2").value = "submit";
    }
    //更新
    function updatetext() {
        var rows = $("#tt3").datagrid('getSelections');
        //这里有一个jquery easyui datagrid的一个小bug，必须把主键单独列出来，要不然不能多选
        if (rows.length == 0) {
            $.messager.alert('提示', "请选择你要更新的短信", 'info');
            return;
        }
        if (rows.length > 1) {
            $.messager.alert('提示', "只能选择一个短信进行更新", 'info');
            return;
        }
        var a = ${uid};
        var b= rows[0].userid; 
        if(a!=b){ 
        	$.messager.alert('提示', "没有权限！", 'info');
            return;
        }
        $("#addsource2").dialog("open").dialog('setTitle', '用户更新');
        $("#fm2").form("load", rows[0]);
        url = "${pageContext.request.contextPath}/sms/updatetxt";
    }

    //删除
    function deletetext() {
        var rows = $("#tt3").datagrid('getSelections');
        //这里有一个jquery easyui datagrid的一个小bug，必须把主键单独列出来，要不然不能多选
        if (rows.length == 0) {
            $.messager.alert('提示', "请选择你要删除的短信", 'info');
            return;
        }
        
        var a = ${uid};
        var b= rows[0].userid; 
        if(a!=b){ 
        	$.messager.alert('提示', "没有权限！", 'info');
            return;
        }
        
        $.messager.confirm('提示', '确定要删除吗?', function (result) {
            if (result) {
                var rows = $("#tt3").datagrid('getSelections');
                var ps = "";
                $.each(rows, function (i, n) {
                    if (i == 0)
                        ps += "?id=" + n.id;
                    else
                        ps += "&id=" + n.id;
                });
                $.post('${pageContext.request.contextPath}/sms/deltxt' + ps, function (data) {
                    $("#tt3").datagrid('reload');
                    $.messager.alert('提示', data.mes, 'info');
                });
            }
        });
    }
    
    
    
    function delshare() {
        var rows = $("#tt2").datagrid('getSelections');
        //这里有一个jquery easyui datagrid的一个小bug，必须把主键单独列出来，要不然不能多选
        if (rows.length == 0) {
            $.messager.alert('提示', "请选择你要解除的共享", 'info');
            return;
        }
        $.messager.confirm('提示', '确定要解除共享吗?', function (result) {
            if (result) {
                var rows = $("#tt2").datagrid('getSelections');
                var ps = "";
                $.each(rows, function (i, n) {
                    if (i == 0)
                        ps += "?id=" + n.id;
                    else
                        ps += "&id=" + n.id;
                });
                $.post('${pageContext.request.contextPath}/sms/delshare' + ps, function (data) {
                    $("#tt2").datagrid('reload');
                    $.messager.alert('提示', data.mes, 'info');
                });
            }
        });
    }
    
    function savesmsg(){
        $("#fm").form("submit", {
            url: url,
            method: 'post',
            onSubmit: function () {
                return $(this).form("validate");
            },
            success: function (result) {
				if(typeof result === 'object'){
				    result = result;
				}
				else{
				    result = eval("("+result+")")
				}
                if (result.result == "1") {
                    $.messager.alert("提示信息", "添加组成功");
                    $("#addsource").dialog("close");
                    $(datagridId).datagrid("load");
                } else if (result.result == "2") {
                    $.messager.alert("提示信息", "更新组成功");
                    $("#addsource").dialog("close");
                    $(datagridId).datagrid("load");
                } else {
                    $.messager.alert("提示信息", result.mes+"操作组失败");
                    /* $("#addsource").dialog("close");
                    $("#flatTable").datagrid("load"); */
                }
            }
        });
    }
    
    /* function savesms(){
    	var gid = $("#fm2 input[name='groupid']").val();
        $("#fm2").form("submit", {
            url: url,
            method: 'post',
            onSubmit: function () {
                return $(this).form("validate");
            },
            success: function (result) {
				if(typeof result === 'object'){
				    result = result;
				}
				else{
				    result = eval("("+result+")")
				}
                if (result.result == "1") {
                    $.messager.alert("提示信息", "添加短信成功");
                    $("#addsource2").dialog("close"); 
                    showtext(gid);
                    //$("#tt3").datagrid("load");
                } else if (result.result == "2") {
                    $.messager.alert("提示信息", "更新短信成功");
                    $("#addsource2").dialog("close");
                    $("#tt3").datagrid("load");
                } else {
                    $.messager.alert("提示信息", result.mes+"添加短信失败");
                    $("#addsource").dialog("close");
                    $("#flatTable").datagrid("load"); 
                }
            }
        });
    } */
    function sharegro(){
    	var rows2 = $("#userlist").datagrid('getSelections');
        //这里有一个jquery easyui datagrid的一个小bug，必须把主键单独列出来，要不然不能多选
        if (rows2.length == 0) {
            $.messager.alert('提示', "请选择你要分享的员工", 'info');
            return;
        }
        $("#fm3 input[name='besharedid']").remove();
        var f = document.getElementById("fm3");
        for(var i=0;i<rows2.length;i++){
        	var input_file = document.createElement("input");
        	var v2 = rows2[i].id;
			input_file.setAttribute("type","checkbox");
			input_file.setAttribute("name","besharedid");
			input_file.setAttribute("checked",true);			
			input_file.setAttribute("value",v2);
			f.appendChild(input_file);
        }
        $("#fm3").form("submit", {
            url: url,
            method: 'post',
            onSubmit: function () {
                return $(this).form("validate");
            },
            success: function (result) {
				if(typeof result === 'object'){
				    result = result;
				}
				else{
				    result = eval("("+result+")")
				}
                if (result.result == "1") {
                    $.messager.alert("提示信息", "创建共享成功");
                    $("#addsource3").dialog("close");
					$('#userlist').datagrid('clearSelections');
					$("#fm3 input[name='besharedid']").remove();
                    showmyshare();
                } else {
                    $.messager.alert("提示信息", result.mes+"创建共享失败");
                    /* $("#addsource").dialog("close");
                    $("#flatTable").datagrid("load"); */
                }
            }
        });
    }
    //短信统计
    function searchStats() { 
        var params = $('#tt').datagrid('options').queryParams; //先取得 datagrid 的查询参数
        var fields = $('#queryForm').serializeArray(); //自动序列化表单元素为JSON对象
        $.each(fields, function (i, field) {
            params[field.name] = field.value; //设置查询参数
        });
        $('#tt').datagrid('reload'); //设置好查询参数 reload 一下就可以了  
        
    } 
    function searchuser1(){
    	var params = $('#userlist1').datagrid('options').queryParams; //先取得 datagrid 的查询参数
        var fields = $('#queryuser1Form').serializeArray(); //自动序列化表单元素为JSON对象
        $.each(fields, function (i, field) {
            params[field.name] = field.value; //设置查询参数
        });
        $('#userlist1').datagrid('reload'); //设置好查询参数 reload 一下就可以了  
    }
    //彩信统计
    function searchStats2() { 
        var params = $('#tt2').datagrid('options').queryParams; //先取得 datagrid 的查询参数
        var fields = $('#queryForm2').serializeArray(); //自动序列化表单元素为JSON对象
        $.each(fields, function (i, field) {
            params[field.name] = field.value; //设置查询参数
        });
        $('#tt2').datagrid('reload'); //设置好查询参数 reload 一下就可以了  
        
    } 
    function searchuser2(){
    	var params = $('#userlist2').datagrid('options').queryParams; //先取得 datagrid 的查询参数
        var fields = $('#queryuser2Form').serializeArray(); //自动序列化表单元素为JSON对象
        $.each(fields, function (i, field) {
            params[field.name] = field.value; //设置查询参数
        });
        $('#userlist2').datagrid('reload'); //设置好查询参数 reload 一下就可以了  
    }
    //上行记录统计
    function searchStats3() { 
        var params = $('#tt3').datagrid('options').queryParams; //先取得 datagrid 的查询参数
        var fields = $('#queryForm3').serializeArray(); //自动序列化表单元素为JSON对象
        $.each(fields, function (i, field) {
            params[field.name] = field.value; //设置查询参数
        });
        $('#tt3').datagrid('reload'); //设置好查询参数 reload 一下就可以了  
        
    } 
    function searchuser3(){
    	var params = $('#userlist3').datagrid('options').queryParams; //先取得 datagrid 的查询参数
        var fields = $('#queryuser3Form').serializeArray(); //自动序列化表单元素为JSON对象
        $.each(fields, function (i, field) {
            params[field.name] = field.value; //设置查询参数
        });
        $('#userlist3').datagrid('reload'); //设置好查询参数 reload 一下就可以了  
    }
     
    function doSearch(){
 		$(datagridId).datagrid('reload',getFormJson( searchFormId));
 	}
 	function cancel(){
 	 	$('#userlist').datagrid('clearSelections');
 		$('#addsource3').dialog('close');
 	}
 	function exportsm(){
    	var myForm=document.getElementById("queryForm");
    	myForm.submit();
    }
    function exportmm(){
    	var myForm=document.getElementById("queryForm2");
    	myForm.submit();
    }
    function exportup(){
    	var myForm=document.getElementById("queryForm3");
    	myForm.submit();
    }
    function exportusersm(){
    	var myForm=document.getElementById("queryuser1Form");
    	var rows = $("#tt").datagrid('getSelections');
    	$("#queryuser1Form input[name='departmentid']").val(rows[0].dpid);
    	myForm.submit();
    }
    function exportusermm(){
    	var myForm=document.getElementById("queryuser2Form");
    	var rows = $("#tt2").datagrid('getSelections');
		$("#queryuser2Form input[name='departmentid']").val(rows[0].dpid);
    	myForm.submit();
    }
    function exportuserup(){
    	var myForm=document.getElementById("queryuser3Form");
    	var rows = $("#tt3").datagrid('getSelections');
    	$("#queryuser3Form input[name='departmentid']").val(rows[0].dpid);
    	myForm.submit();
    }
</script>
  </head>
<body>

<div id="p" class="easyui-panel" data-options="fit:true" title="部门统计">
	<div class="easyui-tabs" style="" data-options="fit:true">   
		<!-- 记住这里的url不需要sitemesh装饰 -->
	    <div title="短信已发送统计 " class="easyui-layout" style="width:1000px; height:1000px; "> 
		    	<form id="queryForm" action="dpstats/exsms" style="margin:10;text-align: center;">
		     	<table width="100%">
				        <tr>
				            <td>开始时间: <input class="easyui-datebox" value="${startTime}" name="startTime" style="width:100px"/></td>
							<td>结束时间: <input class="easyui-datebox" value="${endTime}" name="endTime" style="width:100px"/>
				            <td>通道：<select name="channelId" id="chllist" >
				            			<option value=''>全部</option>
										<c:forEach items="${cclist}" var="stu">
											<option value='${stu.channelId}'>${stu.channelName}</option>
										</c:forEach>
									  </select></td>
				            <td>模板类型：
				            		  <select name="bid" id="buslist" >
				            		  <option value=''>全部</option>
										<c:forEach items="${blist}" var="stu">
											<option value='${stu.id}'>${stu.name}</option>
										</c:forEach>
									  </select>
				            </td>
				            <td>发送类型：
									  <select name="sendType">
				            		  	<option value=''>全部</option>
				            		  	<option value='0'>接口发送</option>
				            		  	<option value='1'>页面发送</option>
									  </select>
				            </td>
				            <td width="60px" align="right"><a href="javascript:void(0)" onclick="searchStats();" class="easyui-linkbutton" iconCls="icon-search">查询</a></td>
				            <td width="60px" align="right"><a href="javascript:void(0)" onclick="exportsm();" class="easyui-linkbutton" iconCls="icon-save">导出</a></td>
				            <!-- <td width="60px" align="right"><a href="#" onclick="clearForm();" class="easyui-linkbutton" iconCls="icon-search">清空</a></td> -->
							<td width="100px" align="right"></td>
				        </tr>
				</table>
				</form>
		    	<!-- <div class="easyui-layout" style="width:1000px;height:1000px;">
		    		<div data-options="region:'north'" style="width:420px;height:500px;"> -->
			    		<table id="tt" data-options="border:false">
						</table>
		    		<!-- </div>
		    		<div data-options="region:'center'" style="width:1000px;height:500px;"> -->
			    		<div id="graph" style="text-align:center;">
						</div>
		    		<!-- </div>  
		    	</div> -->

		</div>
	    <div title="彩信已发送统计" data-options="" style="overflow:auto;">   
				    <!-- 列表 -->
			<form id="queryForm2" action="dpstats/exmms" style="margin:10;text-align: center;">
		     	<table width="100%">
				        <tr>
				            <td>开始时间: <input class="easyui-datebox" value="${startTime}" name="startTime" style="width:100px"/></td>
				            <td>结束时间: <input class="easyui-datebox" value="${endTime}" name="endTime" style="width:100px"/>
				            <td>通道：<select name="channelId" id="chllist" >
				            			<option value=''>全部</option>
										<c:forEach items="${cclist}" var="stu">
											<option value='${stu.channelId}'>${stu.channelName}</option>
										</c:forEach>
									  </select></td>
				            <td>模板类型：
				            		  <select name="bid" id="buslist" >
				            		  <option value=''>全部</option>
										<c:forEach items="${blist}" var="stu">
											<option value='${stu.id}'>${stu.name}</option>
										</c:forEach>
									  </select>
				            </td>
				            <td>发送类型：
									  <select name="sendType">
				            		  	<option value=''>全部</option>
				            		  	<option value='0'>接口发送</option>
				            		  	<option value='1'>页面发送</option>
									  </select>
				            </td>
				            <td width="60px" align="right"><a href="javascript:void(0)" onclick="searchStats2();" class="easyui-linkbutton" iconCls="icon-search">查询</a></td>
				            <td width="60px" align="right"><a href="javascript:void(0)" onclick="exportmm();" class="easyui-linkbutton" iconCls="icon-save">导出</a></td>
				            <!-- <td width="60px" align="right"><a href="#" onclick="clearForm();" class="easyui-linkbutton" iconCls="icon-search">清空</a></td> -->
							<td width="100px" align="right"></td>
				        </tr>
				</table>
				</form>				    
				<div>
			    <table id="tt2" data-options="border:false">
			    </table>			    
			    </div>
			    <div id="graph2" style="text-align:center;">
				</div>
	    </div>
	    <div title="上行记录统计" data-options="" style="overflow:auto;">   
				    <!-- 列表 -->
			<form id="queryForm3" action="dpstats/exups" style="margin:10;text-align: center;">
		     	<table width="100%">
				        <tr>
				            <td>开始时间: <input class="easyui-datebox" value="${startTime}" name="startTime" style="width:100px"/></td>
				            <td>结束时间: <input class="easyui-datebox" value="${endTime}" name="endTime" style="width:100px"/>
				            <td>通道：<select name="channelId" id="chllist" >
				            			<option value=''>全部</option>
										<c:forEach items="${cclist}" var="stu">
											<option value='${stu.channelId}'>${stu.channelName}</option>
										</c:forEach>
									  </select></td>
				            <td>模板类型：
				            		  <select name="bid" id="buslist" >
				            		  <option value=''>全部</option>
										<c:forEach items="${blist}" var="stu">
											<option value='${stu.id}'>${stu.name}</option>
										</c:forEach>
									  </select>
				            </td>
				            <td>发送类型：
									  <select name="sendType">
				            		  	<option value=''>全部</option>
				            		  	<option value='0'>接口发送</option>
				            		  	<option value='1'>页面发送</option>
									  </select>
				            </td>
				            <td width="60px" align="right"><a href="javascript:void(0)" onclick="searchStats3();" class="easyui-linkbutton" iconCls="icon-search">查询</a></td>
				            <td width="60px" align="right"><a href="javascript:void(0)" onclick="exportup();" class="easyui-linkbutton" iconCls="icon-save">导出</a></td>
				            <!-- <td width="60px" align="right"><a href="#" onclick="clearForm();" class="easyui-linkbutton" iconCls="icon-search">清空</a></td> -->
							<td width="100px" align="right"></td>
				        </tr>
				</table>
				</form>
				<div>
			    <table id="tt3" data-options="border:false">
			    </table>			    
			    </div>
			    <div id="graph3" style="text-align:center;">
				</div>
	    </div>
	
</div>

<div id="addsource" class="easyui-dialog" style="width: 1000px; height: 420px; padding: 10px 20px;"
     closed="true" buttons="#dlg-buttons" data-options="iconCls:'icon-save',resizable:true,modal:true">
	 <form id="queryuser1Form" action="dpstats/exusersms" style="margin:10;text-align: center;">
		     	<table width="100%">
				        <tr>
				            <td>开始时间: <input class="easyui-datebox" value="${startTime}" name="startTime" style="width:100px"/></td>
				            <td>结束时间: <input class="easyui-datebox" value="${endTime}" name="endTime" style="width:100px"/>
				            <td>通道：<select name="channelId" id="chllist" >
				            			<option value=''>全部</option>
										<c:forEach items="${cclist}" var="stu">
											<option value='${stu.channelId}'>${stu.channelName}</option>
										</c:forEach>
									  </select></td>
				            <td>模板类型：
				            		  <select name="bid" id="buslist" >
				            		  <option value=''>全部</option>
										<c:forEach items="${blist}" var="stu">
											<option value='${stu.id}'>${stu.name}</option>
										</c:forEach>
									  </select>
				            </td>
				            <input name="departmentid" type="hidden"/>
				            <td width="60px" align="right"><a href="javascript:void(0)" onclick="searchuser1();" class="easyui-linkbutton" iconCls="icon-search">查询</a></td>
				            <td width="60px" align="right"><a href="javascript:void(0)" onclick="exportusersm();" class="easyui-linkbutton" iconCls="icon-save">导出</a></td>
				            <!-- <td width="60px" align="right"><a href="#" onclick="clearForm();" class="easyui-linkbutton" iconCls="icon-search">清空</a></td> -->
							<td width="100px" align="right"></td>
				        </tr>
				</table>
	</form>
					<div>
						<table id="userlist1" data-options="border:false">
						</table>
					</div>
</div>
<div id="dlg-buttons">
    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="javascript:$('#addsource').dialog('close')"
       iconcls="icon-cancel">关闭</a>
</div>

<div id="addsource2" class="easyui-dialog" style="width: 1000px; height: 420px; padding: 10px 20px;"
     closed="true" buttons="#dlg-buttons2" data-options="iconCls:'icon-save',resizable:true,modal:true">
	 <form id="queryuser2Form" action="dpstats/exusermms" style="margin:10;text-align: center;">
		     	<table width="100%">
				        <tr>
				            <td>开始时间: <input class="easyui-datebox" value="${startTime}" name="startTime" style="width:100px"/></td>
				            <td>结束时间: <input class="easyui-datebox" value="${endTime}" name="endTime" style="width:100px"/>
				            <td>通道：<select name="channelId" id="chllist" >
				            			<option value=''>全部</option>
										<c:forEach items="${cclist}" var="stu">
											<option value='${stu.channelId}'>${stu.channelName}</option>
										</c:forEach>
									  </select></td>
				            <td>模板类型：
				            		  <select name="bid" id="buslist" >
				            		  <option value=''>全部</option>
										<c:forEach items="${blist}" var="stu">
											<option value='${stu.id}'>${stu.name}</option>
										</c:forEach>
									  </select>
				            </td>
				            <input name="departmentid" type="hidden"/>
				            <td width="60px" align="right"><a href="javascript:void(0)" onclick="searchuser2();" class="easyui-linkbutton" iconCls="icon-search">查询</a></td>
				            <td width="60px" align="right"><a href="javascript:void(0)" onclick="exportusermm();" class="easyui-linkbutton" iconCls="icon-save">导出</a></td>
				            <!-- <td width="60px" align="right"><a href="#" onclick="clearForm();" class="easyui-linkbutton" iconCls="icon-search">清空</a></td> -->
							<td width="100px" align="right"></td>
				        </tr>
				</table>
	</form>
					<div>
						<table id="userlist2" data-options="border:false">
						</table>
					</div>
</div>
<div id="dlg-buttons2">
    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="javascript:$('#addsource2').dialog('close')"
       iconcls="icon-cancel">关闭</a>
</div>


<div id="addsource3" class="easyui-dialog" style="width: 1000px; height: 420px; padding: 10px 20px;"
     closed="true" buttons="#dlg-buttons3" data-options="iconCls:'icon-save',resizable:true,modal:true">
    <form id="queryuser3Form" action="dpstats/exuserups" style="margin:10;text-align: center;">
		     	<table width="100%">
				        <tr>
				            <td>开始时间: <input class="easyui-datebox" value="${startTime}" name="startTime" style="width:100px"/></td>
				            <td>结束时间: <input class="easyui-datebox" value="${endTime}" name="endTime" style="width:100px"/>
				            <td>通道：<select name="channelId" id="chllist" >
				            			<option value=''>全部</option>
										<c:forEach items="${cclist}" var="stu">
											<option value='${stu.channelId}'>${stu.channelName}</option>
										</c:forEach>
									  </select></td>
				            <td>模板类型：
				            		  <select name="bid" id="buslist" >
				            		  <option value=''>全部</option>
										<c:forEach items="${blist}" var="stu">
											<option value='${stu.id}'>${stu.name}</option>
										</c:forEach>
									  </select>
				            </td>
				            <input name="departmentid" type="hidden"/>
				            <td width="60px" align="right"><a href="javascript:void(0)" onclick="searchuser3();" class="easyui-linkbutton" iconCls="icon-search">查询</a></td>
				            <td width="60px" align="right"><a href="javascript:void(0)" onclick="exportuserup();" class="easyui-linkbutton" iconCls="icon-save">导出</a></td>
				            <!-- <td width="60px" align="right"><a href="#" onclick="clearForm();" class="easyui-linkbutton" iconCls="icon-search">清空</a></td> -->
							<td width="100px" align="right"></td>
				        </tr>
				</table>
	</form>
    <div>
        <table id="userlist3" data-options="border:false">
		</table>
    </div>
    
</div>
<div id="dlg-buttons3">
	<a href="javascript:void(0)" class="easyui-linkbutton" onclick="javascript:$('#addsource3').dialog('close')"
       iconcls="icon-cancel">关闭</a>
    <!-- <a href="javascript:void(0)" class="easyui-linkbutton" onclick="sharegro()" iconcls="icon-save">共享</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="cancel()" iconcls="icon-cancel">取消</a> -->
</div>

</body>
</html>
