package callingProcedure;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.LockModeType;
import javax.persistence.StoredProcedureQuery;
import java.util.List;

import static util.Util.sessionFactory;

public class Main {

    public static void main(String[] args) {

        StoredProcedureQuery spQuery = sessionFactory.createEntityManager().createNamedStoredProcedureQuery("sp_user_details");
        spQuery.setParameter("userName", "User1");
        spQuery.getResultList();

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query query;

        query = session.getNamedNativeQuery("userDetailsProcedure").setLockMode(LockModeType.PESSIMISTIC_WRITE);
        query.setParameter("userID", 1);
        query.setParameter("userName", "V705417");
        List<UserDetails> userDetailsList = query.list();

        query = session.createSQLQuery("CALL sp_user_details(:userID,:userName)").addEntity(UserDetails.class).setLockMode(LockModeType.PESSIMISTIC_WRITE);
        query.setParameter("userID", 1);
        query.setParameter("userName", "V705417");
        List<UserDetails> userDetailLists = query.list();

        transaction.commit();
        session.close();

        userDetailsList.forEach(userDetails -> System.out.println(userDetails.getUserID() + "\t" + userDetails.getUserName()));
        userDetailLists.forEach(userDetails -> System.out.println(userDetails.getUserID() + "\t" + userDetails.getUserName()));
    }
}
