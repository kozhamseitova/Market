package com.company.controllers;

import com.company.models.User;
import com.company.models.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SignUp")
public class SignUp extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        register(request,response);
    }


    private void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        User user = new User();
        user.setEmail(email);
        user.setPassword(password);

        UserDao userDao = UserDao.getInstance();
        userDao.addUser(user);

        response.sendRedirect(request.getContextPath() + "/jsp/signInUp.jsp");

    }
}
