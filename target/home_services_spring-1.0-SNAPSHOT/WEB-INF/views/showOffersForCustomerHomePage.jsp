<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: Home
  Date: 6/14/2021
  Time: 10:15 AM
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
<form:form method="get" action="/customer/showOffers">
    <table class="table table-striped table-success table-hover">
        <tr>
            <td>id</td>
            <td>duration Of Work</td>
            <td>offer price</td>
            <td>start time</td>
            <td colspan="2">expert</td>
            <td colspan="2">order</td>
            <td>select offer</td>
        </tr>
        <c:forEach items="${offersList}" var="list">
            <tr>
                <td rowspan="3" >${list.id}</td>
                <td rowspan="3" >${list.durationOfWork}</td>
                <td rowspan="3" >${list.offerPrice}</td>
                <td rowspan="3" >${list.startTime}</td>
                <td>name</td>
                <td >${list.expert.name}</td>
                <td>id</td>
                <td >${list.orders.id}</td>
                <td>
                    <a onclick="selectOffer(${list.id});" href="#" id="link">select offer</a>
                </td>

            </tr>
            <tr>
                <td>last name</td>
                <td>${list.expert.lastName}</td>
                <td>job description</td>
                <td>${list.orders.jobDescription}</td>
            </tr>
            <tr>
                <td>email</td>
                <td>${list.expert.email}</td>
                <td>date of work</td>
                <td>${list.orders.dateOfWork}</td>
            </tr>
        </c:forEach>

    </table>
</form:form>
<script>
    function selectOffer(id) {
        console.log("hello" + id)
        window.location.href = "http://localhost:8739/offer/selectOffer/" + id;
    }
</script>
</body>
</html>
