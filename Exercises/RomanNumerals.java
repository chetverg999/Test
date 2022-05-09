package com.company.exercises;
import java.util.Scanner;
import java.util.TreeMap;

public class RomanNumerals {
    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);
        System.out.println("Введите число 1");
        String number1 = keyboard.nextLine();
        System.out.println("Введите число 2");
        String number2 = keyboard.nextLine();

        TreeMap<String, Integer> map = new TreeMap<String, Integer>();
        map.put("M", 1000);
        map.put("D", 500);
        map.put("C", 100);
        map.put("L", 50);
        map.put("X", 10);
        map.put("V", 5);
        map.put("I", 1);


        int num1 = 0;
        for (int i = 0; i < number1.length(); i++) {
            String chst1 = Character.toString(number1.charAt(i));
            if ((i + 1) < number1.length()) { //проверка переполнения
                String chst2 = Character.toString(number1.charAt(i + 1));
                if (map.get(chst1) < map.get(chst2)) { //если меньшая цифра стоит перед большей (в этом случае она не может повторяться), то меньшая вычитается из большей;
                    num1 += map.get(chst2) - map.get(chst1);
                    i++;
                } else {
                    num1 += map.get(chst1); // если большая цифра стоит перед меньшей, они складываются
                }
            } else {
                num1 += map.get(chst1);// если на вход дается одна цифра, то она переводится по таблице напрямую
            }
        }
        System.out.println("Число 1 в арабской системе");
        System.out.println(num1);

        int num2 = 0;
        for (int i = 0; i < number2.length(); i++) {
            String chst1 = Character.toString(number2.charAt(i));
            if ((i + 1) < number2.length()) {
                String chst2 = Character.toString(number2.charAt(i + 1));
                if (map.get(chst1) < map.get(chst2)) {
                    num2 += map.get(chst2) - map.get(chst1);
                    i++;
                } else {
                    num2 += map.get(chst1);
                }
            } else {
                num2 += map.get(chst1);
            }
        }
        System.out.println("Число 2 в арабской системе");
        System.out.println(num2);

        int result = num1 + num2;

        System.out.println("Результат сложения в арабской и римской системах");
        System.out.println(result);
        System.out.println(toRoman(result));
    }


    public static String toRoman(int result) {

        TreeMap<Integer, String> reverseMap = new TreeMap<Integer, String>();
        reverseMap.put(1000, "M");
        reverseMap.put(900, "CM");
        reverseMap.put(500, "D");
        reverseMap.put(400, "CD");
        reverseMap.put(100, "C");
        reverseMap.put(90, "XC");
        reverseMap.put(50, "L");
        reverseMap.put(40, "XL");
        reverseMap.put(10, "X");
        reverseMap.put(9, "IX");
        reverseMap.put(5, "V");
        reverseMap.put(4, "IV");
        reverseMap.put(1, "I");

        int l = reverseMap.floorKey(result); //floorKey(K obj): возвращает самый большой ключ k, который меньше или равен ключу obj.Если такого ключа нет, возвращает null;
        if (result == l) { //если число совпало с ключом вытаскиваем объект по этому ключу
            return reverseMap.get(result);
        }
        return reverseMap.get(l) + toRoman(result - l); //берем самое большое ближайшее значениек числу и приписываем справа самое большое ближайшее значение от остатка этого числа,и так пока не попадем на совпадение числа и ключа
    }
}

