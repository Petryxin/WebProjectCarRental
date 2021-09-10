package com.epam.carrental.controller.admin;

import com.epam.carrental.dao.impl.OrdersDaoImpl;
import com.epam.carrental.model.Orders;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet(urlPatterns = {"/orderList"})
public class OrderListForAdminServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        OrdersDaoImpl ordersDaoImpl = new OrdersDaoImpl();
        List<Orders> orderList = ordersDaoImpl.getAll();
        req.getSession().setAttribute("orderList",orderList);

        req.getServletContext().getRequestDispatcher("/orderListForAdmin.jsp").forward(req,resp);
    }
}
