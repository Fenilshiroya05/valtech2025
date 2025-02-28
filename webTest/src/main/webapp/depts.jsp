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
<p>Counters: ${counters}</p>
    <p>Current Dept: ${current}</p>
<form action="depts" method="post">
        <table border="1">
            <tr>
                <td>Id</td>
                <td>
                    <input type="text" name="id" value="${dept.id}"/>
                </td>
            </tr>
            <tr>
                <td>Name</td>
                <td>
                    <input type="text" name="name" value="${dept.name}"/>
                </td>
            </tr>
            <tr>
                <td>Location</td>
                <td>
                    <input type="text" name="location" value="${dept.location}"/>
                </td>
            </tr>
            <tr>
                <td >
                    <input type="submit" name="operation" value="First"/>
                    <input type="submit" name="operation" value="Previous"/>
                    <input type="submit" name="operation" value="Next"/>
                    <input type="submit" name="operation" value="Last"/>
                </td>
            </tr>
        </table>
    </form>
 

    <hr>

    <h3>Employee List :</h3>
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
