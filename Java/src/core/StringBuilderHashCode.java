package core;

public class StringBuilderHashCode {
    public static void main(String[] args) {
        String s = "Java";
        StringBuilder s1 = new StringBuilder("Java"); // same output with StringBuffer
        StringBuilder s2 = new StringBuilder("Java");
        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());
        System.out.println(s.hashCode());
        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));
        System.out.println(s.equals(s1));
    }
}
