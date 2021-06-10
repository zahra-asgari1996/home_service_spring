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
<p class="text-danger">${error}</p>
<form:form modelAttribute="expert" action="/expert/register" method="post">
    <table>
        <tr>
            <td>
                <form:label path="name">Name :</form:label>
            </td>
            <td>
                <form:input path="name" name="name"></form:input>
                <form:errors path="name"/>
            </td>
        </tr>

        <tr>
            <td>
                <form:label path="lastName">Last Name :</form:label>
            </td>
            <td>
                <form:input path="lastName" name="lastName"></form:input>
                <form:errors path="lastName"/>
            </td>
        </tr>

        <tr>
            <td>
                <form:label path="email">Email :</form:label>
            </td>
            <td>
                <form:input path="email" name="email"></form:input>
                <form:errors path="email"/>
            </td>
        </tr>

        <tr>
            <td>
                <form:label path="password">Password :</form:label>
            </td>
            <td>
                <form:input path="password" name="password"></form:input>
                <form:errors path="password"/>
            </td>
        </tr>

        <tr>
            <td>
                <form:label path="image">Password :</form:label>
            </td>
            <td>
                <form:input path="image" name="image" type="file" id="image"></form:input>
                <form:errors path="image"/>
            </td>
        </tr>

        <tr>
            <td></td>
            <td>
                <form:button name="register">Register</form:button>
            </td>
        </tr>
    </table>
</form:form>
<script>
    const imageFile = document.getElementById('image');

    imageFile.onchange = function () {
        const maxAllowedSize = 300 * 1024;

        if (this.files[0].size > maxAllowedSize) {
            alert("Image File is too big!");
            this.value = "";
        }
    }
</script>
</body>
</html>
