package sorting;

public class KthHighest {

    private static int a[] = { 10, 20, 30, 25, 50 }; // 55, 90, 80, 100 };

    public static void main(String[] args) {
        int kth = 3;
        System.out.println("The " + kth + " Max is: " + kthLargest(a.length - kth));
    }

    private static int kthLargest(int k) {
        int left = 0;
        int right = a.length - 1;
        while (true) {
            int pivot = (left + right) / 2;
            int newPivot = partition(left, right, pivot);
            if (newPivot == k)
                return a[newPivot];
            else if (newPivot < k) {
                left = newPivot + 1;
            } else {
                right = newPivot - 1;
            }
        }
    }

    private static int partition(int left, int right, int pivot) {
        int pivotValue = a[pivot];
        swap(pivot, right);
        int storePos = left;
        for (int i = left; i < right; i++) {
            if (a[i] < pivotValue) {
                swap(i, storePos);
                storePos++;
            }
        }
        swap(storePos, right);
        return storePos;
    }

    private static void swap(int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
