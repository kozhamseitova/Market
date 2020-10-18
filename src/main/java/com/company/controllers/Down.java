package com.company.controllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Down")
public class Down extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            PrintWriter out = response.getWriter();

            String path = "C:\\Users\\Acer\\Desktop\\универ\\Джава\\Market1\\src\\main\\webapp\\jsp\\file";

            response.setContentType("APPLICATION/OCTET-STREAM");
            response.setHeader("Content-Disposition","attachment; filename=\"" + "file.txt" + "\"");

            FileInputStream in = new FileInputStream(path);

            int i;
            while ((i = in.read())!=-1){
                out.write(i);
            }
            in.close();
            out.close();
        }catch (Exception e){

        }
    }
}
