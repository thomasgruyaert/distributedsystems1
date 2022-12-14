import java.io.Console;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientWriteThread extends Thread{
    private Socket socket;
    private ChatSystemClient client;

    private ClientChatGui clientGui;

    private Boolean isConnected = true;

    public void disconnect(){
        this.isConnected = false;
    }

    public ClientWriteThread(ChatSystemClient client) {
        this.client = client;
    }

    public ClientWriteThread(ClientChatGui clientGui) {
        this.clientGui = clientGui;
    }

    public void run() {
        do {
            Scanner scanner = new Scanner(System.in);
            client.send(scanner.nextLine());
        } while (isConnected);
    }
}
