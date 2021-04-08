package access;

import java.io.IOException;

class Fruit {

    static String name = "Apple";
    //static final int x; // variable x not initialized in the default constructor

    static Fruit getFruit() {
        System.out.println("Fruit");
        return null;
    }

    static Fruit getName() {
        System.out.println(name);
        return null;
    }

    public static void main(String[] args) throws IOException {
        System.out.println(getFruit().getName());
        //System.out.println(x); // variable x might not have been initialized
    }
}
