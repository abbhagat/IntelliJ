package secondLevelCache;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import java.util.List;
import static util.Util.sessionFactory;

public class SecondLevelCache {

    public static void main(String[] args) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.get(UserDetails.class, 1);
        Query<UserDetails> query1 = session.createQuery("from UserDetails where userID = :userID and userName = :userName", UserDetails.class)
                                           .setCacheable(true)
                                           .setCacheRegion("USER1");
        query1.setParameter("userID", 1);
        query1.setParameter("userName", "V705417");
        query1.getResultList();
        session.getTransaction().commit();
        session.close();

        Session session2 = sessionFactory.openSession();
        session2.beginTransaction();
        session2.get(UserDetails.class, 1);
        Query query2 = session2.createQuery("from UserDetails", UserDetails.class).setCacheable(true).setCacheRegion("USER1");
        query2.getResultList();
        session2.getTransaction().commit();
        session2.close();

        session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List userDetails = session.getNamedNativeQuery("ALL_USERS").getResultList();
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
        transaction = session.beginTransaction();
        Criteria criteria = session.createCriteria(UserDetails.class).addOrder(Order.asc("userID"));
        criteria.add(Restrictions.or(Restrictions.gt("userID", 1), Restrictions.eq("userName", "V705417")));
        criteria.add(Restrictions.gt("userID", 1)).add(Restrictions.eq("userName", "V705417"));
        criteria.setProjection(Projections.property("userID"));
        criteria.list();
        transaction.commit();
        session.close();

        session = sessionFactory.openSession();
        Query<UserDetails> query  = session.createSQLQuery("SELECT * FROM USER_DETAILS");
        Query<UserDetails> query3 = session.createQuery("from UserDetails"); // Creates HQL Query
        List<UserDetails> userDetailsList = query.list();
        transaction.commit();
        session.close();

        userDetailsList.forEach(System.out::println);
    }

}
