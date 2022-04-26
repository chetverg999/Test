package com.company.exercises;

public class Factorial1 {

    public static void main(String[] args) {
        int x = 0;
        factorial(x);
    }
    public static void factorial (int x) {
            if (x % 1 == 0 && x >= 0) {
                long n = 1;
                if (x == 1) {
                    System.out.println("Факториал = " + x);
                    System.exit(0);
                } else {
                    while (x > 1) {
                        n = n * x;
                        x--;
                    }
                    System.out.println("Факториал = " + n);
                    System.exit(0);
                }
            }
    }
}


