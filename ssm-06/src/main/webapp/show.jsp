<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <script type="text/javascript" src="jquery-3.4.1.js"></script>
    <title>Title</title>
    <script type="text/javascript">
        $(function () {
            $("#first").click(function () {
                //取得当前页码和长度
                var pageNum = $(this).attr("pageNum");
                var pageSize = $(this).attr("pageSize");
                if(pageNum == 1) {
                    alert("已经是第一页");
                    return;
                }
                //改变页码
                pageNum = pageNum-pageSize;
                $.post("http://localhost:8888/ssm-06/getPageB.action?",
                    {"startPage":pageNum,"pageSize":pageSize});
            });
        });
    </script>
</head>
<body>
<table border="1">
    <thead>
    <tr>
        <th>id</th>
        <th>名字</th>
        <th>角色</th>
    </tr>
    </thead>
    <tbody>
        <c:forEach items="${pageInfo.list}" var="pageInfo" varStatus="i">
            <tr>
                <td>${pageInfo.admin_id}</td>
                <td>${pageInfo.admin_name}</td>
                <td>${pageInfo.admin_role}</td>
            </tr>
        </c:forEach>
    </tbody>
</table>
<button id="first" pageNum = "${pageInfo.pageNum}" pageSize = "${pageInfo.pageSize}">上一页</button>
<button id="next"  pageNum = "${pageInfo.pageNum}" pageSize = "${pageInfo.pageSize}">下一页</button>
</body>
</html>
