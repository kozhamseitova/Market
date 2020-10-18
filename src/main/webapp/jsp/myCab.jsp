<%@ page import="com.company.models.ShopCartDao" %><%--
  Created by IntelliJ IDEA.
  User: Acer
  Date: 17.10.2020
  Time: 12:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>My Cab</title>
    <link rel="stylesheet" type="text/css" href="l.css" />
    <style>
        body{
            background-image: url("${pageContext.request.contextPath}/jsp/img/pink.jpg");
        }
    </style>
</head>
<body>
<%@include file="header.jsp"%>
<h3 style="color: hotpink; text-align: center;font-size: 60px;">Shopping Cart</h3>
<div class="container px-5 py-24 mx-auto" style="margin-left: 5%; margin-top: -5%">
    <div class="flex flex-wrap -m-12">
        <c:set var="shopCarts" value='${requestScope["shopCarts"]}' />

        <c:forEach items="${shopCarts}" var="shopCart">
            <div class="p-12 md:w-1/3 flex flex-col items-start">
                <img alt="" style="width: 25%;" src="${shopCart.img}">
                <h2 class="font-medium title-font mt-4 text-gray-900 text-lg">${shopCart.name}</h2>
                <div class="w-12 h-1 bg-pink-500 rounded mt-2 mb-4"></div>
                <p class="text-base text-hotpink-600">Price:  <span class="text-base text-gray-700">${shopCart.price}</span></p>
                <a id="o" class="text-white bg-pink-500 border-0 py-1 px-8 focus:outline-none hover:bg-pink-600 rounded text-lg" href="<%=request.getContextPath()%>/alert?id=${shopCart.id}&img=${shopCart.img}&name=${shopCart.name}&price=${shopCart.price}">Order</a>
                <a id="b" class="text-white bg-pink-500 border-0 py-1 px-8 focus:outline-none hover:bg-pink-600 rounded text-lg" href="<%=request.getContextPath()%>/buyBut?id=${shopCart.id}&img=${shopCart.img}&name=${shopCart.name}&price=${shopCart.price}">Buy</a>
            </div>
        </c:forEach>
    </div>
</div>
</body>
</html>
