<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">
	table{
		width: 500px;
		border-collapse: collapse;
	}
	
	table, tr, td{
		border: 1px solid black;
	}
	
	#no input{
		width: 50px;
	}
	
	#no{
		width: 55px;
	}

	#title input{
		width: 400px;
	}

</style>
<title>게시글 수정</title>
</head>
<h2>수정하기</h2>
<body>
	<form action="./update" method="post">
		<table>
			<tr>
				<td id='no'><input name='no' value='${boardDto.no}' readonly></td>
				<td id='title'>제목:<input name='title' type="text" value="${boardDto.title}"></td>
			</tr>	
			<tr>
				<td colspan='2'><textarea name='content' rows="30" cols="200">${boardDto.content}</textarea></td>
			</tr>
		</table>
		<input type="submit" value='수정'>
	</form>
</body>
</html>