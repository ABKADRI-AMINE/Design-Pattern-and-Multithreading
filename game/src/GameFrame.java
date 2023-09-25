import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {

    GamePanel panel;

    GameFrame() {
        panel = new GamePanel();
        this.add(panel);
        this.setTitle("AMINE ABKADRI GAME PING-PONG");
        this.setResizable(false);
        this.setBackground(Color.white);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }
}
