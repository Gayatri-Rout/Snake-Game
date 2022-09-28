import javax.swing.JFrame;

public class gameFrame extends JFrame{
    
    // create default constructor
    gameFrame(){

        //gamePanel panel = new gamePanel();
        //this.add(panel);
        // or use a shorter line
        this.add(new gamePanel());
        this.setTitle("Snake");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }
}
