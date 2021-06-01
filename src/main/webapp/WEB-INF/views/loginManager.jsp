<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Home
  Date: 6/1/2021
  Time: 10:16 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Manager</title>
</head>
<body>
<form:form modelAttribute="manager" action="/manager/signin" method="post">
    <form:label path="userName">User Name:</form:label>
    <form:input path="userName" name="userName"></form:input>
    <form:label path="password">Password:</form:label>
    <form:input path="password" name="password"></form:input>
    <form:button value="submit" >Sign In</form:button>
</form:form>
</body>
</html>
