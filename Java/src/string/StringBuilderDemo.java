package string;

public class StringBuilderDemo {
    public static void main(String[] args) {
        StringBuilder s1 = new StringBuilder("A");
        StringBuilder s2 = new StringBuilder("A");
        System.out.println(s1 + "\t" + s2);
        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));
        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());

        StringBuffer s3 = new StringBuffer("A");
        StringBuffer s4 = new StringBuffer("A");
        System.out.println(s3 + "\t" + s4);
        System.out.println(s3 == s4);
        System.out.println(s3.equals(s4));
        System.out.println(s3.hashCode());
        System.out.println(s4.hashCode());

        String s = "A";
        System.out.println(s.equals(s1));
        System.out.println(s.equals(s3));
        //System.out.println(s == s1);
        //System.out.println(s == s2);

        String s5 = "Java";
        String s6 = new String("Java");
        System.out.println(s5.equals(s6));
        System.out.println(s5 == s6);

    }
}
