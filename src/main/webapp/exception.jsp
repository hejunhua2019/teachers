<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<%@ page isErrorPage="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
    <title>提示信息 - Powered By SUMAVision</title>
    <meta http-equiv="expires" content="0"/>
    <meta http-equiv="Pragma" content="no-cache"/>
    <meta http-equiv="Cache-Control" content="no-cache"/>
    <meta name="author" content="SUMAVision VCM Team"/>
    <meta name="copyright" content="SumaVision"/>

</head>
<body>
<fieldset>
    <legend>系统出现异常</legend>

</fieldset>
<div>错误状态代码是：${pageContext.errorData.statusCode}</div>
<div>错误发生页面是：${pageContext.errorData.requestURI}</div>
<div>错误信息：${pageContext.exception}</div>
<div>
    错误堆栈信息：<br/>
    <c:forEach var="trace" items="${pageContext.exception.stackTrace}">
        <p>${trace}</p>
    </c:forEach>
</div>
</body>
</html>
