package geeks;

public class StringSplitImplementation {

    public static void main(String[] args) {
        String s = "Java is an OOP";
        StringBuilder str = new StringBuilder();
        char splitter = ' ';
        for (char c : (s + " ").toCharArray()) {
            if (c != splitter) {
                str.append(c);
            } else {
                System.out.println(str);
                str = new StringBuilder();
            }
        }
    }
}
