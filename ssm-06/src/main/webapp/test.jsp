<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <script src="jquery-3.4.1.js"></script>
    <script>
        $(function () {
            $("#btn").click(function () {
               var admin_name = $("#admin_name").val();
               var admin_pwd = $("#admin_pwd").val();
               $.post("http://localhost:8888/ssm-06/loginA.action",
                   {"admin_name":admin_name,"admin_pwd":admin_pwd},
                   function (data) {
                      alert(data.flag);
                   }
               )
            });
        })
    </script>
</head>
<body>
    账号：<input id="admin_name" type="text">
    密码:<input type="password" id="admin_pwd">
    登录:<button id="btn" type="button"></button>
</body>
</html>
