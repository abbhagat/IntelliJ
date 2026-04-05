package strings;

/*
Given a string as an input. We need to write a program that will print all non-empty substrings of that given string.
Input :  abcd
Output:   a
          b
          c
          d
          ab
          bc
          cd
          abc
          bcd
          abcd

Input :  abc
          a
          b
          c
          ab
          bc
          abc
*/

// Time  Complexity: O(n^2)
// Space Complexity: O(n^2)
public class PrintAllSubstringOfAGivenString {

  public static void printAllSubstring(String str) {
    for (int i = 0; i < str.length(); i++) {
      for (int j = i + 1; j <= str.length(); j++) {
        System.out.println(str.substring(i, j));
      }
    }
    System.out.println();
  }

  public static void main(String[] args) {
    printAllSubstring("abc");
    printAllSubstring("abcd");
  }
}
