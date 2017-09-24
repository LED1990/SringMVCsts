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
	value from attribute added in method with @ModelAttribute: ${attrOne }</br>
	now with default atribute name value: ${paramToModelDefault}</br> <!-- doesnt work! -->
	<!--  now param value passed in GET and assigned to model via @ModelAttribute: ${withParam}</br> -->
	now example of explicit model atribute assigning: ${explicit}</br>
</body>
</html>