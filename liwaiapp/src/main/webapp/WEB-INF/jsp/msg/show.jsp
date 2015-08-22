<%@ page language="java" contentType="text/html; charset=UTF-8"
	isELIgnored="false" pageEncoding="UTF-8"%>
<%@include file="/inc/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${message.title }</title>
</head>
<body>
发件人：<s:property value="message.user.username"/>
	于<s:date name="message.credate" format="yyyy-MM-dd hh:mm"/>发送<br/>
	<s:if test="#attachs.size > 0">
		附件：
		<s:iterator value="#attachs">
		${newname}
			<a href="<%=request.getContextPath()%>/upload/${newname}.${type}">${oldname}</a><br>
		</s:iterator>
	</s:if>
	<s:textarea name="message.content" label="内容" rows="10" cols="30"/>
</body>
</html>