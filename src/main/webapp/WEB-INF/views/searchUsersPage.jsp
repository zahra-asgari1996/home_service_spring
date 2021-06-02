<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Search Users</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
</head>
<body>
<form:form modelAttribute="users" action="/user/searchUser" method="post">
    <table class="table table-striped table-success table-hover">
        <tr>
            <td>
                <form:input path="name" name="name" placeHolder="Name"></form:input>
            </td>
            <td>
                <form:input path="lastName" name="lastName" placeHolder="Last Name"></form:input>
            </td>
        </tr>

        <tr>
            <td>
                <form:input path="email" name="email" placeHolder="Email"></form:input>
            </td>
            <td>
                <form:input path="field" name="field" placeHolder="Field"></form:input>
            </td>
        </tr>

        <tr>
            <td>
                <form:input path="rate" name="rate" placeHolder="rate"></form:input>
            </td>
            <td>
                Expert<form:checkbox path="role" value="Expert"></form:checkbox>
                Customer<form:checkbox path="role" value="Customer"></form:checkbox>

            </td>
        </tr>
        <tr>
            <td>
                <form:button value="search">Search</form:button>
            </td>
        </tr>

        <tr>
            <td>name</td>
            <td>last Name</td>
            <td>email</td>
            <td>role</td>
            <td>data</td>
        </tr>
        <c:forEach items="${usersList}" var="list">
            <tr>
                <td>${list.name}</td>
                <td>${list.lastName}</td>
                <td>${list.email}</td>
                <td>${list.role}</td>
                <td>${list.date}</td>
            </tr>
        </c:forEach>
    </table>
</form:form>
</body>
</html>
