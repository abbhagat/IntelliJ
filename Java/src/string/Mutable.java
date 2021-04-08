package string;

public class Mutable {
    public static void main(String[] args) {
        StringBuffer s1 = new StringBuffer("Java");
        StringBuffer s2 = new StringBuffer("Java");
        s1 = new StringBuffer("Java is an OOP");
        System.out.println(s1 + "\t" + s2);
        String s4 = "X";
        String s3 = new String("X");
        //s3 = s3.intern();
        System.out.println(s3 == s4);
        System.out.println(s3.equals(s4));
        //System.out.println(null);
    }
}
