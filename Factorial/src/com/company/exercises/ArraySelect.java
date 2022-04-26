package com.company.exercises;

import java.util.Arrays;

public class ArraySelect {
    public static void main(String[] args) {
        int[] arrayTest = {0, 9, 1, 8, 3, 7, 4, 6, 5, 8};
        arraySelection(arrayTest);
    }

    public static void arraySelection(int[] array) {
        int minindex;
        int buffer;
        for (minindex = 0; minindex < array.length; minindex ++) {
            for (int i = array.length - 1; i > minindex; i--) {
                if (array[minindex] > array[i]) {
                    buffer = array[minindex];
                    array[minindex] = array[i];
                    array[i] = buffer;
                }
            }
        }
        System.out.println(Arrays.toString(array));
    }
}