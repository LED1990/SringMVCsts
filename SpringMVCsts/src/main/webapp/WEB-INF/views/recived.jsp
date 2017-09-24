<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Recived data from form</h1>

	${userName}
	</br> ${userId }
	</br> ${cmodel}
	</br> ${cmark}
	
	</br>
	To find user type user name:</br>
	<form:form action="/sts/retriveUser" method="POST" >
		<input type="text" name="userName"></br>
		<input type="submit" value="FIND">
	</form:form>

</body>
</html>