<%@page language="java" contentType="application/json; charset=utf-8" pageEncoding="UTF-8"%>
        <%@ page isErrorPage="true"%>
{
    "status": "${pageContext.errorData.statusCode}",
    "success": "false",
    "requestURI": "${pageContext.errorData.requestURI}",
    "message": "抱歉,发生了未知的系统异常:${pageContext.exception}",
    "cause": "<%=exception.getCause()%>"
}

