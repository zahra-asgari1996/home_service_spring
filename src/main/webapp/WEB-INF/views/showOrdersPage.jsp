<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Home
  Date: 6/6/2021
  Time: 9:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/expert/showOrders" method="get" id="serviceForm">
    <table>
        <tr>
            <td>id</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>

        </tr>
        <c:forEach items="${ordersList}" var="list" >
            <tr>
                <td>${list.id}</td>
                <td>${list.customer}</td>
                <td>${list.dateOfWork}</td>
                <td>${list.}</td>

            </tr>
        </c:forEach>

    </table>
</form>
</body>
</html>
