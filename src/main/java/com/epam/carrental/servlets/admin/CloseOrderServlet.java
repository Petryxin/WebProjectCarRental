package com.epam.carrental.servlets.admin;

import com.epam.carrental.dao.impl.CarDaoImpl;
import com.epam.carrental.dao.impl.OrdersDaoImpl;
import com.epam.carrental.domain.Car;
import com.epam.carrental.domain.OrderStatus;
import com.epam.carrental.domain.Orders;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/closeOrder"})
public class CloseOrderServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idParam = req.getParameter("orderId");
        Integer orderId = Integer.valueOf(idParam);
        OrdersDaoImpl ordersDao = new OrdersDaoImpl();
        Orders orderById = ordersDao.getById(orderId);

        Car car = orderById.getCar();
        car.setRentedCar(false);
        CarDaoImpl carDao = new CarDaoImpl();
        carDao.update(car);

        orderById.setOrderStatus(OrderStatus.COMPLETED);
        ordersDao.update(orderById);

        req.getServletContext().getRequestDispatcher("/orderList").forward(req,resp);
    }
}
