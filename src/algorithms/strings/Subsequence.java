package algorithms.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsequence {

    public static void main(String[] args) {
        String str = "abc";
        System.out.println(subSeq("", str));
        System.out.println(subSeqIter(str.split("")));
        System.out.println(subSeqIterDuplicate(new int[]{2, 1, 2}));
        System.out.println(subSeqAscii("", str));
    }

    static List<String> subSeq(String processed, String unprocessed) {

        if (unprocessed.isEmpty()) {
            List<String> list = new ArrayList<>();
            list.add(processed);
            return list;
        }

        char ch = unprocessed.charAt(0);

        // select
        List<String> left = subSeq(processed + ch, unprocessed.substring(1));

        // don't select
        List<String> right = subSeq(processed, unprocessed.substring(1));

        left.addAll(right);
        return left;

    }

    static List<List<String>> subSeqIter(String[] arr) {
        List<List<String>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());

        for (String ch : arr) {
            int n = outer.size();
            for (int i = 0; i < n; i++) {
                List<String> internal = new ArrayList<>(outer.get(i));
                internal.add(ch);
                outer.add(internal);
            }
        }

        return outer;

    }

    static List<List<Integer>> subSeqIterDuplicate(int[] arr) {
        Arrays.sort(arr); // duplicates must be adjacent

        List<List<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());

        int start = 0;
        int end = 0;

        for (int i = 0; i < arr.length; i++) {
            start = 0;
            // consecutive duplicate found
            if (i > 0 && arr[i] == arr[i - 1]) {
                start = end + 1;
            }

            end = outer.size() - 1;
            int n = outer.size();
            for (int j = 0; j < n; j++) {
                List<Integer> internal = new ArrayList<>(outer.get(j));
                internal.add(arr[i]);
                outer.add(internal);
            }
        }

        return outer;

    }

    static List<String> subSeqAscii(String pr, String up) {

        if (up.isEmpty()) {
            List<String> ls = new ArrayList<>();
            ls.add(pr);
            return ls;
        }

        char ch = up.charAt(0);

        // select
        List<String> left = subSeqAscii(pr + ch, up.substring(1));

        // skip
        List<String> middle = subSeqAscii(pr, up.substring(1));

        // select ascii
        List<String> right = subSeqAscii(pr + (ch + 0), up.substring(1));

        left.addAll(middle);
        left.addAll(right);

        return left;


    }


}
