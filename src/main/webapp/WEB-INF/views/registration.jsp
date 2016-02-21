<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Company Registration Form</title>

<style>

	.error {
		color: #ff0000;
	}
</style>

</head>

<body>

	<h2>Registration Form</h2>
 
	<form:form method="POST" modelAttribute="company">
		<form:input type="hidden" path="companyId" id="companyId"/>
		<table>
			<tr>
				<td><label for="name">Name: </label> </td>
				<td><form:input path="name" id="name"/></td>
				<td><form:errors path="name" cssClass="error"/></td>
		    </tr>
	    
			<tr>
				<td><label for="address">Address: </label> </td>
				<td><form:input path="address" id="address"/></td>
				<td><form:errors path="address" cssClass="error"/></td>
		    </tr>
	
			<tr>
				<td><label for="city">City: </label> </td>
				<td><form:input path="city" id="city"/></td>
				<td><form:errors path="city" cssClass="error"/></td>
		    </tr>
	
			<tr>
				<td><label for="country">Country: </label> </td>
				<td><form:input path="country" id="country"/></td>
				<td><form:errors path="country" cssClass="error"/></td>
		    </tr>
	
			<tr>
				<td colspan="3">
					
							<input type="submit" value="Register"/>
						
				
				</td>
			</tr>
		</table>
	</form:form>
	<br/>
	<br/>
	Go back to <a href="<c:url value='/list' />">List of All Companies</a>
</body>
</html>