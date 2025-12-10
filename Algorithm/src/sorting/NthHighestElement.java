package sorting;

import static util.CommonUtils.swap;

public class NthHighestElement {

  private static final int[] a = {20, 3, 16, 6, 9, 30, 2, 1, 5, 8, 7, 15};
  private static int kth = 4;
  private static int n = a.length - 1;

  public static void buildHeap() {
    for (int i = n / 2; i >= 0; i--) {
      maxheap(i);
    }
  }

  public static void maxheap(int i) {
    int left  = 2 * i;
    int right = 2 * i + 1;
    int largest = left  <= n && a[left]  > a[i]       ? left  : i;
        largest = right <= n && a[right] > a[largest] ? right : largest;
    if (largest != i) {
      swap(a, i, largest);
      maxheap(largest);
    }
  }

  public static void findKth() {
    buildHeap();
    for (int i = n; i >= 0; i--) {
      swap(a, 0, i);
      n--;
      kth--;
      if (kth == 0) {
        System.out.println(a[i]);
        break;
      }
      maxheap(0);
    }
  }

  public static void main(String[] args) {
    findKth();
  }
}
