package oracle;

import java.io.*;
import java.util.Date;

record Employee(int id, String name, Date dob) implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
}

public class CalculateSizeOfObject {

    public static void main(String[] args) throws Exception {
        Employee emp = new Employee(1, "Abhinaw", new Date("07-OCT-1986"));
        FileOutputStream fos  = new FileOutputStream("Student.txt");
        ObjectOutputStream os = new ObjectOutputStream(fos);
        os.writeObject(emp);
        File file = new File("Student.txt");
        System.out.println(file.length() + " bytes");
    }
}
