<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Home
  Date: 6/1/2021
  Time: 2:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form modelAttribute="loginCustomer" action="/customer/loginCustomerPage/login" method="post">
    <form:input path="email" placeHolder="Email"></form:input>
    <form:input path="password" placeHolder="Password"></form:input>
    <form:button value="login">Login</form:button>
</form:form>
</body>
</html>
