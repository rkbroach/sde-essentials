package algorithms.recursion.easy;

public class ProductOfDigits {
    public static void main(String[] args) {

        int num = 1342;
        System.out.println(productOfDigits(num));
    }

    static int productOfDigits(int n) {
        // Last digit remains
        if (n % 10 == n) {
            return n;
        }
        return (n % 10) * productOfDigits(n / 10);

    }
}
