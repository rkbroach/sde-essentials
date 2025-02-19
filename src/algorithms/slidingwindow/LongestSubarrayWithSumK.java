package algorithms.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubarrayWithSumK {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 1, 1, 1, 1, 4, 2, 3};
//        int[] arr = {1, 2, -3, 0, 0, 6, 1, 1, 1};
//        int[] arr = {3, 2, 4};

        int k = 3;
//        System.out.println(findLongestSubArray1(arr, k));
//        System.out.println(findLongestSubArray2(arr, k));
//        System.out.println(findLongestSubArray3(arr, k));
        System.out.println(findLongestSubArray4(arr, k));
    }

    // Good brute force - Generate all subarrays - O(n^2)
    private static int findLongestSubArray2(int[] arr, int k) {
        int longestSubarrayLen = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int sumUntilNow = 0;
            for (int j = i; j < arr.length; j++) {
                sumUntilNow += arr[j];
                if (sumUntilNow == k) {
                    longestSubarrayLen = Math.max(longestSubarrayLen, j - i + 1);
//                    debugSubArray(i, end, sumUntilNow, arr);
                }
            }
        }
        return longestSubarrayLen;
    }

    // Optimised (hashing) for all ints - Time Complexity: O(n * 1) for unordered with negligible collisions, approx O(n * n) =O(n^2) | O(n logn) for ordered map (no collisions)
    // {1, 2, 3, 1, 1, 1, 1, 4, 2, 3}
    private static int findLongestSubArray3(int[] arr, int k) {
        Map<Integer, Integer> prefixSumMap = new HashMap<>();
        int prefixSum = 0;
        int maxLen = 0;

        // DO IN END: Base case: prefix sum 0 occurs before the array starts {3, 2, 4} and k = 3;
        prefixSumMap.put(0, -1);

        for (int i = 0; i < arr.length; i++) {
            prefixSum += arr[i];

            int remaining = prefixSum - k;

            // Check if we've seen prefixSum - k before
            if (prefixSumMap.containsKey(remaining)) {
                int currLen = i - prefixSumMap.get(remaining);
                maxLen = Math.max(maxLen, currLen);
            }

            // Store only the first occurrence of currentSum in the map so that we can find the 'left most' span
            if (!prefixSumMap.containsKey(prefixSum)) {
                prefixSumMap.put(prefixSum, i);
            }

        }
        return maxLen;
    }

    // 2 pointer - Best optimised for only positives / non negatives
    // O(n) because each element is processed at most twice (once by l and once by r).
    // {0, 1, 2, 3, 4, 5, 6, 7, 8, 9}
    // {1, 2, 3, 1, 1, 1, 1, 4, 2, 3};
    private static int findLongestSubArray4(int[] arr, int k) {

        int maxLen = 0;
        int currSum = 0;
        int l = 0;
        int r = 0;
        while (r < arr.length) {
            // update sum from end
            currSum += arr[r];

            // keep shrinking from left until currSum is within bound for k
            while (l <= r && currSum > k) {
                currSum -= arr[l];
                l++;
            }

            // update maxLen if found k
            if (currSum == k) {
                maxLen = Math.max(maxLen, r - l + 1);
            }

            // move pointer ahead
            r++;

        }

        return maxLen;

    }

    private static void debugSubArray(int i, int j, int sum, int[] arr) {
        System.out.print("[");
        for (int p = i; p <= j; p++) {
            System.out.print(arr[p]);
            if (p < j) {
                System.out.print(", ");
            }
        }
        System.out.println("] = " + sum);
    }

    // BAD Brute Force - Generate all subarrays - approx O(n^3)
    private static int findLongestSubArray1(int[] arr, int k) {
        int longestSubarrayLen = Integer.MIN_VALUE;

        // generate all subarrays
        for (int start = 0; start < arr.length; start++) {
            for (int end = start; end < arr.length; end++) {
                int currentSubarraySum = 0;
                for (int i = start; i <= end; i++) {
                    currentSubarraySum += arr[i];
                }
//                    debugSubArray(start, end, currentSubarraySum, arr);

                if (currentSubarraySum == k) {
                    longestSubarrayLen = Math.max(longestSubarrayLen, end - start + 1);
                }
            }
        }
        return longestSubarrayLen;
    }

}
