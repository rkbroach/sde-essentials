/*
 * 345. Reverse Vowels of a String
 * https://leetcode.com/problems/reverse-vowels-of-a-string/description/
 * */

package problems.array.strings;

public class LC345_ReverseVowels {

    public static void main(String[] args) {
        String s = "leetcode";
        System.out.println(reverseVowels(s));
    }

    /*
     * Time complexity: O(n)
     * Space complexity: O(1)
     *
     * */
    public static String reverseVowels(String s) {
        int start = 0;
        int end = s.length() - 1;
        char[] word = s.toCharArray();

        // Iterate until 2 pointers cross each other
        while (start < end) {
            // Both pointers at consonants: continue
            if (!isVowel(word[start]) && !isVowel(word[end])) {
                start++;
                end--;
            } else if (!isVowel(word[start])) {
                // move pointer forward
                start++;
            } else if (!isVowel(word[end])) {
                // move pointer backward
                end--;
            } else {
                // Both pointers at vowels: swap
                swap(start, end, word);
                start++;
                end--;
            }
        }

        return new String(word);
    }

    static boolean isVowel(char letter) {
        switch (letter) {
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
            case 'A':
            case 'E':
            case 'I':
            case 'O':
            case 'U':
                return true;
            default:
                return false;
        }
    }

    static void swap(int i, int j, char[] word) {
        char temp = word[i];
        word[i] = word[j];
        word[j] = temp;
    }
}
