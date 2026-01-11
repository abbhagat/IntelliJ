package OneToMany;

import org.hibernate.Session;
import org.hibernate.Transaction;

import static util.Util.sessionFactory;

public class OneToManyMain {

  public static void main(String[] args) {

    UserDetails user = new UserDetails();
    user.setUserName("Abhinaw");

    Vehicles vehicle1 = new Vehicles();
    Vehicles vehicle2 = new Vehicles();

    vehicle1.setVehicleName("Honda Amaze");
    vehicle2.setVehicleName("Honda City");

    vehicle1.setUserDetails(user);
    vehicle2.setUserDetails(user);

    Session session = sessionFactory.openSession();
    Transaction transaction = session.beginTransaction();

    session.persist(user);
    session.persist(vehicle1);
    session.persist(vehicle2);
    transaction.commit();

    session.close();
  }
}
