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
	table, tr{
		border: 1px solid black;
	}
	#title{
		font-size: 27px;
		font-weight: bold;
	}
	
	#date{
		text-align: right;
	}
	
</style>
<title>게시글 보기</title>
</head>
<body>
	<h2>게시글 보기</h2>
	<table>
		<tr>
			<td id='title' colspan="2">${boardDto.title}</td>
			
		</tr>	
		<tr>
			<td colspan='2'><textarea name='content' rows="30" cols="200" readonly>${boardDto.content}</textarea></td>
		</tr>
		<tr>
			<td id='writer'>작성자: ${boardDto.writer}</td>
			<td id='date'>작성일:${boardDto.creDate} 수정일:${boardDto.modDate}</td>
		</tr>
	</table>
	<button onclick='location.href="./list"'>목록보기</button>
	<c:if test="${sessionScope.member.email eq boardDto.writer}">
		<button onclick='location.href="./update?no=${boardDto.no}"'>수정</button>
		<button onclick='location.href="./delete?no=${boardDto.no}"'>삭제</button>
	</c:if>
	
</body>
</html>