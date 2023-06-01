package adobe;

// Time Complexity :- O(n)
public class VersionComparison {

    private static int compareVersion(String v1, String v2) {
        if (v1 == null && v2 == null) {
            return 0;
        }
        if (v1 == null || v2 == null) {
            return v1 == null ? -1 : 1;
        }
        if (v1.isEmpty() && v2.isEmpty()) {
            return 0;
        }
        String[] list1 = v1.split("\\.");
        String[] list2 = v2.split("\\.");
        for (int i = 0; i < list1.length || i < list2.length; i++) {
            int x = i < list1.length ? Integer.parseInt(list1[i]) : 0;
            int y = i < list2.length ? Integer.parseInt(list2[i]) : 0;
            if (x == y) {
                continue;
            }
            return x < y ? -1 : 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(compareVersion("0.1", "1.1"));
        System.out.println(compareVersion(null, "1.1"));
        System.out.println(compareVersion(null, ""));
        System.out.println(compareVersion("", ""));
        System.out.println(compareVersion("", null));
        System.out.println(compareVersion(null, null));
        System.out.println(compareVersion("1.0.1", "1"));
        System.out.println(compareVersion("7.5.2.4", "7.5.3"));
        System.out.println(compareVersion("7.5.2.4", "7.5.2.4"));
    }
}
