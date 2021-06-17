package string;

public class OperatorDemo {
    public static void main(String[] args) {
        int x = 5;
        x++;
        ++x;
        x *= x++ + x + ++x;
        System.out.println(x);
        String s = new String("Java");
        String t = s.intern();
        System.out.println(t == s);
        System.out.println(t.equals(s));
        System.out.println(s.substring(1, 4));
        System.out.println(s.equals(null));
        System.out.println(null == null);
        // System.out.println(null.equals(null));
    }
}
