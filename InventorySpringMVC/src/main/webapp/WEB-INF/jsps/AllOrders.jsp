<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All Orders</title>
</head>
<body>
<form action="/api/v1/orders/${orderId }" method="post">
<table>
    <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Current Quantity</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${orders}" var="order">
            <tr>
                <td>${order.id}</td>
                <td>${order.name}</td>
                <td>${order.quantity}</td>
            </tr>
        </c:forEach>
    </tbody>
</table>
<label for="OrderStatus">OrderStatus</label>
<input value="${OrderStatus}" name="orderStatus" />
<button name="">Update</button>
</form>
</body>
</html>