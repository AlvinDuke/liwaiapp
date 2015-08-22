<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/inc/taglib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<script type="text/javascript">
		var fn = function(){
			var btn = document.getElementById("addAttach");
			var holder = document.getElementById("attachContainer");
			//注册按钮点击事件
			btn.onclick = function(){
				var node = "<div><input type='file' name='attachments'/><input type='button' value='删除附件' onclick='removeEle(this)'/><div/>";
				holder.innerHTML = holder.innerHTML + node;
			};
		};
		
		//删除当前这个input（file）节点
		function removeEle(obj){
			var holder = document.getElementById("attachContainer");
			holder.removeChild(obj.parentNode);
		}
		
		document.addEventListener("DOMContentLoaded", fn, false);
		
	</script>
<title>新增私信</title>
</head>
<body>
	<s:form	action="msg_add" method="post" enctype="multipart/form-data">
		<s:textfield name="title" label="标题"/>
		<input type="button" value="添加一个附件" id="addAttach"/>
		<div id="attachContainer">
			<input type="file" name="attachments"/><br>
		</div>
		<s:textarea name="content" label="内容" cols="30" rows="10"/>
		<s:checkboxlist name="selectedReceiversId" list="receiversUser" listKey="id" listValue="nickname"/>
		<s:submit value="保存"/>
	</s:form>
</body>
</html>