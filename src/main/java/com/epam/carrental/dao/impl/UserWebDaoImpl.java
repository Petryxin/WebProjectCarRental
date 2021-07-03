package com.epam.carrental.dao.impl;


import com.epam.carrental.dao.UserWebDao;
import com.epam.carrental.domain.UserWeb;
import com.epam.carrental.hibernateutil.HibernateUtil;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;


import java.util.List;

public class UserWebDaoImpl implements UserWebDao {

    @Override
    public List<UserWeb> getAll() {
        Transaction transaction = null;
        List<UserWeb> list = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            String hql = "FROM UserWeb";
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
    public void create(UserWeb userWeb) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.save(userWeb);
            transaction.commit();
        }catch (Exception e){
            if (transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer userId) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            String hql = "DELETE UserWeb WHERE id = :id";
            //String hql = "DELETE User WHERE login = :lg";
            Query query = session.createQuery(hql);
            query.setParameter("id", userId);
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
    public void update(UserWeb userWeb) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();//roadAccident
            String hql = "update UserWeb "
                    + "SET firstName = :name "
                    +   ", lastName = :lastName "
                    +   ", passportNumber = :passportNumber "
                    +  " where id = :idParam";
            Query query = session.createQuery(hql);
            query.setParameter("name", userWeb.getFirstName());
            query.setParameter("lastName", userWeb.getLastName());
            query.setParameter("passportNumber", userWeb.getPassportNumber());
            query.setParameter("idParam", userWeb.getId());
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
    public UserWeb getByLogin(String login) {
        List<UserWeb> users = getAll();
        return users.stream().filter(u -> u.getLogin().equals(login)).findAny().orElse(null);
    }
}
