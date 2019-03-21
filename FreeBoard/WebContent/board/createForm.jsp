<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	#title input{
		width: 500px;
	}
</style>
<title>Insert title here</title>
</head>
<body>
<h2>글쓰기</h2>
	<form action="./create" method="post">
		<table>
			<tr>
				<td id='title'>제목:<input name='title' type="text"></td>
			</tr>	
			<tr>
				<td><textarea name='content' rows="30" cols="200"></textarea></td>
			</tr>
		</table>
		<button type="submit">등록</button>
	</form>
</body>
</html>