<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customers List</title>
</head>
<body>
	<form action="/api/v1/customers/" method="post">

		<label for="name">Customer Name</label> 
		<input name="name" type="text" />
		<label for="age">Customer Age</label> 
		<input name="age" type="text" />
		<label for="currentCity">Current City</label> 
		<input name="currentCity" type="text" /> 
		<label for="currentPinCode">Current Pin Code</label> 
		<input name="currentPinCode" type="text" /> 
		<label for="currentStreet">Current Street Name</label> 
		<input name="currentStreet" type="text" /> 
		<label for="permananatCity">Permanant City</label> 
		<input type="text" name="permanantCity" /> 
		<label for="permanantPinCode">Permanant Pin Code</label> 
		<input type="text" name="permanantPinCode" /> 
		<label for="permanantStreet">Permanant Street Name</label> 
		<input type="text" name="permanantStreet" />
		<button type="submit">Register</button>
	</form>
	<table>
		<thead>
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Age</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${customers}" var="customer">
				<tr>
					<td>${customer}</td>
					<td>${customer.id}</td>
					<td>${customer.name}</td>
					<td>${customer.age}</td>
					<a href="/">View Order</a>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>