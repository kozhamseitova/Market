package com.company.controllers;

import com.company.models.Products;
import com.company.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "AlertMessage")
public class AlertMessage extends HttpServlet {
    static int i = 1;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String nameProduct = request.getParameter("name");
        Double price = Double.parseDouble(request.getParameter("price"));


        Cookie cookie;
        Cookie cookies[] = request.getCookies();

        User user = (User) request.getSession().getAttribute("user");
        String email = user.getEmail();

        if( cookies != null ) {
            out.println("<h2> Found Cookies Name and Value</h2>");
            for (int i = 0; i < cookies.length; i++) {
                    cookie = cookies[i];
                    String s = cookie.getValue();
                    String d = "date";
                    if(s.equals(email)){
                        out.print(cookie.getValue()+"<h4> Thank you for purchasing from our online store! </h4>");
                        out.println("Product name: " + nameProduct + " Product price: " + price);
                        Cookie ck = null;
                        if(cookies!=null)
                        {
                            for(int o=0;o<cookies.length;o++)
                            {
                                String name=cookies[o].getName();
                                if(d.equals(name)){
                                    ck=cookies[o];
                                    break;
                                }
                            }
                        }
                        if(ck==null){
                            ck=new Cookie("date",new java.util.Date().toString());
                            out.print(" Your last visit: " + ck.getValue());

                        }else{
                            out.println("Your last visit : "+ck.getValue());
                            ck.setValue(new java.util.Date().toString());
                        }
                        response.addCookie(ck);

                    }
            }
        }
        else {
            out.println("<h2>No cookies founds</h2>");
        }
    }
}