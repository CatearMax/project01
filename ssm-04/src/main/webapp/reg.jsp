<%--
  Created by IntelliJ IDEA.
  User: xiawenchao
  Date: 2020/4/16
  Time: 18:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    ${msg }

    <hr>
    默认回显
    <form action="regA.action">
        用户名：<input name="admin_name" type="text" autocomplete="off" value="${admin.admin_name}">
        密码：<input name="admin_pwd" type="password">
        <button>提交</button>
    </form>

    <hr>
    ModelAttribute设置回显
    <form action="regB.action">
        用户名：<input name="admin_name" type="text" autocomplete="off" value="${a.admin_name}">
        密码：<input name="admin_pwd" type="password">
        <button>提交</button>
    </form>

    <hr>
    Model设置回显
    <form action="regC.action">
        用户名：<input name="admin_name" type="text" autocomplete="off" value="${adminC.admin_name}">
        密码：<input name="admin_pwd" type="password">
        <button>提交</button>
    </form>
</body>
</html>
