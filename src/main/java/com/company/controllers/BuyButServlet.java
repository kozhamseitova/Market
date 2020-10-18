package com.company.controllers;

import com.company.models.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "BuyButServlet")
public class BuyButServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDao userDao = UserDao.getInstance();
        int id = Integer.parseInt(request.getParameter("id"));
        String img = request.getParameter("img");
        String name = request.getParameter("name");
        Double price = Double.parseDouble(request.getParameter("price"));
        User user = (User) request.getSession().getAttribute("user");
        long user_id = userDao.getUserIdByEmail(user.getEmail());

        Buys buy = new Buys();
        buy.setUser_id(user_id);
        buy.setId(id);
        buy.setImg(img);
        buy.setName(name);
        buy.setPrice(price);

        BuyDao buyDao = BuyDao.getInstance();
        buyDao.addProductsToBuy(buy);
        List<Buys> buys = buyDao.getProductsFromBuyByUserId(user_id);

        request.setAttribute("buys", buys);
        request.getRequestDispatcher("jsp/mycab2.jsp").forward(request,response);

    }
}
