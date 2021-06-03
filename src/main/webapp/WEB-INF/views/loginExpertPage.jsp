<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Home
  Date: 6/1/2021
  Time: 2:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form modelAttribute="loginExpert" method="post" action="/expert/loginExpertPage/login">
    <form:input path="email" placeHolder="email"></form:input>
    <form:input path="password" placeHolder="password"></form:input>
    <form:button value="login">login</form:button>

</form:form>
</body>
</html>
