package algorithms.strings;

public class StreamOfChars {

    public static void main(String[] args) {
        String str = "aaaabaw22cAAaacd";
        System.out.println(skipAChar('a', str));
        String str2 = "@gmail.commyemail@gmail.com";
        System.out.println(skipAWord("@gmail.com", str2));

        String x = "Hello";
        System.out.println(x.substring(1, 4));

    }

    static String skipAChar(char target, String unprocessed) {

        if (unprocessed.isEmpty()) {
            return "";
        }

        char ch = unprocessed.toLowerCase().charAt(0);

        if (ch == target) {
            return skipAChar(target, unprocessed.substring(1));
        } else {
            return ch + skipAChar(target, unprocessed.substring(1));
        }
    }

    static String skipAWord(String target, String unprocessed) {
        if (unprocessed.isEmpty()) {
            return "";
        }

        if (unprocessed.startsWith(target)) {
            return skipAWord(target, unprocessed.substring(target.length()));
        } else {
            return unprocessed.charAt(0) + skipAWord(target, unprocessed.substring(1));
        }


    }
}





















