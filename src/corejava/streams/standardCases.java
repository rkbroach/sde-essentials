package corejava.streams;

import java.util.*;

public class standardCases {

    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(4, 5, 2, 1, 3);

        printSumOfAllNums(nums);
        avgOfAllNums(nums);
    }

    public static void printSumOfAllNums(List<Integer> nums) {
        /*
         * Identity 0 is the initial 'starter' i.e.
         * accumulator = 0 (identity) ; currentValue = accumulator (0) + 4 = 4
         * accumulator = 4            ; currentValue = 4 + 5 = 9
         * accumulator = 9            ; currentValue = 9 + 5 = 14 and so on
         *
         * */

        int result = nums.stream().reduce(0, (accumulator, currentValue) -> accumulator + currentValue);
        System.out.println("sumAll : " + result);

    }

    public static void avgOfAllNums(List<Integer> nums) {
        List<Integer> e = new ArrayList<>();
        OptionalDouble result = e
                .stream()
                .mapToDouble(Integer::doubleValue)
                .average();
//                .getAsDouble();
        System.out.println("avgAll : " + result);
    }
}