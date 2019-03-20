<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">
	table {
		border-collapse: collapse;
	}
	table, tr, td{
		border: 5px solid lemonchiffon;
		background-color: lightsalmon; 
	}
</style>
<title>회원 정보 페이지</title>
</head>
<body>
	<jsp:include page="/Header.jsp" />
	
	<h1>회원 정보</h1>
	<div>
		<table>
			<tr>
				<td>회원 번호</td>
				<td>${member.memberNo}</td>
				<td></td>
			</tr>
			<tr>
				<td>회원 이름</td>
				<td>${member.memberName}</td>
				<td></td>
			</tr>
			<tr>
				<td>이메일</td>
				<td>${member.email}</td>
				<td></td>
			</tr>
			<tr>
				<td>가입일</td>
				<td>${member.createDate}</td>
				<td></td>
			</tr>
		</table><br>
		
		<a href='./login'>돌아가기</a>
		<a href='./update?no=${member.memberNo}'>수정</a>
		<a href='./delete?no=${member.memberNo}'>삭제</a>
	</div>
	<jsp:include page="/Footer.jsp" />
	
</body>
</html>