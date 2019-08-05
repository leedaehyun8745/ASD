<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%@taglib uri= "http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>회원정보</title>
</head>
<body>
	<h3>정보</h3>
	<c:if test="${!empty menber}">
		<table>
			<tr>
				<td>번호</td>			
				<td>아이디</td>
				<td>비밀번호</td>
				<td>이름</td>
				<td>성별</td>
				<td>생일</td>
			</tr>
			<c:forEach var="menbers" items="${menber}">
				<tr>
					<td>${menbers.no}</td>
					<td>${menbers.id}</td>
					<td>${menbers.password}</td>
					<td>${menbers.name}</td>
					<td>${menbers.gender}</td>
					<td>${menbers.birth}</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	<a href="menber_update">상세보기</a>
</body>
</html>