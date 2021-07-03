package com.epam.carrental.servlets.user;

import com.epam.carrental.domain.Car;
import com.epam.carrental.services.CarService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/carById"})
public class CarByIdServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idParam = req.getParameter("id");
        Integer carId = Integer.valueOf(idParam);

        List<Car> cars = (List<Car>) req.getSession().getAttribute("car_list");
        CarService carService = new CarService();
        Car selectedCar = carService.getSelectedCar(carId, cars);
        req.getSession().setAttribute("selected_car",selectedCar);

        req.getServletContext().getRequestDispatcher("/formOfOrder.jsp").forward(req,resp);
    }
}
