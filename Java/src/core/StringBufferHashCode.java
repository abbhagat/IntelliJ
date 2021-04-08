package core;

public class StringBufferHashCode {
    public static void main(String[] args) {
        String s = "Java";
        StringBuffer s1 = new StringBuffer("Java"); // same output with StringBuilder
        StringBuffer s2 = new StringBuffer("Java");
        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());
        System.out.println(s.hashCode());
        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));
        System.out.println(s.equals(s1));
    }
}
