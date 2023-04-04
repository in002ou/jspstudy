<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- jsp내장객체 --%>
<%-- 고유 아이디인 세션 아이디는 브라우저를 껏다 켜면 재생성되며, 이를 db에 저장하여 자동로그인 구현을 할 수 있다. db에 저장한 것과 쿠키에 저장한 값을 대조하여 자동 로그인 --%>
	<%
		String sessionId = session.getId();
	%>
	<h1><%=sessionId%></h1>
</body>
</html>