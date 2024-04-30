package sorting.cyclicSort;

import java.util.ArrayList;
import java.util.List;

public class LC442_FindAllDuplicateInArray {

    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println(findDuplicates(nums));
    }

    public static List<Integer> findDuplicates(int[] nums) {
        // Cyclic Sort in O(n)
        int i = 0;
        while (i < nums.length) {

            int correctIndex = nums[i] - 1;
            if (nums[i] != nums[correctIndex]) {
                swap(nums, i, correctIndex);
            } else {
                i++;
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != j + 1) {
                result.add(nums[j]);
            }
        }

        return result;
    }

    static void swap(int[] arr, int start, int dest) {
        int temp = arr[start];
        arr[start] = arr[dest];
        arr[dest] = temp;
    }
}
