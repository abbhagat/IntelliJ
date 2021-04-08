package arrays;

public class FirstNonRepeatingChar {
    public static void main(String[] args) {
        char[] c = "aaabbbccddddefffgghhhiiijjjkkklmnooopppp".toCharArray();
        int[] temp = new int[128];
        for (char a : c) {
            temp[a]++;
        }
        for (char a : c) {
            if (temp[a] == 1) {
                System.out.println(a);
                break;
            }
        }
    }
}
