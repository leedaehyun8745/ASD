<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<h4>상세보기</h4>
	
	<form action="benber_update" method= "post">
	<input type = "hidden" name = "no" value="${menber.no }"><br/>
	<input type = "text" name = "id" value="${menber.id }"><br/>
	<input type = "text" name = "password" value="${menber.password }"><br/>
	<input type = "text" name = "name" value="${menber.name }"><br/>
	<input type = "text" name = "gender" value="${menber.gender }"><br/>
	<input type = "text" name = "birth" value="${menber.birth }"><br/>
	<input type ="submit" value="수정">
	</form>
</body>
</html>