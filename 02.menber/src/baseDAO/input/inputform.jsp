<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta  charset="utf-8">
	<title>Insert title here</title>
</head>
<body>
	<h3>Input Element</h3>
	
	<!-- 전송할때 form-->
	<form method ="post" action="input01">
		<input type="text" name = "username"/>
		<input type="password" name ="password"/> <!-- 패스워드가릴때 -->
		<input type ="reset"/>
		<input type ="submit"/> 
	</form>
	
	<!-- 선택 -->
	<form method = "post" action="input_02">
		<input type="radio" name="gender" value="male">남자
		<input type="radio" name="gender" value="female">여자
		<input type="radio" name="gender" value="order">또다른사람
		<input type= "submit"/>
	
	<!-- 체크 -->
	</form>
	
	<form method = "post" action="input_03">
		<input type="checkbox" name="vehicle" value="bike">자전거
		<input type="checkbox" name="vehicle" value="Car">자동차
		<input type="checkbox" name="vehicle" value="Subway">지하철
		<input type="checkbox" name="vehicle" value="Bus">버스
			
		<input type= "submit"/>
	</form>
	
	<!-- 리스트중 선택 -->
	<form method = "post" action="select">
		<select name = car>
			<option value="volvo">Volvo</option>
			<option value="audi">Audi</option>
			<option value="bmw">Bmw</option>
		</select>
		<input type= "submit"/>
	</form>
	
	<!-- 메모 -->
	<form method = "post" action="textarea">
		<textarea name ="message" rows="10" cols="30"></textarea>	
		<input type= "submit"/>
	</form>
</body>
</html>