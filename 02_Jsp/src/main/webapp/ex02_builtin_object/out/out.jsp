<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String[] seasons = {"spring", "summer", "autumn", "winter"};
	%>
	<ul>
		<% for(int i = 0; i < seasons.length; i++) { %>
				<li><%=seasons[i]%></li>
		<% } %>
	</ul>
	<%-- out 객체 활용하기(3번째 jsp 내장 객체) --%><hr>
	<ul>
		<%
			for(int i = 0; i < seasons.length; i++) {
				out.println("<li>" + seasons[i] + "</li>");
			}
		%>
	</ul>
</body>
</html>