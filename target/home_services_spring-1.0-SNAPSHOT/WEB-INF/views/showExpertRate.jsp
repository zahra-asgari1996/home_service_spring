<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Home
  Date: 6/13/2021
  Time: 8:04 PM
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
<form:form action="/comment/showRate" method="get">
    <table class="table table-striped table-success table-hover">
        <tr>
            <td>rate</td>
            <td>comment</td>
        </tr>
        <c:forEach items="${commentList}" var="list">
            <tr>
                <td>
                        ${list.rate}
                </td>
                <td>
                        ${list.comment}
                </td>
            </tr>
        </c:forEach>
    </table>
    <p>Average rate :   ${rate}</p>
</form:form>
</body>
</html>
