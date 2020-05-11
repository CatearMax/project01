<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <script type="text/javascript" src="jquery-3.4.1.js"></script>
    <title>Title</title>
    <script type="text/javascript">
        $(function () {
            $("#btn").click(function () {
                var admin_name = $("#admin_name").val();
                var admin_pwd = $("#admin_pwd").val();
                $.post("http://localhost:8888/ssm-06/loginA.action",
                    {"admin_name":admin_name,"admin_pwd":admin_pwd},
                    function (data) {
                    alert(data.flag);
                        if (data.flag == 0) {
                            window.location = "//index.jsp";
                        } else {
                            alert("账号或者密码错误");
                        }
                    }
                );
            });
        });
    </script>
</head>
<body>
            姓名：<input id="admin_name" type="text" autocomplete="off" name="admin_name">
            密码：<input id="admin_pwd" type="password" name="admin_pwd">
            <button id="btn" >登录</button>
</body>
</html>
