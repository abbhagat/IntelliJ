package selectBeforeUpdate;

import org.hibernate.Session;

import static util.Util.sessionFactory;

public class Main {

    public static void main(String[] args) {

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        UserDetails user = session.get(UserDetails.class, 1);
        session.getTransaction().commit();
        session.close();

        user.setUserName("Updated User Name");

        session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(user);
        session.getTransaction().commit();
        session.close();
    }
}
