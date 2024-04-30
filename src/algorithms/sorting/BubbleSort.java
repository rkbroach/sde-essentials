package algorithms.sorting;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = {10, 6, 5, 3, 2, 1};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void bubbleSort(int[] arr) {
        boolean swapped;

        for (int i = 0; i < arr.length; i++) {
            swapped = false;
            // Iterate from 1 to 'unsorted' range left
            for (int j = 1; j < arr.length - i; j++) {
                if (arr[j - 1] > arr[j]) {
                    swap(arr, j, j - 1);
                    swapped = true;
                }
            }

            if (!swapped) {
                // list already found to be sorted in first pass
                break;
            }

        }
    }

    static void swap(int[] arr, int start, int end) {
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }


}
