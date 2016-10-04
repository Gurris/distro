<%@ page import="java.util.ArrayList" %>
<%@ page import="Model.Entitys.Product" %><%--
  Created by IntelliJ IDEA.
  User: Gurris
  Date: 2016-10-03
  Time: 19:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    ArrayList<Product> cart = new ArrayList<>();
    cart = (ArrayList<Product>) session.getAttribute("CART");
    if(cart == null){
        cart = new ArrayList<Product>();
    }
%>
<html>
<head>
    <title>Shopping cart</title>
</head>
<body>

<h1>Your shopping cart</h1>

<Table style="width:30%" border="1">
    <tr>
        <th>Product</th>
        <th>Price</th>
    </tr>

    <%for(int i=0; i<cart.size(); i++){%>
    <tr>
        <form action="ControllerServlet" method="get">
            <input type="hidden" name="controllerInput" value="3">
            <input type="hidden" name="P_id" value="<%=cart.get(i).getId()%>">
            <td><input type="hidden" name="P_name" value="<%=cart.get(i).getName()%>"><%=cart.get(i).getName()%></td>
            <td><input type="hidden" name="P_price" value="<%=cart.get(i).getPrice()%>"><%=cart.get(i).getPrice()%></td>
        </form>
    </tr>
    <%}%>
</Table>

<p style="padding: 0.15em"></p>

<form action="index.jsp">
    <input type="submit" value="Return" />
</form>


</body>
</html>
