package dao;

import model.Book;
import model.BookCopy;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static SessionFactory sessionFactory;

    static {
        try {
      
            Configuration cfg = new Configuration().configure(); 

           
            cfg.addAnnotatedClass(Book.class);
            cfg.addAnnotatedClass(BookCopy.class);

            sessionFactory = cfg.buildSessionFactory();
        } catch (Exception e) {
            e.printStackTrace();
            throw new ExceptionInInitializerError("Initial SessionFactory creation failed " + e);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
