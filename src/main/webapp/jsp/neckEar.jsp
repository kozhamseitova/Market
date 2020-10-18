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
    <script src="https://code.jquery.com/jquery-3.5.1.js" crossorigin="anonymous"></script>
    <style>
        body{
            background-image: url("${pageContext.request.contextPath}/jsp/img/pink.jpg");
        }
    </style>
    <script>
        $( document ).ready(function() {
            var a = false;
            var b = false;
            var c = false;
            $("#so").on("click", function () {
                if (a == false) {
                    $("#r2").css("display", "block")
                    $("#r").css("display", "none")
                    $("#r3").css("display", "none")
                    a = true;
                    b = false;
                    c = false;
                } else {
                    $("#r2").css("display", "none")
                    a = false;
                }
            });
            $("#so1").on("click", function () {
                if (b == false) {
                    $("#r").css("display", "block")
                    $("#r2").css("display", "none")
                    $("#r3").css("display", "none")
                    b = true;
                    a = false;
                    c = false;
                } else {
                    $("#r").css("display", "none")
                    b = false;
                }
            });
            $("#soo").on("click", function () {
                if (c == false) {
                    $("#r3").css("display", "block")
                    $("#r2").css("display", "none")
                    $("#r").css("display", "none")
                    c = true;
                    b = false;
                    a = false;
                } else {
                    $("#r3").css("display", "none")
                    c = false;
                }
            });
        });
    </script>
</head>
<body>
<%@include file="header.jsp"%>
<h3 style="color: hotpink; text-align: center;font-size: 60px; margin-top: -2%">Necklaces and Earrings</h3>
<nav class="md:ml-auto md:mr-auto flex flex-wrap items-center text-base justify-center">
    <a id="so" class="mr-5 hover:text-pink-900" >Sort By price</a>
    <a id="soo" class="mr-5 hover:text-pink-900" >Sort By name</a>
    <a id="so1" class="mr-5 hover:text-pink-900" >Previous list</a>
</nav>
<div class="container px-5 py-24 mx-auto" style="display: block; margin-left: 5%; margin-top: -5%" id="r" >
<div class="flex flex-wrap -m-12">
<c:set var="neckEars" value='${requestScope["neckEars"]}' />

<c:forEach items="${neckEars}" var="neckEar">
    <div class="p-12 md:w-1/3 flex flex-col items-start">
        <img alt="" style="width: 25%;" src="${neckEar.img}">
        <h2 class="font-medium title-font mt-4 text-gray-900 text-lg">${neckEar.name}</h2>
        <div class="w-12 h-1 bg-pink-500 rounded mt-2 mb-4"></div>
        <p class="text-base text-hotpink-600">Price:  <span class="text-base text-gray-700">${neckEar.price}</span></p>
        <a class="text-white bg-pink-500 border-0 py-2 px-8 focus:outline-none hover:bg-pink-600 rounded text-lg" href="<%=request.getContextPath()%>/shopCart?id=${neckEar.id}&img=${neckEar.img}&name=${neckEar.name}&price=${neckEar.price}">Add to Shopping Cart</a>

    </div>
</c:forEach>
</div>
</div>

<div class="container px-5 py-24 mx-auto" style="display: none; margin-left: 5%; margin-top: -5%" id="r2" >
    <div class="flex flex-wrap -m-12">
        <c:set var="necks" value='${requestScope["necks"]}' />

        <c:forEach items="${necks}" var="neck">
            <div class="p-12 md:w-1/3 flex flex-col items-start">
                <img alt="" style="width: 25%;" src="${neck.img}">
                <h2 class="font-medium title-font mt-4 text-gray-900 text-lg">${neck.name}</h2>
                <div class="w-12 h-1 bg-pink-500 rounded mt-2 mb-4"></div>
                <p class="text-base text-hotpink-600">Price:  <span class="text-base text-gray-700">${neck.price}</span></p>
                <a class="text-white bg-pink-500 border-0 py-2 px-8 focus:outline-none hover:bg-pink-600 rounded text-lg" href="<%=request.getContextPath()%>/shopCart?id=${neck.id}&img=${neck.img}&name=${neck.name}&price=${neck.price}">Add to Shopping Cart</a>

            </div>
        </c:forEach>
    </div>
</div>

<div class="container px-5 py-24 mx-auto" style="display: none; margin-left: 5%; margin-top: -5%" id="r3" >
    <div class="flex flex-wrap -m-12">
        <c:set var="nec" value='${requestScope["nec"]}' />

        <c:forEach items="${nec}" var="n">
            <div class="p-12 md:w-1/3 flex flex-col items-start">
                <img alt="" style="width: 25%;" src="${n.img}">
                <h2 class="font-medium title-font mt-4 text-gray-900 text-lg">${n.name}</h2>
                <div class="w-12 h-1 bg-pink-500 rounded mt-2 mb-4"></div>
                <p class="text-base text-hotpink-600">Price:  <span class="text-base text-gray-700">${n.price}</span></p>
                <a class="text-white bg-pink-500 border-0 py-2 px-8 focus:outline-none hover:bg-pink-600 rounded text-lg" href="<%=request.getContextPath()%>/shopCart?id=${n.id}&img=${n.img}&name=${n.name}&price=${n.price}">Add to Shopping Cart</a>

            </div>
        </c:forEach>
    </div>
</div>
</body>
</html>

