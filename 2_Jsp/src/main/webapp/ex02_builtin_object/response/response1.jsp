<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- 2번째 jsp내장객체(총 9개가 있다.) --%>
	<%
		response.sendRedirect(request.getContextPath() + "/ex02_builtin_object/response/response2.jsp");
	%>
</body>
</html>