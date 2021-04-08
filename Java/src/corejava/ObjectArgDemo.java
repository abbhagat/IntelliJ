package corejava;

public class ObjectArgDemo {

    private static int x = 10;

    ObjectArgDemo(int x) {
        this.x = x;
    }

    public void display(ObjectArgDemo arg) {
        System.out.println(x);
        arg.x = x + 5;
        System.out.println(arg.x);
    }

    public static void main(String[] args) {
        ObjectArgDemo obj = new ObjectArgDemo(50);
        obj.display(obj);
        System.out.println(obj.x);
    }
}
