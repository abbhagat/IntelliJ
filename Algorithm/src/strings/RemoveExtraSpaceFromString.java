package strings;

import java.util.Arrays;
import java.util.List;

/*
 * Input: str = "   Hello Geeks . Welcome   to  GeeksforGeeks   .    ";
   Output: s =  "Hello Geeks. Welcome to GeeksforGeeks."
 */
public class RemoveExtraSpaceFromString {

    public static void main(String[] args) {
        String str = "   Hello Geeks . Welcome   to  GeeksforGeeks   .    ";
        List<String> listOfStrings = Arrays.asList(str.split(" "));
        String output = "";
        for (String s : listOfStrings) {
            if (!"".equals(s.trim())) {
                if (".".equals(s)) {
                    output = output.trim() + s + " ";
                }else{
                    output += s + " ";
                }
            }
        }
        System.out.println(output);
    }
}
