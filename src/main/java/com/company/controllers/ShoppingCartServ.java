package com.company.controllers;

import com.company.models.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "ShoppingCartServ")
public class ShoppingCartServ extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDao userDao = UserDao.getInstance();

        int id = Integer.parseInt(request.getParameter("id"));
        String img = request.getParameter("img");
        String name = request.getParameter("name");
        Double price = Double.parseDouble(request.getParameter("price"));
        User user = (User) request.getSession().getAttribute("user");
        long user_id = userDao.getUserIdByEmail(user.getEmail());

        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setUser_id(user_id);
        shoppingCart.setId(id);
        shoppingCart.setImg(img);
        shoppingCart.setName(name);
        shoppingCart.setPrice(price);


        PrintWriter writer = new PrintWriter("C:\\Users\\Acer\\Desktop\\универ\\Джава\\Market1\\src\\main\\webapp\\jsp\\file\\file.txt", "UTF-8");
        writer.println(name + " " + price);
        writer.close();


        ShopCartDao shopCartDao = ShopCartDao.getInstance();
        shopCartDao.addProductsToShopCart(shoppingCart);
        List<ShoppingCart> shopCarts = shopCartDao.getProductsFromShopCartByUserId(user_id);
        request.setAttribute("shopCarts", shopCarts);
        request.getRequestDispatcher("jsp/myCab.jsp").forward(request,response);

    }
}
