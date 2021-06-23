package geeks;

public class StringSplitImplementation {

    public static void main(String[] args) {
        String s = "Java is an OOP";
        String str = "";
        char splitter = ' ';
        for (char c : (s + " ").toCharArray()) {
            if (c != splitter) {
                str += c;
            } else {
                System.out.println(str);
                str = "";
            }
        }
    }
}
