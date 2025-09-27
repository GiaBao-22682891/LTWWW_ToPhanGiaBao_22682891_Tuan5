package org.example.tuan5.utils;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class HibernateListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("mariadb");
        sce.getServletContext().setAttribute("emf", emf);
        System.out.println("EntityManagerFactory");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        ServletContextListener.super.contextDestroyed(sce);
    }
}
