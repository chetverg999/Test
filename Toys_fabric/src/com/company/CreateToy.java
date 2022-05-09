package com.company;

import java.io.*;
import java.util.*;
import java.text.*;

public class CreateToy {

    String[] authors = new String[6];
    String[] toys = new String[6];
    String[] machine = new String[3];

    public void toy_maid() throws IOException {
        Main main = new Main();
        parametrsOfToy();
        System.out.println("Игрушка готова!");
        main.mainMenu();
    }

    private String chooseAuthor() throws IOException {
        String author_name = null;
        while (true) {
            System.out.println("Возможные авторы игрушки представлены ниже:");
            String vip = " - Игрушка умеет говорить - Привет";
            authors[0] = "VIP Томас Каллаган";
            authors[1] = "VIP Джон Смит";
            authors[2] = "Алиса";
            authors[3] = "Боб";
            authors[4] = "Сол";
            authors[5] = "Гарсия";
            for (String i : authors) {
                System.out.println(i);
            }
            System.out.println("Введите автора игрушки, которого вы хотите:");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String word1 = br.readLine();

            for (int i = 0; i < 6; i++) {
                if (word1.equals(authors[i])) {
                    author_name = word1;
                    if (word1.equals(authors[0]) || word1.equals(authors[1])) {
                        author_name = word1 + vip;
                    }
                }
            }
            if (author_name == null) {
                System.out.println("Такого автора нет");
            } else {
                break;
            }
        }
        return author_name;
    }

    private String chooseToy() throws IOException {
        String toy_name = null;
        while (true) {
            System.out.println("Возможные игрушки представлены ниже:");
            toys[0] = "Медведь";
            toys[1] = "Машина";
            toys[2] = "Пирамида";
            toys[3] = "Кукла";
            toys[4] = "Мяч";
            toys[5] = "Конструктор";
            for (String i : toys) {
                System.out.println(i);
            }
            System.out.println("Введите название игрушки, которую вы хотите:");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String word1 = br.readLine();

            for (int i = 0; i < 6; i++) {
                if (word1.equals(toys[i])) {
                    toy_name = word1;
                }
            }
            if (toy_name == null) {
                System.out.println("Такой игрушки нет");
            } else {
                break;
            }
        }
        return toy_name;
    }

        private void parametrsOfToy () throws IOException {
            Date dateNow = new Date();
            SimpleDateFormat formatForDateNow = new SimpleDateFormat("E yyyy.MM.dd 'и время' hh:mm:ss a zzz");
            String author_name1 = chooseAuthor();
            String toy_name1 = chooseToy();
            machine[0] = "50%";
            machine[1] = "70%";
            machine[2] = "95%";
            double weight = Math.random() * 100;
            double length = Math.random() * 100;
            double width = Math.random() * 100;
            double a = Math.random() * 3;
            int i = (int) a;
            String stanok = "Качество игрушки = " + machine[i];
            try (FileWriter writer = new FileWriter("toys.txt", true)) {
                String author_name = "\n" + "\n" + "Автор игрушки " + author_name1;
                String toy_name = "Название игрушки " + toy_name1;
                String text = "Вес игрушки = " + weight + "\n" + "Длина игрушки = " + length + "\n" + "Ширина игрушки = " + width + "\n";
                writer.write(author_name + "\n" + toy_name + "\n" + stanok + "\n" + text);
                writer.write("Дата создания игрушки " + formatForDateNow.format(dateNow));
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }


