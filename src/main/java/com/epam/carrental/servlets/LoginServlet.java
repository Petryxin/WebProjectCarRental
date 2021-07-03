package com.epam.carrental.servlets;

import com.epam.carrental.dao.impl.AdministratorDaoImpl;
import com.epam.carrental.dao.impl.OrdersDaoImpl;
import com.epam.carrental.dao.impl.UserWebDaoImpl;
import com.epam.carrental.domain.Administrator;
import com.epam.carrental.domain.Orders;
import com.epam.carrental.domain.UserWeb;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        UserWebDaoImpl userWebDaoImpl = new UserWebDaoImpl();
        UserWeb userByLogin = userWebDaoImpl.getByLogin(login);

        if (userByLogin != null && userByLogin.getPassword().equals(password) ){
            req.getSession().setAttribute("user",userByLogin);
            Integer userId = userByLogin.getId();

            OrdersDaoImpl ordersDao = new OrdersDaoImpl();
            List<Orders> ordersByUserId = ordersDao.getOrdersByUserId(userId);

            if(!ordersByUserId.isEmpty()){
                req.getSession().setAttribute("personalOrders",ordersByUserId);
                req.getServletContext().getRequestDispatcher("/personalOrders").forward(req,resp);
            }
            req.getServletContext().getRequestDispatcher("/carList").forward(req,resp);
        }

        AdministratorDaoImpl administratorDaoImpl = new AdministratorDaoImpl();
        Administrator adminByLogin = administratorDaoImpl.getByLogin(login);

        if (adminByLogin != null && adminByLogin.getPassword().equals(password)){
            req.getSession().setAttribute("admin",adminByLogin);
            req.getServletContext().getRequestDispatcher("/orderList").forward(req,resp);
        }else {
            req.setAttribute("userNotFound",true);
            req.getServletContext().getRequestDispatcher("/").forward(req,resp);
        }
    }
}
