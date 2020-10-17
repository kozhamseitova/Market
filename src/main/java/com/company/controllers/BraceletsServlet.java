package com.company.controllers;

import com.company.models.Products;
import com.company.services.ProductsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "BraceletsServlet")
public class BraceletsServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        List<Products> bracelets = ProductsService.getAllBracelets();
        request.setAttribute("bracelets", bracelets);
        request.getRequestDispatcher("jsp/bracelets.jsp").forward(request,response);
    }
}
