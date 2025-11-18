package geeks;

public class SevenSegmentDisplayOfANumber {

  private static String getSevenSegments(int n) {
    String i = "", j = "", k = "";
    switch (n) {
      case 0:
        i = " __";
        j = "|  |";
        k = "|__|";
        break;
      case 1:
        i = "";
        j = "|";
        k = "|";
        break;
      case 2:
        i = " __";
        j = " __|";
        k = "|__";
        break;
      case 3:
        i = " __";
        j = " __|";
        k = " __|";
        break;
      case 4:
        i = "";
        j = "|__|";
        k = "   |";
        break;
      case 5:
        i = " __";
        j = "|__";
        k = " __|";
        break;
      case 6:
        i = " __";
        j = "|__";
        k = "|__|";
        break;
      case 7:
        i = " __";
        j = "   |";
        k = "   |";
        break;
      case 8:
        i = " __";
        j = "|__|";
        k = "|__|";
        break;
      case 9:
        i = " __";
        j = "|__|";
        k = " __|";
        break;
    }
    return i + "\n" + j + "\n" + k;
  }

  public static void main(String[] args) {
    System.out.println(getSevenSegments(5));
    System.out.println(getSevenSegments(7));
  }

}
