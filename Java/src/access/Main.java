package access;

import java.math.BigDecimal;

public class Main {
    final int x;
    final int k = 1000; // Error(16,13): cannot assign a value to final variable x
    final int y;
    // y = 1000;
    {
        y = 5000;
        // y = 5000;
        // x = 900;
        // System.out.println(x);
    }

    public Main(int x) {
        this.x = x; // Error(16,13): cannot assign a value to final variable x
    }

    public static void main(String[] args) throws ClassNotFoundException {
/*
        try{
            int q = 100;
        }catch(IOException e){
            e.printStackTrace();
        }
        */
        final int x;
        x = 100;
        // x = 200; // Error(21,9): variable x might already have been assigned
        System.out.println(x);
        Main m1 = new Main(10);
        System.out.println(m1.y);
        System.out.println(m1.x);
        // System.out.println(Main.x);
        Main m2 = new Main(20);
        System.out.println(m2.x);
        BigDecimal i = null;
        //System.out.println(i.abs()); //NPE
        // System.out.println(null);  //  Error
        System.out.println((String)null);
        System.out.println(null == null);
    }
}
