package util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Util {

    public static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
    
}
