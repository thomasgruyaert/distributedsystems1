import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
    private IChatClient serverClient;
    private String hostName = "";
    private int port = 0;

    private String userName = "";
    private ClientChatGui gui;
    private int index = 0;
    public Client(String hostName, int port, ClientChatGui gui){
        this.gui = gui;
        this.hostName = hostName;
        this.port = port;

        start();
    }

    public synchronized void start(){
        try {
            Registry myRegistry = LocateRegistry.getRegistry(hostName, port);
            serverClient = (IChatClient) myRegistry.lookup("ChatService");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void sendMessage(String message) throws RemoteException {
        serverClient.sendMessage(userName,message);
    }

    public void receive() {
        try {
            String message = serverClient.receiveMessage(index);
            index++;
            gui.display(message);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    public void registerUser(String userName){
        this.userName = userName;
        try {
            serverClient.connectUser(this.userName);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }
}
