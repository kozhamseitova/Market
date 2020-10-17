package com.company.controllers;

import com.company.models.Buys;
import com.company.models.ShoppingCart;
import com.company.services.BuyService;
import com.company.services.ShopCartService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "Buy")
public class Buy extends HttpServlet {
    BuyService buyService = new BuyService();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Buys> buys = buyService.getAllBuyProducts();
        request.setAttribute("buys", buys);
        request.getRequestDispatcher("jsp/mycab2.jsp").forward(request,response);
    }
}
