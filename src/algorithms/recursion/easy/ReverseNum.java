package algorithms.recursion.easy;

public class ReverseNum {

    static int sum = 0;

    public static void main(String[] args) {
        System.out.println(rev2(1234));
    }

    // Using global variable
    static void rev1(int n) {
        if (n == 0) {
            return;
        }
        int rem = n % 10;
        sum = sum * 10 + rem;
        rev1(n / 10);
    }

    // special pattern, how to pass a value to above calls
    static int rev2(int n) {
        // sometimes you might need some additional variables in the argument
        // in that case, make another function
        int numOfDigits = (int) (Math.log10(n)) + 1;
        return helper(n, numOfDigits);
    }

    private static int helper(int n, int numOfDigits) {
        if (n % 10 == n) {
            return n;
        }
        int rem = n % 10;
        return rem * (int) (Math.pow(10, numOfDigits - 1)) + helper(n / 10, numOfDigits - 1);
    }

}
