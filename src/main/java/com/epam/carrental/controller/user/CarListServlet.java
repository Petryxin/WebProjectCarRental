package com.epam.carrental.controller.user;

import com.epam.carrental.dao.impl.CarDaoImpl;
import com.epam.carrental.model.Car;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/carList"})
public class CarListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CarDaoImpl car = new CarDaoImpl();
        List<Car> listCars = car.getAll();

        req.getSession().setAttribute("car_list",listCars);

        req.getServletContext().getRequestDispatcher("/carList.jsp").forward(req,resp);
    }
}
