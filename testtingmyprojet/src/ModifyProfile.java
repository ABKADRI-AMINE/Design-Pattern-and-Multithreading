import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.Socket;
import java.sql.*;
import java.util.Map;
public class ModifyProfile extends JFrame implements ActionListener {
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/testch";
    static final String USER = "root";
    static final String PASS = "";
    private Map<String, Socket> clients;
    private JLabel nameLabel, phoneLabel, emailLabel, passwordLabel;
    private JTextField nameField, phoneField, emailField, passwordField;
    private JButton saveButton, cancelButton,deleteButton;

    private String clientEmail;

    public ModifyProfile(Map<String, Socket> clients, String clientEmail) {
        super("Modifier le profil");
        this.clients = clients;
        this.clientEmail = clientEmail;
        nameLabel = new JLabel("Nom complet :");
        phoneLabel = new JLabel("Téléphone :");
        emailLabel = new JLabel("Adresse e-mail :");
        passwordLabel = new JLabel("Mot de passe :");

        nameField = new JTextField();
        phoneField = new JTextField();
        emailField = new JTextField();
        passwordField = new JPasswordField();

        saveButton = new JButton("Enregistrer");
        cancelButton = new JButton("Exit");
        deleteButton = new JButton("Supprimer");
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(Box.createVerticalStrut(10));
        panel.add(phoneLabel);
        panel.add(phoneField);
        panel.add(Box.createVerticalStrut(10));
        panel.add(emailLabel);
        panel.add(emailField);
        panel.add(Box.createVerticalStrut(10));
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(Box.createVerticalStrut(20));
        panel.add(saveButton);
        panel.add(cancelButton);

        panel.add(deleteButton);
        deleteButton.addActionListener(this);


        saveButton.addActionListener(this);
        cancelButton.addActionListener(this);

        add(panel);

        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == saveButton) {
            String name = nameField.getText();
            String phone = phoneField.getText();
            String email = emailField.getText();
            String password = passwordField.getText();
            Connection conn = null;
            PreparedStatement stmt = null;

            try {
                Class.forName(JDBC_DRIVER);
                System.out.println("Connexion à la base de données...");
                conn = DriverManager.getConnection(DB_URL, USER, PASS);

                System.out.println("Création de la requête...");
                String sqll = "SELECT name, phone, email, password FROM clients WHERE email=?";
                stmt = conn.prepareStatement(sqll);
                stmt.setString(1, clientEmail);
                ResultSet rs = stmt.executeQuery();
                String oldName = null;
                String oldPhone = null;
                String oldPassword = null;
                while (rs.next()) {
                    oldName = rs.getString("name");
                    oldPhone = rs.getString("phone");
                    oldPassword = rs.getString("password");

                }

                System.out.println("Création de la requête de mise à jour...");
                String sql = "UPDATE clients SET name=?, phone=?, email=?, password=? WHERE email=?";
                stmt = conn.prepareStatement(sql);
                if (!name.isEmpty()) {
                    stmt.setString(1, name);
                } else {
                    stmt.setString(1, oldName);
                }
                if (!phone.isEmpty()) {
                    stmt.setString(2, phone);
                } else {
                    stmt.setString(2, oldPhone);
                }
                if (!email.isEmpty()) {
                    stmt.setString(3, email);
                } else {
                    stmt.setString(3, clientEmail);
                }

                if (!password.isEmpty()) {
                    stmt.setString(4, password);
                } else {
                    stmt.setString(4, oldPassword);
                }
                stmt.setString(5, clientEmail);

                System.out.println("Exécution de la requête...");
                int rowsAffected = stmt.executeUpdate();

                System.out.println(rowsAffected + " ligne(s) modifiée(s) dans la table clients.");

            } catch (SQLException se) {
                se.printStackTrace();
            } catch (Exception ex) {
                ex.printStackTrace();
            } finally {
                try {
                    if (stmt != null) stmt.close();
                } catch (SQLException se) {
                    se.printStackTrace();
                }
            }
        } else if (e.getSource() == cancelButton) {
            dispose();
        }
        if (e.getSource() == deleteButton) {
            int dialogResult = JOptionPane.showConfirmDialog(null, "Êtes-vous sûr de vouloir supprimer votre compte?", "Confirmation", JOptionPane.YES_NO_OPTION);
            if (dialogResult == JOptionPane.YES_OPTION) {
                Connection conn = null;
                PreparedStatement stmt = null;

                try {
                    Class.forName(JDBC_DRIVER);
                    System.out.println("Connexion à la base de données...");
                    conn = DriverManager.getConnection(DB_URL, USER, PASS);

                    System.out.println("Création de la requête de suppression...");
                    String sql = "DELETE FROM clients WHERE email=?";
                    stmt = conn.prepareStatement(sql);
                    stmt.setString(1, clientEmail);

                    System.out.println("Exécution de la requête...");
                    int rowsAffected = stmt.executeUpdate();

                    System.out.println(rowsAffected + " ligne(s) supprimée(s) de la table clients.");
                    String email = clientEmail;
                    Socket clientSocket = clients.get(email);
                    try {
                        clientSocket.close();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    clients.remove(email);
                    System.out.println("Client déconnecté : " + email);
                    dispose();
                    Client client = new Client();
                    client.setVisible(true);

                } catch (SQLException se) {
                    se.printStackTrace();
                } catch (Exception ex) {
                    ex.printStackTrace();
                } finally {
                    try {
                        if (stmt != null) stmt.close();
                    } catch (SQLException se) {
                        se.printStackTrace();
                    }
                }
            }
        }

    }
}