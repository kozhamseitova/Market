package com.company.controllers;

import com.company.services.AddressService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Set;

@WebServlet(name = "Addresses")
public class Addresses extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HashMap<String, String> addresses = AddressService.getAddresses();

        Set<String> certs = AddressService.getCert();

        request.setAttribute("certs", certs);
        request.setAttribute("addresses", addresses);
        request.getRequestDispatcher("jsp/main.jsp").forward(request,response);
    }


}
