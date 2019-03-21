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
		font-size: 20px;
		font-weight: bold;
	}
	#writer{
		width: 120px;
		text-align: right;
	}
	#date{
		text-align: right;
	}
</style>
<title>Insert title here</title>
</head>
<body>
	
	<table>
		<tr><td id='title'>${boardDto.title}</td>
			<td id='writer'>${boardDto.writer}</td>
		</tr>	
		<tr>
			<td colspan='2'>${boardDto.content}</td>
		</tr>
		<tr>
			<td id='date' colspan='2'>작성일:${boardDto.creDate} 수정일:${boardDto.modDate}</td>
		</tr>
	</table>
	<button onclick='location.href="./update?no=${boardDto.no}"'>수정하기</button>
	<button onclick='location.href="./delete?no=${boardDto.no}"'>수정하기</button>
	<td><a href='./delete?no=${boardDto.no}'>[삭제]</a></td>
	
</body>
</html>