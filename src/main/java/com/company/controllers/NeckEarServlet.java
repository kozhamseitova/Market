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

@WebServlet(name = "NeckEarServlet")
public class NeckEarServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        List<Products> neckEar = ProductsService.getAllNecklacesEarrings();
        request.setAttribute("neckEars", neckEar);
        request.getRequestDispatcher("jsp/neckEar.jsp").forward(request,response);
    }
}
