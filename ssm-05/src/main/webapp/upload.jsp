<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	<form action="upload.action" method="post" enctype="multipart/form-data">
		<input type="file" name="userFile">
		
		<button>提交</button>
	</form>
</body>
</html>