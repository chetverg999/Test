package com.company.exercises;

public class MassivСopy {
    public static void main(String[] args) {
        int [] array2 = new int[20];
        int [] array5 = new int[20];
        int [] array1 = {167, -2, 16, 99, 26, 92, 43, -234, 35, 80};
        int start1 = 0;
        int start2 = 2;
        int length1 = 5;
        int stop1 = start1 + length1;
        int stop2 =start2 + length1;
        for (int number1 = start1; number1 < stop1 ; number1++ ) {
            array5[number1] = array1[number1];
        }
        for (int number2 = start2; number2 < stop2; number2++) {
            array5[number2] = array5[number2];
        }
        for (int number2 = start2; number2 < stop2; number2++) {
            array2[number2] = array5[number2];
        }


        // System.arraycopy(array1, 1, array2, 1, 4);
        /*— массив, элементы которого планируем копировать;
        — индекс элемента;
        — итоговый (результирующий) массив;
        — первый элемент итогового массива;
        — общее число элементов, предназначенных для копирования. */
        for (int i=0; i<array2.length; i++)
            System.out.println(array2[i]);
    }
}



