package utildemo;

import java.time.LocalDate;

final class Person {

    private final int id;
    private final String firstName;
    private final LocalDate dob;

    Person(int id, String firstName, LocalDate dob) {
        this.id = id;
        this.firstName = firstName;
        this.dob = dob;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public LocalDate getDob() {
        return dob;
    }

    @Override
    public boolean equals(Object obj) {

        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        Person guest = (Person)obj;
        return this.getId() == guest.getId() && (this.getFirstName() == guest.getFirstName() || (this.firstName != null && this.firstName.equals(guest.getFirstName()))) && (this.dob == guest.dob || (this.dob != null && this.dob.equals(guest.getDob())));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
        result = prime * result + ((dob  == null) ? 0 : dob.hashCode());
        return result;
    }

    public static void main(String[] args) {
        Person p1 = new Person(1, "Abhinaw", LocalDate.of(1986,10,7));
        Person p2 = new Person(1, "Abhinaw", LocalDate.of(1986,10,7));
        System.out.println(p1.equals(p2));
        System.out.println(p1.hashCode() == p2.hashCode());
    }
}
