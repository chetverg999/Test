package Snake;
import javax.swing.*;

public class Window extends JFrame {

    public Window() { //непостредственно задание параметров окна
        setTitle("SnakeGame"); //задание заголовка окна
        setDefaultCloseOperation(EXIT_ON_CLOSE); //закрытие окна на крестик
        setSize(785, 810); //размер окна
        setResizable(false); //изменение размеров окна
        add(new Game()); //добавляем игровое поле в окно
        setLocation(400, 20); // место открытия на экране
        setVisible(true); //само отображение окна
    }

    public static void main(String[] args) {
        Window window = new Window(); //создание экземпляра окна для его открытия
    }
}