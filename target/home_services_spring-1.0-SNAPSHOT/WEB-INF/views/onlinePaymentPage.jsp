<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%--
  Created by IntelliJ IDEA.
  User: Home
  Date: 6/15/2021
  Time: 11:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/customer/onlinePayment" method="post">
    <input type="number" placeholder="card number">
    <input type="date" placeholder="expire date">
    <input type="number" placeholder="cvv2">
    <button type="submit">pay</button>
</form>
</body>
</html>
