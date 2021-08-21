package locking;

import org.hibernate.Session;
import org.hibernate.query.Query;
import secondLevelCache.UserDetails;

import javax.persistence.LockModeType;

import static util.Util.sessionFactory;

public class PessimisticLocking {

    public static void main(String[] args) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.get(UserDetails.class, 1);
        Query query = session.createQuery("from UserDetails", UserDetails.class).setLockMode(LockModeType.PESSIMISTIC_WRITE);
        query.getResultList();
        session.getTransaction().commit();
        session.close();
    }
}
