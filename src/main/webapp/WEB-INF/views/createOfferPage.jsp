<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Home
  Date: 6/7/2021
  Time: 10:48 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form modelAttribute="newOffer" method="post" action="/offer/createOffer">
    <form:input path="offerPrice" placeHolder="offer price"/>
    <form:input path="durationOfWork" placeHolder="durationOfWork"/>
    <form:input path="startTime" type="date" placeHolder="startTime"/>
    <form:button value="create" >create</form:button>
</form:form>
</body>
</html>