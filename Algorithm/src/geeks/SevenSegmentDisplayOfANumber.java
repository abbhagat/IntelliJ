package geeks;

public class SevenSegmentDisplayOfANumber {

    public static void main(String[] args) {
        int num = 5;
        String i = "", j = "", k = "";
        if (num == 1) {
            i = "";
            j = "|";
            k = "|";
        } else if (num == 2) {
            i = " __";
            j = " __|";
            k = "|__";
        } else if (num == 3) {
            i = " __";
            j = " __|";
            k = " __|";
        } else if (num == 4) {
            i = "";
            j = "|__|";
            k = "   |";
        } else if (num == 5) {
            i = " __";
            j = "|__";
            k = " __|";
        } else if (num == 6) {
            i = " __";
            j = "|__";
            k = "|__|";
        } else if (num == 7) {
            i = " __";
            j = "   |";
            k = "   |";
        } else if (num == 8) {
            i = " __";
            j = "|__|";
            k = "|__|";
        } else if (num == 9) {
            i = " __";
            j = "|__|";
            k = " __|";
        } else if (num == 0) {
            i = " __";
            j = "|  |";
            k = "|__|";
        }
        System.out.println(i + "\n" + j + "\n" + k);
    }

}
