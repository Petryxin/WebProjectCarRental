package com.epam.carrental.controller.admin;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet(urlPatterns = {"/rejectionOrderById"})
public class RejectionOrderById extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idOrder = req.getParameter("id");
        req.getSession().setAttribute("idOrderToReject",idOrder);
        req.getServletContext().getRequestDispatcher("/rejectionReason.jsp").forward(req,resp);
    }
}
