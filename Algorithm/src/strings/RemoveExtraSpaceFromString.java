package strings;

/*
 * Input: str = "   Hello Geeks . Welcome   to  GeeksforGeeks   .    ";
   Output: s =  "Hello Geeks. Welcome to GeeksforGeeks."
 */
public class RemoveExtraSpaceFromString {

    public static void main(String[] args) {
        String x = "   Hello Geeks . Welcome   to  GeeksforGeeks   .    ";
        String[] str = x.trim().split(" ");
        String output = "";
        for (String s : str) {
            if (!s.isEmpty()) {
                output += s.equals(".") ? "." : " " + s;
            }
        }
        System.out.println(output.trim());
    }
}
