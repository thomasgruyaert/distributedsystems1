import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ChatServer extends UnicastRemoteObject implements IChatClient{

    private Set<String> connectedUsers;
    private List<String> messages;
    public ChatServer() throws RemoteException {
        connectedUsers = new HashSet<>();
        messages = new ArrayList<>();
    }

    @Override
    public synchronized String receiveMessage(int index) throws RemoteException {
        while(index > messages.size() -1){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        return messages.get(index);
    }

    @Override
    public synchronized void sendMessage(String sender, String message) throws RemoteException {
        for (var user: connectedUsers) {
            if(!user.equals(sender)) {
                messages.add(message);
                System.out.println("Received message: "+message);
                notifyAll();
            }
        }
    }

    @Override
    public void connectUser(String userName) throws RemoteException {
        connectedUsers.add(userName);
        System.out.println("User connected: "+ userName);
    }
}
