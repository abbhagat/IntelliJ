package leetcode;

import java.util.*;

public class CheckIfAStringCanBeCutWhere1stHalfAnd2ndHalfHasSameNoOfCharacters {

  public static boolean sameFrequencyCharactersInString(String str) {
    int n = str.length();
    int k = n % 2 == 0 ? (n / 2) - 1 : n / 2;
    int count = 0;
    for (int i = k; i >= 0; i--) {
      count++;

    }
    for (int i = k; i < n; i++) {
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
