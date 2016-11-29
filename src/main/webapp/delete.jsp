<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 29.11.2016
  Time: 18:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Delete</title>
</head>
<body>
<form action="/update" method="get">
    <table>
        <td><input type="text" name="createdByCheck"/></td>
        <td><input type="submit" value="DELETE"/></td>
    </table>
</form>
</body>
</html>
