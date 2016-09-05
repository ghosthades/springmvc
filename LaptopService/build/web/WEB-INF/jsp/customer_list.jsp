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
        <h1>Customer List</h1>
         
        
    <table style="border-collapse: collapse" cellpadding="7px" border="1">
        <tr>
            <th>ID</th> 
            <th>Name</th>
            <th>Telephone Number</th>                
        </tr>
        <c:forEach var="customer" items="${list}">
            <tr>
                <td>
                    <c:out value="${customer.customerId}"></c:out>
                </td>
                <td>
                    <c:out value="${customer.name}"></c:out>
                </td> 
                <td>
                    <c:out value="${customer.telNumber}"></c:out>
                </td>
                <td>
                    Edit | <a href="remove.htm?customerId=${customer.customerId}"
                              onclick="return confirm('Are you sure you want to delete this item?');">Remove</a>
                </td>
            </tr>    
        </c:forEach>
    </table>   
        
</body>

</html>
