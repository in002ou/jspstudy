<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%--
		<c:if></c:if>
		1. if문을 대체하는 태그이다.
		2. else문이 지원되지 않는다.
		3. 형식
			<c:if test="조건식">
				실행문
			</c:if>
	 --%>
	 <c:set var="age" value="461" scope="page"></c:set>
	 <c:if test="${age <= 100}">
	 	<h1>잘살아</h1>
	 </c:if>
	 <c:if test="${age > 100}">
	 	<h1>잘죽어</h1>
	 </c:if>
	 <c:set var="score" value="101" scope="page"></c:set>
	 <c:if test="${score > 100 || score < 0}">
	 	<h1>잘못된 점수</h1>
	 </c:if>
	 <c:if test="${score >= 90 && score <= 100}">
	 	<h1>A학점</h1>
	 </c:if>
	 <c:if test="${score >= 80 && score < 90}">
	 	<h1>B학점</h1>
	 </c:if>
	 <c:if test="${score >= 70 && score < 80}">
	 	<h1>C학점</h1>
	 </c:if>
	 <c:if test="${score >= 60 && score < 70}">
	 	<h1>D학점</h1>
	 </c:if>
	 <c:if test="${score >= 0 && score < 60}">
	 	<h1>F학점</h1>
	 </c:if>
</body>
</html>