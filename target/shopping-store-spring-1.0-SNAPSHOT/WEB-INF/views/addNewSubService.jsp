<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Home
  Date: 6/2/2021
  Time: 7:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form modelAttribute="newSubService" method="post" action="addNewSubService">
    <form:input path="basePrice" name="basePrice" placeHolder="basePrice"></form:input>
    <form:input path="name" name="name" placeHolder="name"></form:input>
    <form:input path="description" name="description" placeHolder="description"></form:input>
    <form:input path="service.name" name="serviceName" placeHolder="Service Name"></form:input>
    <form:button value="add">Add</form:button>
</form:form>
</body>
</html>
