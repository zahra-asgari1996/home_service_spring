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
<form:form modelAttribute="onlinePayment" method="post" action="/customer/onlinePayment">
    <form:input path="creditNumber" placeHolder="credit number"/>
    <form:errors path="creditNumber"/>
    <form:input path="password" placeHolder="password"/>
    <form:errors path="password"/>
    <form:input path="cvv2" placeHolder="cvv2"/>
    <form:errors path="cvv2"/>
    <form:input path="expireDate" placeHolder="expire date"/>
    <form:errors path="expireDate"/>
    <img src="${pageContext.request.contextPath }/captcha">
    <br>
    <form:input type="text" name="captcha"  style="margin-top: 5px;" path="captcha" />
    <form:errors path="captcha"/>
    ${error}
    <br>
    <form:button name="pay" value="pay">pay</form:button>
</form:form>
</body>
</html>
