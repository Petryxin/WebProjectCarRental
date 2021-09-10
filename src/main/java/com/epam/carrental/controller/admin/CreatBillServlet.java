package com.epam.carrental.controller.admin;

import com.epam.carrental.dao.impl.OrdersDaoImpl;
import com.epam.carrental.dao.impl.RepairBillDaoImpl;
import com.epam.carrental.model.OrderStatus;
import com.epam.carrental.model.Orders;
import com.epam.carrental.model.RepairBill;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/creatBill"})
public class CreatBillServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idParam = (String) req.getSession().getAttribute("orderId");
        int orderId = Integer.parseInt(idParam);
        OrdersDaoImpl ordersDao = new OrdersDaoImpl();
        Orders orderById = ordersDao.getById(orderId);

        String amountParam = req.getParameter("amountRepair");
        String damage = req.getParameter("damage");

        if (amountParam.equals("") || damage.equals("")){
            req.setAttribute("emptyFields",true);
            req.getServletContext().getRequestDispatcher("/creatBill.jsp").forward(req,resp);
        }
        if(!amountParam.equals("") && !damage.equals("")) {
            int amountRepair = Integer.parseInt(amountParam);
            RepairBill repairBill = new RepairBill();
            repairBill.setAmountRepair(amountRepair);
            repairBill.setDamage(damage);
            repairBill.setOrder(orderById);

            RepairBillDaoImpl repairBillDao = new RepairBillDaoImpl();
            repairBillDao.create(repairBill);

            orderById.setOrderStatus(OrderStatus.CAR_BEING_REPAIRED);
            ordersDao.update(orderById);
        }
        req.getServletContext().getRequestDispatcher("/orderList").forward(req,resp);
    }
}
