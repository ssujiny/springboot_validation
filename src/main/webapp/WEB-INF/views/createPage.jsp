<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>createPage</title>
</head>
<body>
	createPage.jsp
	<br />
	
	<%
		String conPath = request.getContextPath();
	%>
	
	<form action="<%=conPath%>/create">
		작성자 : <input type="text" name="writer" value="${dto.writer}" /> <br />
		내용 : <input type="text" name="content" value="${dto.content}" /> <br />
		<input type="submit" value="전송" /> <br />
	</form>
</body>
</html>