/*
 * 1768: Merge Strings Alternately
 * https://leetcode.com/problems/merge-strings-alternately
 *
 * */

package problems.array.strings;

public class LC1768_MergeStringsAlternately {

    public static void main(String[] args) {
        String word1 = "ab";
        String word2 = "pqrs";
        System.out.println(mergeAlternatelyTwoPointerApproach(word1, word2));
        System.out.println(mergeAlternatelySimplifiedTwoPointerApproach(word1, word2));
    }

    /*
     * Time complexity: O(m+n)
     * Space complexity: O(1)
     *
     * */
    public static String mergeAlternatelySimplifiedTwoPointerApproach(String word1, String word2) {
        StringBuilder result = new StringBuilder();

        int m = word1.length();
        int n = word2.length();

        int i = 0;
        int j = 0;

        // Iterate until both words not completely processed
        while (i < m || j < n) {

            // Keep processing Word 1
            if (i < m) {
                result.append(word1.charAt(i));
                i++;
            }

            // Keep processing Word 2
            if (j < n) {
                result.append(word2.charAt(j));
                j++;
            }

        }

        return result.toString();
    }

    /*
     * Time complexity: O(m+n)
     * Space complexity: O(1)
     *
     * */
    public static String mergeAlternatelyTwoPointerApproach(String word1, String word2) {
        StringBuilder result = new StringBuilder();
        int i = 0;
        int j = 0;
        boolean flag = true;

        // Case 1: At least one word is not completely processed
        while (i < word1.length() && j < word2.length()) {
            if (flag) {
                result.append(word1.charAt(i));
                i++;
            } else {
                result.append(word2.charAt(j));
                j++;
            }

            flag = !flag;
        }

        // Case 2: Word1 got completely processed, process Word2 only
        while (j < word2.length()) {
            result.append(word2.charAt(j));
            j++;
        }

        // Case 3: Word2 got completely processed, process Word1 only
        while (i < word1.length()) {
            result.append(word1.charAt(i));
            i++;
        }

        return result.toString();

    }
}
