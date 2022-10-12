import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IChatClient extends Remote {
    public String receiveMessage(int index) throws RemoteException;

    public void sendMessage(String sender, String message) throws RemoteException;

    //public void getUserList() throws RemoteException;

    public void connectUser(String username) throws RemoteException;
}
