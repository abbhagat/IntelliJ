package searching;

public class FindMaxInARotatedSortedArray {

    private static int findMax(int[] a, int low, int mid, int high) {
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
        int a[] = {5, 6, 1, 1, 1, 2, 3, 4, 4, 5};
        int n1 = a.length;
        System.out.println("Max :" + findMax(a, 0, 0,n1 - 1));

        int arr2[] = {1, 2, 3, 4};
        int n2 = arr2.length;
        System.out.println("Max :" + findMax(arr2, 0, 0,n2 - 1));

        int arr3[] = {1};
        int n3 = arr3.length;
        System.out.println("Max :" + findMax(arr3, 0, 0,n3 - 1));

        int arr4[] = {1, 2};
        int n4 = arr4.length;
        System.out.println("Max :" + findMax(arr4, 0, 0,n4 - 1));

        int arr5[] = {2, 1};
        int n5 = arr5.length;
        System.out.println("Max :" + findMax(arr5, 0, 0,n5 - 1));

        int arr6[] = {5, 6, 7, 1, 2, 3, 4};
        int n6 = arr6.length;
        System.out.println("Max :" + findMax(arr6, 0, 0,n6 - 1));

        int arr7[] = {1, 2, 3, 4, 5, 6, 7};
        int n7 = arr7.length;
        System.out.println("Max :" + findMax(arr7, 0, 0,n7 - 1));

        int arr8[] = {2, 3, 4, 5, 6, 7, 8, 1};
        int n8 = arr8.length;
        System.out.println("Max :" + findMax(arr8, 0, 0,n8 - 1));

        int arr9[] = {3, 4, 5, 1, 2};
        int n9 = arr9.length;
        System.out.println("Max :" + findMax(arr9, 0, 0,n9 - 1));
    }
}
