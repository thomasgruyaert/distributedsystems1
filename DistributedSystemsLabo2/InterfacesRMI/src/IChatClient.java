import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Set;

public interface IChatClient extends Remote {
    public String receiveMessage(int index) throws RemoteException;

    public void sendMessage(String sender, String message) throws RemoteException;

    //public void getUserList() throws RemoteException;

    public void connectUser(String username) throws RemoteException;

    public void disconnectUser(String username) throws RemoteException;

    public Set<String> updateUserList(Set<String> currentUserList) throws RemoteException;
}
