package com.company.controllers;

import com.company.models.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

@WebServlet(name = "ShowUsers")
public class ShowUsers extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDao userDao = UserDao.getInstance();
        HashMap<Long, String> users = userDao.getAllUsers();
        request.setAttribute("users", users);
        request.getRequestDispatcher("jsp/main.jsp").forward(request,response);
    }
}
