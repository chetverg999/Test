package com.company.exercises;
import java.util.Scanner;
public class Factorial1 {

    public static void main(String[] args) {
        System.out.println("Введите число");
        int x;
        long n = 1; // гарантия что не будет домножения на ноль и факториал 0 = 1 а вообще пашол нахуй
        Scanner keyboard = new Scanner(System.in);
        if (keyboard.hasNextInt()) {
            x = keyboard.nextInt();
            if (x % 1 == 0 && x>=0) {
                if (x == 1 ) {
                    System.out.println("Факториал = " + x);
                    System.exit(0);
                }
                else {
                    while (x>1) {
                        n = n * x;
                        x--;
                    }
                    System.out.println("Факториал = " + n);
                    System.exit(0);
                }
            }
            else {
                System.out.println("Пашол нахуй");
                System.exit(0);
            }
        }
        else {
            System.out.println("Пашол нахуй");
            System.exit(0);
        }
    }
}


