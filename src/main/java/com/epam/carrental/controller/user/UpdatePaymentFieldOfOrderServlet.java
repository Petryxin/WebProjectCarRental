package com.epam.carrental.controller.user;

import com.epam.carrental.dao.impl.OrdersDaoImpl;
import com.epam.carrental.model.OrderStatus;
import com.epam.carrental.model.Orders;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/updatePaymentFieldOfOrder"})
public class UpdatePaymentFieldOfOrderServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idParam = req.getParameter("id");
        Integer orderId = Integer.valueOf(idParam);

        OrdersDaoImpl ordersDaoImpl = new OrdersDaoImpl();
        Orders orderById = ordersDaoImpl.getById(orderId);
        orderById.setPayment(true);
        orderById.setOrderStatus(OrderStatus.RENTED);
        ordersDaoImpl.update(orderById);

        req.getServletContext().getRequestDispatcher("/personalOrders").forward(req,resp);
    }
}
