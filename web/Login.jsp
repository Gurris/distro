<%--
  Created by IntelliJ IDEA.
  User: Gurris
  Date: 2016-10-03
  Time: 19:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>

<h1>Login page!</h1>

<%
if(session.getAttribute("Username") != null){%>
    <p>You are already logged in!<br/>Enter new credentials to change user</p>
<%}%>

<%

%>
<form action="ControllerServlet" method="get">
    <input type="hidden" name="controllerInput" value="1">
    <br/>Username:<input type="text" name="Username">
    <br/>Password:<input type="password" name="Password">
    <br/><input type="submit" value="Submit">
</form>

<p style="padding: 0.15em"></p>

<form action="index.jsp">
    <input type="submit" value="Cancel" />
</form>


</body>
</html>
