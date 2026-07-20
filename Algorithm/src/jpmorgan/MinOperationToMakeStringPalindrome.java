package jpmorgan;

public class MinOperationToMakeStringPalindrome {

  public static int minOpsToMakeStringAnagram(String s) {
    int i= 0, j = s.length() - 1, count = 0;
    while (i < j) {
      if (s.charAt(i) != s.charAt(j)) {
        count++;
      }
      i++;
      j--;
    }
    return count;
  }

  public static void main(String[] args) {
    System.out.println(minOpsToMakeStringAnagram("12321"));
    System.out.println(minOpsToMakeStringAnagram("12341"));
    System.out.println(minOpsToMakeStringAnagram("12345"));
    System.out.println(minOpsToMakeStringAnagram("123456"));
    System.out.println(minOpsToMakeStringAnagram("1234567"));
  }
}
