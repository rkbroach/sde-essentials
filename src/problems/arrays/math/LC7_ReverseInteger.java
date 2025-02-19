package problems.arrays.math;

import java.util.ArrayList;
import java.util.List;

public class LC7_ReverseInteger {

    public static void main(String[] args) {
        System.out.println(reverse(1534236469));
    }

    public static int reverse(int x) {

        // get digits
        boolean isPositive = x >= 0;
        int n = Math.abs(x);
        List<Integer> digits = new ArrayList<>();
        while (n > 0) {
            digits.add(n % 10);
            n = n / 10;
        }

        long ans = 0;
        // reverse digits
        for (int i = 0; i < digits.size(); i++) {
            ans += digits.get(i) * Math.pow(10, digits.size() - 1 - i);
        }

        if (ans > Integer.MAX_VALUE || ans < Integer.MIN_VALUE) {
            return 0;
        }

        if (!isPositive) {
            return (int) ans * -1;
        } else {
            return (int) ans;
        }
    }
}
