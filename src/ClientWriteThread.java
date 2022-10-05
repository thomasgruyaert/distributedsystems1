import java.io.Console;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientWriteThread extends Thread{
    private PrintWriter out;
    private Socket socket;
    private ChatSystemClient client;

    public ClientWriteThread(Socket socket, ChatSystemClient client) {
        this.socket = socket;
        this.client = client;

        try {
            OutputStream output = socket.getOutputStream();
            out = new PrintWriter(output, true);
        } catch (IOException ex) {
            System.out.println("Error getting output stream: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    public void run() {
        Console console = System.console();
        String userName = console.readLine("\nEnter your name: ");
//        client.setUserName(userName);
//        writer.println(userName);
        String text;
        do {
            text = console.readLine("[" + "..." + "]: ");
            out.println(text);
        } while (!text.equals("bye"));

        try {
            socket.close();
        } catch (IOException ex) {

            System.out.println("Error writing to server: " + ex.getMessage());
        }
    }
}
