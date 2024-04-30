package sorting.cyclicSort;

import java.util.*;

public class LC268_MissingNumber {

    public static void main(String[] args) {
        int[] arr = {3, 2, 0, 1};

        System.out.println(missingNumber(arr));
    }

    public static int missingNumber(int[] nums) {

        // Sort arr in asc order using Cyclic Sort
        int currentIndex = 0;
        int N = nums.length;

        while (currentIndex < N) {
            int correctIndex = nums[currentIndex];

            if (correctIndex < N && nums[currentIndex] != nums[correctIndex]) {
                swap(nums, currentIndex, correctIndex);
            } else {
                currentIndex++;
            }
        }

            // Find missing element
            for (int i = 0; i < N; i++) {
                if (nums[i] != i) {
                    return i;
                }
            }

        return N;

    }

    static void swap(int[] arr, int start, int dest) {
        int temp = arr[start];
        arr[start] = arr[dest];
        arr[dest] = temp;
    }
}
