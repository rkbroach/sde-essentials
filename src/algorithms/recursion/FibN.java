package algorithms.recursion;

public class FibN {

    public static void main(String[] args) {
        int n = 10;
        int ans = fibN(n);
        System.out.println(ans);
    }

    static int fibN(int n) {
        // 0, 1, 1, 2, 3, 4, ...

        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return fibN(n - 1) + fibN(n - 2);
        }
    }
}
