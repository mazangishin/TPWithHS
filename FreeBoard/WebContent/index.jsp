<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>어서오세요</title>
</head>
<body>
	<jsp:include page="./Header.jsp"/>
	<br>

	<h1>
	<a href="./auth/login">로그인</a>
	</h1>
	<br>
	<h1>
	<a href="./board/list">게시판으로 가기</a>
	</h1>
	<br>
	<h2>
	<a href="./member/create">회원가입</a>
	</h2>
	<br>
	<jsp:include page="./Footer.jsp"/>
</body>
</html>