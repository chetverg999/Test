package com.company;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    static Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.mainMenu();
    }

    public void mainMenu() throws IOException {
        CreateToy createToy = new CreateToy();
        ReadFile read_file = new ReadFile();
        int s = menu();
        switch (s) {
            case 1:
                createToy.toy_maid();
                break;

            case 2:
                read_file.menuFileReader();
                break;

            case 3:
                System.exit(0);
                break;

            default:
                System.out.println("Ошибка");
                System.exit(0);
        }

    }

    private int menu() {
        int menu_answer = 0;
        int buffer = 0;
        while (true) {
            String s = "───▄▀▀▀▄▄▄▄▄▄▄▀▀▀▄───\n" +
                    "───█▒▒░░░░░░░░░▒▒█───\n" +
                    "────█░░█░░░░░█░░█────\n" +
                    "─▄▄──█░░░▀█▀░░░█──▄▄─\n" +
                    "█░░█─▀▄░░░░░░░▄▀─█░░█\n" +
                    "█▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀█\n" +
                    "█░░╦─╦╔╗╦─╔╗╔╗╔╦╗╔╗░░█\n" +
                    "█░░║║║╠─║─║─║║║║║╠─░░█\n" +
                    "█░░╚╩╝╚╝╚╝╚╝╚╝╩─╩╚╝░░█\n" +
                    "█▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄█";
            System.out.println(s);
            System.out.println("\uD834\uDD1E Добро пожаловать на фабрику игрушек \uD834\uDD1E");
            System.out.println("        МЕНЮ");
            System.out.println("1. Сделать игрушку");
            System.out.println("2. Посмотреть файл");
            System.out.println("3. Выйти");
            if (keyboard.hasNextInt()) {
                buffer = keyboard.nextInt();
            } else {
                System.out.println("Неверная кнопка");
                keyboard.next();
                continue;
            }
            if (buffer >= 1 && buffer <= 3) {
                menu_answer = buffer;
                break;
            } else {
                System.out.println("Неверная кнопка");
            }
        }
        return menu_answer;
    }
}