import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ChatSystemServerThread extends Thread {

    private Socket socket = null;
    private PrintWriter writer;
    private ChatSystemServer server;

    private ClientChatGui clientGui;

    public ChatSystemServerThread(Socket socket, ChatSystemServer server) {
        super("ChatSystemServerThread");
        this.socket = socket;
        this.server = server;
        this.clientGui = new ClientChatGui("Chat");
    }

    public void run() {

        try (
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(
                                socket.getInputStream()));
        ) {
            String inputLine, outputLine;
            writer = out;
            out.println("Welcome to the chat group");
            out.println("Enter username: ");
            clientGui.display("Welcome to the chat group");
            clientGui.display("Please enter your username above");
            String userName = in.readLine();
            server.addUserName(userName);
            String serverMessage = "New user connected: " + userName;
            server.broadCast(serverMessage, this);

            while ((inputLine = in.readLine()) != null) {
                server.broadCast(inputLine, this);
            }
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void updateUsers() {
        if (server.hasUsers()) {
            clientGui.setOnlineUsers(server.getUserNames());
            writer.println("Connected users: " + server.getUserNames());
        } else {
            clientGui.display("No other users connected");
            writer.println("No other users connected");
        }
    }

    public void send(String message){
        writer.println(message);
        clientGui.display(message);
    }
}
