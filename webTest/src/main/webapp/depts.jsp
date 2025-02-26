<%-- <%@page import="dao.Employee"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
Counters =${counters}
Current dept = ${current}


<!--  <form action ="depts" method ="get">

<tr>
	<th>Id</th>
	<th>Name</th>
	<th>Location</th>
</tr>

</form>  -->

<h1>Current Department: ${dept.name}</h1>
<ul>
    <c:forEach var="dept" items="${depts}">
        <li>${dept.name} - ${dept.location}</li>
    </c:forEach>
</ul>


<form action="depts" method="post">
<table>
<tr>
	<td>Id</td>
	<td>${depts.deptid}</td>
</tr>
<tr>
	<td>Name</td>
	<td>${depts.deptname}</td>
</tr>
<tr>
	<td>Location</td>
	<td>${depts.deptlocation}</td>
</tr>
<tr>
	<td colspan ="2">
		<input type="submit" name ="operation" value="First">
		<input type="submit" name ="operation" value="Previous">
		<input type="submit" name ="operation" value="Next">
		<input type="submit" name ="operation" value="Last">
	</td>
</tr>
</table>
</form>
<hr></hr>


<table>
<tr>
	<th><a href="depts?operation=sortByIdDep">Id</a></th>
	<th><a href="depts?operation=sortByNameDep">Name</a></th>
	<th><a href="depts?operation=sortByAgeDep">Age</a></th>
	<th><a href="depts?operation=sortByGenderDep">Gender</a></th>
	<th><a href="depts?operation=sortBySalaryDep">Salary</a></th>
	<th><a href="depts?operation=sortByExperienceDep">Experience</a></th>
	<th><a href="depts?operation=sortByLevelDep">Level</a></th>
	<th>Actions</th>
</tr>

<c:forEach items="${emps}" var="e">
	<tr>
		<td><c:out value="${e.id}"></c:out></td>
		<td>${e.name}</td>
		<td>${e.age}</td>
		<td>${e.gender}</td>
		<td>${e.salary}</td>
		<td>${e.experience}</td>
		<td>${e.level}</td>
		<td>
			<a href="employees?operation=Update&id=${e.id}">Update</a>
			|
			<a href="employees?operation=Delete&id=${e.id}">Delete</a>
		</td>
	</tr>
</c:forEach>

</table>


</body>
</html> --%>


<%@ page import="dao.Employee" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
</head>
<body>
    <!-- Display the department details for the current department -->
    <h3>Department Info:</h3>
    <table border="1">
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Location</th>
        </tr>
        <tr>
            <td>${dept.id}</td>
            <td>${dept.name}</td>
            <td>${dept.location}</td>
        </tr>
    </table>

    <!-- Form for navigating departments -->
    <form action="depts" method="post">
        <input type="submit" name="operation" value="First">
        <input type="submit" name="operation" value="Previous">
        <input type="submit" name="operation" value="Next">
        <input type="submit" name="operation" value="Last">
    </form>

    <hr>


    <!-- Sorting employee data by various fields -->
    <h3>Employee List (Sort Options):</h3>
    <table border="1">
        <tr>
            <th><a href="depts?operation=sortByIdDep">Id</a></th>
            <th><a href="depts?operation=sortByNameDep">Name</a></th>
            <th><a href="depts?operation=sortByAgeDep">Age</a></th>
            <th><a href="depts?operation=sortByGenderDep">Gender</a></th>
            <th><a href="depts?operation=sortBySalaryDep">Salary</a></th>
            <th><a href="depts?operation=sortByExperienceDep">Experience</a></th>
            <th><a href="depts?operation=sortByLevelDep">Level</a></th>
            <th>Actions</th>
        </tr>

        <!-- Iterating through the employees and displaying their details -->
        <c:forEach items="${emps}" var="e">
            <tr>
                <td>${e.id}</td>
                <td>${e.name}</td>
                <td>${e.age}</td>
                <td>${e.gender}</td>
                <td>${e.salary}</td>
                <td>${e.experience}</td>
                <td>${e.level}</td>
                <td>
                    <a href="employees?operation=Update&id=${e.id}">Update</a>
                    |
                    <a href="employees?operation=Delete&id=${e.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
