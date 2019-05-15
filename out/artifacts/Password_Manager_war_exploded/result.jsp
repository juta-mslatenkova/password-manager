<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: juta.miscenko
  Date: 2019-03-25
  Time: 22:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>R</title>
</head>
<body>

<%
    List styles = (List) request.getAttribute("crudOperation");
    Iterator it = styles.iterator();

    while (it.hasNext()) {
        response.getWriter().print("<br>try: " + it.next());
    }
%>

</body>
</html>