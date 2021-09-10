package com.epam.carrental.dao.impl;

import com.epam.carrental.dao.OrdersDao;
import com.epam.carrental.model.Orders;
import com.epam.carrental.hibernateutil.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class OrdersDaoImpl implements OrdersDao {

    @Override
    public void create(Orders orders) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.save(orders);
            transaction.commit();
        }catch (Exception e){
            if (transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer orderId) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            String hql = "DELETE Orders WHERE id = :id";
            Query query = session.createQuery(hql);
            query.setParameter("id", orderId);
            int rows = query.executeUpdate();
            transaction.commit();
        }catch (Exception e){
            if (transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void update(Orders order) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            String hql = "update Orders "
                    + "SET approval = :approval "
                    +   ", payment = :payment "
                    +   ", rejectionReason = :rejectionReason "
                    +   ", orderStatus = :orderStatus "
                    +  " where id = :idParam";
            Query query = session.createQuery(hql);
            query.setParameter("approval", order.isApproval());
            query.setParameter("rejectionReason",order.getRejectionReason());
            query.setParameter("payment",order.isPayment());
            query.setParameter("orderStatus",order.getOrderStatus());
            query.setParameter("idParam", order.getId());
            int result = query.executeUpdate();
            transaction.commit();
        }catch (Exception e){
            if (transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public List<Orders> getAll() {
        Transaction transaction = null;
        List<Orders> list = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            String hql = "FROM Orders";
            Query query = session.createQuery(hql);
            list = query.list();
            transaction.commit();
        }catch (Exception e){
            if (transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Orders> getOrdersByUserId(Integer userId) {
        Transaction transaction = null;
        List<Orders> list = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            String hql = "FROM Orders a WHERE a.userWeb.id = :id";
            Query query = session.createQuery(hql);
            query.setParameter("id", userId);
            list = query.list();
            transaction.commit();
        }catch (Exception e){
            if (transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Orders getById(Integer orderId) {
        Transaction transaction = null;
        Orders orderById = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            String hql = "FROM Orders WHERE id = :id";
            Query query = session.createQuery(hql);
            query.setParameter("id", orderId);
            orderById = (Orders) query.uniqueResult();
            transaction.commit();
        }catch (Exception e){
            if (transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return orderById;
    }


}
