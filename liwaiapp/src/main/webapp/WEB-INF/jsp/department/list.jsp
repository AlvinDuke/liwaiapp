<%@ page language="java" contentType="text/html; charset=UTF-8"
	isELIgnored="false" pageEncoding="UTF-8"%>
<%@include file="/inc/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>


<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>部门列表</title>
</head>
<body>

	部门列表
	<div>
		<table align="center" width="800px" class="ct" cellpadding="0px"
			cellspacing="0px">
			<tr>
				<td>部门ID</td>
				<td>部门名称</td>
				<td>操作</td>
			</tr>
			<s:iterator value="#ds" var="dep">
				<tr>
					<td><s:property value="id" /></td>
					<td><a href="dep_show?id=${id}"><s:property value="name" /></a></td>
					<td>操作:<a href="dep_updateInput?id=${id}">更新</a>&nbsp;&nbsp;<a href="dep_delete?id=${id}">删除</a>
				</tr>
			</s:iterator>
		</table>
	</div>
</body>
</html>