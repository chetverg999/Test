package com.company.exercises;

public class Factorial {
    public static void main(String[] args) {
        int a = 10;
        System.out.println( factor(a));
    }

    public static int factor(int num) {
        if (num <= 1)
            return 1;
        return num * factor(num - 1);
    }
}

