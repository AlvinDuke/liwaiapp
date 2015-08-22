<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/inc/taglib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户新增</title>
</head>
<body>
	<s:form	action="user_add" method="post">
		<s:textfield name="username" label="用户名"/>
		<s:textfield name="nickname" label="昵    称"/>
		<s:textfield name="email" label="邮    箱"/>
		<s:radio name="type" list="#{'1':'管理员','0':'用户'}" label="类    型"/>
		<s:select list="#ds" listKey="id" listValue="name" label="部    门" name="depBelongs"/>
		<s:submit value="保存"/>
	</s:form>
</body>
</html>