package serialization;


import java.io.*;

class XYZ implements Serializable {

    private static final long serialVersionUID = 1L;
    static int z = 30;
    int x = 10;
    transient int y = 20;
}

class PQR extends XYZ implements Serializable {
    private static final long serialVersionUID = 1L;
    static int z = 300;
    int x = 100;
    transient int y = 200;
}

public class SerializeInheritanceDemo {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        PQR pqr = new PQR();

        FileOutputStream fos = new FileOutputStream("SerializeInheritanceDemo.txt");
        ObjectOutputStream os = new ObjectOutputStream(fos);
        os.writeObject(pqr);

        FileInputStream fin = new FileInputStream("SerializeInheritanceDemo.txt");
        ObjectInputStream is = new ObjectInputStream(fin);
        pqr = (PQR) is.readObject();
        System.out.println(pqr.x);
        System.out.println(pqr.y);
        System.out.println(pqr.z);
    }

}
