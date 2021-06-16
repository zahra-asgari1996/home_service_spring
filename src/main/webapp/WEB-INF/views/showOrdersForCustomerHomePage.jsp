<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Home
  Date: 6/12/2021
  Time: 11:52 AM
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
<form:form action="/customer/showSuggestions" method="get">
    <table class="table table-striped table-success table-hover">
        <tr>
            <td>id</td>
            <td>job description</td>
            <td>proposed price</td>
            <td>situation</td>
            <td>date of work</td>
            <td>date of create order</td>
            <td colspan="2">address</td>
            <td colspan="2">expert</td>
            <td colspan="2">customer</td>
            <td colspan="2">add comment</td>
            <td colspan="2">pay</td>
        </tr>
        <c:forEach items="${ordersList}" var="list">
            <tr>
                <td rowspan="4">${list.id}</td>
                <td rowspan="4">${list.jobDescription}</td>
                <td rowspan="4">${list.proposedPrice}</td>
                <td rowspan="4">${list.situation}</td>
                <td rowspan="4">${list.dateOfWork}</td>
                <td rowspan="4">${list.dateOfOrderRegistration}</td>
                <td>city</td>
                <td>${list.address.city}</td>
                <td>id</td>
                <td>${list.expert.id}</td>
                <td>id</td>
                <td>${list.customer.id}</td>
                <td rowspan="4">
                    <c:if test="${list.situation eq 'FINISHED'}">
                        <a onclick="sendOffer(${list.id});" href="#" id="link">Add a comment To order</a>
                    </c:if>
                </td>
                <td rowspan="4">
                    <c:if test="${list.situation eq 'DONE'}">
                        <a onclick="paymentFromAccountCredit(${list.id});" href="#" id="paymentLink">pay from account balance</a>
                        <a onclick="onlinePayment(${list.id});" href="#" id="onlinePayment">online payment</a>

                    </c:if>
                </td>
<%--                اینجا باید چرداخت انلاین رو اضافه کنم--%>
            </tr>
            <tr>
                <td>street</td>
                <td>${list.address.street}</td>
                <td>name</td>
                <td>${list.expert.name}</td>
                <td>name</td>
                <td>${list.customer.name}</td>
            </tr>
            <tr>
                <td>alley</td>
                <td>${list.address.alley}</td>
                <td>last Name</td>
                <td>${list.expert.lastName}</td>
                <td>last Name</td>
                <td>${list.customer.lastName}</td>
            </tr>
            <tr>
                <td>plaque</td>
                <td>${list.address.plaque}</td>
                <td>email</td>
                <td>${list.expert.email}</td>
                <td>email</td>
                <td>${list.customer.email}</td>
            </tr>

        </c:forEach>

    </table>
</form:form>
<script>
    function sendOffer(id) {
        console.log("hello" + id)
        window.location.href = "http://localhost:8739/comment/addComment/" + id;
    }

    function paymentFromAccountCredit(id) {
        window.location.href = "http://localhost:8739/customer/paymentFromAccountCredit/" + id;
    }
    function onlinePayment(id) {
        window.location.href = "http://localhost:8739/customer/onlinePayment/" + id;
    }
</script>
</body>
</html>
