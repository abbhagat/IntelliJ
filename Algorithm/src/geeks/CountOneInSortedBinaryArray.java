package geeks;

public class CountOneInSortedBinaryArray {

    private static int a[] = {1, 1, 1, 1, 1, 1, 0, 0, 0};

    private static int countOnes(int low, int high) {
        if (low <= high) {
            int mid = (low + high) / 2;
            if ((mid == high || a[mid + 1] == 0) && (a[mid] == 1)) {  // check if the element at middle index is last 1
                return mid + 1;
            }
            if (a[mid] == 1) {
                return countOnes(mid + 1, high);
            }
            return countOnes(low, mid - 1);
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(countOnes(0, a.length - 1));
    }
}
