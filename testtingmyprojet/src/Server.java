import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class Server {

    private final int PORT = 12345;
    private Map<String, Socket> clients = new HashMap<String, Socket>();

    public void start() {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Serveur lancé sur le port " + PORT);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                new Thread(new ClientHandler(clientSocket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Server().start();
    }

    private class ClientHandler implements Runnable {

        private Socket clientSocket;

        private BufferedReader in;
        private PrintWriter out;

        public ClientHandler(Socket clientSocket) {
            this.clientSocket = clientSocket;
        }

        @Override
        public void run() {
            try {
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                out = new PrintWriter(clientSocket.getOutputStream(), true);

                String email = in.readLine();
                String password = in.readLine();

                if (isValidClient(email, password)) {
                    System.out.println("Client connecté : " + email);
                    clients.put(email, clientSocket);
                    out.println("OK");
                    Sidebar side =  new Sidebar(clients,email);
                    side.setVisible(true);


                } else {
                    System.out.println("Tentative de connexion invalide avec l'email : " + email);
                    out.println("ERREUR");
                    clientSocket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public boolean isValidClient(String email, String password) {
            Connection conn = null;
            PreparedStatement stmt = null;
            ResultSet rs = null;
            try {
                Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testch", "root", "");
                String sql = "SELECT COUNT(*) FROM clients WHERE email = ? AND password = ?";
                stmt = conn.prepareStatement(sql);
                stmt.setString(1, email);
                stmt.setString(2, password);
                rs = stmt.executeQuery();
                rs.next();
                int count = rs.getInt(1);
                return count == 1;
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
                return false;
            } finally {
                try {
                    if (rs != null) rs.close();
                    if (stmt != null) stmt.close();
                    if (conn != null) conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
