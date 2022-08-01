package generator;

public class Main {

    public static void main(String[] args) {
        MainMenu menu = new MainMenu();
        menu.getGenThreads().thread1.start();
        menu.getGenThreads().thread2.start();
        menu.menu();
    }
}
