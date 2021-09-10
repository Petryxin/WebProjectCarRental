package com.epam.carrental.dao.impl;

import com.epam.carrental.dao.RepairBillDao;
import com.epam.carrental.model.RepairBill;
import com.epam.carrental.hibernateutil.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;


public class RepairBillDaoImpl implements RepairBillDao {
    @Override
    public void create(RepairBill repairBill) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.save(repairBill);
            transaction.commit();
        }catch (Exception e){
            if (transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public void update(RepairBill repairBill) {

    }

    @Override
    public List<RepairBill> getAll() {
        Transaction transaction = null;
        List<RepairBill> list = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            String hql = "FROM RepairBill";
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
    public List<RepairBill> getBillsByUserId(Integer userId) {
        Transaction transaction = null;
        List<RepairBill> list = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            String hql = "FROM RepairBill a WHERE a.order.userWeb.id = :id";
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
}
