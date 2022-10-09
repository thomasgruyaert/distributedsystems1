import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class ChatSystemClient {

    private PrintWriter out;
    private String hostName = "";
    private int portNumber = 0;
    private ClientChatGui gui;

    public ChatSystemClient(String hostname, int portNumber){
        this.hostName = hostname;
        this.portNumber = portNumber;
    }

    public ChatSystemClient(String hostname, int portNumber, ClientChatGui gui){
        this.hostName = hostname;
        this.portNumber = portNumber;
        this.gui = gui;
    }
    public void start() throws IOException {
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

    public void messageReceived(String messsage){
        if(gui != null)
            gui.display(messsage);
        else
            System.out.println(messsage);
    }

    public void send(String message){
        out.println(message);
    }

}
