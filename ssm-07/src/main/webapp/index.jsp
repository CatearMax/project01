<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<html>
<body>
<h2>Hello World!</h2>
hey ${sessionScope.admin.admin_name}

<a href="${pageContext.request.contextPath}/showUsers.action">点击</a>
<a href="${pageContext.request.contextPath}/shiro.jsp">细粒度权限控制</a>
</body>
</html>
