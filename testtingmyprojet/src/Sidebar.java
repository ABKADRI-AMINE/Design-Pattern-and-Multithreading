import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class Sidebar extends JFrame{

    private Map<String, Socket> clients;
    private JButton viewConnectedClientsButton;
    private JButton disconnectButton;
    private JButton modifyProfileButton;

    public Sidebar(Map<String, Socket> clients, String clientEmail) {
        this.clients = clients;
        setTitle("Sidebar Frame");

        JPanel sidebarPanel = new JPanel();
        sidebarPanel.setLayout(new GridLayout(0, 1, 0, 10));
        sidebarPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel emailLabel = new JLabel("Bonjour: " + clientEmail);
        sidebarPanel.add(emailLabel);

        viewConnectedClientsButton = new JButton("Voir les clients connectés");
        disconnectButton = new JButton("Déconnexion");
        modifyProfileButton = new JButton("Modifier le profil");
        sidebarPanel.add(modifyProfileButton);
        sidebarPanel.add(viewConnectedClientsButton);
        sidebarPanel.add(disconnectButton);

        viewConnectedClientsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new ConnectedClientsFrame(clients);
            }
        });

        disconnectButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
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
            }

        });

        modifyProfileButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        ModifyProfile modifyProfile = new ModifyProfile(clients,clientEmail);
                        modifyProfile.setVisible(true);
                    }
                });
            }
        });

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel mainLabel = new JLabel("Contenu principal");
        mainLabel.setHorizontalAlignment(JLabel.CENTER);
        mainPanel.add(mainLabel, BorderLayout.CENTER);

        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BorderLayout());
        contentPanel.add(sidebarPanel, BorderLayout.WEST);
        contentPanel.add(mainPanel, BorderLayout.CENTER);

        getContentPane().add(contentPanel);

        setSize(400, 300);
        setVisible(true);
    }
}