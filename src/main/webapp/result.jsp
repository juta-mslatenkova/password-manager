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
        <th style="width:100px">action</th>
    </tr>

    <%
        ArrayList<Account> accountsList =
                (ArrayList<Account>) request.getAttribute("data");
        for (Account s : accountsList) {
    %>
    <%-- Arranging data in tabular form
    --%>
    <tr>
        <td ><%=s.getId()%>
        </td>
        <td><%=s.getWebsite()%>
        </td>
        <td><%=s.getLogin()%>
        </td>
        <td><%=s.getPassword()%>
        </td>
        <td>
            <form method="post" action="deletedata" style="float: left">
                <input type="hidden" name="accountId" value="<%=s.getId()%>"/>
                <input type="SUBMIT" value="DELETE">
            </form>
            <form action="update-account.jsp" method="GET" style="float: right">
                <input type="hidden" name="accountId" value="<%=s.getId()%>"/>
                <input type="hidden" name="accountWebsite" value="<%=s.getWebsite()%>">
                <input type="hidden" name="accountLogin" value="<%=s.getLogin()%>">
                <input type="hidden" name="accountPassword" value="<%=s.getPassword()%>">
                <button
                        onclick="window.location.href = 'http://localhost:8080/Password_Manager_war_exploded/update-account.jsp';">
                    UPDATE
                </button>
            </form>
        </td>
    </tr>
    <%}%>
</table>
<br>
<button style="height:28px; font-size: 14px"
        onclick="history.back()">Go Back
</button>

</body>
</html>
