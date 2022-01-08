package corejava;

final class Constant {
    int x = 10;

    {
        x = 100;
    }
}

public class ConstantObject {

    static Constant cons = new Constant();

    void display() {
        cons = new Constant();
        System.out.println(cons.x);
    }

    public static void main(String[] args) {
        ConstantObject constantObject = new ConstantObject();
        System.out.println(cons.x);
        constantObject.display();
    }
}
