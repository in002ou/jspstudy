<%@page import="java.util.Optional"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%-- request는 jsp에서 이미 선언이 되어있어서 선언을 하지않고 바로 사용가능(jsp 내장객체) --%>
	<%
		request.setCharacterEncoding("UTF-8");
		String model = request.getParameter("model");
		Optional<String> opt = Optional.ofNullable(request.getParameter("price"));
		int price = Integer.parseInt(opt.orElse("0"));
	%>
	
	<h1>모델 : <%=model%></h1>
	<h1>가격 : <%=price%></h1>

</body>
</html>