import java.io.IOException;

public class Client {
    public static void main(String[] args) throws IOException {
        new ChatSystemClient("localhost",4200).start();
    }
}
