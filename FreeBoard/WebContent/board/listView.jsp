<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">
	table{
		width: 600px;
		border-collapse: collapse;
	}
	table, tr, td{
		border: 1px solid black;
	}

</style>
<title>Insert title here</title>
</head>
<body>
<table>
<h2>게시판 목록</h2>
	<button onclick='location.href="./create"'>글쓰기</button>
		<tr>
			<td id='no'>번호</td><td>작성자</td>
			<td>제목</td><td>작성일</td>
			<td>수정일</td><td></td>
		</tr>	
		<tr>
	<c:forEach var="boardDto" items="${boardList}">
			<td>${boardDto.no}</td>
			<td>${boardDto.writer}</td>
			<td><a href='./read?no=${boardDto.no}'>${boardDto.title}</a></td>
			<td>${boardDto.creDate}</td>
			<td>${boardDto.modDate}</td>
			<td><a href='./delete?no=${boardDto.no}'>[삭제]</a></td>
		</tr>
	</c:forEach>
	</table>
</body>
</html>