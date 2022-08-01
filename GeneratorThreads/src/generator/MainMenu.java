package generator;

import java.util.*;

public class MainMenu {

    private final Scanner scanner;
    private final GenThreads genThreads;

    public MainMenu() {
        this.genThreads = new GenThreads();
        this.scanner = new Scanner(System.in);
    }

    public GenThreads getGenThreads() {
        return genThreads;
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
                        genThreads.setStatus(true);
                        synchronized (genThreads.getSync()) {
                            genThreads.getSync().notifyAll();
                        }
                        System.out.println("Генерация продолжается");
                        break;
                    case (2):
                        genThreads.setStatus(false);
                        System.out.println("Генерация остановлена");
                        break;
                    case (3):
                        System.out.println("Вывод значений");
                        genThreads.getCounter().printValues();
                        break;
                    case (4):
                        System.out.println("Вывод значений за последние 10 секунд");
                        genThreads.getCounter().printValuesPer10sec();
                        break;
                    case (5):
                        System.out.println("Вывод всех номеров больших 5");
                        genThreads.getCounter().printValues5();
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

