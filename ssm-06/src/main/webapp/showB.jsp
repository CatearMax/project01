<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div id="vue">
        <table border="1">
            <thead>
            <tr>
                <th>id</th>
                <th>名字</th>
                <th>角色</th>
            </tr>
            </thead>
            <tbody>
                <tr v-for="pageInfoA in pageInfo.list">
                    <td>111</td>
                    <td>{{pageInfoA.admin_id}}</td>
                    <td>{{pageInfoA.admin_name}}</td>
                    <td>{{pageInfoA.admin_role}}</td>
                </tr>
            </tbody>
        </table>
        <button id="first" pageNum = "${pageInfo.pageNum}" pageSize = "${pageInfo.pageSize}">上一页</button>
        <button id="next"  pageNum = "${pageInfo.pageNum}" pageSize = "${pageInfo.pageSize}">下一页</button>
</div>
</body>
<script type="text/javascript" src="jquery-3.4.1.js"></script>
<script src="vue.js"></script>
<script src = "page.js"></script>
</html>
