<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Manager</title>
</head>
<body>
<form:form modelAttribute="manager" action="/managerPage/login" method="post">
    <table>
        <tr>
            <td>
                <form:label path="userName">User Name:</form:label>
            </td>
            <td>
                <form:input path="userName" name="userName"></form:input>
                <p class="text-danger">${notFoundManager}</p>
            </td>
        </tr>

        <tr>
            <td>
                <form:label path="password">Password:</form:label>
            </td>
            <td>
                <form:input path="password" name="password"></form:input>
                <p class="text-danger">${invalidPassword}</p>
            </td>
        </tr>
        <tr>
            <td></td>
            <form:button name="signin" >Sign In</form:button>
        </tr>
    </table>
</form:form>
</body>
</html>
