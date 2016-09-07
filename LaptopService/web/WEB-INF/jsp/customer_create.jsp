<%-- 
    Document   : customer_edit
    Created on : Sep 5, 2016, 3:14:31 PM
    Author     : rin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="f" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create customer</title>
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
    <center><h2><a href="<%=request.getContextPath()%>/index.htm">Home page</a></h2></center>
    <form action="create.htm" method="POST" modelAttribute="customer">   
        name: <input type="text" name="name"  />
        tel: <input type="text" name="telNumber" />
        <input type="submit" value="Insert" />            
    </form>
    <br>
</body>
</html>
