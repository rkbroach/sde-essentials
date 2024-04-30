package datastructures.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PrimitiveArray {
    public static void main(String[] args) {
        List<Integer> myList = new ArrayList<>();
        myList.add(10);
        myList.add(20);
        myList.add(20);
        myList.add(30);
        myList.add(40);
        myList.add(50);


        System.out.println(Collections.min(myList));


    }


}
