<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 29.11.2016
  Time: 18:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Update page </title>
</head>
<body>
<form action="/update" method="post">
    <table border="2">
        <tr>
            <td>Id</td>
            <td>Name</td>
            <td>Created By</td>
            <td>Date</td>
        </tr>
        <%--<tr>--%>
            <%--<td><input type="text" name="userId" value="${user.getUserId}"/></td>--%>
            <%--<td><input type="text" name="userName" value="${user.getUserName()}"/></td>--%>
            <%--<td><input type="text" name="createdBy" value="${user.getCreatedBy()}"/></td>--%>
            <%--<td><input type="text" name="createdDate" value="${user.getCreatedDate()}"/></td>--%>
        <%--</tr>--%>
        <br><input type="submit" value="UPDATE"></br>
    </table>
</form>

</body>
</html>
