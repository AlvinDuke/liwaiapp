<%@ page language="java" contentType="text/html; charset=UTF-8"
	isELIgnored="false" pageEncoding="UTF-8"%>
<%@include file="/inc/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link type="text/css" rel="stylesheet"
	href="<%=request.getContextPath()%>/css/dep/deplist.css">

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户列表</title>
</head>
<body>
	<div>
		<table align="center" width="800px" class="ct" cellpadding="-10px"
			cellspacing="0px">
			<tr>
				<td colspan="6">
					<form action="user_list">
						<s:select name="searchDep" list="#ds" listKey="id" listValue="name" headerKey="0" headerValue="所有部门" theme="simple"/>
						<s:submit value="查询" theme="simple"/>
					</form>
				</td>
			
			</tr>
			<tr>
				<td>用户名</td>
				<td>昵称</td>
				<td>邮箱</td>
				<td>类别</td>
				<td>所在部门</td>
				<td>操作</td>
			</tr>
			<s:iterator value="#pager.datas" var="u">
				<tr>
					<td><a href="user_show?id=<s:property value="id" />"><s:property value="username" /></a></td>
					<td><s:property value="nickname" /></td>
					<td><s:property value="email" /></td>
					<td>
						<s:if test="%{type == 1}">
							管理员
						</s:if>
						<s:else>
							一般用户
						</s:else>
					</td>
					<td><s:property value="department.name" /></td>
					<td><a href="user_updateInput?id=<s:property value="id"/>">更新</a>&nbsp;&nbsp;<a href="user_del?id=<s:property value="id"/>">删除</a></td>
				</tr>
			</s:iterator>
			<tr>
				<td colspan="7"><jsp:include page="/inc/pager.jsp">
						<jsp:param value="user_list.action" name="url" />
						<jsp:param value="${pager.totalPageRecord }" name="items" />
						<jsp:param value="searchDep" name="params" />
					</jsp:include></td>
			</tr>
		</table>
	</div>
</body>
</html>