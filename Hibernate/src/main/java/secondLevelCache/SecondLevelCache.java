package secondLevelCache;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.query.Query;

import java.util.List;

import static util.Util.sessionFactory;

public class SecondLevelCache {

    public static void main(String[] args) {
        Session session = sessionFactory.openSession();
        session.get(UserDetails.class, 1);
        Query query1 = session.createQuery("from UserDetails where userID = :userID and userName = :userName", UserDetails.class).setCacheable(true).setCacheRegion("USER1");
        query1.setParameter("userID", 1);
        query1.setParameter("userName", "V705417");
        query1.getResultList();
        //session.merge(session.get(UserDetails.class,1));
        session.close();

        session = sessionFactory.openSession();
        session.get(UserDetails.class, 1);
        Query query2 = session.createQuery("from UserDetails", UserDetails.class).setCacheable(true).setCacheRegion("USER1");
        query2.getResultList();
        session.close();
        //System.out.println(sessionFactory.getStatistics());

        session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<UserDetails> userDetails = session.getNamedNativeQuery("ALL_USERS").getResultList();
        System.out.println(userDetails);
        transaction.commit();
        session.close();

        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        userDetails = session.getNamedQuery("ALL_USERS1").getResultList();
        System.out.println(userDetails);
        transaction.commit();
        session.close();


        session = sessionFactory.openSession();
        Criteria criteria = session.createCriteria(UserDetails.class).addOrder(Order.asc("userID"));
        criteria.setProjection(Projections.property("userID"));
        criteria.list();

        Query query = session.createSQLQuery("SELECT * FROM USER_DETAILS");
        List<UserDetails> userDetailsList = query.getResultList();
        userDetailsList.forEach(System.out::println);
    }

}
