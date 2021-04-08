package ManyToMany;

import org.hibernate.Session;
import org.hibernate.Transaction;

import static util.Util.sessionFactory;

public class ManyToManyMain {

    public static void main(String[] args) {

        UserDetails user1 = new UserDetails();
        UserDetails user2 = new UserDetails();

        Vehicles vehicle1 = new Vehicles();
        Vehicles vehicle2 = new Vehicles();

        user1.setUserName("Abhinaw");
        user2.setUserName("Nikita");
        vehicle1.setVehicleName("Honda Amaze");
        vehicle2.setVehicleName("Honda City");

        user1.getVehicles().add(vehicle1);
        user1.getVehicles().add(vehicle2);
        user2.getVehicles().add(vehicle1);
        user2.getVehicles().add(vehicle2);
        vehicle1.getUserDetails().add(user1);
        vehicle2.getUserDetails().add(user2);

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.persist(user1);
        session.persist(user2);
        session.persist(vehicle1);
        session.persist(vehicle2);
        transaction.commit();

        session.close();
    }
}
