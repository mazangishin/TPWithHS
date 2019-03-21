<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보 조회</title>

<script type="text/javascript">
	function backPageFnc(){
		location.href = './read';
	}
	
	function deleteUserFnc() {
		var obj = document.getElementById('no');
		
		var memberNo = obj.value;
		
		location.href = './delete?no=' + ${member.memberNo};
	}
</script>
</head>


<body>
	
	<jsp:include page="/Header.jsp"/>
	
	<h1>${member.memberName} 회원정보 조회</h1>
	<form action="./update" method="post">
		번호: <input type="text" id='no' name="no" value="${member.memberNo}" readonly="readonly"><br>
		이름: <input type="text" name='name' value="${member.memberName}"><br>
		이메일: <input type="text" name="email" value="${member.email}"><br>
		가입일: ${member.createDate}<br>
		<input type="submit" value="수정">
		<input type="button" value="삭제" onclick="deleteUserFnc();">
		<input type="button" value="뒤로가기" onclick="backPageFnc();">
	</form>

	<jsp:include page="/Footer.jsp"/>

</body>

</html>