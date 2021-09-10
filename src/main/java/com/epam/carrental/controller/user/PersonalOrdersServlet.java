package com.epam.carrental.controller.user;

import com.epam.carrental.dao.impl.OrdersDaoImpl;
import com.epam.carrental.dao.impl.RepairBillDaoImpl;
import com.epam.carrental.model.Orders;
import com.epam.carrental.model.RepairBill;
import com.epam.carrental.model.UserWeb;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/personalOrders"})
public class PersonalOrdersServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserWeb user = (UserWeb)req.getSession().getAttribute("user");
        Integer userId = user.getId();

        RepairBillDaoImpl repairBillDao = new RepairBillDaoImpl();
        List<RepairBill> billsByUserId = repairBillDao.getBillsByUserId(userId);
        req.getSession().setAttribute("bills",billsByUserId);

        OrdersDaoImpl ordersDao = new OrdersDaoImpl();
        List<Orders> ordersByUserId = ordersDao.getOrdersByUserId(userId);

        req.getSession().setAttribute("personalOrders",ordersByUserId);

        req.getServletContext().getRequestDispatcher("/orderListForUser.jsp").forward(req,resp);
    }
}
