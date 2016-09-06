<%-- 
    Document   : customer_edit
    Created on : Sep 5, 2016, 3:14:31 PM
    Author     : rin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customer edit</title>
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
         <form action="update.htm" method="POST"> 
            <input type="hidden" name="orderId" value="${emp.orderId}"> 
            Amount: <input type="text" name="amount"  />
            Detail: <input type="text" name="detail" /> 
            Customer :
        <select name="customerId" >
            <c:forEach var="customer" items="${list}" >
                <option value="${customer.customerId}" label="${customer.name}"/>
            </c:forEach>
        </select>
            <input type="submit" value="Save" />  
        </form>
        <br>                 
    </body>
</html>
