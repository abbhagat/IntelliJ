import java.util.*;

import static java.lang.Integer.min;

class A {

}
public class Main {

       private A a = new A();


    public static void main(String[] args) {
        Main m1 = new Main();
        Main m2 = new Main();
        System.out.println(m1.a.hashCode());
        System.out.println(m2.a.hashCode());
    }
}
