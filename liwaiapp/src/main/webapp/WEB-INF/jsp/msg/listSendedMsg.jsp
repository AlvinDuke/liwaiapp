<%@ page language="java" contentType="text/html; charset=UTF-8" isErrorPage="false"
	isELIgnored="false" pageEncoding="UTF-8"%>
<%@include file="/inc/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>发件箱</title>
</head>
<body>
	<div align="center">
		<form action="">
			标题或内容：<s:textfield name="param"/>
			<input type="submit" value="检索"/>
		</form>
	</div>
	<div>
		<table align="center" width="800px" class="ct" cellpadding="0px"
			cellspacing="0px">
			<tr>
				<td>标题</td>
				<td>创建时间</td>
				<td>收件人</td>
				<td>操作</td>
			</tr>
			<s:iterator value="#pager.datas">
				<tr>
					<td><a href="msg_showSendedMsg?userMsgid=${id}">${msg.title}</a></td>
					<td><s:date name="msg.credate" format="yyyy-MM-dd hh:mm"/></td>
					<td>${user.username}[${user.department.name}]</td>
					<td><a href="msg_deleteSended?userMsgid=${id}">删除</a>
				</tr>
			</s:iterator>
			<tr>
				<td colspan="7"><jsp:include page="/inc/pager.jsp">
						<jsp:param value="msg_listSendedMsg" name="url" />
						<jsp:param value="${pager.totalPageRecord }" name="items" />
						<jsp:param value="param" name="params" />
					</jsp:include></td>
			</tr>
		</table>
	</div>
</body>
</html>