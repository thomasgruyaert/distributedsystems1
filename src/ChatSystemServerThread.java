import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ChatSystemServerThread extends Thread {

    private Socket socket = null;
    private PrintWriter writer;
    private ChatSystemServer server;
    private String userName = "";

    public ChatSystemServerThread(Socket socket, ChatSystemServer server) {
        super("ChatSystemServerThread");
        this.socket = socket;
        this.server = server;
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
            userName = in.readLine();
            server.addUserName(userName);
            String serverMessage = "New user connected: " + userName;
            server.broadCast(serverMessage, this);

            while ((inputLine = in.readLine()) != null) {
                server.broadCast("["+userName+"]: "+inputLine, this);
            }
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void updateUsers() {
        if (server.hasUsers()) {
            writer.println("Connected users: " + server.getUserNames());
        } else {
            writer.println("No other users connected");
        }
    }

    public void send(String message){
        writer.println(message);
    }
}
