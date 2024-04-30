package algorithms.recursion.easy;

public class SumOfDigits {

    public static void main(String[] args) {

        int num = 13425;
        System.out.println(sumOfDigits(num));
    }

    static int sumOfDigits(int n) {
        if (n == 0) {
            return 0;
        }
        return (n % 10) + sumOfDigits(n / 10);

    }
}
