<%--
  Created by IntelliJ IDEA.
  User: juta.miscenko
  Date: 2019-03-25
  Time: 21:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hello World</title>
</head>
<body>
Here you can make your requests to the database

<form method="post" action="openDatabase">
    Choose what would you like to do?

    <br>
    <br>

    <select name="operation">
        <option value="read all data">readAll</option>
    </select>

    <input type="submit">
</form>
</body>
</html>
