<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false"
    pageEncoding="UTF-8"%>
<%@taglib prefix="decorator"  uri="http://www.opensymphony.com/sitemesh/decorator"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link type="text/css" rel="stylesheet"
	href="<%=request.getContextPath()%>/css/dep/deplist.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><decorator:title/></title>
<decorator:head/>
</head>
<body>

<!-- 用户登陆的情况下 -->
<s:if test="#session.loginUser != null">
	欢迎[${session.loginUser.nickname}]登录系统，你可以：
	<a href="<%=request.getContextPath()%>/dep/dep_addInput">添加部门</a>
	<a href="<%=request.getContextPath()%>/user/user_addInput">添加用户</a>
	<a href="<%=request.getContextPath()%>/user/user_updateInput?user.id=${session.loginUser.id}">修改个人信息</a>
	<a href="<%=request.getContextPath()%>/msg/msg_addInput">新建私信</a>
	<a href="<%=request.getContextPath()%>/msg/msg_listRevMsg">查看收件箱</a>
	<a href="<%=request.getContextPath()%>/msg/msg_listSendedMsg">查看发件箱</a>
	<a href="<%=request.getContextPath()%>/doc/doc_addInput">新建公文</a>
	<a href="<%=request.getContextPath()%>/doc/doc_listRevDoc">查看收到公文</a>
	<a href="<%=request.getContextPath()%>/doc/doc_listSendedDoc">查看已发公文</a>
	<a href="<%=request.getContextPath()%>/logout">退出登录</a>
</s:if>


<hr>
<h1 align="center"><decorator:title/></h1>
<decorator:body/>
<hr>
</body>
</html>