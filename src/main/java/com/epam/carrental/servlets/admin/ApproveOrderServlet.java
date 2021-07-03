package com.epam.carrental.servlets.admin;

import com.epam.carrental.dao.impl.OrdersDaoImpl;
import com.epam.carrental.domain.OrderStatus;
import com.epam.carrental.domain.Orders;
import com.epam.carrental.services.OrdersService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/approveOrder"})
public class ApproveOrderServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idParam = req.getParameter("id");
        Integer orderId = Integer.valueOf(idParam);

        List<Orders> orderList = (List<Orders>)req.getSession().getAttribute("orderList");

        OrdersService ordersService = new OrdersService();
        Orders orderById = ordersService.getOrderById(orderId, orderList);
        orderById.setApproval(true);
        orderById.setOrderStatus(OrderStatus.APPROVED);

        OrdersDaoImpl orderDaoImpl = new OrdersDaoImpl();
        orderDaoImpl.update(orderById);
        req.getServletContext().getRequestDispatcher("/orderList").forward(req,resp);
    }
}
