package sorting.cyclicSort;

import java.util.*;

public class LC448_FindAllNumsDisappearedInArray {
    public static void main(String[] args) {
        int[] arr = {2, 2, 1, 2, 2, 6};

        System.out.println(findDisappearedNumbers(arr));
    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {

        // Sort using Cyclic Sort in O(n)
        int i = 0;
        while (i < nums.length) {
            int correctIndex = nums[i] - 1;

            if (nums[i] != nums[correctIndex]) {
                swap(nums, i, correctIndex);
            } else {
                i++;
            }
        }

        // Find missing elements
        List<Integer> result = new ArrayList<>();
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != j + 1) {
                result.add(j + 1);
            }
        }

        return result;
    }

    static void swap(int[] arr, int start, int end) {
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }
}