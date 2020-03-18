<%--
  Created by IntelliJ IDEA.
  User: raves
  Date: 18.03.2020
  Time: 15:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<body>
<c:url value="/edit" var="var"/>
<form action="${var}" method="POST">
    <input type="hidden" name="id" value="${user.id}">
    <label for="name">Name</label>
    <input type="text" name="name" id="name">
    <label for="surname">Surname</label>
    <input type="text" name="surname" id="surname">
    <label for="email">Email</label>
    <input type="text" name="email" id="email">
    <input type="submit" value="add User">
</form>
</body>
</body>
</html>
