package com.company.controllers;

import com.company.models.Products;
import com.company.models.ShoppingCart;
import com.company.models.User;
import com.company.services.ShopCartService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ShoppingCartServ")
public class ShoppingCartServ extends HttpServlet {
    User user = new User();
    ShopCartService shopCartService = new ShopCartService();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String img = request.getParameter("img");
        String name = request.getParameter("name");
        Double price = Double.parseDouble(request.getParameter("price"));
        long user_id = user.getId();
        shopCartService.addToSC(user_id,id,img,name,price);
        List<ShoppingCart> shopCarts = shopCartService.getAllShopCartProducts();
        request.setAttribute("shopCarts", shopCarts);
        request.getRequestDispatcher("jsp/myCab.jsp").forward(request,response);
    }
}
