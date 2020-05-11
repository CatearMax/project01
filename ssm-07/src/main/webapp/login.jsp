<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Insert title here</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/login.action" method="post">
    <input name="admin_name" autocomplete = "off">

    <input name="admin_pwd" type="password">

    <button>提交</button>
    <a href="${pageContext.request.contextPath}/shiro.jsp">细粒度权限控制</a>
    ${error}
</form>
</body>
</html>