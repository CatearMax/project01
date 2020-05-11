<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Insert title here</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/login.action">
    <input name="user_name">
    <span style="color:red;">${user_nameErrors}</span>
    <br>
    <input name="user_pwd">
    <span style="color:red;">${user_pwdErrors}</span>
    <br>
    <br>
    <button>提交</button>
</form>
</body>
</html>