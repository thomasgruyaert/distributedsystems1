import java.io.*;
import java.net.Socket;

public class ClientReadThread  extends Thread{
    private BufferedReader in;
    private Socket socket;
    private ChatSystemClient client;

    public ClientReadThread(Socket socket, ChatSystemClient client) {
        this.socket = socket;
        this.client = client;

        try {
            InputStream input = socket.getInputStream();
            in = new BufferedReader(new InputStreamReader(input));
        } catch (IOException ex) {
            System.out.println("Error getting input stream: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    public void run() {
        while (true) {
            try {
                String response = in.readLine();
                System.out.println("\n" + response);

            } catch (IOException ex) {
                System.out.println("Error reading from server: " + ex.getMessage());
                ex.printStackTrace();
                break;
            }
        }
    }
}
