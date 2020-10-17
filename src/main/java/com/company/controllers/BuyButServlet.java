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

@WebServlet(name = "BuyButServlet")
public class BuyButServlet extends HttpServlet {
    BuyService buyService = new BuyService();
    ShopCartService shopCartService = new ShopCartService();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        long user_id = Long.parseLong(request.getParameter("user_id"));
        int id = Integer.parseInt(request.getParameter("id"));
        String img = request.getParameter("img");
        String name = request.getParameter("name");
        Double price = Double.parseDouble(request.getParameter("price"));
        buyService.addToBuys(user_id,id,img,name,price);
        List<Buys> buys = buyService.getAllBuyProducts();
        request.setAttribute("buys", buys);
        request.getRequestDispatcher("jsp/mycab2.jsp").forward(request,response);
    }
}
