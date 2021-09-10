package com.epam.carrental.controller.user;

import com.epam.carrental.dao.impl.CarDaoImpl;
import com.epam.carrental.dao.impl.OrdersDaoImpl;
import com.epam.carrental.model.Car;
import com.epam.carrental.model.OrderStatus;
import com.epam.carrental.model.Orders;
import com.epam.carrental.model.UserWeb;
import com.epam.carrental.services.OrdersService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/saveOrder"})
public class SaveOrderServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //String passportNumber = req.getParameter("passportNumber");
        String paramNumber = req.getParameter("numberOfDays");
        int numberOfDays = Integer.parseInt(paramNumber);
        UserWeb user = (UserWeb)req.getSession().getAttribute("user");

        Car car = (Car)req.getSession().getAttribute("selected_car");
        Integer carId = car.getId();
        int paymentPerDay = car.getPaymentPerDay();

        CarDaoImpl carDao = new CarDaoImpl();
        Car carById = carDao.getById(carId);
        boolean rentedCar = carById.isRentedCar();
        if (!rentedCar) {
            car.setRentedCar(true);
            carDao.update(car);

            OrdersService ordersService = new OrdersService();
            int amount = ordersService.getAmount(numberOfDays, paymentPerDay);

            Orders order = new Orders();
            order.setNumberOfDays(numberOfDays);
            //order.setPassportNumberOfUser(passportNumber);
            order.setAmount(amount);
            order.setUserWeb(user);
            order.setCar(car);
            order.setOrderStatus(OrderStatus.IN_PROGRESS);
            OrdersDaoImpl ordersDaoImpl = new OrdersDaoImpl();
            ordersDaoImpl.create(order);

            req.getSession().setAttribute("order", order);
        }
        req.getServletContext().getRequestDispatcher("/personalOrders").forward(req,resp);
    }
}
