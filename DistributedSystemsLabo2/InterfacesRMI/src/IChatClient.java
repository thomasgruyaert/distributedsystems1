import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IChatClient extends Remote {
    public void receiveMessage(String message) throws RemoteException;

    //public void updateUserList(List<String> users) throws RemoteException;
}
