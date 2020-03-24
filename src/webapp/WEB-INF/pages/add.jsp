<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8"  %>
<html>
<head>
    <title>Add User</title>
</head>
<body>
    <c:url value="/add" var="var"/>
    <form action="${var}" method="POST">
<%--        <input type="hidden" name="id" value="${user.id}">--%>
        <label for="name">Name</label>
        <input type="text" name="name" id="name">
        <label for="surname">Surname</label>
        <input type="text" name="surname" id="surname">
        <label for="email">Email</label>
        <input type="text" name="email" id="email">
        <input type="submit" value="add User">
    </form>
</body>
</html>
