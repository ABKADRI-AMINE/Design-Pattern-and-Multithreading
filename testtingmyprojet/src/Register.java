import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Register extends JFrame implements ActionListener {
        static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
        static final String DB_URL = "jdbc:mysql://localhost/testch";

        static final String USER = "root";
        static final String PASS = "";

        JLabel emailLabel, passwordLabel, nameLabel, phoneLabel;
        JTextField emailField, passwordField, nameField, phoneField;
        JButton registerButton, connectButton;

        public Register() {
            super("Inscription");

            emailLabel = new JLabel("Adresse e-mail :");
            passwordLabel = new JLabel("Mot de passe :");
            nameLabel = new JLabel("Nom complet :");
            phoneLabel = new JLabel("Téléphone :");
            emailField = new JTextField(20);
            passwordField = new JPasswordField(20);
            nameField = new JTextField(20);
            phoneField = new JTextField(20);
            registerButton = new JButton("S'inscrire");
            connectButton = new JButton("Se connecter");

            JPanel panel = new JPanel();
            panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
            panel.add(emailLabel);
            panel.add(emailField);
            panel.add(passwordLabel);
            panel.add(passwordField);
            panel.add(nameLabel);
            panel.add(nameField);
            panel.add(phoneLabel);
            panel.add(phoneField);
            panel.add(registerButton);
            panel.add(connectButton);

            registerButton.addActionListener(this);
            connectButton.addActionListener(this);

            setContentPane(panel);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            pack();
            setVisible(true);
        }

        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == registerButton) {
                String email = emailField.getText();
                String password = passwordField.getText();
                String name = nameField.getText();
                String phone = phoneField.getText();

                Connection conn = null;
                Statement stmt = null;

                try {

                    Class.forName(JDBC_DRIVER);

                    System.out.println("Connexion à la base de données...");
                    conn = DriverManager.getConnection(DB_URL, USER, PASS);

                    System.out.println("Création de la requête...");
                    stmt = conn.createStatement();
                    String sql = "INSERT INTO clients (email, password, name, phone) VALUES ('" + email + "', '" + password + "', '" + name + "', '" + phone + "')";

                    System.out.println("Exécution de la requête...");
                    int rowsAffected = stmt.executeUpdate(sql);
                    System.out.println(rowsAffected + " ligne(s) insérée(s) dans la table clients.");

                    System.out.println("Fermeture des ressources...");
                    stmt.close();
                    conn.close();
                } catch(SQLException se) {

                    se.printStackTrace();
                } catch(Exception ex) {

                    ex.printStackTrace();
                } finally {

                    try {
                        if(stmt != null) stmt.close();
                    } catch(SQLException se) {
                        se.printStackTrace();

                    }
                }
            } else if (e.getSource() == connectButton) {

                dispose();
            Client client = new Client();
            client.setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Register();
    }
}
