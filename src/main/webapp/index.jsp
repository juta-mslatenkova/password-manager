<%@ page import="com.accounts.model.Account" %>
<%@ page import="java.util.ArrayList" %>
<html>
<br>
<div style="text-align:center"><h1>The Password Manager</h1></div>
<body style="padding-left: 40px; padding-right: 400px; background-color:#FAF0E6;">
<h2></h2>
<br>

<br>
<button style="height:28px; font-size: 14px; float: right"
        onclick="window.location.href = 'http://localhost:8080/Password_Manager_war_exploded/add-account.jsp';">Add new
    user
</button>


<form method="post" action="finddataall">
    Find all the entries:
    <select name="database" size="1">
        <option value="none" selected disabled hidden>
            select database
        </option>
        <option value="XML">XML</option>
        <option value="POSTGRESQL_HIBERNATE">POSTGRESQL_HIBERNATE</option>
        <option value="POSTGRESQL_JDBC">POSTGRESQL_JDBC</option>
    </select>
    <input type="SUBMIT">
</form>

<form method="post" action="findbyid">
    Find user by id:
    <select name="database" size="1">
        <option value="none" selected disabled hidden>
            select database
        </option>
        <option value="XML">XML</option>
        <option value="POSTGRESQL_HIBERNATE">POSTGRESQL_HIBERNATE</option>
        <option value="POSTGRESQL_JDBC">POSTGRESQL_JDBC</option>
    </select>

    <input type="number" name="id" placeholder="id">
    <input type="SUBMIT">
</form>
<br>



<hr/>

</body>
</html>
