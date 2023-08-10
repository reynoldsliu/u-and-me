<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <title>Spring Boot Example</title>
    <link rel="stylesheet" th:href="@{/css/styles.css}" />
</head>
<body>
<h1>Welcome to Spring Boot</h1>

<form action="/u-and-me/show/hello.jsp">
    <a href="">go to show/hello.jsp</a>
    <input type="submit">
</form>

<form action="getOneAttr">
    <a href="">go to show/getOneAttr.jsp</a>
    <input type="submit">
</form>

<form action="getAllAttr">
    <a href="">go to show/getAllAttr.jsp</a>
    <input type="submit">
</form>

<form action="/u-and-me/show/yt_layout.jsp">
    <a href="">go to show/yt_layout.jsp</a>
    <input type="submit">
</form>

<form action="/u-and-me/show/bootstrap12.jsp">
    <a href="">go to show/bootstrap12.jsp</a>
    <input type="submit">
</form>

<p th:text="${message}"></p>
<script th:src="@{/js/scripts.js}"></script>
</body>
</html>