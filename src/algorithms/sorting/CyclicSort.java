package algorithms.sorting;

import java.util.*;

public class CyclicSort {

    public static void main(String[] args) {
        int[] arr = {3, 5, 2, 1, 4};

        System.out.println(Arrays.toString(cyclicSort(arr)));
    }

    static int[] cyclicSort(int[] arr) {
        int currentIndex = 0;
        while (currentIndex < arr.length) {
            // int correctIndex = arr[currentIndex]; // 0 to N
            int correctIndex = arr[currentIndex] - 1; // 1 to N
//            int correctIndex = arr[currentIndex] - a; // a to N
            if (arr[currentIndex] != arr[correctIndex]) {
                swap(arr, currentIndex, correctIndex);
            } else {
                currentIndex++;
            }
        }

        return arr;
    }

    static void swap(int[] arr, int currentIndex, int destinationIndex) {
        int temp = arr[currentIndex];
        arr[currentIndex] = arr[destinationIndex];
        arr[destinationIndex] = temp;
    }
}
