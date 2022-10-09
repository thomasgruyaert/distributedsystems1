import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
public class ChatServerImpl extends UnicastRemoteObject implements IChatServer{
    public ChatServerImpl() throws RemoteException {
    }
}
