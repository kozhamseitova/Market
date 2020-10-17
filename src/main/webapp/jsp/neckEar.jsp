<%--
  Created by IntelliJ IDEA.
  User: Acer
  Date: 13.10.2020
  Time: 0:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Necklaces and Earrings</title>
    <link href="https://unpkg.com/tailwindcss@^1.0/dist/tailwind.min.css" rel="stylesheet">
    <style>
        body{
            background-image: url("${pageContext.request.contextPath}/jsp/img/pink.jpg");
        }
    </style>
</head>
<body>
<%@include file="header.jsp"%>
<h1 style="color: hotpink; font-family: Great Vibes, cursive; font-size: 60px; font-weight: normal; text-align: center; text-shadow: 0 1px 1px #fff">Necklaces and Earrings</h1>
<div class="container px-5 py-24 mx-auto" style="margin-left: 5%; margin-top: -5%">
<div class="flex flex-wrap -m-12">
<c:set var="neckEars" value='${requestScope["neckEars"]}' />

<c:forEach items="${neckEars}" var="neckEar">
    <div class="p-12 md:w-1/3 flex flex-col items-start">
        <img alt="" style="width: 25%;" src="${neckEar.img}">
        <h2 class="font-medium title-font mt-4 text-gray-900 text-lg">${neckEar.name}</h2>
        <div class="w-12 h-1 bg-pink-500 rounded mt-2 mb-4"></div>
        <p class="text-base text-hotpink-600">Price:  <span class="text-base text-gray-700">${neckEar.price}</span></p>
        <a class="text-white bg-pink-500 border-0 py-2 px-8 focus:outline-none hover:bg-pink-600 rounded text-lg" href="<%=request.getContextPath()%>/shopCart?id=${neckEar.id}&img=${neckEar.img}&name=${neckEar.name}&price=${neckEar.price}">Add to Shopping Cart</a>
\
    </div>
</c:forEach>
</div>
</div>
</body>
</html>

