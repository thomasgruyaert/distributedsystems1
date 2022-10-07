import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ChatSystemServerThread extends Thread {

    private Socket socket = null;
    private PrintWriter writer;
    private ChatSystemServer server;
    private String username;

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

            out.println("Enter username: ");
            username = in.readLine();
            server.addUsername(username);
            out.println("Welcome to the chat group "+username);
            if (server.usernames.size() > 0)
                out.println("The current online users are "+server.usernames.toString());

            while ((inputLine = in.readLine()) != null) {
                server.BroadCast("["+username+"]: "+inputLine, this);
            }
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void send(String message){
        writer.println(message);
    }
}
