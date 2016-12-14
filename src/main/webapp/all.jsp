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
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">


    <!-- Optional theme -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
          integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">


    <!-- Latest compiled and minified JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
            integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
            crossorigin="anonymous"></script>
    <title>all</title>
</head>
<body>
<div class="container">
    <div class="row"><h2>Dear ${user.getUserName()} you can see here all users & information about them </h2></div>
    <br><br>
    <div class="row">
        <table class="table">
            <tr>
                <td>Id</td>
                <td>Name</td>
                <td>Create By</td>
                <td>Date</td>
            </tr>
            <c:forEach var="user" items="${userList}">
                <tr>
                    <form action="/">
                        <td><input type="text" name="userId" value="${user.getUserId()}" /></td>
                        <td><input type="text" name="userName" value="${user.getUserName()}"/></td>
                        <td><input type="text" name="createdBy" value="${user.getCreatedBy()}"/></td>
                        <td>${user.getCreatedDate()}</td>
                        <td><input type="submit" name="methods" value="UPDATE" class="btn btn-danger"/></td>
                        <td><a href="/?method=DELETE&userId=${user.getUserId()}" class="btn btn-danger"> DELETE</a></td>
                    </form>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>
