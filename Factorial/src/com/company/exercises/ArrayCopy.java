package com.company.exercises;

import java.util.Arrays;

public class ArrayCopy {
    public static void main(String[] args) {
        int[] array1 = {167, -2, 16, 99, 26, 92, 43, -234, 35, 80};
        int[] array2 = new int[20];
        copyToArray(array1, array2, 7);
    }

    public static void copyToArray(int [] array1, int [] array2, int length) {
        for (int i = 0; i < length; i++) {
            array2[i] = array1[i];
        }
            System.out.println(Arrays.toString(array2));
    }
}
