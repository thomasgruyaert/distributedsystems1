import java.io.PrintWriter;
import java.net.Socket;

public class ClientWriteThread extends Thread{
    private PrintWriter out;
    private ChatSystemClient client;
    private Socket socket;


    @Override
    public void run() {
        super.run();
    }
}
