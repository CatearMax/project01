<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<html>
<head>
    <title>Insert title here</title>
</head>
<body>
<form action="update.action">
    <table>
        <thead>
        <tr>
            <th>用户id</th>
            <th>用户名</th>
            <th>用户状态</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${user}" var="users" varStatus="status">
            <tr>
                <td><input name="userList[${status.index}].user_id" readonly="readonly" value="${users.user_id}"></td>
                <td><input name="userList[${status.index}].user_name" value="${users.user_name}"></td>
                <td><input name="userList[${status.index}].user_state" value="${users.user_state}"></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <button>提交更改</button>
</form>
</body>
</html>