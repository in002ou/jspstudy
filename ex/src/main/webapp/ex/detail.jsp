<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	function fnList(){
		location.href = '${contextPath}/list.do';
	}
	function fnRemove() {
		if(confirm('삭제할까여?')){
		location.href = '${contextPath}/delete.do?exNo=${ex.exNo}';
		}
	}
</script>
</head>
<body>
			<div>${ex.exNo}</div>
			<div>${ex.exContent}</div>
			<div>${ex.exCreatedAt}</div>
			<div>
				<input type="button" onclick="fnList()" value="목록">
				<input type="button" onclick="fnModify(${ex.exNo})" value="수정">
				<input type="button" value="삭제" onclick="fnRemove()"> 
			</div>
			
</body>
</html>