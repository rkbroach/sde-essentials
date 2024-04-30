package problems.binarysearch;

public class LC35_SearchInsertPosition {

    public static void main(String[] args) {
        int[] nums = {-1, 3, 5, 6};
        System.out.println(searchInsert(nums, 0));

    }

    public static int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int mid = start + (end - start) / 2;

        while (start <= end) {
            mid = start + (end - start) / 2;
            if (target < nums[mid]) {
                // start
                end = mid - 1;
            } else if (target > nums[mid]) {
                // end
                start = mid + 1;
            } else {
                // target found
                return mid;
            }
        }

        if (target > nums[end]) {
            // next value after end
            return start;
        } else {
            // previous value before end
            return end;
        }


    }
}
