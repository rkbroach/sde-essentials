package algorithms.recursion.easy;

public class Palindrome {

    public static void main(String[] args) {
        String str1 = "HelloWorld";
        String str2 = "ambmmbma";

        System.out.println(isPalindrome(str1));
        System.out.println(isPalindrome(str2));

    }

    static boolean isPalindrome(String str) {
        if (str.isEmpty()) {
            return true;
        }
        
        if (str.charAt(0) == str.charAt(str.length() - 1)) {
            return isPalindrome(str.substring(1, str.length() - 1));
        } else {
            return false;
        }
    }
}
