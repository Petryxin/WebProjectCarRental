package com.epam.carrental.dao.impl;

import com.epam.carrental.dao.AdministratorDao;
import com.epam.carrental.domain.Administrator;
import com.epam.carrental.hibernateutil.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class AdministratorDaoImpl implements AdministratorDao {

    @Override
    public void create(Administrator administrator) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.save(administrator);
            transaction.commit();
        }catch (Exception e){
            if (transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer adminId) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            String hql = "DELETE Administrator WHERE id = :id";
            Query query = session.createQuery(hql);
            query.setParameter("id", adminId);
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
    public void update(Administrator administrator) {

    }

    @Override
    public List<Administrator> getAll() {
        Transaction transaction = null;
        List<Administrator> list = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            String hql = "FROM Administrator";
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
    public Administrator getByLogin(String login) {
        List<Administrator> admins = getAll();
        Administrator administratorByLogin = admins.stream().filter(u -> u.getLogin().equals(login)).findAny().orElse(null);
        return administratorByLogin;
    }
}
