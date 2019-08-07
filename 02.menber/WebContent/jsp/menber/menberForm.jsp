<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta  charset="utf-8">
<title>회원 관리 </title>
	<!-- bootstrap 준비완료 -->
	<meta name="viewport" content="width=device-width, initial-scale=1">
  	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
	<body>
		<h3>회원가입</h3>
		<form method="post" action="menber_save">
			ID <input type="text" name="ID"/><br />	
			PASSWORD <input type="text" name="PASSWORD"/><br />
			name <input type="text" name="name"/><br />	
			gemder<br/>
			<select name= gender>
			<option value= "남" class="form-control" />남</option>
			<option value= "여" class="form-control" />여</option>
			</select><br />
			
			BIRTH <input type="text" class="form-control" name="BIRTH"/><br />
			<input type= "submit" value="회원가입">
		</form>
	</body>
</html>