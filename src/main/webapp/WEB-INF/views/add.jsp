<%--
  Created by IntelliJ IDEA.
  User: ning
  Date: 9/30/15
  Time: 11:41 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>add user</title>
</head>
<body>
<form action="/adduser" method="post">
    <div>
        <input type="text" name="userName">
        <br>
        <input type="text" name="password">
        <br>
        <input type="text" name="age">
        <br>
        <input type="submit" value="submit">
    </div>
</form>
</body>
</html>