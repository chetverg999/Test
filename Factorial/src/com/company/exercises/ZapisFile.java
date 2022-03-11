package com.company.exercises;

import java.io.*;
import java.util.Scanner;

public class ZapisFile {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader file = null;
        FileWriter writer = null;

        while (true) {
            System.out.println("Куда пишем?  1-В конец    2-В начало    3-Идти нахуй");

                switch (reader.readLine()) {
                    case "1":
                        file = new BufferedReader(new FileReader("Documents/TextDocument.txt"));
                        String s;
                        while ((s = file.readLine()) != null) {
                            System.out.println(s);
                        }
                        file.close();

                        Scanner keyboard1 = new Scanner(System.in);
                        writer = new FileWriter("Documents/TextDocument.txt", true);
                        System.out.println("Запишите че нить");
                        writer.write("\n" + keyboard1.nextLine()); // запись в файл с клавиатуры
                        writer.close();

                        file = new BufferedReader(new FileReader("Documents/TextDocument.txt"));
                        while ((s = file.readLine()) != null) {
                            System.out.println(s);
                        }
                        file.close();
                        break;

                    case "2":
                        file = new BufferedReader(new FileReader("Documents/TextDocument.txt"));
                        String sq;
                        while ((sq = file.readLine()) != null) {
                            System.out.println(sq);
                        }
                        file.close();

                        Scanner keyboard2 = new Scanner(System.in);
                        ByteArrayOutputStream baos = new ByteArrayOutputStream(); // открытие потока байтов
                        System.out.println("Запишите че нить");
                        String text = keyboard2.nextLine() + "\n"; // получение текста
                        byte[] buffer = text.getBytes(); // перевод текста в байты
                        baos.write(buffer); // запись байтов в поток
                        FileInputStream fileIS = new FileInputStream("Documents/TextDocument.txt");
                        while (fileIS.available() > 0)
                            baos.write(fileIS.read()); // чтение и запись в поток остального файла
                        fileIS.close();
                        FileOutputStream fileOS = new FileOutputStream("Documents/TextDocument.txt");
                        baos.toString(); //перевод потока байтов в строку
                        baos.writeTo(fileOS);// запись в файл всего потока строк
                        fileOS.close();
                        baos.close();

                        file = new BufferedReader(new FileReader("Documents/TextDocument.txt"));
                        while ((s = file.readLine()) != null) {
                            System.out.println(s);
                        }
                        file.close();

                        break;
                    case "3":
                        System.exit(0);
                        break;

                    default:
                        System.exit(0);
                }
            }
        }
    }

        /*file = new BufferedReader(new FileReader("TextDocument.txt"));
        String s;
        while ((s = file.readLine()) != null) {
           System.out.println(s);
        }
        file.close();


        keyboard = new Scanner(System.in);
        writer = new FileWriter("TextDocument.txt", true);
        System.out.println("Запишите че нить");
        writer.write( "\n" + keyboard.nextLine()); // запись в файл с клавиатуры
        writer.close();


        file = new BufferedReader(new FileReader("TextDocument.txt"));
       while ((s = file.readLine()) != null) {
            System.out.println(s);
       }
        file.close();


        ByteArrayOutputStream baos = new ByteArrayOutputStream(); // открытие потока байтов
        System.out.println("Запишите че нить");
        String text = keyboard.nextLine()+ "\n"; // получение текста
        byte[] buffer = text.getBytes(); // перевод текста в байты
        baos.write(buffer); // запись байтов в поток
        FileInputStream fileIS = new FileInputStream("TextDocument.txt");
        while(fileIS.available() > 0)
            baos.write(fileIS.read()); // чтение и запись в поток остального файла
        fileIS.close();
        FileOutputStream fileOS = new FileOutputStream("TextDocument.txt");
        baos.toString(); //перевод потока байтов в строку
        baos.writeTo(fileOS);// запись в файл всего потока строк
        fileOS.close();
        baos.close();


        file = new BufferedReader(new FileReader("TextDocument.txt"));
        while ((s = file.readLine()) != null) {
            System.out.println(s);
        }
        file.close();*/