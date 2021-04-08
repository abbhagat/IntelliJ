package string;

public class StringDemo {
    static int x = 10;

    public static void main(String[] args) {
        StringBuilder sb1 = new StringBuilder("Java");
        StringBuilder sb2 = new StringBuilder("Java");
        //sb1 = sb1 + sb2;  // Error
        System.out.println(sb1 + "\t" + sb2);
        sb2.append(" is an OOP");
        System.out.println(sb1 + "\t" + sb2);
        String s = "Java";
        System.out.println(x);
    }
}
