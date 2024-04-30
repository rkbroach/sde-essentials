package recursion;

/*
 * 1342. Number of Steps To Reduce A Number To Zero
 * https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero/description/
 * */
public class LC1342_NumOfStepsToReduceANumToZero {

//    static int stepCount = 0;

    public static void main(String args[]) {
        System.out.println(numberOfStepsRec(123, 0));
        System.out.println(numberOfStepsIter(123));
    }

    public static int numberOfStepsIter(int num) {
        int stepCount = 0;

        while (num != 0) {
            if (isEven(num)) {
                num = num / 2;
            } else {
                num = num - 1;
            }
            stepCount++;
        }

        return stepCount;
    }


    public static int numberOfStepsRec(int num, int stepCount) {

        if (num == 0) {
            return stepCount;
        }

        if (isEven(num)) {
            num = num / 2;
        } else {
            num -= 1;
        }
        return numberOfStepsRec(num, ++stepCount);

    }


    private static boolean isEven(int n) {
        return n % 2 == 0;
    }
}
