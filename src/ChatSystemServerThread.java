import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ChatSystemServerThread extends Thread {

    private Socket socket = null;

    public ChatSystemServerThread(Socket socket) {
        super("ChatSystemServerThread");
        this.socket = socket;
    }

    public void run() {

        try (
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(
                                socket.getInputStream()));
        ) {
            String inputLine, outputLine;

            while ((inputLine = in.readLine()) != null) {

            }
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
