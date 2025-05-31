package geeks;

public class StringSplitImplementation {

    private static void split(String s, char delimiter) {
        StringBuilder str = new StringBuilder();
        for (char c : (s + delimiter).toCharArray()) {
            if (c != delimiter) {
                str.append(c);
            } else {
                System.out.println(str);
                str = new StringBuilder();
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        split("Java is an OOP", ' ');
        split("Java, s;is;r an;w OOP", ';');
    }
}
