<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Home
  Date: 6/9/2021
  Time: 9:02 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form modelAttribute="changePassword" action="/customer/changePassword" method="post">
    <form:input path="password" placeHolder="New Password"/>
    <form:button value="changePassword">change password</form:button>
</form:form>
</body>
</html>
