package callingProcedure;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

import static util.Util.sessionFactory;

public class Main {

    public static void main(String[] args) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.getNamedNativeQuery("userDetailsProcedure");
        query.setParameter("userId", 1);
        query.setParameter("userName", "V705417");
        List<UserDetails> userDetailsList = query.getResultList();

        Query query1 = session.createSQLQuery("CALL PROCEDURE_NAME(:userId,:userName)").addEntity(UserDetails.class);
        query1.setParameter("userId", 1);
        query1.setParameter("userName", "V705417");
        List<UserDetails> userDetailsList1 = query1.getResultList();

        transaction.commit();
        session.close();

        userDetailsList.forEach(userDetails -> System.out.println(userDetails.getUserId() + "\t" + userDetails.getName()));
        userDetailsList1.forEach(userDetails -> System.out.println(userDetails.getUserId() + "\t" + userDetails.getName()));
    }
}
