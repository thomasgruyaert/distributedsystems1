import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface IChatServer extends Remote {
    public void broadcastMessage(String senderUserName, String message) throws RemoteException;

    public void registerListener(String userName, String hostName, String serviceName) throws RemoteException;

    //public void disconnectClient(String username) throws RemoteException;

    //public void sendPrivateMessage(int[] privateGroup, String privateMessage) throws RemoteException;
}
