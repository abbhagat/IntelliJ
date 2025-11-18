package jpmorgan;

public class MinOperationToMakeStringAnagram {

  public static int minOpsToMakeStringAnagram(String s) {
    int count = 0, l = s.length();
    for (int i = 0, j = l - 1; i < l / 2; i++, j--) {
      if (s.charAt(i) != s.charAt(j)) {
        count++;
      }
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
