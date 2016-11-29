<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 22.11.2016
  Time: 14:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>all</title>
</head>
<body>
<h1>Dear ${user.getUserName()} you can see here all users & information about them </h1>
<table border="2">
    <tr>
        <td>Id</td>
        <td>Name</td>
        <td>Create By</td>
        <td>Date</td>
    </tr>
    <c:forEach var="user" items="${userList}">
        <tr>
            <td>${user.getUserId()}</td>
            <td>${user.getUserName()}</td>
            <td>${user.getCreatedBy()}</td>
            <td>${user.getCreatedDate()}</td>
        </tr>
    </c:forEach>
</table>
<br><a href="/">To login page </a>
<br><a href="update.jsp">To updating your feeds </a>
<br><a href="delete.jsp">Delete you...</a>
</body>
</html>
