<%--
  Created by IntelliJ IDEA.
  User: Gurris
  Date: 2016-10-02
  Time: 19:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
  <title>Web shop!</title>

</head>
<body>
<h1>Welcome to the web shop!</h1>
<p>Feel free to browse around!</p>

<% if(session.getAttribute("LoginStatus") == "Login success"){%>
    <p>Welcome <%=session.getAttribute("Username")%></p>
<%}else if(session.getAttribute("LoginStatus") == "Login failed"){%>
    <p>Login failed</p>
<%} else {%>
    <p>You are not logged in</p>
<%}%>

<ul>
  <li><a href="Login.jsp">Login</a></li>
  <li><a href="Browse.jsp">Browse</a></li>
  <li><a href="ShoppingCart.jsp">Shopping cart</a></li>
</ul>

</body>
</html>
