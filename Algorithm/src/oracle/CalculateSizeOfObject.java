package oracle;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;

class Employee implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;
    private String name;
    private Date dob;

    public Employee(int id, String name, Date dob) {
        this.id = id;
        this.name = name;
        this.dob = dob;
    }
}

public class CalculateSizeOfObject {

    public static void main(String[] args) throws Exception {
        Employee emp = new Employee(1, "Abhinaw", new Date("07-OCT-1986"));
        FileOutputStream fos = new FileOutputStream("Student.txt");
        ObjectOutputStream os = new ObjectOutputStream(fos);
        os.writeObject(emp);
        File file = new File("Student.txt");
        System.out.println(file.length() + " bytes");
    }
}
