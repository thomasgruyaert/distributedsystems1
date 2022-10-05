import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.*;

public class ChatSystemServer {
    private Set<ChatSystemServerThread> userThreads = new HashSet<>();
    private int portNumber = 4200;

    public void Execute(){
        boolean listening = true;
        try (ServerSocket serverSocket = new ServerSocket(portNumber)) {
            while (listening) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");


                ChatSystemServerThread serverThread = new ChatSystemServerThread(socket, this);
                userThreads.add(serverThread);
                serverThread.start();

            }
        } catch (IOException e) {
            System.err.println("Could not listen on port " + portNumber);
            System.exit(-1);
        }
    }

    public void BroadCast(String message, ChatSystemServerThread sender){
        System.out.println("client sent message: "+message);
        for (var userThread: userThreads) {
            if(!userThread.equals(sender))
                userThread.send(message);
        }
    }
}
