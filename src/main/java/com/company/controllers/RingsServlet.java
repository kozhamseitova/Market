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

@WebServlet(name = "RingsServlet")
public class RingsServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        List<Products> rings = ProductsService.getAllRings();

        List<Products> rl = ProductsService.getAllRings();
        Collections.sort(rl, new PriceSorter());

        List<Products> rll = ProductsService.getAllRings();
        rll.sort(Comparator.comparing(Products::getName)); //using lambda

        request.setAttribute("rll", rll);
        request.setAttribute("rl", rl);
        request.setAttribute("rings", rings);
        request.getRequestDispatcher("jsp/ring.jsp").forward(request,response);
    }
}
