package corejava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class OptionalDemo {

    public static void main(String[] args) {

        String s1 = "ogs1";
        String s2 = "ogs2";

        s2 = s1; // s2 becomes ogs1, s1 remains ogs1
        s1 = "changedS1"; // s1 becomes changedS1, s2 remains ogs1
        s2 = "changedS2"; // s1 remains changedS1, s2 becomes changedS2

    }

    private static final void printDefaultIfNull(String s) {
        Optional.ofNullable(s).ifPresentOrElse(x -> System.out.println(x), () -> System.out.println("default"));
    }
}
