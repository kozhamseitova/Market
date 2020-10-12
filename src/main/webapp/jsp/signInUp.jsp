<%--
  Created by IntelliJ IDEA.
  User: Acer
  Date: 12.10.2020
  Time: 20:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="l.css" />
    <script src="https://code.jquery.com/jquery-3.5.1.js" crossorigin="anonymous"></script>
    <script>
        $( document ).ready(function() {
                var a = false;
                var b = false;
                $("#signIn").on("click", function () {
                    if (a == false) {
                        $("#in").css("display", "block")
                        $("#up").css("display", "none")
                        a = true;
                        b = false;
                    } else {
                        $("#in").css("display", "none")
                        a = false;
                    }
                });
                $("#signUp").on("click", function () {
                    if (a == false) {
                        $("#up").css("display", "block")
                        $("#in").css("display", "none")
                        a = true;
                        b = false;
                    } else {
                        $("#up").css("display", "none")
                        a = false;
                    }
                });
            });
    </script>
</head>
<body>
<%@include file="header.jsp"%>
<section class="text-gray-700 body-font" id="up" style="display: block">
        <div class="lg:w-2/6 md:w-1/2 bg-gray-200 rounded-lg p-8 flex flex-col md:ml-auto w-full mt-10 md:mt-0">
            <h2 class="text-gray-900 text-lg font-medium title-font mb-5">Sign Up</h2>
            <form method="post" action="">
                <input class="bg-white rounded border border-gray-400 focus:outline-none focus:border-pink-500 text-base px-4 py-2 mb-4" placeholder="email" type="email">
                <input class="bg-white rounded border border-gray-400 focus:outline-none focus:border-pink-500 text-base px-4 py-2 mb-4" placeholder="password" type="password">
                <input type="submit" value="submit" class="text-white bg-pink-500 border-0 py-2 px-8 focus:outline-none hover:bg-pink-600 rounded text-lg">
            </form>
            <p class="text-xs text-gray-500 mt-3">If you already have an account, please <a id="signIn" style="color: pink">Sign in</a></p>
        </div>
    </div>
</section>
<section class="text-gray-700 body-font" id="in" style="display: none">
    <div class="lg:w-2/6 md:w-1/2 bg-gray-200 rounded-lg p-8 flex flex-col md:ml-auto w-full mt-10 md:mt-0">
        <h2 class="text-gray-900 text-lg font-medium title-font mb-5">Sign In</h2>
        <form method="post" action="">
            <input class="bg-white rounded border border-gray-400 focus:outline-none focus:border-pink-500 text-base px-4 py-2 mb-4" placeholder="email" type="email">
            <input class="bg-white rounded border border-gray-400 focus:outline-none focus:border-pink-500 text-base px-4 py-2 mb-4" placeholder="password" type="password">
            <input type="submit" value="submit" class="text-white bg-pink-500 border-0 py-2 px-8 focus:outline-none hover:bg-pink-600 rounded text-lg">
        </form>
        <p class="text-xs text-gray-500 mt-3">If you don't have an account yet, <a id="signUp" style="color: pink ">Sign Up</a></p>
    </div>
    </div>
</section>
</body>
</html>
