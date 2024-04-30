package linkedList;

/*
 * https://leetcode.com/problems/happy-number/description/
 * O(n), O(1)
 *
 * */
public class LC202_HappyNumber {
    public static void main(String[] args) {
        /*
         * Output: true for n = 19
         * 12 + 92 = 82
         * 82 + 22 = 68
         * 62 + 82 = 100
         * 12 + 02 + 02 = 1
         *
         * */
        int n = 19;
        System.out.println(isHappy(n));
    }

    public static boolean isHappy(int n) {

        int slow = n;
        int fast = n;

        do {
            slow = calculateSumOfSquaresInDigits(slow);
            fast = calculateSumOfSquaresInDigits(calculateSumOfSquaresInDigits(fast));
        } while (slow != fast);

        return slow == 1 ? true : false;

    }

    public static int calculateSumOfSquaresInDigits(int n) {
        int sum = 0;

        while (n > 0) {
            int digit = n % 10;
            sum += (digit * digit);
            n /= 10;
        }

        return sum;
    }
}
