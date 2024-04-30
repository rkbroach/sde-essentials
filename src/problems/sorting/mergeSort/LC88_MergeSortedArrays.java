package sorting.mergeSort;

public class LC88_MergeSortedArrays {

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 5, 6};
        int n = 3;

        merge(nums1, m, nums2, n);
        System.out.println(nums1);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = 0;
        int p2 = 0;

        while (p1 < m || p2 < n) {
            if (nums1[p1] < nums2[p2]) {
                nums1[p1] = nums1[p1];
                p1++;
            } else {
                nums1[p1] = nums2[p2];
                p2++;
            }
        }

    }
}
