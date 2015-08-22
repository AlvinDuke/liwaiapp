<%@ page language="java" contentType="text/html; charset=UTF-8"
	isELIgnored="false" pageEncoding="UTF-8"%>
<%@include file="/inc/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户详细</title>
</head>
<body>
	用户名：<s:property value="user.username"/><br>
	昵&nbsp;&nbsp;称：<s:property value="user.nickname"/><br>
	邮&nbsp;&nbsp;箱：<s:property value="user.email"/><br>
	类&nbsp;&nbsp;型：<s:if test="%{user.type ==1}">管理员<br></s:if><s:else>一般用户<br></s:else>
	部&nbsp;&nbsp;门：<s:property value="user.department.name"/>
</body>
</html>