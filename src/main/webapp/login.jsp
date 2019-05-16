<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>非标车辆管理系统</title>
<link rel="stylesheet" type="text/css" href="css/style.css" />
<link rel="stylesheet" type="text/css" href="css/default.css" >
<link rel="stylesheet" type="text/css" href="js/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="js/themes/icon.css">
<link rel="icon" href="images/favicon.ico" type="image/x-icon">
<link rel="shortcut icon" href="images/favicon.png" type="image/x-icon">
<!-- 
<link type="image/x-icon" rel="shortcut icon" href="images/favicon.ico">
 -->
<script type="text/javascript" src="js/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="js/jquery.easyui.min.js" ></script>
<script type="text/javascript" src="js/easyui-lang-zh_CN.js" ></script>
<script type="text/javascript" src="js/main.js"></script> 
<script type="text/javascript" src="js/jquery.cookie.js"></script>
<script type="text/javascript">


 jQuery(function(){
	//获取cookie的值
		var name=$.cookie('lname');
		//取值如果存在则赋值
		$("#loginName").val(name);
		 if($("#loginName").val()=='undefind'){
			$("#loginName").val('');
		} 
		/* if(name==undefind){
			$("#loginName").val('');
		} */
   if (name!=null && name!=''){
	   $("#remember").attr('checked',true);
   }
	/*
	$("#captcha").keyup(function(event){
        if(event.keyCode == 13){
            clickButton();
        }
    }); 
	*/
}) 

  function clickButton(){
	  
	  if($('#remember').attr('checked') == true){//保存密码
		$.cookie('lname',$('#loginName').val(), {expires:7,path:'/'});
		var name = $.cookie('lname');
		  }else {
			  $.cookie('lname', '', { expires: -1, path: '/' });
	  }  
	
  $.ajax({
      url: 'login/loginAjax',
      data: getFormJson( '#myform'),
      type: "post",
      dataType: "json",
      //beforeSend: function(){
      // return $( '#myform').form('enableValidation').form( 'validate');
      //},
      success: function (result){
          if (result["result"]== "success"){
        	  location.href="index/welcome";
          } else {
              showMessage( "提示",result["message"]);
              clickimg();
          }
      }
  });
  }

  function clickimg(){ 
	  var myimg=document.getElementById("mycaptchaimg");
	  myimg.src='captcha/create?d='+new Date();
  }
  </script>

</head>

<body>
<!--logo***********************-->
<div class="login_header">
         <!--logo***********************-->
         <div class="login_left"><a href="#"><img src="images/ui-header.png" /></a></div>
         <!-- <div class="login_right"></div> -->
         <font style="font-size:40px;font-weight:bold;margin-left:-80px;font-family:"微软雅黑";">非标车辆管理系统<font/>
         <div class="clear"></div><!--清除浮动,误删*********************************-->
</div>
<div class="clear"></div>

<!--login_mian***********************-->
<div class="login_mian">
	<form action="" method="post" id="myform">
	
	      <div class="lm_left"><img src="images/login_01.png"/></div>
	      <div class="lm_right">
	           <p><input type="text" id="loginName" name="loginName" class="login_name"  /></p>
	           <p><input type="password" name="loginPassword" class="login_password"   /></p>
	           <!-- 
	           <p><input type="text" id="captcha" name="captcha" class="login_verification" value ="请输入验证码" onfocus="if(value=='请输入验证码') {value=''}"  onblur="if (value=='') {value='请输入验证码'}" /><a href="javascript:clickimg()" class="verification_right"><img src="captcha/create" id="mycaptchaimg"/></a></p>
	            -->
	           <p class="login_registered" style="margin-left:0px;"><label><input type="checkbox" class="login_radio" id="remember" name="remember" />记住账号</label><!-- <a href="regist/manage">注册</a> --></p>
	       <div class="clear"></div><!--清除浮动,误删*********************************-->
	       
	       
	       <!--登录按钮*********************************-->
	       <div class="login_button"><a href="javascript:clickButton()" >登录</a></div>
	      </div>
	      <div class="clear"></div><!--清除浮动,误删*********************************-->
	</form>
</div>

<!--login_footer***********************-->
<div class="login_footer">Copyright © 2016 All Rights Reserved　版权所有·江西永安交通设施集团　备案号：赣ICP备11002902号-1　<img src="images/beian.png" width="35px" style="margin-bottom: -10px;"></img></div>
</body>
</html>
