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
    static final int unit_size = 15;
    static final int game_units = (screen_height * screen_width) / (unit_size * unit_size);
    static final int delay = 75;
    final int x[] = new int[game_units]; // holds all x co-ordinates of the snake body including its head
    final int y[] = new int[game_units];// holds all y co-ordinates of the snake body
    int bodyparts = 5;
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
        timer = new Timer(delay, this);
        timer.start();

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g) {
        // create a grid for easier visualization
        for (int i = 0; i < screen_height / unit_size; i++) {
            // vertical grid lines
            g.drawLine(i * unit_size, 0, i * unit_size, screen_height);

            // horizontal grid lines
            g.drawLine(0, i * unit_size, screen_width, i * unit_size);
        }

        // draw the food
        g.setColor(Color.CYAN);
        g.fillOval(foodX, foodY, unit_size, unit_size);

        // draw head and body
        for (int i = 0; i < bodyparts; i++) {
            if (i == 0) {
                g.setColor(Color.white);
                g.fillRect(x[i], y[i], unit_size, unit_size);
            } else {
                g.setColor(Color.yellow);
                g.fillRect(x[i], y[i], unit_size, unit_size);
            }
        }
    }

    public void newFood() {
        // foodX = random.nextInt((int)(screen_width/unit_size))*unit_size;
        // foodY = random.nextInt((int)(screen_height/unit_size))*unit_size;
        foodX = random.nextInt(screen_width-10);
        foodY = random.nextInt(screen_height-10);
    }

    public void move() {
        for (int i = bodyparts; i > 0; i--) {
            x[i] = x[i - 1];
            y[i] = y[i - 1];
        }

        switch (direction) {
            case 'U':
                y[0] = y[0] - unit_size;
                break;

            case 'D':
                y[0] = y[0] + unit_size;
                break;

            case 'L':
                x[0] = x[0] - unit_size;
                break;

            case 'R':
                x[0] = x[0] + unit_size;
                break;
        }
    }

    public void checkFood() {

    }

    public void checkCollisions() {

        // checks if head collides with body
        for (int i = bodyparts; i > 0; i--) {

            if ((x[0] == x[i]) && (y[0] == y[i])) {

                running = false;

            }

        }

        // check if head touches left border

        if (x[0] < 0) {

            running = false;

        }

        // check if head touches right border

        if (x[0] > screen_width) {

            running = false;

        }

        // check if head touches top border

        if (y[0] < 0) {

            running = false;

        }

        // check if head touches bottom border

        if (y[0] > screen_height) {

            running = false;

        }

        if (!running) {

            timer.stop();

        }
    }

    public void gameOver(Graphics g) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (running) {
            move(); // move the snake
            checkFood(); // Is the food around?
            checkCollisions(); // did snake head collide with food?
        }
        repaint();

    }

    // inner class
    public class MyKeyAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            switch(e.getKeyCode()){
                case KeyEvent.VK_LEFT:
                if(direction != 'R'){
                    direction = 'L';
                }
                break;

                case KeyEvent.VK_RIGHT:
                if(direction != 'L'){
                    direction = 'R';
                }
                break;

                case KeyEvent.VK_UP:
                if(direction != 'D'){
                    direction = 'U';
                }
                break;

                case KeyEvent.VK_DOWN:
                if(direction != 'U'){
                    direction = 'D';
                }
                break;
            }
        }
    }

}
