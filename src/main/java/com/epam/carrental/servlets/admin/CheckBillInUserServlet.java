package com.epam.carrental.servlets.admin;

import com.epam.carrental.dao.impl.RepairBillDaoImpl;
import com.epam.carrental.domain.RepairBill;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/checkBill"})
public class CheckBillInUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idParam = req.getParameter("userId");
        Integer userId = Integer.valueOf(idParam);

        String orderId = req.getParameter("orderId");
        req.getSession().setAttribute("orderId",orderId);

        RepairBillDaoImpl repairBillDao = new RepairBillDaoImpl();
        List<RepairBill> billsByUserId = repairBillDao.getBillsByUserId(userId);
        if (billsByUserId.isEmpty()){
            req.getServletContext().getRequestDispatcher("/creatBill.jsp").forward(req,resp);
        }
        req.getServletContext().getRequestDispatcher("/orderList").forward(req,resp);
    }
}
