<%-- 
    Document   : thanhviens
    Created on : Aug 30, 2016, 10:09:37 PM
    Author     : rin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Order List</title>
        <style type="text/css">
            h1 {color:red;}
            body {background-color: wheat;}
            a {color: blue;}
            th, td {padding: 15px;text-align: left;}
            input[type=submit] {
                padding:5px 15px; 
                background:#ccc; 
                border:0 none;
                cursor:pointer;
                -webkit-border-radius: 5px;
                border-radius: 5px;}
            </style>         

        </head>
        <body
    <center><h2><a href="<%=request.getContextPath()%>/index.htm">Home page</a></h2></center>
    <h1>Order List</h1>


    <table style="border-collapse: collapse" cellpadding="7px" border="1">
    <tr>
        <th> Order ID </th>
        <th> Amount  </th>
        <th> Detail </th>   
        <th> Belongto   </th>
    </tr>
    <c:forEach var="order" items="${list}">
        <tr>
            <td>
                <c:out value="${order.getOrderId()}"></c:out>
                </td> 
                <td>
                <c:out value="${order.getAmount()}"></c:out>
                </td> 
                <td>
                <c:out value="${order.getDetail()}"></c:out>
                </td>
                <td>
                <c:out value="${order.getCustomer().getName()}"></c:out>
                </td>
                <td>
                    <a href="edit.htm?orderId=${order.orderId}"> Edit </a> | <a href="remove.htm?orderId=${order.orderId}"
                                                                            onclick="return confirm('Are you sure you want to delete this item?');">Remove</a>
            </td>
            </td>
        </tr>    
    </c:forEach>
</table>   

</body>

</html>
