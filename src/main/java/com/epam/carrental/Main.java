package com.epam.carrental;

import com.epam.carrental.model.Administrator;
import com.epam.carrental.model.Car;
import com.epam.carrental.model.UserWeb;
import com.epam.carrental.hibernateutil.HibernateUtil;
import com.epam.carrental.model.UserRole;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main {
    public static void main(String[] args) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();

            Administrator admin = new Administrator();
            admin.setLogin("Petr");
            admin.setPassword("4321");
            admin.setFirstName("Petr");
            admin.setLastName("Kylibin");
            admin.setUserRole(UserRole.ADMIN);
            session.save(admin);

            UserWeb user = new UserWeb();
            user.setLogin("Kalyan");
            user.setPassword("1234");
            user.setUserRole(UserRole.USER);
            session.save(user);

            UserWeb user1 = new UserWeb();
            user1.setLogin("Yana");
            user1.setPassword("1234");
            user1.setUserRole(UserRole.USER);
            session.save(user1);

            UserWeb user2 = new UserWeb();
            user2.setLogin("Igor");
            user2.setPassword("1234");
            user2.setUserRole(UserRole.USER);
            session.save(user2);

            Car car = new Car();
            car.setBrand("BMW");
            car.setModel("525");
            car.setEngineVolume(2.5);
            car.setYearOfIssue(2001);
            car.setPaymentPerDay(12);
            session.save(car);

            Car car1 = new Car();
            car1.setBrand("Renault");
            car1.setModel("Megan");
            car1.setEngineVolume(1.8);
            car1.setYearOfIssue(2005);
            car1.setPaymentPerDay(11);
            session.save(car1);

            Car car2 = new Car();
            car2.setBrand("Tesla");
            car2.setModel("Model S");
            car2.setEngineVolume(100);
            car2.setYearOfIssue(2012);
            car2.setPaymentPerDay(15);
            session.save(car2);

            transaction.commit();
        }catch (Exception e){
            if (transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}
