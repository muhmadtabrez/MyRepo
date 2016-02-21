<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Company  Listing</title>

	<style>
		tr:first-child{
			font-weight: bold;
			background-color: #C6C9C4;
		}
	</style>

</head>


<body>
	<h2>List of Companies</h2>	
	<h3  color="red">${success}</h3>
	<table>
		<tr>
			<td>NAME</td><td>Address</td><td>City</td><td>Country</td><td></td><td></td>
		</tr>
	
		<c:forEach items="${companies}" var="company">
			<tr>
			<td>${company.name}</td>
			<td>${company.address}</td>
			<td>${company.city}</td>
		    <td>${company.country}</td>
			<td><a href="<c:url value='/edit-${company.companyId}-companyId' />">edit</a></td>
			<td><a href="<c:url value='/delete-${company.companyId}-companyId' />">delete</a></td>
			</tr>
		</c:forEach>
	</table>
	<br/>
	<a href="<c:url value='/new' />">Add New Company</a>
</body>
</html>