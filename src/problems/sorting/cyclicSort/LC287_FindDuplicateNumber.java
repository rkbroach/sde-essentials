package sorting.cyclicSort;

public class LC287_FindDuplicateNumber {

    public static void main(String[] args) {
        int[] nums = {1, 3, 4, 2, 2};
        System.out.println(findDuplicate(nums));
    }

    static int findDuplicate(int[] nums) {

        int i = 0;
        while (i < nums.length) {
            if (nums[i] != i + 1) {
                int correctIndex = nums[i] - 1;

                if (nums[i] != nums[correctIndex]) {
                    swap(nums, i, correctIndex);
                } else {
                    return nums[i];
                }
            } else {
                i++;
            }
        }

        return -1;

    }

    static void swap(int[] arr, int start, int end) {
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }
}
