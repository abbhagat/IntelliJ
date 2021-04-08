package secondLevelCache;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;

import javax.persistence.Query;
import java.util.List;

import static util.Util.sessionFactory;

public class SecondLevelCache {

    public static void main(String[] args) {
        Session session1 = sessionFactory.openSession();
        session1.get(UserDetails.class,1);
        Query query1 = session1.createQuery("from UserDetails where userID = :userID and userName = :userName", UserDetails.class).setCacheable(true).setCacheRegion("USER1");
        query1.setParameter("userID",1);
        query1.setParameter("userName","V705417");
        query1.getResultList();
        //session1.merge(session1.get(UserDetails.class,1));
        session1.close();

        Session session2 = sessionFactory.openSession();
        session2.get(UserDetails.class,1);
        Query query2 = session2.createQuery("from UserDetails", UserDetails.class).setCacheable(true).setCacheRegion("USER1");
        query2.getResultList();
        session2.close();
        //System.out.println(sessionFactory.getStatistics());

        Session session3 = sessionFactory.openSession();
        Transaction transaction = session3.beginTransaction();
        List<UserDetails> userDetails = session3.getNamedNativeQuery("ALL_USERS").getResultList();
        System.out.println(userDetails);
        transaction.commit();
        session3.close();

        Session session4 = sessionFactory.openSession();
        transaction = session4.beginTransaction();
        userDetails = session4.getNamedQuery("ALL_USERS1").getResultList();
        System.out.println(userDetails);
        transaction.commit();
        session4.close();


        Session session5 = sessionFactory.openSession();
        Criteria criteria = session5.createCriteria(UserDetails.class).addOrder(Order.asc("userID"));
        criteria.setProjection(Projections.property("userID"));
        criteria.list();
        Query query = session5.createSQLQuery("SELECT * FROM USER_DETAILS");
        List<UserDetails> userDetailsList = query.getResultList();
        userDetailsList.forEach(System.out::println);
    }

}
