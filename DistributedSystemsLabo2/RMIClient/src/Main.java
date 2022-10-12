import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Main {
    public static void main(String[] args){
        start();
    }

    private static void start(){
        try {
            Registry myRegistry = LocateRegistry.getRegistry("localhost", 1099);
            IChatServer server = (IChatServer) myRegistry.lookup("localhost");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
