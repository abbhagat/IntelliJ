package serialization;

import java.io.*;

class Father1 implements Serializable {

    private static final long serialVersionUID = 1L;

    int parent = 1;

    public Father1() {
        System.out.println("Father1 Constructor...");
        parent = 3;
    }

    {
        parent = 2;
        System.out.println("Instance Block....");
    }

}

class Son1 extends Father1 {
    int child = 4;

    public Son1() {
        System.out.println("Son1 Constructor...");
        child = 5;
    }

    {
        child = 6;
        System.out.println("Son Instance Block....");
    }
}

public class SerializationDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Son1 son = new Son1();
//        son.child = 11;
//        son.parent = 21;
        System.out.println("Serialization Starts");
        FileOutputStream fileOutputStream = new FileOutputStream("inheritance.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(son);

        System.out.println("DeSerialization Starts");
        FileInputStream fileInputStream = new FileInputStream("inheritance.txt");
        ObjectInputStream inputStream = new ObjectInputStream(fileInputStream);
        son = (Son1) inputStream.readObject();

        System.out.println(son.child);
        System.out.println(son.parent);
    }

}
