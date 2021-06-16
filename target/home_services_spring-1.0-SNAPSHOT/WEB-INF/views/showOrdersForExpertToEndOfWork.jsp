<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Home
  Date: 6/15/2021
  Time: 7:29 PM
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
<form action="/expert/showOrdersToClickEndOfWork" method="get" id="serviceForm">
    <table class="table table-striped table-success table-hover">
        <tr>
            <td>id</td>
            <td>date of work</td>
            <td>order situation</td>
            <td colspan="2">subservice</td>
            <td colspan="2">customer</td>
            <td colspan="2">address</td>
            <td colspan="2">start work</td>
            <td colspan="2">end of Work</td>
            <td colspan="2">confirm payment</td>

        </tr>


        <c:forEach items="${ordersList}" var="list">
            <tr>
                <td rowspan="4">${list.id}</td>
                <td rowspan="4">${list.dateOfWork}</td>
                <td rowspan="4">${list.situation}</td>
                <td rowspan="2">name</td>
                <td rowspan="2">${list.subService.name}</td>
                <td rowspan="2">name</td>
                <td rowspan="2">${list.customer.name}</td>
                <td>city</td>
                <td>${list.address.city}</td>
                <c:if test="${list.situation eq 'Waiting_for_expert_to_come'}">
                    <td rowspan="4">
                        <a onclick="startWork(${list.id});" href="#" id="link">click</a>
                    </td>
                </c:if>
                <c:if test="${list.situation eq 'STARTED'}">
                    <td rowspan="4">
                        <a onclick="endOfWork(${list.id});" href="#" id="endOfWorkLink">click</a>
                    </td>
                </c:if>
                <c:if test="${list.situation eq 'paid'}">
                    <td rowspan="4">
                        <a onclick="confirmPay(${list.id});" href="#" id="confirmPay">click</a>
                    </td>
                </c:if>
            </tr>
            <tr>
                <td>street</td>
                <td>${list.address.street}</td>

            </tr>
            <tr>
                <td rowspan="2">base price</td>
                <td rowspan="2">${list.subService.basePrice}</td>
                <td rowspan="2">last name</td>
                <td rowspan="2">${list.customer.lastName}</td>
                <td>alley</td>
                <td>${list.address.alley}</td>
            </tr>
            <tr>
                <td>plaque</td>
                <td>${list.address.plaque}</td>

            </tr>
        </c:forEach>

    </table>
</form>
<link href="/" title="home">
<script>
    function startWork(id) {
        // document.getElementById("link").href="/offer/sendOffer/ "+id;
        //document.getElementById("link").setAttribute("onclick", "location.href='http://localhost:8739'");
        console.log("hello" + id)
        window.location.href = "http://localhost:8739/order/startWork/" + id;
    }

    function endOfWork(id) {
        // document.getElementById("link").href="/offer/sendOffer/ "+id;
        //document.getElementById("link").setAttribute("onclick", "location.href='http://localhost:8739'");
        console.log("hello" + id)
        window.location.href = "http://localhost:8739/order/endOfWork/" + id;
    }
    function confirmPay(id) {
        // document.getElementById("link").href="/offer/sendOffer/ "+id;
        //document.getElementById("link").setAttribute("onclick", "location.href='http://localhost:8739'");
        console.log("hello" + id)
        window.location.href = "http://localhost:8739/order/confirmPay/" + id;
    }
</script>
</body>
</html>
