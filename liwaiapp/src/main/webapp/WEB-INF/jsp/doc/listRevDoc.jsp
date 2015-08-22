<%@ page language="java" contentType="text/html; charset=UTF-8" isErrorPage="false"
	isELIgnored="false" pageEncoding="UTF-8"%>
<%@include file="/inc/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>公文收件箱</title>
</head>
<body>
	<div align="center">
		<form action="">
			标题或内容：<s:textfield name="param"/>
			<input type="submit" value="检索"/>
		</form>
		<a href="doc_listRevDoc?isRead=0">未读公文</a>
		<a href="doc_listRevDoc?isRead=1">已读公文</a>
	</div>
	<div>
		<table align="center" width="800px" class="ct" cellpadding="0px"
			cellspacing="0px">
			<tr>
				<td>公文标题</td>
				<td>创建时间</td>
				<td>发件人</td>
				<td>操作</td>
			</tr>
			<s:iterator value="#page.datas">
				<tr>
					<td><a href="doc_showDoc?id=${id}">${title}</a></td>
					<td><s:date name="credate" format="yyyy-MM-dd hh:mm"/></td>
					<td>${user.username}[${user.department.name}]</td>
					<td></td>
				</tr>
			</s:iterator>
			<tr>
				<td colspan="7"><jsp:include page="/inc/pager.jsp">
						<jsp:param value="doc_listRevDoc" name="url" />
						<jsp:param value="${pager.totalPageRecord }" name="items" />
						<jsp:param value="param" name="params" />
					</jsp:include></td>
			</tr>
		</table>
	</div>
</body>
</html>