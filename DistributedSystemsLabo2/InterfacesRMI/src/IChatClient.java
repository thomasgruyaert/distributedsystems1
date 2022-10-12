import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IChatClient extends Remote {
    public String receiveMessage() throws RemoteException;

    public void sendMessage(String userName, String message) throws RemoteException;

    //public void getUserList() throws RemoteException;

    public void connectUser(String username) throws RemoteException;
}
