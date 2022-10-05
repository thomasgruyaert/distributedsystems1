import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class ChatSystemClient {

    private PrintWriter out;
    public void start() throws IOException {
        String hostName = "localhost";
        int portNumber = 4200;

        try{
            Socket socket = new Socket(hostName, portNumber);
            OutputStream output = socket.getOutputStream();
            out = new PrintWriter(output, true);

            ClientWriteThread writeThread = new ClientWriteThread(this);
            ClientReadThread readThread = new ClientReadThread(socket, this);

            writeThread.start();
            readThread.start();


        } catch (UnknownHostException e) {
            System.err.println("Don't know about host " + hostName);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to " +
                    hostName);
            System.exit(1);
        }
    }

    public void send(String message){
        out.println(message);
    }
}
