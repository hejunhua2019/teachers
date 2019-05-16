<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  %>
<%@ taglib uri="/WEB-INF/tld/sitemesh-decorator.tld" prefix="decorator"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://yajiaotong.com.cn/jstl/wface" prefix="wface" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<% 
	String path = request.getContextPath(); 
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"; 
%> 
<base href="<%=basePath%>" />

<!-- <title>非标车辆管理系统</title> -->
<title></title>
<!-- 
<link type="image/x-icon" rel="shortcut icon" href="images/favicon.ico">
-->
<link href="css/style.css" rel="stylesheet" type="text/css" />
<%@ include file="/main/headimport.jsp"%>

<script type="text/javascript">
/* $(document).ready(function() { 
	var _leftDiv=$("#iframe_left_div");
	var _rightDiv=$("#if
			
			rame_right_div");
    $("#iframe_right_div").css("height",(_leftDiv.height()-2)+"px");
    var _windowWidth=$(document).width();
   // jQuery("#iframe_right_div").css("width", (_windowWidth-(_leftDiv.width())-5)+"px");
}); */
</script>
<decorator:head />  <!-- sitemesh 装饰头部 -->
</head>

<body>
<%-- <div class="header">
       <!--***************logo***********************-->
       <div class="h_left">
           <a href="javascript:void(0)"><img src="images/ui-header.png" size="30px"/></a><font style="font-size:38px;font-weight:bold;margin-left:-80px;font-family:"微软雅黑";">非标车辆管理系统</font>
           <div class="clear"></div> <!--清除浮动，勿删***********************-->
       </div>
       <div class="h_right">
           <p class="h_icon">欢迎您，${uname }</p><p><a href="login/logout">[退出]</a></p>
       </div>
       <!--清除浮动，勿删***********************-->
       <div class="clear"></div>

</div> --%>
<!--***************mian***********************-->
<%-- <div class="mian">
     <div class="m_left" id="iframe_left_div" >
                    <div class="nav_tiele">
                    <c:forEach var="item" items="${ fList}">
				   		<!-- 判断用户是否包含该一级菜单的权限 -->
					   <c:if test="${wface:contains(upList,item['id']) }">
					    	<h2><a href="${item['url'] }" class="m_fixed">${item['name'] }<i></i></a></h2>
					    	<!-- 遍历一级菜单对应的二级菜单 -->
					    	<ul class="m_fixed_ul">
							<div title="${item['name'] }" data-options="collapsed:false,collapsible:false" style="text-align:center;overflow-x:hidden;">
								
						 			 <c:forEach var="titem" items="${ sMap[item['id']]}">
						 			 	<c:if test="${titem['needjdmsecondmenu']==0 }">
						 			 		<div style="border-bottom:1px solid #E8F1FF"><a href="${titem.url }" class="easyui-linkbutton" data-options="plain:true" style="width:100%;">${titem.name }</a></div>
						 			 		 <li 
						 			 		 
						 			 		 <c:if test="${currentUrl == titem.url }">
						 			 		 
						 			 		 class="current_url"
						 			 		 
						 			 		 </c:if>
						 			 		 
						 			 		 ><a href="${titem.url }">${titem.name }</a></li>
						 			 	</c:if>
						 			 	<c:if test="${titem['needjdmsecondmenu']==1 && wface:contains(upList, titem['id'])}">
						 			 		<div style="border-bottom:1px solid #E8F1FF"><a href="${titem.url }" class="easyui-linkbutton" data-options="plain:true" style="width:100%;">${titem.name }</a></div>
						 			 		<li
						 			 		
						 			 		 <c:if test="${currentUrl == titem.url }">
						 			 		 
						 			 		 class="current_url"
						 			 		 
						 			 		 </c:if>
						 			 		
						 			 		><a href="${titem.url }">${titem.name }</a></li>
						 			 	</c:if>
						 			 </c:forEach>
						 	</ul>
					   </c:if>
				   	</c:forEach>
                    
                    </div>
               </div>          --%>
      <div class="m_right" >
	     <decorator:body />	 
     </div> 
     <!--清除浮动，勿删***********************-->
     <div class="clear"></div>
     
</div>
<!-- <div class="new-footer">
	<div class="new-footer">
		<div class="new-footer-cen">Copyright © 2016 All Rights Reserved　版权所有·江西永安交通设施集团　备案号：赣ICP备11002902号-1 <img src="images/beian.png" width="35px" style="margin-bottom: -10px;"></img></div>
	</div>
</div> -->
</body>
</html>
