package algorithms.recursion.arrays;

public class arraySortedOrNot {

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 8, 9};
        System.out.println(resultIter(arr));
        System.out.println(resultRecur(arr, 0));
    }


    private static boolean resultRecur(int[] arr, int i) {
        if (i == arr.length - 1) {
            return true;
        }
        return (arr[i] < arr[i + 1] && resultRecur(arr, i + 1));
    }

    private static boolean resultIter(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }
}
