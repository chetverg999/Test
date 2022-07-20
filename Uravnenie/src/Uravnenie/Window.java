package Uravnenie;

import javax.swing.*;

public class Window extends JFrame {

    public Window() {
        add(new Uravnenie.Panel());
        setVisible(true); // видимость окна
        setResizable(false);
        setBounds(550, 200, 300, 215); // границы
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // закрытие на крестик
        setTitle("Калькулятор");
    }
}
