package serialization;

import java.io.*;


/*
Transient variables − The values of the transient variables are never considered (they are excluded from the serialization process).
i.e. When we declare a variable transient, after de-serialization its value will always be null, false, or, zero (default value).

Static variables − The values of static variables will not be preserved during the de-serialization process.
In-fact static variables are also not serialized but since these belongs to the class. After de-serialization they get their current values from the class.
 */
class Emp implements Externalizable {

    private static final long serialVersionUID = 1L;

    transient int x = 10;
    float y = 200f;
    static long z = 300L;
    String name = "Java";

    public Emp() {

    }

    public void writeExternal(ObjectOutput out) throws IOException {
        System.out.println("Inside write external");
//        out.writeInt(x);
//        out.writeInt(y);
//        out.writeInt(z);
//        out.writeUTF(name);
    }

    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        System.out.println("Inside read external");
//        x = in.readInt();
//        y = in.readInt();
//        z = in.readInt();
//        name = in.readUTF();
    }

    @Override
    public String toString() {
        return "Emp {" + "x=" + x + ", y=" + y + ", z=" + z + ", name =" + name +"}";
    }
}

public class ExternalizableDemo {

    public static void main(String[] args) {
        Emp e = new Emp();
        System.out.println(e);
        try {
            FileOutputStream fos = new FileOutputStream("file");
            ObjectOutputStream os = new ObjectOutputStream(fos);
            os.writeObject(e);
            os.flush();
            fos.close();
            os.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        try {
            FileInputStream fis = new FileInputStream("file");
            ObjectInputStream in = new ObjectInputStream(fis);
            e = (Emp)in.readObject();
            fis.close();
            in.close();
            System.out.println(e);
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }
}
