package strings;

/*
 * Input: str = "   Hello Geeks . Welcome   to  GeeksforGeeks   .    ";
   Output: s =  "Hello Geeks. Welcome to GeeksforGeeks."
 */
public class RemoveExtraSpaceFromString {

    public static void main(String[] args) {
        String str = "   Hello Geeks . Welcome   to  GeeksforGeeks   .    ";
        StringBuilder result = new StringBuilder();
        for (String s : str.trim().split(" ")) {
            if (!s.isEmpty()) {
                result.append(s.equals(".") ? "." : " " + s);
            }
        }
        System.out.println(result.toString().trim());
    }
}
