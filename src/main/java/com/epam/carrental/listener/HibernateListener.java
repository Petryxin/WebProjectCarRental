package com.epam.carrental.listener;

import com.epam.carrental.hibernateutil.HibernateUtil;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class HibernateListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent event) {
        HibernateUtil.getSessionFactory();
    }

    public void contextDestroyed(ServletContextEvent event) {
        HibernateUtil.getSessionFactory().close();
    }
}
