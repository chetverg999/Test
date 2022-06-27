package Generator;


import java.text.SimpleDateFormat;
import java.util.*;

public class MainMenu {

    Scanner scanner = new Scanner(System.in);
    static Generator generator = new Generator();

    public static void main(String[] args) throws InterruptedException {
        MainMenu menu = new MainMenu();
        generator.start();
        menu.menu();
    }

    public void menu()  {
        System.out.println("Добро пожаловать в меню");
        while (true) {

            System.out.println("Выберите действие");
            System.out.println("1 - продолжить генерацию");
            System.out.println("2 - остановить генерацию");
            System.out.println("3 - вывести все данные");
            System.out.println("4 - выход");

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
                        Counter.printValues();
                        break;
                    case (4):
                        System.exit(0);
                        break;
                }
            } else {
                System.out.println("Не та кнопка" + "\n" + "\n");
                scanner.next();
            }
        }

    }


    static class Generator extends Thread {

        long id = 0;
        String date;
        int number;
        Map<Long, List<Object>> map = new LinkedHashMap<>();
        Date dateNow = new Date();
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("E yyyy.MM.dd 'и время' hh:mm:ss a zzz");



        public void run() {
            while (true) {
                id++;
                number = (int) (Math.random() * 10);
                date = formatForDateNow.format(dateNow);
                map.put(id, Arrays.asList(number, date));
                Counter.count.put(id, Arrays.asList(number, date));
                try {
//                        System.out.println("main::Sleeping");
                    Thread.sleep(2000);
                } catch (InterruptedException ex) {
                }
            }
        }
    }
}

