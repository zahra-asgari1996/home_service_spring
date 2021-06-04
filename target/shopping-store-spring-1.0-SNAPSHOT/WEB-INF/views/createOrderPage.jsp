<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
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
        <form:option value="NONE" label="Select"/>
        <form:options items="${subServiceList}"/>
    </form:select>
    <%--    <c:forEach items="${subServiceList}" var="list">--%>
    <%--        <form:option value="${list.name}">${list.name},${list.service.name}</form:option>--%>
    <%--    </c:forEach>--%>
    <form:button value="create">create</form:button>
</form:form>

<form action="/subService/getSubService" method="get" id="serviceForm">
    <select name="service" onchange="submitForm()">
        <option value="NONE" label="${selectedService}">${selectedService}</option>
        <c:forEach items="${serviceList}" var="list">
            <c:if test="${list.name ne selectedService}">
                <option value="${list.name}">${list.name}</option>
            </c:if>

        </c:forEach>
        <%--            <option value = "NONE" label = "Select"></option>--%>
        <%--            <option items = "${serviceList}" itemValue="name" itemLabel="name"></option>--%>
    </select>
</form>
<script>
    function submitForm() {
        console.log("success")
        document.getElementById("serviceForm").submit();
        console.log("error")

    }
</script>
</body>
</html>
