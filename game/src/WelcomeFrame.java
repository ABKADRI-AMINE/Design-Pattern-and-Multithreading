import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WelcomeFrame extends JFrame {

    private JPanel panel;
    private JLabel welcomeLabel;
    private JButton playButton;

    public WelcomeFrame() {
        panel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 1.0;
        c.weighty = 1.0;
        c.anchor = GridBagConstraints.CENTER;
        panel.add(new JLabel(), c); // add empty component to center the image

        // Créez un label pour contenir l'image
        JLabel imageLabel = new JLabel();

        // Chargez l'image depuis le fichier
        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/img/ping-pong3.jpg"));

        // Redimensionnez l'image à une taille de 400x400
        Image image = imageIcon.getImage().getScaledInstance(400, 400, Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(image);

        // Affichez l'image dans le label
        imageLabel.setIcon(imageIcon);

        // Ajoutez l'image au panel
        c.gridy = 1;
        panel.add(imageLabel, c);

        welcomeLabel = new JLabel("Amine Ping-Pong Game!", SwingConstants.CENTER);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 32));
        c.gridy = 2;
        panel.add(welcomeLabel, c);

        JPanel playPanel = new JPanel();
        playPanel.setBackground(Color.white);
        playButton = new JButton("Play");
        playButton.setFont(new Font("Arial", Font.PLAIN, 20));
        playButton.setBackground(Color.black);
        playButton.setForeground(Color.white);
        playButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                playButton.setBackground(Color.white);
                playButton.setForeground(Color.black);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                playButton.setBackground(Color.black);
                playButton.setForeground(Color.white);
            }
        });
        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startGame();
            }
        });
        playPanel.add(playButton);

        c.gridy = 3;
        panel.add(playPanel, c);

        panel.setBackground(Color.white);

        // Redimensionnez la fenêtre à une taille de 800x600
        this.setPreferredSize(new Dimension(800, 600));
        this.add(panel);
        this.setTitle("Amine Ping-Pong Game");
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);

        // Ajoutez du style au frame
        Border border = BorderFactory.createLineBorder(new Color(49, 108, 180), 20, true);
        this.getRootPane().setBorder(border);
        this.getContentPane().setBackground(new Color(227, 231, 239));
        this.setUndecorated(true);
        this.getRootPane().setWindowDecorationStyle(JRootPane.PLAIN_DIALOG);
    }

    private void startGame() {
        GameFrame gameFrame = new GameFrame();
        gameFrame.setVisible(true);
        this.dispose();
    }
}
