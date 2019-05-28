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

<form method="post" action="updatedata">

    <% String updId = request.getParameter("accountId"); %>
    <% String updWebsite = request.getParameter("accountWebsite"); %>
    <% String updLogin = request.getParameter("accountLogin"); %>
    <% String updPassword = request.getParameter("accountPassword"); %>
    <input type="hidden" name="accountId" value=<%=updId%>>

    <input type="website" name="website" placeholder= <%=updWebsite %>>
    <input type="login" name="login" placeholder=<%=updLogin%>>
    <input type="password" name="password" placeholder=<%=updPassword%>>

    <input type="SUBMIT">
</form>

<br>
<button style="height:28px; font-size: 14px"
        onclick="history.back()">Go Back
</button>

</body>
</html>
