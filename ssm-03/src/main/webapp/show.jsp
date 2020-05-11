<%@ page language="java" contentType="text/html; charset=utf-8"
		 pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<html>
<head>
	<title>Insert title here</title>
	<script src = "time/My97DatePicker/WdatePicker.js"></script>
	<link href="time/My97DatePicker/skin/WdatePicker.css" rel="stylesheet" type="text/css">
</head>
<body>
<form action="${pageContext.request.contextPath}/find.action">
	用户名：<input name="user_name">
	用户状态:<input name="user_state">
	用户手机号:<input name="userDetails.user_phone">
	时间：<input type="text" name="user_time" class="Wdate" onClick="WdatePicker()">
	<button>搜索</button>
</form>

<form action="edit.action">
	<table>
		<thead>
		<tr>
			<th>用户id</th>
			<th>用户名</th>
			<th>用户状态</th>
		</tr>
		</thead>
		<tbody>
		<c:forEach items="${user}" var="users">
			<tr>
				<td>${users.user_id}</td>
				<td>${users.user_name }</td>
				<td>${users.user_state }</td>
				<td><input type="checkbox" name="ids" value="${users.user_id}"></td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<button>编辑</button>
</form>
</body>
</html>