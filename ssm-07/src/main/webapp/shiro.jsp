<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--引入shiro的标签库 在jsp页面做细粒度权限控制--%>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="s"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <s:authenticated>
        <button>已登录显示</button>
    </s:authenticated>
    
    <s:hasRole name="超级管理员">
        <button>超级管理员显示</button>
    </s:hasRole>

    <s:hasAnyRoles name="超级管理员,次级管理员">
        <button>超级管理员 次级管理员角色显示</button>
    </s:hasAnyRoles>

    <s:hasPermission name="boss">
        <button>boss权限可见</button>
    </s:hasPermission>

    <a href="${pageContext.request.contextPath}/loginOut.action">登出</a>

</body>
</html>
