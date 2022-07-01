package generator;

import java.util.*;

public class MainMenu {

    private Scanner scanner = new Scanner(System.in);
    protected Generator generator = new Generator();

    public MainMenu() {

    }

    public void menu() {

        System.out.println("Добро пожаловать в меню");

        while (true) {

            System.out.println("Выберите действие");
            System.out.println("1 - продолжить генерацию");
            System.out.println("2 - остановить генерацию");
            System.out.println("3 - вывести все данные");
            System.out.println("4 - вывести значения за последние 10 секунд");
            System.out.println("5 - вывод всех номеров больших 5");
            System.out.println("6 - выход");

            if (scanner.hasNextInt()) {
                int a = scanner.nextInt();

                switch (a) {
                    case (1):
                        generator.resume();
                        System.out.println("Генерация продолжается");
                        break;
                    case (2):
                        generator.suspend();
                        System.out.println("Генерация остановлена");
                        break;
                    case (3):
                        System.out.println("Вывод значений");
                        generator.counter.printValues();
                        break;
                    case (4):
                        System.out.println("Вывод значений за последние 10 секунд");
                        generator.counter.printValuesPer10sec();
                        break;
                    case (5):
                        System.out.println("Вывод всех номеров больших 5");
                        generator.counter.printValues5();
                        break;
                    case (6):
                        System.exit(0);
                        break;
                }
            } else {
                System.out.println("Не та кнопка" + "\n" + "\n");
                scanner.next();
            }
        }
    }
}

