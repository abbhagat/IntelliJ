package corejava;

class Y {

    final static int MAX_VALUE = 10;
    int y = 10;

    Y() {
        y = 100;
        System.out.println("Constructor Invoked");
    }

    static {
        System.out.println(MAX_VALUE);
        System.out.println("Super Class Static block invoked");
    }

    {
        System.out.println("Super Class Non static block invoked");
        System.out.println(y);
    }
}

public class X extends Y {

    static char c;
    static {
        System.out.println("Static block of Class X invoked");
    }

    public static void main(String[] args) {
        new X();
        boolean b[] = new boolean[10];
        //System.out.println(c==null); Error
        System.out.println(c);
        System.out.println("b[" + c + "] :" + b[c]);
    }
}
