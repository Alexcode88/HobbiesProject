<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %>   
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Hobbies page</title>
	</head>
	<body>
		<h1>
			List of hobbies
		</h1>
		<ul>
			<c:forEach var="hobby" items="${hobbyList}">
				<li>
					<div>
						<c:out value="${hobby.getName()}" > </c:out>
					</div>
					<ul>
						<c:forEach var="user" items="${hobby.getUsers()}">
							<li>
								<c:out value="${user.getFirstname()}"></c:out>
								<c:out value="${user.getLastname()}"></c:out>
							</li>
						</c:forEach>
					</ul>
				</li>
			</c:forEach>
		</ul>
		<form method="POST" action="/hobbies/update" >
			<div>
				<label for="identifier">
					Hobby id to update:
				</label>
				<input type="number" id="identifier" name="identifier" />
			</div>
			<div>
				<label for="name">
					New hobby name:
				</label>
				<input type="text" id="name" name="name" />
			</div>
			<button type="submit">
				Update hobby
			</button>
		</form>
		<form:form method="POST" action="/hobbies/create" modelAttribute="hobby">
			<div>
				<form:label path="identifier">
					Hobby id to create:
				</form:label>
				<form:errors path="identifier"/>
				<form:input type="number" path="identifier"/>
			</div>
			<div>
				<form:label path="name">
					New hobby name:
				</form:label>
				<form:errors path="name"/>
				<form:input type="text" path="name" />
			</div>
			<button type="submit">
				Create hobby
			</button>
		</form:form>
		
		<div>
			<c:out value="${errorMessage}"></c:out>
		</div>
	</body>
</html>