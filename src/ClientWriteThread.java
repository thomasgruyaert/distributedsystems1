import java.io.PrintWriter;
import java.net.Socket;

public class ClientWriteThread extends Thread{
    private PrintWriter out;
    private ChatSystemClient client;
    private Socket socket;

    public ClientWriteThread(Socket socket, ChatSystemClient client) {
        super("ChatSystemServerThread");
        this.socket = socket;
        this.client = client;
    }
    @Override
    public void run() {

    }
}
