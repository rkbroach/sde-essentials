package javaessentials.generics;

import javaessentials.generics.CustomGenericArrayList;

public class MAIN {

    public static void main(String[] args) {
        CustomGenericArrayList<Integer> arr = new CustomGenericArrayList();
        System.out.println(arr.size());
        System.out.println(arr);
        arr.add(100);
        arr.add(69);
        System.out.println(arr.size());
        System.out.println(arr);

        CustomGenericArrayList<String> arrStr = new CustomGenericArrayList();
        System.out.println(arrStr.size());
        System.out.println(arrStr);
        arrStr.add("Rohan");
        arrStr.add("broach");
        System.out.println(arrStr.size());
        System.out.println(arrStr);
    }
}
