package algorithms.recursion.arrays;

import java.util.ArrayList;
import java.util.List;

public class LinearSearch {

    public static void main(String args[]) {
        int[] arr = {3, 2, 1, 18, 9, 1, 15, 1, 123, 1};
        int target = 1;

        System.out.println(linearSearch(arr, 0, target));
        List<Integer> ans = new ArrayList<>();

        System.out.println(linearSearchAll(arr, 0, target, ans));
    }

    public static int linearSearch(int[] arr, int i, int target) {

        // Search completed till end and not found
        if (i == arr.length - 1) {
            return -1;
        }

        // Target found
        if (arr[i] == target) {
            return i;
        } else {
            return linearSearch(arr, i + 1, target);
        }

    }

    public static List linearSearchAll(int[] arr, int i, int target, List<Integer> ans) {
        if (i == arr.length) {
            return ans;
        }

        if (arr[i] == target) {
            ans.add(i);
        }

        return linearSearchAll(arr, i + 1, target, ans);
    }
}
