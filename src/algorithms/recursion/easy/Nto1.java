package algorithms.recursion.easy;

public class Nto1 {

    public static void main(String[] args) {
        int n = 5;
        System.out.println("----N to 1------");
        nTo1(n);
        System.out.println("----1 to N------");
        oneToN(n);
        System.out.println("----n-- vs --n ------");
        passByValueConcept(n);
    }

    static void passByValueConcept(int n) {
        if (n == 0) {
            return;
        }

        System.out.println(n);
//        passByValueConcept(n--); // prints n, n times
        passByValueConcept(--n); // prints n, n-1, n-2, n-3, ... 1
    }

    static void nTo1(int n) {
        if (n == 0) {
            return;
        }

        System.out.println(n);
        nTo1(n - 1);
    }

    static void oneToN(int n) {
        if (n == 0) {
            return;
        }
        oneToN(n - 1);
        System.out.println(n);
    }
}
