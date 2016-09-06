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
        <title>Search result</title>
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
    <body>
        <center><h2><a href="<%=request.getContextPath() %>/index.htm">Home page</a></h2></center>
        <h1>Search result</h1>
         
        
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
                    <a href="edit.htm?customerId=${customer.customerId}"> Edit </a>| <a href="remove.htm?customerId=${customer.customerId}"
                              onclick="return confirm('Are you sure you want to delete this item?');">Remove</a>
                </td>
            </tr>    
        </c:forEach>
    </table>   
        
</body>

</html>
