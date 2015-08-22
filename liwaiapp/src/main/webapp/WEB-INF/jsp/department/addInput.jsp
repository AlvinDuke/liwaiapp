<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/inc/taglib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>部门新增</title>
</head>
<body>
	<s:form	action="dep_add" method="post">
		<s:textfield name="name" label="部门名称"/>
		<s:checkboxlist name="curSelDepScopes" list="departments" listKey="id" listValue="name" value="#selectedDepScopes"/>
		<s:submit value="保存"/>
	</s:form>
</body>
</html>