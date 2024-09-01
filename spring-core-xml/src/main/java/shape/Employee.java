package shape;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Employee {

    private int empID;
    private Address address;

    public int getEmpID() {
        return empID;
    }

    public void setEmpID(int empID) {
        this.empID = empID;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
