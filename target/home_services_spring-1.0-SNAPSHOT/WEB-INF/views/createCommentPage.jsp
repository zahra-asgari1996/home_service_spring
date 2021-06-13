<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Home
  Date: 6/12/2021
  Time: 4:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form modelAttribute="comment" method="post" action="/comment/addComment">
    <form:input path="rate" placeHolder="rate"/>
    <form:errors path="rate"/>
    <form:input path="comment" placeHolder="comment"/>
    <form:errors path="comment"/>
    <form:button value="send">add a comment</form:button>
</form:form>
</body>
</html>
