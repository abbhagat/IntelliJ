package jpmorgan;

// Time  Complexity : O(n*k)
// Space Complexity : O(k)
public class SmallestAndLargestSubstring {

    public static void getSmallestAndLargest(String s, int k) {
        String str = s.substring(0, k);
        String min = str, max = str;
        for (int i = k; i < s.length(); i++) {
            str = str.substring(1, k) + s.charAt(i);
            max = max.compareTo(str) < 0 ? str : max;
            min = min.compareTo(str) > 0 ? str : min;
        }
        System.out.println(min + "\t" + max);
    }

    public static void main(String[] args) {
        getSmallestAndLargest("GeeksForGeeks", 3);
    }
}
