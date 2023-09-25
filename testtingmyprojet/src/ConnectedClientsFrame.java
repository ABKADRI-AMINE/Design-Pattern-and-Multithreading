import javax.swing.*;
import java.awt.*;
import java.net.Socket;
import java.util.Map;

public class ConnectedClientsFrame extends JFrame {

    private JTextArea textArea;

    public ConnectedClientsFrame(Map<String, Socket> clients) {
        super("Clients connectés");

        textArea = new JTextArea(20, 40);
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);

        for (String email : clients.keySet()) {
            textArea.append(email + "\n");
        }

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(scrollPane, BorderLayout.CENTER);
        setContentPane(panel);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
