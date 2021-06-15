<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
<form:form action="/expert/selectField" method="get">
    <table>
        <tr>
            <td>id</td>
            <td>name</td>
            <td>base price</td>
            <td>service name</td>
            <td>select field</td>
        </tr>
        <c:forEach items="${listOfFields}" var="list">
            <tr>
                <td>${list.id}</td>
                <td>${list.name}</td>
                <td>${list.basePrice}</td>
                <td>${list.service.name}</td>
                <td>
                    <a onclick="selectField(${list.id});" href="#" id="link">select offer</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</form:form>
<script>
    function selectField(id) {
        console.log("hello" + id)
        window.location.href = "http://localhost:8739/expert/selectField/" + id;
    }
</script>
</body>
</html>
