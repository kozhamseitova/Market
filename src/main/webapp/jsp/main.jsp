<%@ page import="com.company.models.User" %><%--
  Created by IntelliJ IDEA.
  User: Acer
  Date: 12.10.2020
  Time: 22:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Main</title>
    <link rel="stylesheet" type="text/css" href="l.css" />
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</head>
<body>
<%@include file="header.jsp"%>
<img src="img/main.png" style="margin-left: 17%">

<h1 style="color: hotpink; text-align: center;font-size: 60px;">Pink Shop</h1>
<p style="text-align: center">In our online shop you can find different jewelry to your daily mood</p>
<%--
to show all users only if admin will authorized
--%>
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
</body>
</html>
