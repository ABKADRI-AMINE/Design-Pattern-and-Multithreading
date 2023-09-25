import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client extends JFrame implements ActionListener {
    private static final String SERVER_IP = "127.0.0.1";
    private static final int SERVER_PORT = 12345;

    private JTextField emailField;
    private JPasswordField passwordField;
    private JButton loginButton;

    public Client() {
        super("Client");

        setTitle("Authentification client");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel emailLabel = new JLabel("Email :");
        JLabel passwordLabel = new JLabel("Password :");
        emailField = new JTextField();
        passwordField = new JPasswordField();
        loginButton = new JButton("Se connecter");
        loginButton.addActionListener(this);

        JPanel panel = new JPanel(new GridLayout(3, 2));
        panel.add(emailLabel);
        panel.add(emailField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(new JLabel());
        panel.add(loginButton);
        getContentPane().add(panel, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Client client = new Client();
            client.setVisible(true);
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {

            String email = emailField.getText();
            String password = new String(passwordField.getPassword());

            try (Socket socket = new Socket(SERVER_IP, SERVER_PORT);
                 BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                 PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {

                out.println(email);
                out.println(password);

                String response = in.readLine();
                if ("OK".equals(response)) {
                    JOptionPane.showMessageDialog(this, "Authentification réussie pour l'email : " + email);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "Authentification échouée pour l'email : " + email);
                }

            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
