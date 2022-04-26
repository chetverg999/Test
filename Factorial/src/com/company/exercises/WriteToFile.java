package com.company.exercises;

import java.io.*;
import java.util.Scanner;

public class WriteToFile {
    public static void main(String[] args) throws IOException {
        menu();
    }

    public static void menu() throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            System.out.println("Куда пишем?  1-В конец    2-В начало    3-Выйти");

            switch (reader.readLine()) {

                case "1":
                    writeToEnd();
                    break;

                case "2":
                    writeToBegin();
                    break;

                case "3":
                    System.exit(0);
                    break;

                default:
                    System.exit(0);
            }
        }
    }


    public static void readFile() throws IOException {

        BufferedReader file = null;
        file = new BufferedReader(new FileReader("Documents/TextDocument.txt"));
        String sq;

        while ((sq = file.readLine()) != null) {
            System.out.println(sq);
        }

        file.close();
    }

    public static void writeToBegin() throws IOException {
        readFile();

        Scanner keyboard2 = new Scanner(System.in);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        System.out.println("Запишите что нибудь");
        String text = keyboard2.nextLine() + "\n";
        byte[] buffer = text.getBytes();
        baos.write(buffer);
        FileInputStream fileIS = new FileInputStream("Documents/TextDocument.txt");
        while (fileIS.available() > 0) baos.write(fileIS.read());
        fileIS.close();
        FileOutputStream fileOS = new FileOutputStream("Documents/TextDocument.txt");
        baos.toString();
        baos.writeTo(fileOS);
        fileOS.close();
        baos.close();

        readFile();
    }

    public static void writeToEnd() throws IOException {
        readFile();

        FileWriter writer = null;
        Scanner keyboard1 = new Scanner(System.in);
        writer = new FileWriter("Documents/TextDocument.txt", true);

        System.out.println("Запишите что нибудь");
        writer.write("\n" + keyboard1.nextLine()); // запись в файл с клавиатуры
        writer.close();

        readFile();
    }
}