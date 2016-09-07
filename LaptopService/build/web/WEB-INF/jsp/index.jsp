<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome to laptop service</title>
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
        <h1>Laptop service</h1>
        <a href="<%=request.getContextPath()%>/customer/customer_list.htm">Customer list</a> 
        <a href="<%=request.getContextPath()%>/customer/redirectCreate.htm"> Insert a customer</a><br><br>
        <form action="<%=request.getContextPath()%>/customer/search.htm">
            Search :
            <input type="search" name="key">
            <input type="submit">
        </form>
        <br><br><br>
        <a href="<%=request.getContextPath()%>/order/order_list.htm">Order list</a>
        <a href="<%=request.getContextPath()%>/order/redirectCreate.htm"> Insert an order</a><br><br>
        <form action="<%=request.getContextPath()%>/order/search.htm">
            Search :
            <input type="search" name="key">
            <input type="submit">
            <br>
            </body>
            </html>
