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
<form action="/delete" method="post">
    <table>
        <tr>
            <td><input type="text" name="check" value="${word}"/></td>
            <td><input type="submit" value="DELETE"/></td>
        </tr>
    </table>
</form>
</body>
</html>
