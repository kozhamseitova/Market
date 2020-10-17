<%--
  Created by IntelliJ IDEA.
  User: Acer
  Date: 12.10.2020
  Time: 15:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://unpkg.com/tailwindcss@^1.0/dist/tailwind.min.css" rel="stylesheet">
</head>
<body>
<header class="text-gray-700 body-font">
    <div class="container mx-auto flex flex-wrap p-5 flex-col md:flex-row items-center">
        <a class="flex title-font font-medium items-center text-gray-900 mb-4 md:mb-0" href="main.jsp">
            <img src="${pageContext.request.contextPath}/jsp/img/logo.png" class="w-20 h-20 text-white p-2 "><span>PINK SHOP</span>
        </a>
        <nav class="md:ml-auto md:mr-auto flex flex-wrap items-center text-base justify-center">
            <a class="mr-5 hover:text-gray-900" href="${pageContext.request.contextPath}/jsp/main.jsp">Main</a>
            <%
                if(session.getAttribute("user")!=null){

            %>
            <a class="mr-5 hover:text-gray-900" href="${pageContext.request.contextPath}/ringsServlet">Rings</a>
            <a class="mr-5 hover:text-gray-900" href="${pageContext.request.contextPath}/braceletsServlet">Bracelets</a>
            <a class="mr-5 hover:text-gray-900" href="${pageContext.request.contextPath}/neckEar">Necklaces and Earrings</a>
            <a class="mr-5 hover:text-gray-900" href="${pageContext.request.contextPath}/buy">My orders</a>

            <%
                }
            %>
        </nav>
        <button class="inline-flex items-center bg-pink-200 border-0 py-1 px-3 focus:outline-none hover:bg-pink-200 rounded text-base mt-4 md:mt-0">Log out
            <a href="${pageContext.request.contextPath}/logOut"><svg fill="none" stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" class="w-4 h-4 ml-1" viewBox="0 0 24 24">
                <path d="M5 12h14M12 5l7 7-7 7"></path>
            </svg>
            </a>
        </button>
    </div>
</header>
