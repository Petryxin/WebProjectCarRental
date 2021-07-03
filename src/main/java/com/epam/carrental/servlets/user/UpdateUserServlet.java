package com.epam.carrental.servlets.user;

import com.epam.carrental.dao.impl.UserWebDaoImpl;
import com.epam.carrental.domain.UserWeb;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/updateUser"})
public class UpdateUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String passportNumber = req.getParameter("passportNumber");
        String paramNumber = req.getParameter("numberOfDays");
        UserWeb userByLogin = (UserWeb)req.getSession().getAttribute("user");

        if (firstName.equals("") || lastName.equals("") || passportNumber.equals("") || paramNumber.equals("")){
            req.setAttribute("emptyFields",true);
            req.getServletContext().getRequestDispatcher("/formOfOrder.jsp").forward(req,resp);
        }
        if(!firstName.equals("") && !lastName.equals("") && !passportNumber.equals("") && !paramNumber.equals("")
                && userByLogin.getPassportNumber() == null) {
            userByLogin.setFirstName(firstName);
            userByLogin.setLastName(lastName);
            userByLogin.setPassportNumber(passportNumber);

            UserWebDaoImpl userWebDaoImpl = new UserWebDaoImpl();
            userWebDaoImpl.update(userByLogin);
        }
        req.getServletContext().getRequestDispatcher("/saveOrder").forward(req,resp);
    }
}
