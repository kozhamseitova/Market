package com.company.controllers;

import com.company.models.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "Buy")
public class Buy extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDao userDao = UserDao.getInstance();
        User user = (User) request.getSession().getAttribute("user");
        long user_id = userDao.getUserIdByEmail(user.getEmail());
        BuyDao buyDao = BuyDao.getInstance();
        List<Buys> buys = buyDao.getProductsFromBuyByUserId(user_id);
        request.setAttribute("buys", buys);
        request.getRequestDispatcher("jsp/mycab2.jsp").forward(request,response);
    }
}
