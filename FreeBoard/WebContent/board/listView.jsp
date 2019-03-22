<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">
	table{
		width: 800px;
		border-collapse: collapse;
	}
	table, tr, td{
		border: 1px solid black;
		text-align: center;
	}
	#title{
		width: 400px;
		
	}
	
	#first{
		background-color: #FAF4C0;
	}
</style>
<title>게시판 목록</title>
</head>
<body>

	<jsp:include page="../Header.jsp"/>
	<table>
	
	<h2>게시판 목록</h2>
		<button onclick='location.href="../index.jsp"'>메인으로가기</button>
		<c:if test="${sessionScope.member != null}">
			<button onclick='location.href="./create"'>글쓰기</button>
		</c:if>
		<c:if test="${sessionScope.member == null}">
			<button onclick='location.href="../auth/login"'>글쓰기</button>
		</c:if>
		
			<tr id='first'>
				<td>번호</td><td>작성자</td>
				<td id='title'>제목</td><td>작성일</td>
				<td>수정일</td>
			</tr>	
			<tr>
		<c:forEach var="boardDto" items="${boardList}">
				<td>${boardDto.no}</td>
				<td>${boardDto.writer}</td>
				<td><a href='./read?no=${boardDto.no}'>${boardDto.title}</a></td>
				<td>${boardDto.creDate}</td>
				<td>${boardDto.modDate}</td>
				
			</tr>
		</c:forEach>
		</table>
	<jsp:include page="../Footer.jsp"/>
</body>
</html>