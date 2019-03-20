<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div style="background-color: #ffa500; color: #ffffff; 
	height: 20px; padding: 5px;">

	조원 : 김준혁, 조혜선
	<span style="float:right;">
		<c:if test="${sessionScope.member == null}">
			게스트1
			<a href="<%=request.getContextPath()%>/auth/logout"	style="color:white;">
				나가기
			</a>
		</c:if>
		<c:if test="${sessionScope.member != null}">
			${sessionScope.member.memberName}
			<a href="<%=request.getContextPath()%>/auth/logout"	style="color:white;">
				로그아웃
			</a>
		</c:if>
	</span>

</div>