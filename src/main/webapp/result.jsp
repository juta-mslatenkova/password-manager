<%@ page import="com.accounts.model.Account" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: juta.miscenko
  Date: 2019-05-20
  Time: 21:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<br>
<div style="text-align:center"><h2>Results</h2></div>
<body style="padding-left: 40px; padding-right: 400px; background-color:#FAF0E6;">
<h2></h2>
<br>


<table style="width:100%" bordercolor="black" border="1">
    <tr>
        <th>id</th>
        <th>website</th>
        <th>login</th>
        <th>password</th>
    </tr>

    <%
        ArrayList<Account> accountsList =
                (ArrayList<Account>) request.getAttribute("data");
        for (Account s : accountsList) {
    %>
    <%-- Arranging data in tabular form
    --%>
    <tr>
        <td><%=s.getId()%>
        </td>
        <td><%=s.getWebsite()%>
        </td>
        <td><%=s.getLogin()%>
        </td>
        <td><%=s.getPassword()%>
        </td>
    </tr>
    <%}%>
</table>
</body>
</html>
