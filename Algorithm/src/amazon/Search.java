package amazon;

public class Search {

    private static int pivotedBinarySearch(int[] a, int key){
        int low = 0, high = a.length - 1;
        int pivot = findPivot(a, low, high);
        if(pivot == -1){
            return binarySearch(a, low, high, key);
        }
        if(a[pivot] == key){
            return pivot;
        }
        return a[0] > key ? binarySearch(a, pivot + 1, high, key) : binarySearch(a, low, pivot - 1, key);
    }

    private static int findPivot(int[] a, int low, int high){
        if(low <= high){
            int mid = (low + high)/2;
            if(mid < high && a[mid] > a[mid + 1]){
                return mid;
            }
            if(low < mid && a[mid - 1] > a[mid]){
                return mid - 1;
            }
            return a[low] < a[mid] ? findPivot(a, mid + 1, high) : findPivot(a, low, mid - 1);
        }
        return -1;
    }

    private static int binarySearch(int[] a, int low, int high, int key) {
        if (low <= high) {
            int mid = (low + high) / 2;
            if (a[mid] == key) {
                return mid;
            }
            return key < a[mid] ? binarySearch(a, low, mid - 1, key) : binarySearch(a, mid + 1, high, key);
        }
        return -1;
    }

    private static int findMax(int[] a){
        int low = 0, high = a.length - 1;
        int mid = 0;
        while(low <= high){
            mid = (low + high) / 2;
            if(a[mid] == a[high]){
                high--;
            }else if(a[mid] > a[mid + 1]){
                return a[mid];
            }
            else if(a[mid] > a[high]){
                high = mid;
            }else{
                low = mid + 1;
            }
        }
        return a[mid];
    }

    private static int findMin(int[] a){
        int low = 0, high = a.length - 1;
        while(low < high){
            int mid = (low + high) / 2;
            if(a[mid] == a[high]){
                high--;
            }
            else if(a[mid] > a[high]){
                low = mid + 1;
            }else{
                high = mid;
            }
        }
        return a[high];
    }

    public static void main(String[] args) {
        int arr1[] = {5, 6, 1, 1, 1, 2, 3, 4, 4, 5};
        System.out.println("Min :" + findMin(arr1));
        System.out.println("Max :" + findMax(arr1));

        int arr2[] = {1, 2, 3, 4};
        System.out.println("Min :" + findMin(arr2));
        System.out.println("Max :" + findMax(arr2));

        int arr3[] = {1};
        System.out.println("Min :" + findMin(arr3));
        System.out.println("Max :" + findMax(arr3));

        int arr4[] = {1, 2};
        System.out.println("Min :" + findMin(arr4));
        System.out.println("Max :" + findMax(arr4));

        int arr5[] = {2, 1};
        System.out.println("Min :" + findMin(arr5));
        System.out.println("Max :" + findMax(arr5));

        int arr6[] = {5, 6, 7, 1, 2, 3, 4};
        System.out.println("Min :" + findMin(arr6));
        System.out.println("Max :" + findMax(arr6));

        int arr7[] = {1, 2, 3, 4, 5, 6, 7};
        System.out.println("Min :" + findMin(arr7));
        System.out.println("Max :" + findMax(arr7));

        int arr8[] = {2, 3, 4, 5, 6, 7, 8, 1};
        System.out.println("Min :" + findMin(arr8));
        System.out.println("Max :" + findMax(arr8));

        int arr9[] = {3, 4, 5, 1, 2};
        System.out.println("Min :" + findMin(arr9));
        System.out.println("Max :" + findMax(arr9));
    }
}
