package com.epam.carrental.dao.impl;

import com.epam.carrental.dao.CarDao;
import com.epam.carrental.model.Car;
import com.epam.carrental.hibernateutil.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;


import java.util.List;


public class CarDaoImpl implements CarDao {

    @Override
    public void create(Car car) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.save(car);
            transaction.commit();
        }catch (Exception e){
            if (transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer carId) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            String hql = "DELETE Car WHERE id = :id";
            Query query = session.createQuery(hql);
            query.setParameter("id", carId);
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
    public void update(Car car) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            String hql = "update Car "
                    + "SET rentedCar = :rentedCar "
                    +   ", paymentPerDay = :paymentPerDay "
                    +  " where id = :idParam";
            Query query = session.createQuery(hql);
            query.setParameter("rentedCar", car.isRentedCar());
            query.setParameter("paymentPerDay", car.getPaymentPerDay());
            query.setParameter("idParam", car.getId());
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
    public List<Car> getAll() {
        Transaction transaction = null;
        List<Car> list = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            String hql = "FROM Car";
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
    public Car getById(Integer carId) {
        Transaction transaction = null;
        Car carById = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            String hql = "FROM Car WHERE id = :id";
            Query query = session.createQuery(hql);
            query.setParameter("id", carId);
            carById = (Car) query.uniqueResult();
            transaction.commit();
        }catch (Exception e){
            if (transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return carById;
    }
}
