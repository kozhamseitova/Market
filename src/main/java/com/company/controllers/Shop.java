package com.company.controllers;

import com.company.models.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "Shop")
public class Shop extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDao userDao = UserDao.getInstance();
        User user = (User) request.getSession().getAttribute("user");
        long user_id = userDao.getUserIdByEmail(user.getEmail());
        ShopCartDao shopCartDao = ShopCartDao.getInstance();
        List<ShoppingCart> shopCarts = shopCartDao.getProductsFromShopCartByUserId(user_id);
        request.setAttribute("shopCarts", shopCarts);
        request.getRequestDispatcher("jsp/myCab.jsp").forward(request,response);

    }
}
