package Snake;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Random;

public class Game extends JPanel implements ActionListener {

    private final int size = 700;
    private final int dotSize = 70;
    private final int allDots = 100;
    private BufferedImage dot;
    private BufferedImage apple;
    private BufferedImage background;
    private BufferedImage apex;
    private BufferedImage stone;
    private int appleX;
    private int appleY;
    private int stoneX;
    private int stoneY;
    private int[] x = new int[allDots];
    private int[] y = new int[allDots];
    private int dots;
    private Timer timer;
    private boolean left = false;
    private boolean right = true;
    private boolean up = false;
    private boolean down = false;
    private boolean inGame = true;
    private JButton b1, b2, b3;
    private boolean create = false;


    public Game() {
        loadImages();


        b1 = new JButton("Заново (ALT)");
        b1.setMnemonic(KeyEvent.VK_ALT);
        b1.addActionListener(new ButtonIvent1());
        add(b1);
        b1.setVisible(false);

        b2 = new JButton("<html><h3><font color=\"black\">ПАУЗА (ALT)");
        b2.setContentAreaFilled(false);
        b2.setMnemonic(KeyEvent.VK_ALT);
        b2.addActionListener(new ButtonIvent2());
        add(b2);
        b2.setVisible(true);

        b3 = new JButton("<html><h5><font color=\"black\">ПРОДОЛЖИТЬ (ALT)");
        b3.setContentAreaFilled(false);
        b3.setMnemonic(KeyEvent.VK_ALT);
        b3.addActionListener(new ButtonIvent3());
        add(b3);
        b3.setVisible(false);


        audioStart();
        startGame();
        addKeyListener(new FieldKeyListener());
        setFocusable(true);

    }

    public void startGame() {

        inGame = true;
        initGame();

    }

    class ButtonIvent1 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            startGame();
            b2.setVisible(true);
        }
    }

    class ButtonIvent2 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            timer.stop();
            b2.setVisible(false);
            b3.setVisible(true);
        }
    }

    class ButtonIvent3 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            timer.start();
            b3.setVisible(false);
            b2.setVisible(true);
        }
    }

    public void audioStart() {
        try {
//            File file = new File(Window.class.getResource("sound.wav").toURI());
//            InputStream inputStream = getClass().getResourceAsStream("sound.wav");
            URL url = getClass().getResource("sound.wav");
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(url));
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            clip.start();
        } catch (Exception e) {
            System.err.println("Put the music.wav file in the sound folder if you want to play background music, only optional!");
        }
    }

    public void loadImages() {
//        ImageIcon iia = new ImageIcon("src/res/apple.png");
//        apple = iia.getImage();
//        ImageIcon iid = new ImageIcon("src/res/dot.png");
//        dot = iid.getImage();
//        ImageIcon iib = new ImageIcon("src/res/backGround.png");
//        background = iib.getImage();
//        ImageIcon iip = new ImageIcon("src/res/Apex.png");
//        apex = iip.getImage();
//        ImageIcon iis = new ImageIcon("src/res/dot.png");
//        stone = iis.getImage();

        try {
            apple = ImageIO.read(getClass().getResource("apple.png"));
            dot = ImageIO.read(getClass().getResource("dot.png"));
            background = ImageIO.read(getClass().getResource("backGround.png"));
            apex = ImageIO.read(getClass().getResource("Apex.png"));
            stone = ImageIO.read(getClass().getResource("dot.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void initGame() {
        dots = 3;
        for (int i = 0; i < dots; i++) {
            x[i] = 280 - i * dotSize;
            y[i] = 280;
        }
        timer = new Timer(400, this);
        timer.start();
        createApple();
    }

    public void createApple() {
        appleX = new Random().nextInt(10) * dotSize;
        appleY = new Random().nextInt(10) * dotSize;
    }

    public void checkApple() {
        if (x[0] == appleX && y[0] == appleY) {
            dots++;
            createApple();
            createStone();
        }
    }

    public void checkStone() {
        if (x[0] == stoneX && y[0] == stoneY) {
            inGame = false;
            timer.stop();
        }
    }

    public void move() {  //прописываем движение
        for (int i = dots; i > 0; i--) {
            x[i] = x[i - 1];
            y[i] = y[i - 1];
        }
        if (left) {
            x[0] -= dotSize;
        }
        if (right) {
            x[0] += dotSize;
        }
        if (up) {
            y[0] -= dotSize;
        }
        if (down) {
            y[0] += dotSize;
        }
    }

    public void checkCollisions() {  // првоерка коллизии если змея длиннее 4
        for (int i = dots; i > 0; i--) {
            if (i > 4 && x[0] == x[i] && y[0] == y[i]) {
                inGame = false;
            }
        }

        if (x[0] > size) {
            inGame = false;
            timer.stop();
        }
        if (x[0] < 0) {
            inGame = false;
            timer.stop();
        }
        if (y[0] > size) {
            inGame = false;
            timer.stop();
        }
        if (y[0] < 0) {
            inGame = false;
            timer.stop();
        }
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Font f = new Font("Arial", Font.BOLD, 30);
        g.setFont(f);
        g.setColor(Color.black);
        g.drawImage(background, 0, 0, this);
        if (inGame) {
            b2.setSize(150, 30);
            b2.setLocation(50, 48);
            b3.setSize(150, 30);
            b3.setLocation(50, 48);
            b1.setVisible(false);
            g.drawImage(apple, appleX, appleY, this);
            g.drawImage(stone, stoneX, stoneY, this);
            for (int i = 0; i < dots; i++) {
                g.drawImage(dot, x[i], y[i], this);
                g.drawString("СЧЕТ: " + String.valueOf(dots - 3), 600, 70);
            }
        } else {
            timer.stop();
            g.drawImage(apex, 100, 100, this);
            g.drawString("Вы проиграли! " + "СЧЕТ: " + String.valueOf(dots - 3), 210, 300);
            b1.setSize(150, 50);
            b1.setLocation(300, 400);
            b1.setVisible(true);
            b2.setVisible(false);

        }
    }


    public void createStone() {
        stoneX = new Random().nextInt(10) * dotSize;
        stoneY = new Random().nextInt(10) * dotSize;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (inGame) {
            checkApple();
            checkStone();
            checkCollisions();
            move();
        }
        repaint();
    }


    class FieldKeyListener extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            super.keyPressed(e);
            int key = e.getKeyCode();
            if (key == KeyEvent.VK_LEFT && !right) {
                left = true;
                up = false;
                down = false;
            }
            if (key == KeyEvent.VK_RIGHT && !left) {
                right = true;
                up = false;
                down = false;
            }

            if (key == KeyEvent.VK_UP && !down) {
                right = false;
                up = true;
                left = false;
            }
            if (key == KeyEvent.VK_DOWN && !up) {
                right = false;
                down = true;
                left = false;
            }
        }
    }


}