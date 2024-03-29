package geeksforgeeks;

public class RemoveOneElementToMakeArrayStrictlyIncreasing {

    public static boolean check(int[] a) {
        int count = 0, index = -1;
        for (int i = 1; i < a.length - 1; i++) {
            if (a[i - 1] >= a[i]) {
                count++;
                index = i;
            }
        }
        if (count == 0) {
            return true;
        }
        if (count > 1) {
            return false;
        }
        if (index == 1 || (a[index - 1] < a[index + 1])) {
            System.out.println(a[index]);
            return true;
        }
        if (a[index - 2] < a[index]) {
            System.out.println(a[index - 1]);
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] a = {1, 5, 4, 6};
        System.out.println(check(a) ? Boolean.TRUE : Boolean.FALSE);
    }
}
