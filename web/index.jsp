<%--
  Created by IntelliJ IDEA.
  User: Gurris
  Date: 2016-10-02
  Time: 19:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="Model.ManageDataObj.UserManager"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="Model.Entitys.*" %>
<%
  ArrayList<User> list = new ArrayList<User>();
  UserManager um = new UserManager();
  list = um.getUsers();
%>
<html>
<head>
  <title>Web shop!</title>

</head>
<body>
<h1>Welcome to the web shop!</h1>
<p>Feel free to browse around!</p>


<%
if(session.getAttribute("Username") != null){%>
    <p>Welcome <%=session.getAttribute("Username")%></p>
<%}else {%>
    <p>You are not logged in!</p>
<%}%>

<ul>
  <li><a href="Login.jsp">Login!</a></li>
  <li><a href="Browse.jsp">Browse</a></li>
  <li><a href="ShoppingCart.jsp">Shopping cart</a></li>
</ul>


<form action = "ControllerServlet" method="post">
  <input type = "text" name="controllerInput" value=""/>
</form>




</body>
</html>
