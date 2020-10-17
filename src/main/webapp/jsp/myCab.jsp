<%--
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
</head>
<body>
<%@include file="header.jsp"%>
<section class="text-gray-700 body-font overflow-hidden">
    <div class="container px-5 py-24 mx-auto">
        <div class="flex flex-wrap -m-12">
            <div class="p-12 md:w-1/2 flex flex-col items-start">
                <span class="inline-block py-1 px-3 rounded bg-pink-100 text-pink-500 text-sm font-medium tracking-widest">SHOPPING CART</span>
                <c:set var="shopCarts" value='${requestScope["shopCarts"]}' />

                <c:forEach items="${shopCarts}" var="shopCart">
                    <div class="flex items-center flex-wrap pb-4 mb-4 border-b-2 border-gray-200 mt-auto w-full">
                        <img alt="" style="width: 25%;" src="${shopCart.img}">
                        <h2 class="font-medium title-font mt-4 text-gray-900 text-lg">${shopCart.name}</h2>
                        <p class="text-base text-hotpink-600">Price:  <span class="text-base text-gray-700">${shopCart.price}</span></p><br>
                        <a class="text-white bg-pink-500 border-0 py-2 px-8 focus:outline-none hover:bg-pink-600 rounded text-lg" href="<%=request.getContextPath()%>/buy?user_id=${shopCart.user_id}&id=${shopCart.id}&img=${shopCart.img}&name=${shopCart.name}&price=${shopCart.price}">Buy</a>
                    </div>
                </c:forEach>
            </div>
            <div class="p-12 md:w-1/2 flex flex-col items-start">
                <span class="inline-block py-1 px-3 rounded bg-pink-100 text-pink-500 text-sm font-medium tracking-widest">MY PURCHASES</span>

            </div>
        </div>
    </div>
</section>
</body>
</html>
