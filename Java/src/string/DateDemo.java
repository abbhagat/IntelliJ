package string;

public class DateDemo {
    static final DateDemo d = new DateDemo();
    int x = 10;
    String s = "Java";

    public static void main(String[] args) {
        System.out.println(d.x);
        //d = new DateDemo();
        Integer i = 10;
        System.out.println(i instanceof Object);
        System.out.println(i instanceof Integer);
        // System.out.println(s);
        System.out.println(Boolean.FALSE ? "true" : "false");
    }
}
