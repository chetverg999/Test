package com.company.exercises;

public class MassivViborka {
    public static void main(String[] args) {
        int[] array1 = {0, 9, 1, 8, 3, 7, 4, 6, 5, 8};
        int minindex;
        int buffer;
        for (minindex = 0; minindex < array1.length; minindex ++) {
            for (int i=array1.length - 1; i > minindex; i--) {
                if (array1[minindex] > array1[i]) {
                    buffer = array1[minindex];
                    array1[minindex] = array1[i];
                    array1[i] = buffer;
                }

            }
        }
        for (int i=0; i<array1.length; i++)
            System.out.println(array1[i]);
    }
}