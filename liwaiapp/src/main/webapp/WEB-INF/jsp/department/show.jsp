<%@ page language="java" contentType="text/html; charset=UTF-8"
	isELIgnored="false" pageEncoding="UTF-8"%>
<%@include file="/inc/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>部门详细</title>
</head>
<body>
	<s:debug />
	部门名称：${department.name}
	<a href="dep_list">返回列表</a>
	<br> 收件部门：
	<s:if test="depScopes.size() < 1">
			无
		</s:if>
	<s:else>
		<s:iterator value="depScopes">
			${scopeDep.name}
		</s:iterator>
	</s:else>

</body>
</html>