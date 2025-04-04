<%@page import="org.springframework.ui.Model"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Order List</title>
</head>
<body>

	<form action="/api/v1/orders/place" method="post">
		<div>
		
			<label for="itemId">Id</label> <input name="itemId" type="text" placeholder="Enter Item Id"></input> 
			<label for="itemQuantity">Quantity</label>
			<input name="itemQuantity" placeholder="Enter Item Quantity"></input>
			<label for="customerId">Customer-Id</label> <input name="customerId" placeholder="Enter Customer Id"></input>
		</div>
		<button type="submit" name="submitButton">Add Item</button>
		<c:forEach items="${itemsl}" var="ids">
		${ids}
	</br>
		</c:forEach>

		<button type="submit" name="submitButton" value="placeOrder">Place sOrder</button>
	</form>
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
					<td>${order.customerId}</td>
					<td>${order.orderStatus.toString()}</td>
					<td><a href="/api/v1/orders/${order.id}">View/Update</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>