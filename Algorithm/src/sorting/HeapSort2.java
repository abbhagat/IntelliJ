package sorting;

import static util.CommonUtils.printArray;
import static util.CommonUtils.swap;

/**
 * Heap sort is a comparison-based sorting technique based on Binary Heap data structure.
 * It is similar to selection sort where we first find the minimum element and place the minimum element at the beginning.
 * We repeat the same process for the remaining elements.
 * A Binary Heap is a Complete Binary Tree where items are stored in a special order such that the value in a parent node
 * is greater(or smaller) than the values in its two children nodes.
 * The former is called max heap, and the latter is called min-heap. The heap can be represented by a binary tree or array.
 */

// Time  Complexity : O(N log N)
// Space Complexity : O(1)
public class HeapSort2 {

  private static void buildHeap(int[] a, int n) {
    for (int i = n / 2; i >= 0; i--) {
      maxHeap(a, i, n);   // heapify
    }
  }

  private static void maxHeap(int[] a, int i, int n) {
    int left  = 2 * i;
    int right = 2 * i + 1;
    int largest;
    largest = left  <= n && a[left]  >= a[i]       ? left  : i;
    largest = right <= n && a[right] >= a[largest] ? right : largest;
    if (i != largest) {
      swap(a, i, largest);
      maxHeap(a, largest, n);
    }
  }

  private static void heapSort(int[] a) {
    int n = a.length - 1;
    buildHeap(a, n);
    for (int i = n; i >= 0; i--) {
      swap(a, 0, i);
      maxHeap(a, 0, i - 1);
    }
  }

  public static void main(String[] args) {
    int[] a = {1, 3, 4, 2, 5};
    heapSort(a);
    printArray(a);
  }
}
