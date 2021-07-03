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

@WebServlet(urlPatterns = {"/changeCarStatus"})
public class ChangeCarStatusServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idParam = req.getParameter("carId");
        Integer carId = Integer.valueOf(idParam);

        CarDaoImpl carDao = new CarDaoImpl();
        Car car = carDao.getById(carId);
        car.setRentedCar(false);
        carDao.update(car);

        String idParamOrder = req.getParameter("orderId");
        Integer orderId = Integer.valueOf(idParamOrder);

        OrdersDaoImpl ordersDaoImpl = new OrdersDaoImpl();
        Orders order = ordersDaoImpl.getById(orderId);
        order.setOrderStatus(OrderStatus.COMPLETED);
        ordersDaoImpl.update(order);

        req.getServletContext().getRequestDispatcher("/orderList").forward(req,resp);
    }
}
