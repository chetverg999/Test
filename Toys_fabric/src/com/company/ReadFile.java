package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


public class ReadFile {

static Scanner keyboard1 = new Scanner(System.in);

    public void menuFileReader() throws IOException {
        Main main = new Main();
        while (true) {
        System.out.println("1. Ввести название файла");
        System.out.println("2. Назад");
        String s = keyboard1.next();
            if (s.equals("1")) {
                fileReader();
                continue;
            }
            if (s.equals("2")) {
                main.mainMenu();
            } else {
                System.out.println("Неверная кнопка");
                continue;
            }
        }
    }

    private void fileReader() throws IOException {

        BufferedReader reader = null;
        String fileName = null;
        BufferedReader writer =null;
        System.out.println("Введите название файла для чтения:");

        try {
            fileName = keyboard1.next();
        } catch (Exception e) {
            System.out.println("Ошибка - " + e.getMessage());
            menuFileReader();
        } try {
            writer = new BufferedReader(new FileReader(fileName));
            String s;
            while ((s = writer.readLine())!=null) {
                System.out.println(s);
            }
        } catch (Exception e) {
            System.out.println("Ошибка - " + e.getMessage());
            menuFileReader();
        } finally {
            try {
                if (writer != null & reader != null) {
                    writer.close();
                    reader.close();
                }
            } catch (Exception e) {
                System.out.println("Ошибка - " + e.getMessage());
                menuFileReader();
            }
        }
    }
}
