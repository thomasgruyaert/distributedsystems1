import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
    private IChatServer server;
    private String hostName = "";
    private int port = 0;

    private String userName = "";
    private ClientChatGui gui;
    public Client(String hostName, int port, ClientChatGui gui){
        this.gui = gui;
        this.hostName = hostName;
        this.port = port;

        start();
    }

    public void start(){
        try {
            Registry myRegistry = LocateRegistry.getRegistry(hostName, port);
            server = (IChatServer) myRegistry.lookup(hostName);

            server.registerListener("Gebruiker","localhost","ChatService");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void sendMessage(String message) throws RemoteException {
        server.broadcastMessage(userName,message);
    }

    public void registerUser(String userName){
        this.userName = userName;
    }
}
