package leetcode;

public class AddSpacesInString {

    private static StringBuilder addSpaces(String s, int[] spaces) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0, j = 0; i < s.length(); i++) {
            if (j < spaces.length && i == spaces[j]) {
                sb.append(" ");
                j++;
            }
            sb.append(s.charAt(i));
        }
        return sb;
    }

    public static void main(String[] args) {
        System.out.println(addSpaces("LeetCodeHelpsMeLearn", new int[]{8, 13, 15}));
        System.out.println(addSpaces("icodeinpython", new int[]{1, 5, 7}));
        System.out.println(addSpaces("spacing", new int[]{0, 1, 2, 3, 4, 5,}));
    }
}
