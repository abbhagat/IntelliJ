package OneToOne;

import org.hibernate.Session;

import static util.Util.sessionFactory;

public class OneToOneMain {

  public static void main(String[] args) {

    UserDetails user = new UserDetails();
    Vehicles vehicle = new Vehicles();

    vehicle.setVehicleName("Honda Amaze");
    user.setUserName("Abhinaw");
    user.setVehicles(vehicle);

    Session session = sessionFactory.openSession();
    session.beginTransaction();
    session.persist(user);
    session.persist(vehicle);
    session.getTransaction().commit();
    session.close();
    //System.out.println(sessionFactory.getStatistics());
  }
}
