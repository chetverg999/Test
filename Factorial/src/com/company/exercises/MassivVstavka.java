package com.company.exercises;
import java.util.Arrays;

public class MassivVstavka {
    public static void main(String[] args) {
        /*int[] array1 = {0, 9, 1, 8, 3, 7, 4, 6, 5, 8};
        for (int i = 1; i < array1.length; i++) {
            int buffer = array1[i];
            int j;
            for (int j = i-1; j >= 0; j--) {
                if (array1[i-1] < array1[i]) {
                    array1 [j + 1] = array1[j];
                }
            }
            array1[j] = buffer;
        }
        for (int i=0; i<array1.length; i++)
            System.out.println(array1[i]);
    }*/
        int[] array = {10, 2, 10, 3, 1, 2, 5};
        System.out.println(Arrays.toString(array));
        for (int i = 0; i < array.length; i++) {
            int buffer = array[i];// Вытаскиваем значение элемента
            int j;
            for ( j = i - 1; j >= 0; j--) {// Перемещаемся по элементам, которые перед вытащенным элементом
                if (buffer < array[j]) { // Если вытащили значение меньшее — передвигаем больший элемент дальше
                    array[j + 1] = array[j];
                } else {
                    break;// Если вытащенный элемент больше — останавливаемся
                }
            }
            array[j + 1] = buffer; // В освободившееся место вставляем вытащенное значение
        }
        System.out.println(Arrays.toString(array));
    }
}
