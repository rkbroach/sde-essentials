package algorithms.recursion;

public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 56, 69, 82, 901, 1290, 4314, 43144};
        int target = 12;
        System.out.println(binarySearch(arr, target, 0, arr.length - 1));

    }

    static int binarySearch(int[] arr, int target, int start, int end) {

        if (start > end) {
            return -1;
        }

        int mid = start + (end - start) / 2;

        if (target > arr[mid]) {
            return binarySearch(arr, target, mid + 1, end);
        } else if (target < arr[mid]) {
            return binarySearch(arr, target, start, mid - 1);
        } else {
            return mid;
        }
    }
}
