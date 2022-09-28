import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.*;
import javax.swing.*;
import javax.swing.Timer;

public class gamePanel extends JPanel implements ActionListener {

    static final int screen_width = 600;
    static final int screen_height = 600;
    static final int unit_size = 25;
    static final int game_units = (screen_height * screen_width) / unit_size;
    static final int delay = 75;
    final int x[] = new int[game_units]; // holds all x co-ordinates of the snake body including its head
    final int y[] = new int[game_units];// holds all y co-ordinates of the snake body
    int bodyparts = 6;
    int foodEaten;
    int foodX, foodY;
    char direction = 'R'; // which direction the snake starts from
    boolean running = false;
    Timer timer;
    Random random;

    // create default constructor
    gamePanel() {
        random = new Random();
        this.setPreferredSize(new Dimension(screen_width, screen_height));
        this.setBackground(Color.BLACK);
        this.setFocusable(true);
        this.addKeyListener(new MyKeyAdapter());
        startGame();
    }

    public void startGame() {
        newFood();
        running = true;
        timer = new Timer(delay,this);
        timer.start();

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g) {
        // create a grid for easier visualization
        for(int i = 0; i<screen_height/unit_size; i++){
            // vertical grid lines
            g.drawLine(i*unit_size, 0, i*unit_size, screen_height); 

            // horizontal grid lines
            g.drawLine(0, i*unit_size, screen_width, i*unit_size);
        }
    }

    public void newFood() {

    }

    public void move() {

    }

    public void checkFood() {

    }

    public void checkCollisions() {

    }

    public void gameOver(Graphics g) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

    }

    // inner class
    public class MyKeyAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {

        }
    }

}
