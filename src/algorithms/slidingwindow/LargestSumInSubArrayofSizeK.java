package algorithms.slidingwindow;

public class LargestSumInSubArrayofSizeK {

    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 1, 3, 2};
        int k = 3;

        System.out.println(findMaxSumSubarray(arr, k));
    }

    // O(n)
    public static int findMaxSumSubarray(int[] arr, int k) {
        if (arr.length < k) {
            throw new IllegalArgumentException("Array length must be at least k");
        }

        int maxSum = 0;
        int currentSum = 0;

        // Calculate the sum of the first 'k' elements
        for (int i = 0; i < k; i++) {
            currentSum += arr[i];
        }
        maxSum = currentSum;

        // Slide the window of size 'k' through the array
        for (int i = k; i < arr.length; i++) {
            currentSum = currentSum - arr[i - k] + arr[i]; // Add the new element and subtract the oldest
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }

}
