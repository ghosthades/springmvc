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
        <title>JSP Page</title>
    </head>
    <body
        <h1>Order List</h1>
         
        
    <table style="border-collapse: collapse" cellpadding="7px">
        <tr>
            <th> Order ID </th>
            <th>  Amount  </th>
            <th> Detail </th>              
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
                    Edit | Remove
                </td>
            </tr>    
        </c:forEach>
    </table>           
</body>

</html>
