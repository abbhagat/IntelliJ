package strings;

/*
 * Input: str = "   Hello Geeks . Welcome   to  GeeksforGeeks   .    ";
   Output: s =  "Hello Geeks. Welcome to GeeksforGeeks."
 */
public class RemoveExtraSpaceFromString {

    public static void main(String[] args) {
        String x = "   Hello Geeks . Welcome   to  GeeksforGeeks   .    ";
        String[] str = x.trim().split(" ");
        StringBuilder result = new StringBuilder();
        for (String s : str) {
            if (!s.isEmpty()) {
                result.append(s.equals(".") ? "." : " " + s);
            }
        }
        System.out.println(result.toString().trim());
    }
}
