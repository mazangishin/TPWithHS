<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 등록</title>
</head>
<body>
	<jsp:include page="/Header.jsp"/>
	
	<h1>회원등록</h1>
	<form action="./create" method="post">
		이메일:  <input type="text" name="email"><br>
		비밀번호: <input type="password" name='password'><br>
		이름:    <input type="text" name='name'><br>
		<input type="submit" value="추가">
		<input type="reset" value="취소">
	</form>

	<jsp:include page="/Footer.jsp"/>

</body>
</html>