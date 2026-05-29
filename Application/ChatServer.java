package Application;

import java.io.*;
import java.net.*;
import java.util.*;

public class ChatServer {
    private static final int PORT = 12345;

    // Lista e klientëve
    private static Set<ClientHandler> clients = Collections.synchronizedSet(new HashSet<>());

    public static void main(String[] args) {
        System.out.println("Server started...");

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected");

                ClientHandler client = new ClientHandler(socket);
                clients.add(client);

                new Thread(client).start(); // THREAD per klient
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Broadcast tek të gjithë klientët
    public static void broadcast(String message) {
        synchronized (clients) {
            for (ClientHandler client : clients) {
                client.sendMessage(message);
            }
        }
    }

    // Heq klientin kur disconnect
    public static void removeClient(ClientHandler client) {
        clients.remove(client);
    }

    // =========================
    // THREAD për çdo klient
    // =========================
    static class ClientHandler implements Runnable {
        private Socket socket;
        private PrintWriter out;
        private BufferedReader in;

        public ClientHandler(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);

                String message;

                while ((message = in.readLine()) != null) {
                    System.out.println("Received: " + message);

                    // Broadcast tek të gjithë
                    ChatServer.broadcast(message);
                }

            } catch (IOException e) {
                System.out.println("Client disconnected.");
            } finally {
                try {
                    ChatServer.removeClient(this);
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        public void sendMessage(String message) {
            out.println(message);
        }
    }
}