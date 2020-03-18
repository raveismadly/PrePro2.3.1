
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Users</title>
</head>
<body>
<a href="/add">Add User</a>
<table border="1px">
    <tr>
        <td>Name</td>
        <td>Surname</td>
        <td>Email</td>
        <td>Actions</td>
    </tr>
    <c:forEach var="user" items="${allUsers}">
        <tr>
            <td>${user.name}</td>
            <td>${user.surname}</td>
            <td>${user.email}</td>
            <td><a href="/updateUser">Update User</a> </td>
            <td><a href="/deleteUser">Delete User</a> </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
