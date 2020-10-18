package com.company.controllers;

import com.company.models.Products;
import com.company.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@WebServlet(name = "AlertMessage")
public class AlertMessage extends HttpServlet {
    static int i = 1;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String hello = getInitParameter("message");
        String nameProduct = request.getParameter("name");
        Double price = Double.parseDouble(request.getParameter("price"));
        /*response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        Cookie cookie;
        Cookie cookies[] = request.getCookies();



        String d = "date";

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
            response.addCookie(ck);
        }else{
            out.println("Your last visit : "+ck.getValue());
            ck.setValue(new java.util.Date().toString());
        }

        if( cookies != null ) {
            out.println("<h2> Found Cookies Name and Value</h2>");
            for (int i = 0; i < cookies.length; i++) {
                    cookie = cookies[i];
                    String s = cookie.getValue();
                    if(s.equals(email)){
                        out.print(hello + ", " + cookie.getValue()+"<h4> Thank you for purchasing from our online store! </h4>");
                        out.println("Product name: " + nameProduct + " Product price: " + price);
                        out.println(" Your last visit: " + ck.getValue());

                    }
            }
        }
        else {
            out.println("<h2>No cookies founds</h2>");
        }*/

        User user = (User) request.getSession().getAttribute("user");
        String email = user.getEmail();

        response.setContentType("text/html");
        HttpSession session = request.getSession();
        PrintWriter printWriter = response.getWriter();

        Integer counter = 0;
        session.setMaxInactiveInterval(60);
        try
        {
            if(session.isNew())
            {
                printWriter.println(hello + " " + email + "<br>");
            }
            else
            {
                printWriter.println("Welcome back " + email + "<br>");
                if(session.getAttribute("counter") != null)
                {
                    counter = (Integer)session.getAttribute("counter")+1;
                    //count = (Integer)session.getAttribute("counter");
                    //counter = new Integer(count.intValue()+1);
                }
            }
            session.setAttribute("counter", counter);

            printWriter.println("inactivity interval "+session.getMaxInactiveInterval()+"<br>");
            Date createDate = new Date(session.getCreationTime());
            Date lastAccess = new Date(session.getCreationTime());
            printWriter.println("creation time "+ createDate +"<br>");
            printWriter.println("last accessed time "+lastAccess+"<br>");

            printWriter.println("you are visiting us: "+(++counter));
            if(counter>1)
                printWriter.println("times");
            else
                printWriter.println("time");

            printWriter.println("You are ordering: " + nameProduct + ", Price: " + price);
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }
}