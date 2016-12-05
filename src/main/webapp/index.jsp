<%--
  Created by IntelliJ IDEA.
  User: 33558
  Date: 20.11.2016
  Time: 18:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>index</title>
</head>
<body>
<form method="post" action="/all">
    <table>
        <tr>
            <td>Name</td>
            <td><input type="text" name="userName" value="user Name" ></td>
        </tr>
        <tr>
            <td>Created By</td>
            <td><input type="text" name="createdBy" value="created By"></td>
        </tr>
        <tr>
            <td>
                <input type="reset" value="Reset"/>
                <input type="submit" value="Login"/>
            </td>
        </tr>

    </table>
</form>
</body>
</html>
