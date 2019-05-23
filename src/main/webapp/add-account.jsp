<%--
  Created by IntelliJ IDEA.
  User: juta.miscenko
  Date: 2019-05-20
  Time: 21:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<br>
<div style="text-align:center"><h2>Add New Account</h2></div>
<body style="padding-left: 40px; padding-right: 400px; background-color:#FAF0E6;">
<h2></h2>
<br>

<form method="post" action="addaccount">

    <input type="website" name="website" placeholder="website">
    <input type="login" name="login" placeholder="login">
    <input type="password" name="password" placeholder="password">
    <input type="SUBMIT">
</form>

<br>
<button style="height:28px; font-size: 14px"
        onclick="window.location.href = 'http://localhost:8080/Password_Manager_war_exploded/index.jsp';">Go Back
</button>

</body>
</html>
