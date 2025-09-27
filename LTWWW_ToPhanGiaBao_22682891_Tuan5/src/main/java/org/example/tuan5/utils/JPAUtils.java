//package org.example.tuan5.utils;
//
//import jakarta.persistence.EntityManager;
//import jakarta.persistence.EntityManagerFactory;
//import jakarta.persistence.Persistence;
//
//public class JPAUtils {
//    private static final EntityManagerFactory emf = null;
//
//    static {
//        try {
////            emf = Persistence.createEntityManagerFactory("mariadb");
//            System.out.println('1');
//        } catch (Throwable e) {
//            throw new ExceptionInInitializerError(e);
//        }
//
//    }
//
//    public static EntityManager getEntityManager() {
//        return emf.createEntityManager();
//    }
//
//    public static void closeEntityManager() {
//        if (emf.isOpen()) {
//            emf.close();
//        }
//    }
//}
