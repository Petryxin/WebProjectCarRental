package com.epam.carrental.controller.admin;

import com.epam.carrental.dao.impl.CarDaoImpl;
import com.epam.carrental.dao.impl.OrdersDaoImpl;
import com.epam.carrental.model.Car;
import com.epam.carrental.model.OrderStatus;
import com.epam.carrental.model.Orders;
import com.epam.carrental.services.OrdersService;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/rejectOrder"})
public class RejectOrderServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idParam = (String) req.getSession().getAttribute("idOrderToReject");
        Integer orderId = Integer.valueOf(idParam);

        String reason = req.getParameter("reason");
        if (reason.equals("")){
            req.setAttribute("emptyFields",true);
            req.getServletContext().getRequestDispatcher("/rejectionReason.jsp").forward(req,resp);
        }else {
            List<Orders> orderList = (List<Orders>)req.getSession().getAttribute("orderList");
            OrdersService ordersService = new OrdersService();
            Orders orderById = ordersService.getOrderById(orderId, orderList);
            orderById.setRejectionReason(reason);
            orderById.setOrderStatus(OrderStatus.REJECTED);

            OrdersDaoImpl orderDaoImpl = new OrdersDaoImpl();
            orderDaoImpl.update(orderById);

            Car car = orderById.getCar();
            car.setRentedCar(false);
            CarDaoImpl carDao = new CarDaoImpl();
            carDao.update(car);
        }
        req.getServletContext().getRequestDispatcher("/orderList").forward(req,resp);
    }
}
