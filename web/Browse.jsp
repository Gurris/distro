<%--
  Created by IntelliJ IDEA.
  User: Gurris
  Date: 2016-10-03
  Time: 19:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="Model.Entitys.*" %>
<%@ page import="Model.ManageDataObj.ProductManager" %>
<%
    ArrayList<Product> list = new ArrayList<Product>();
    ProductManager PM = new ProductManager();
    list = PM.getProducts();
%>

<%
    ArrayList<Product> Sesslist = new ArrayList<>();
    Sesslist.add(new Product(1, "första", 33));
    Sesslist.add(new Product(2, "andra", 44));
    Sesslist.add(new Product(3, "tredje", 55));
    System.out.println("HERE::::: " + Sesslist.size());
    session.setAttribute("CART", Sesslist);
%>

<html>
<head>
    <title>Browse</title>
</head>
<body>
<h1>Browse products!</h1>

<Table style="width:30%" border="1">
    <tr>
        <th>Product</th>
        <th>Price</th>
        <th>Add to cart</th>
    </tr>

    <%for(int i=0; i<list.size(); i++){%>
    <tr>
        <form action="ControllerServlet" method="get">
            <input type="hidden" name="controllerInput" value="2">
            <input type="hidden" name="P_id" value="<%=list.get(i).getId()%>">
            <td><input type="hidden" name="P_name" value="<%=list.get(i).getName()%>"><%=list.get(i).getName()%></td>
            <td><input type="hidden" name="P_price" value="<%=list.get(i).getPrice()%>"><%=list.get(i).getPrice()%></td>
            <th><button>Cart --></button></th>
        </form>

    </tr>
    <%}%>
</Table>

</body>
</html>
