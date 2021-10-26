<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<h1>
			List of hobbies
		</h1>
		<ul>
			<c:forEach var = "hobby" items = "${hobbyList}">
				<li>
					<c:out value = "${hobby.getName()}" > </c:out>
				</li>
			</c:forEach>
		</ul>
	
	</body>
</html>