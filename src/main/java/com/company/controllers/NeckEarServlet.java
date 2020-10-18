package com.company.controllers;

import com.company.models.Products;
import com.company.services.ProductsService;
import com.company.sort.PriceSorter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@WebServlet(name = "NeckEarServlet")
public class NeckEarServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        List<Products> neckEar = ProductsService.getAllNecklacesEarrings();

        List<Products> necks = ProductsService.getAllNecklacesEarrings();
        Collections.sort(necks, new PriceSorter());

        List<Products> nec = ProductsService.getAllNecklacesEarrings();
        nec.sort(Comparator.comparing(Products::getName)); //using lambda

        request.setAttribute("nec", nec);
        request.setAttribute("necks", necks);
        request.setAttribute("neckEars", neckEar);
        request.getRequestDispatcher("jsp/neckEar.jsp").forward(request,response);
    }
}
