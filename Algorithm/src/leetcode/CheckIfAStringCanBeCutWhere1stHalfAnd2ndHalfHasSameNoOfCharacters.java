package leetcode;

public class CheckIfAStringCanBeCutWhere1stHalfAnd2ndHalfHasSameNoOfCharacters {

  public static boolean sameFrequencyCharactersInString(String str) {
    int mid = str.length() / 2;
    int count = 0;
    for (int i = mid; i >= 0; i--) {
      count++;

    }
    for (int i = mid; i < str.length(); i++) {
      count--;

    }
    return count == 0;
  }

  public static void main(String[] args) {
    System.out.println(sameFrequencyCharactersInString("aaabb"));
    System.out.println(sameFrequencyCharactersInString("aababbb"));
    System.out.println(sameFrequencyCharactersInString("aaabbb"));
  }
}
