package algorithms.binarysearch;

public class BinarySearch {

    public static void main(String[] args) {
        int[] arrAsc = {1, 2, 4, 5, 16, 69, 420, 1069, 2352, 3312}; // Sorted Array in asc order
        int[] arrDesc = {4000, 3500, 3312, 420, 69, 24, 16, 12, 1}; // Sorted Array in asc order
        int target = 3312;

        System.out.println(binarySearchImpl(arrAsc, target));
        System.out.println(binarySearchOrderAgnostic(arrAsc, target));
        System.out.println(binarySearchOrderAgnostic(arrDesc, target));
    }

    private static int binarySearchOrderAgnostic(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        // Check whether asc or desc
        boolean isAsc = arr[left] < arr[right];

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return mid;
            }

            if (isAsc) {
                if (target < arr[mid]) {
                    // left
                    right = mid - 1;
                } else {
                    // right
                    left = mid + 1;
                }
            } else {
                if (target > arr[mid]) {
                    // left
                    right = mid - 1;
                } else {
                    // right
                    left = mid + 1;
                }

            }
        }

        return -1;
    }

    // Return index if found, else -1
    static int binarySearchImpl(int[] arr, int target) {

        // Input Array is empty
        if (arr.length == 0) {
            return -1;
        }

        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {

            int mid = left + (right - left) / 2;
            int ans = arr[mid];

            if (target > ans) {
                // Search right side
                left = mid + 1;
            } else if (target < ans) {
                // Search left side
                right = mid - 1;
            } else {
                return mid;
            }
        }

        return -1;
    }
}
