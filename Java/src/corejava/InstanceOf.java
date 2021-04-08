package corejava;

class X1 {

}

class Y1 {

}

public class InstanceOf {
    public static void main(String[] args) {
        X1 x = new X1();
        Y1 y = new Y1();
        //System.out.println(x instanceof Y1); // Compilation error
        //System.out.println(x==y); // Compilation error
        System.out.println(x instanceof X1);
    }
}
