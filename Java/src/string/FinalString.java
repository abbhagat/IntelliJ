package string;

public class FinalString {

    public static void main(String[] args) {
        final String s = "Java";
        //s+="is an OOP.";
        final StringBuffer sb = new StringBuffer(s);
        sb.append(" is an OOP.");
        sb.append(" is an OOP.");
        System.out.println(sb);
    }
}
