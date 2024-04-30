package javaessentials.generics;

import java.util.Arrays;

public class CustomGenericArrayList<T> {

    private Object[] data;
    private static final int DEFAULT_SIZE = 10;
    private int SIZE = 0;

    public CustomGenericArrayList() {
        data = new Object[DEFAULT_SIZE];
    }

    public void add(T num) {
        if (isFull()) {
            resize();
        }
        data[SIZE++] = num;
    }

    public int removeAt(int index) {
// TO DO
        return 0;

    }


    public T get(int index) {
        return (T) data[index];
    }

    public void set(int index, int value) {
        data[index] = value;
    }

    private void resize() {
        Object[] tempArr = new Object[data.length * 2];

        // copy data to tempArr
        for (int i = 0; i < data.length; i++) {
            tempArr[i] = data[i];
        }

        data = tempArr;
    }

    private boolean isFull() {
        return size() == data.length;
    }

    public int size() {
        return SIZE;
    }

    @Override
    public String toString() {
        return "CustomArrayList{" + "data=" + Arrays.toString(data) + ", SIZE=" + SIZE + '}';
    }
}
