package sorting.cyclicSort;

import java.util.Arrays;

public class LC645_SetMismatch {
    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 4};
        System.out.println(Arrays.toString(findErrorNums(nums)));
    }

    static int[] findErrorNums(int[] nums) {
        // Cyclic Sort
        int i = 0;

        while (i < nums.length) {
            int correctIndex = nums[i] - 1;

            if (nums[i] != nums[correctIndex]) {
                swap(nums, i, correctIndex);
            } else {
                i++;
            }
        }

        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != j + 1) {
                return new int[]{nums[j], j + 1};
            }
        }

        return new int[]{-1, -1};
    }

    static void swap(int[] arr, int start, int dest) {
        int temp = arr[start];
        arr[start] = arr[dest];
        arr[dest] = temp;
    }
}
