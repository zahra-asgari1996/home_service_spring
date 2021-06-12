<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Home
  Date: 6/2/2021
  Time: 9:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
</head>
<body>
<c:if test="${expert ne null}">
    <p>welcome ${expert.email}</p>
</c:if>

<c:if test="${loginExpert ne null}">
    <p>welcome ${loginExpert.email}</p>
</c:if>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <%--    <a class="navbar-brand" href="#">Navbar</a>--%>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav"
            aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav">
            <li class="nav-item active">
                <a class="nav-link" href="/">Home <span class="sr-only"></span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/expert/selectField">Select Field </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/expert/showOrders">See Orders </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/expert/changePassword">change pass </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/expert/showSuggestion">change pass </a>
            </li>
            <%--            <li class="nav-item">--%>
            <%--                <a class="nav-link" href="customer">Customer Page</a>--%>
            <%--            </li>--%>
            <%--            <li class="nav-item">--%>
            <%--                <a class="nav-link" href="expert">Expert Page</a>--%>
            <%--            </li>--%>

        </ul>
    </div>
</nav>
</body>
</html>
