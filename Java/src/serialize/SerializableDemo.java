package serialize;

import java.io.*;

/**
 * Serialization Rule
 *
 * During serialization process, if any instance variable is inherited from non serializable parent class,
 * then JVM will ignore the normal value instead it will store the default value for that variable.
 *
 * Deserialization Rule
 *
 * During deserialization process, if we have any non serializable parent class, then JVM will perform following things for that non-serializable parent class.
 *
 * Variable Initialization will be done.
 * Instance block will be executed.
 * No-argument constructor will be executed.
 */

class Father {

    transient int parent;
    String s = "Java";

    public Father() {
        System.out.println("Father Constructor");
        parent = 3;
    }

    {
        System.out.println("Initialization Block..");
        parent = 2;
    }
}

class Son extends Father implements Serializable {

    //transient int child = 4;
    int child = 4;

    public Son() {
        System.out.println("Son Constructor...");
    }

}

public class SerializableDemo {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Son son = new Son();
        FileOutputStream fileOutputStream = new FileOutputStream("son.ser");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(son);
        FileInputStream fileInputStream = new FileInputStream("son.ser");
        ObjectInputStream inputStream = new ObjectInputStream(fileInputStream);
        son = (Son) inputStream.readObject();
        System.out.println(son.parent);
        System.out.println(son.child);
        System.out.println(son.s);
    }
}
