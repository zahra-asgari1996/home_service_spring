<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Home
  Date: 6/2/2021
  Time: 10:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

</head>
<body>
<form:form action="/expert/selectField" method="post" modelAttribute="selectFieldForExpert">
    <form:input path="expertDto.email" placeHolder="Expert Email"></form:input>
    <form:input path="subServiceDto.name" placeHolder="SubService Name"></form:input>
    <form:button value="select">Select</form:button>
</form:form>
</body>
</html>
