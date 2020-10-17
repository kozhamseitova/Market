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
    <style>
        body{
            background-image: url("${pageContext.request.contextPath}/jsp/img/pink.jpg");
        }
    </style>
</head>
<body>
<%@include file="header.jsp"%>
<section class="text-gray-700 body-font overflow-hidden">
    <div class="container px-5 py-24 mx-auto">
        <div class="flex flex-wrap -m-12">
            <div class="p-12 md:w-1/2 flex flex-col items-start">
                <a href="<%=request.getContextPath()%>/jsp/myCab.jsp" class="inline-block py-1 px-3 rounded bg-pink-100 text-pink-500 text-sm font-medium tracking-widest">SHOPPING CART</a>
            </div>
            <div class="p-12 md:w-1/2 flex flex-col items-start">
                <span class="inline-block py-1 px-3 rounded bg-pink-100 text-pink-500 text-sm font-medium tracking-widest">MY PURCHASES</span>
                <c:set var="buys" value='${requestScope["buys"]}' />

                <c:forEach items="${buys}" var="buys">
                    <div class="flex items-center flex-wrap pb-4 mb-4 border-b-2 border-gray-200 mt-auto w-full">
                        <img alt="" style="width: 25%;" src="${buys.img}">
                        <h2 class="font-medium title-font mt-4 text-gray-900 text-lg">${buys.name}</h2>
                        <p class="text-base text-hotpink-600">Price:  <span class="text-base text-gray-700">${buys.price}</span></p><br>
                    </div>
                </c:forEach>
            </div>
        </div>
    </div>
</section>
</body>
</html>
