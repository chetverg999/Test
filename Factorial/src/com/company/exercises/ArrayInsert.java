package com.company.exercises;
import java.util.Arrays;

public class ArrayInsert {
    public static void main(String[] args) {
        int[] array = {10, 2, 10, 3, 1, 2, 5};
        insertArrays(array);
    }

    public static void insertArrays(int[] array) {
        System.out.println(Arrays.toString(array));
        for (int i = 0; i < array.length; i++) {
            int buffer = array[i];
            int j;
            for ( j = i - 1; j >= 0; j--) {
                if (buffer < array[j]) {
                    array[j + 1] = array[j];
                } else {
                    break;
                }
            }
            array[j + 1] = buffer;
        }
        System.out.println(Arrays.toString(array));
    }
}
