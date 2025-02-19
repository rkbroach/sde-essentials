package problems.arrays.math;

import java.util.ArrayList;
import java.util.List;

/*
* https://www.geeksforgeeks.org/problems/count-digits5716/1
* */
public class GFG_CountDigits {

    public static void main(String[] args) {
        int N = 22074;
        System.out.println(evenlyDivides(N));
    }

    static int evenlyDivides(int N) {
        // Calculate set of digits
        int n = N;
        List<Integer> digits = new ArrayList<>();
        while (n > 0) {
            digits.add(n % 10);
            n = n / 10;
        }

        // Check divisibility
        int options = 0;
        for (Integer digit : digits) {
            if (digit != 0 && N % digit == 0) {
                options++;
            }
        }
        return options;
    }
}
