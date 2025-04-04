<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/api/v1/customers/" method="post">

<label for="name">Customer Name</label>
<input name="name" type="text"/>
<label for="age">Customer Age</label>
<input name="age" type="text"/>
<label for="currentCity">Current Addresss</label>
<input name="currentAddress" type="text"/>
<label for="permananatCity">Permanant Addresss</label>
<input type="text" name="permanantAddresss" />
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