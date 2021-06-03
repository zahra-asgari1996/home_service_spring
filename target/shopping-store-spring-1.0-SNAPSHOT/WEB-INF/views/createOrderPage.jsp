<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Home
  Date: 6/3/2021
  Time: 11:46 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form modelAttribute="newOrder" method="post" action="/customer/createOrder">
    <form:input path="customer.email" placeHolder="Customer Email"></form:input>
    <form:input path="proposedPrice" placeHolder="Proposed Price"></form:input>
    <form:input path="jobDescription" placeHolder="Job Description"></form:input>
    <form:input path="dateOfWork" placeHolder="dateOfWork"></form:input>
    <form:input path="addressDto.city" placeHolder="city name"></form:input>
    <form:input path="addressDto.street" placeHolder="street name"></form:input>
    <form:input path="addressDto.alley" placeHolder="alley name"></form:input>
    <form:input path="addressDto.plaque" placeHolder="plaque"></form:input>
    <form:select path="subService.name">
        <form:option value = "NONE" label = "Select"/>
        <form:options items = "${subServiceList}"  />
    </form:select>
<%--    <c:forEach items="${subServiceList}" var="list">--%>
<%--        <form:option value="${list.name}">${list.name},${list.service.name}</form:option>--%>
<%--    </c:forEach>--%>
</form:form>


</body>
</html>
