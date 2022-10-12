import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Set;

public class ChatServer extends UnicastRemoteObject implements IChatClient{

    private Set<String> connectedUsers;
    public ChatServer() throws RemoteException {
    }

    @Override
    public String receiveMessage() throws RemoteException {
        return null;
    }

    @Override
    public void sendMessage(String sender, String message) throws RemoteException {
        for (var user: connectedUsers) {
            if(!user.equals(sender))
                broadcastMessage(sender, message);
        }
    }

    @Override
    public void connectUser(String username) throws RemoteException {

    }

    private void broadcastMessage(String sender, String message){

    }
}
