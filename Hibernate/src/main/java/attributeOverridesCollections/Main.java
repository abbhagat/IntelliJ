package attributeOverridesCollections;

import org.hibernate.Session;
import org.hibernate.Transaction;

import static util.Util.sessionFactory;

public class Main {

    public static void main(String[] args) {
        UserDetails userDetails = new UserDetails();
        userDetails.setUserName("Abhinaw");
        Address homeAddress = new Address("Nathnagar", "Bhagalpur", "Bihar", "812006");
        Address officeAddress = new Address("Nallurhalli", "Bengaluru", "Karnataka", "560066");
        userDetails.getAddressCollection().add(homeAddress);
        userDetails.getAddressCollection().add(officeAddress);
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(userDetails);
        transaction.commit();
        session.close();
    }
}
