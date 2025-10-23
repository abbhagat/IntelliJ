package oracle;

import java.io.*;
import java.time.LocalDate;

record Employee(int id, String name, LocalDate dob) implements Serializable {
  @Serial
  private static final long serialVersionUID = 1L;
}

public class CalculateSizeOfObject {

  public static void main(String[] args) throws Exception {
    Employee emp = new Employee(1, "Abhinaw", LocalDate.of(1986, 10, 7));
    System.out.println(emp);
    FileOutputStream fos = new FileOutputStream("Employee.txt");
    ObjectOutputStream os = new ObjectOutputStream(fos);
    os.writeObject(emp);
    File file = new File("Employee.txt");
    System.out.println(file.length() + " bytes");
  }
}
