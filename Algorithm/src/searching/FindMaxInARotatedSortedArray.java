package searching;

public class FindMaxInARotatedSortedArray {

    private static int findMax(int[] a) {
        int low = 0, high = a.length - 1;
        int mid = (low + high) / 2;
        while (low <= high) {
            mid = (low + high) / 2;
            if (a[mid] == a[high]) {
                high--;
            } else if (a[mid] > a[mid + 1]) {
                return a[mid];
            }else if(a[low] > a[mid]){
                high = mid;
            }else{
                low = mid + 1;
            }
        }
        return a[mid];
    }

    public static void main(String[] args) {
        System.out.println(findMax(new int[]{4, 5, 6, 7, 1, 2, 3}));
        System.out.println(findMax(new int[]{5, 6, 1, 1, 1, 2, 3, 4, 4, 5}));
    }
}
