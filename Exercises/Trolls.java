package com.company.exercises;
import java.util.Arrays;
import java.util.Scanner;
public class Trolls {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Задайте размер массива");
        int size = keyboard.nextInt();
        int walls[] = new int[size];
        System.out.println("Задайте значения массива");
        if (keyboard.hasNextInt()) {
            for (int i = 0; i < size; i++) {
                walls[i] =keyboard.nextInt();
            }
        }
        System.out.println("Ваш массив");
        System.out.println(Arrays.toString(walls));
        int sred = (int) Math.ceil(Arrays.stream(walls).average().orElse(Double.NaN)); // Считаем среднее массива округляя в большую сторону
        System.out.println("Среднее значение массива равно " + sred);
        int count = 0;
        for (int i = 0; i < size; i++) {
                count = count + Math.abs(walls[i] - sred);
        }
        System.out.println("Минимальное количество ходов " + count);
    }
}
