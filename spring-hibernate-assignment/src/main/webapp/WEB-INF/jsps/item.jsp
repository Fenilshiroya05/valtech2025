<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/api/v1/items/create" method="post">

<label for="id">Id</label>
<input type="text" name="id"/>
<label for="name">ItemName</label>
<input name="name" type="text"/>
<label for="name">Description</label>
<input name="description" type="text"/>
<label for="currentQuantity">ItemQuantity</label>
<input name="currentQuantity" type="text" />
<label for="maxQuantity" type="text">MaximumQuantity</label>
<input name="maxQuantity" type="text" />
<label for="reOrderQuantity">ReOrderValue</label>
<input name="reOrderQuantity" type="text"/>

<button type="submit">Add</button>

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
        <c:forEach items="${itemLists}" var="item">
            <tr>
                <td>${item.id}</td>
                <td>${item.name}</td>
                <td>${item.currentQuantity}</td>
                
            </tr>
        </c:forEach>
    </tbody>
</table>

</body>
</html>