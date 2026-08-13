package binarySearchImpl;

import java.util.Collections;
import java.util.List;

/**
 * A machine learning training pipeline processes data in batches to optimize graphics processing unit (GPU) utilization.
 * Several users contribute data samples, and the pipeline divides them into batches of a specific size.
 * All data must be processed.Multiple users' data cannot be combined for processing.
 * The number of batches across all users cannot exceed a limit.
 * Determine the minimum batch size.

 * Example 1 Input: dataSamples = [1, 5, 7], maxBatches = 8 Output: 2

 * Explanation:
 * If the batch size is 1, the number of batches required is 1 + 5 + 7 = 13 (exceeds the limit).
 * If the batch size is 2, the number of batches required is:
 * ceil(1/2) + ceil(5/2) + ceil(7/2) = 1 + 3 + 4 = 8 (meets the limit).

 * Example 2 Input: dataSamples = [2, 4, 5], maxBatches = 10 Output: 2

 * Explanation:
 * If the batch size is 1, the number of batches required is 2 + 4 + 5 = 11 (exceeds the limit).
 * If the batch size is 2, the number of batches required is:
 * 1 + 2 + 3 = 6 (meets the limit).
 */

public class MinBatchSize {

  public static int findMinBatchSize(List<Integer> list, int maxBatches) {
    int low = 1, high = Collections.max(list);
    while (low <= high) {
      int mid = (low + high) / 2;
      int batches = 0;
      for (int x : list) {
        batches += (x + mid - 1) / mid;
        if (batches > maxBatches) {           // No need to continue if already too many
          break;
        }
      }
      if (batches > maxBatches) {
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }
    return low;
  }

  public static void main(String[] args) {
    System.out.println(findMinBatchSize(List.of(1, 5, 7), 8));
  }
}
