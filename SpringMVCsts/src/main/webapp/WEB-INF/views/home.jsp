<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  Type needed data </P>
<form:form action="/sts/recived" method="POST" modelAttribute="mName">

<form:label path="name">NAME</form:label>
<form:input path="name"/>
</br>

<form:label path="id">ID</form:label>
<form:input path="id"/>
</br>

<form:label path="carModel.model">Car model</form:label>
<form:input path="carModel.model"/>
</br>

<form:label path="carModel.mark">Car mark</form:label>
<form:input path="carModel.mark"/>
</br>

<input type="submit" value="ADD"/>

</form:form>

</body>
</html>
