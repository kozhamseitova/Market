<%@ page import="com.company.models.User" %><%--
  Created by IntelliJ IDEA.
  User: Acer
  Date: 12.10.2020
  Time: 22:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Main</title>
    <link rel="stylesheet" type="text/css" href="l.css" />
    <style>
        body{
            background-image: url("${pageContext.request.contextPath}/jsp/img/pink.jpg");
        }
    </style>
</head>
<body>
<%@include file="header.jsp"%>
<img src="${pageContext.request.contextPath}/jsp/img/main.png" style="margin-left: 17%">

<h1 style="color: hotpink; text-align: center;font-size: 60px;">Pink Shop</h1>
<p style="text-align: center">In our online shop you can find different jewelry to your daily mood</p>
<%--
to show all users only if admin will authorized

<%
    User user = (User) request.getSession().getAttribute("user");
    if(user.getEmail()=="admin@m.m"){
%>
    <form method="get" action="${pageContext.request.contextPath}/showUsers">
        <input type="submit" value="Show all users">
    </form>
    <div >
        <c:set var="users" value='${requestScope["users"]}' />

        <c:forEach items="${users}" var="user">
            <div class="p-12 md:w-1/3 flex flex-col items-start">
                <p class="font-medium title-font mt-4 text-gray-900 text-lg">${user.id}</p>
                <p class="font-medium title-font mt-4 text-gray-900 text-lg">${user.email}</p>
                <div class="w-12 h-1 bg-pink-500 rounded mt-2 mb-4"></div>
            </div>
        </c:forEach>
    </div>
<%
    }

%>
--%>
<br>
<h1 style="color: hotpink; text-align: center;font-size: 40px;">You can find our shops by this addresses</h1>
<div class="container px-5 py-24 mx-auto" style="margin-left: 5%; margin-top: -5%">
    <div class="flex flex-wrap -m-12">
        <c:set var="addresses" value='${requestScope["addresses"]}' />

        <c:forEach items="${addresses}" var="address">
            <div class="p-12 md:w-1/3 flex flex-col items-start">
                <img alt="" style="width: 25%;" src="${address.key}">
                <div class="w-12 h-1 bg-pink-500 rounded mt-2 mb-4"></div>
                <h2 class="font-medium title-font mt-4 text-gray-900 text-lg">${address.value}</h2>
            </div>
        </c:forEach>
    </div>
</div>

<h1 style="color: hotpink; text-align: center;font-size: 40px;">Our certificates</h1>
<div class="container px-5 py-24 mx-auto" style="margin-left: 5%; margin-top: -5%">
    <div class="flex flex-wrap -m-12">
        <c:set var="certs" value='${requestScope["certs"]}' />

        <c:forEach items="${certs}" var="cert">
            <div class="p-12 md:w-1/3 flex flex-col items-start">
                <img alt="" style="width: 25%;" src="${cert}">
                <div class="w-12 h-1 bg-pink-500 rounded mt-2 mb-4"></div>
            </div>
        </c:forEach>
    </div>
</div>
</body>
</html>
