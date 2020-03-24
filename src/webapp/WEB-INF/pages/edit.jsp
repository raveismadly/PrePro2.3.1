<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>

<html>
<head>
    <title>Edit</title>
</head>
<body>

<c:url value="/edit" var="var"/>
<form action="${var}" method="POST">
    <table border="1">
        <c:if test="${user != null}">
            <input type="hidden" name="id" value="<c:out value="${user.id}" />"/>
            <input type="hidden" name="id"/>
        </c:if>
        <tr>
            <th>Name</th>
            <td><input type="text" name="name" value="<c:out value='${user.name}' />"/>
            </td>
        </tr>
        <tr>
            <th>Surname</th>
            <td>
                <input type="text" name="surname" value="<c:out value='${user.surname}' />"/>
            </td>
        </tr>
        <tr>
            <th>Mail</th>
            <td>
                <input type="text" name="email" value="<c:out value='${user.email}' />"/>
            </td>
        </tr>
        <tr>
            <td>
                <input type="submit" value="Save"/>
            </td>
        </tr>
    </table>
</form>

</body>
</html>