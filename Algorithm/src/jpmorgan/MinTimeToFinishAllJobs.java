package jpmorgan;

import java.util.Arrays;
import static java.lang.Integer.min;

/**
Given an array of jobs with different time requirements.
There are K identical assignees available, and we are also given how much time an assignee takes to do one unit of the job.
Find the minimum time to finish all jobs with the following constraints.
An assignee can be assigned only contiguous jobs. For example, an assignee cannot be assigned jobs 1 and 3, but not 2.
Two assignees cannot share (or co-assigned) a job, i.e., a job cannot be partially assigned to one assignee and partially to others.
Input:
K: Number of assignees available.
T: Time taken by an assignee to finish one unit of job
An array that represents time requirements of different jobs.
Examples:
Input: k = 2, T = 5, job[] = {4, 5, 10} Output: 50
The minimum time required to finish all the jobs is 50. There are 2 assignees available. We get this time by
assigning {4, 5} to first assignee and {10} to second assignee.
Input: k = 4, T = 5, job[] = {10, 7, 8, 12, 6, 8} Output: 75
We get this time by assigning {10} {7, 8} {12} and {6, 8}
*/

// Time complexity: O(n log n)
// Space complexity: O(1)

public class MinTimeToFinishAllJobs {

    private static int findMinTime(int K, int T, int[] job) {
        // Set start and end for the binary search end provides an upper limit on time
        int start = 0, end = Arrays.stream(job).sum();
        int min = end;
        int job_max = Arrays.stream(job).max().getAsInt();
        while (start <= end) {
            int mid = (start + end) / 2;
            if (mid >= job_max && isPossible(mid, K, job)) {
                min = min(min, mid);
                end = mid - 1;
            } else
                start = mid + 1;
        }
        return min * T;
    }

    static boolean isPossible(int time, int K, int[] job) {
        int cnt = 1, curr_time = 0, i = 0;
        while (i < job.length) {
            // If time assigned to the current assignee exceeds max, increment count of assignees.
            if (curr_time + job[i] > time) {
                curr_time = 0;
                cnt++;
            }
            // Else add time of a job to current time and move to the next job.
            else {
                curr_time += job[i];
                i++;
            }
        }
        return cnt <= K;
    }

    public static void main(String[] args) {
        int[] job = {10, 7, 8, 12, 6, 8};
        int k = 4, T = 5;
        System.out.println(findMinTime(k, T, job));
    }
}
