import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.Set;

public class ClientChatGui extends JFrame {
    private JPanel mainPanel;
    private JLabel usernameLabel;
    private JTextField usernameField;
    private JTextArea chatArea;
    private JTextField messageField;
    private JButton sendButton;
    private JButton connectButton;
    private JButton disconnectButton;
    private JTextArea onlineUsersArea;
    private Client client;
    private String userName = "";

    void start() throws IOException {
        client = new Client("localhost", 1099, this);
        client.start();
    }

    public ClientChatGui(String title) {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.setSize(640, 480);
        this.sendButton.setEnabled(false);
        this.messageField.setEnabled(false);
        disconnectButton.setEnabled(true);
        try {
            start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMessage(messageField.getText());
            }
        });
        connectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!usernameField.getText().isEmpty()){
                    sendButton.setEnabled(true);
                    messageField.setEnabled(true);
                    usernameField.setEnabled(false);
                    connectButton.setEnabled(false);
                    disconnectButton.setEnabled(true);
                    userName = usernameField.getText();
                    connectUser(usernameField.getText());
                }
            }
        });
        disconnectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                disconnectUser();
                sendButton.setEnabled(false);
                messageField.setEnabled(false);
                usernameField.setEnabled(true);
                connectButton.setEnabled(true);
                disconnectButton.setEnabled(false);
                userName = "";
                usernameField.setText("");
            }
        });
        messageField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMessage(messageField.getText());
            }
        });
    }

    private void connectUser(String username){
        client.registerUser(userName);
        updateOnlineUsers();
        getMessages();
    }

    private void disconnectUser(){
        client.logoutUser();
        onlineUsersArea.setText("");
    }

    private void getMessages(){
        new Thread(() -> {
            client.receive();
        }).start();
    }

    private void updateOnlineUsers(){
        new Thread(() -> {
           setOnlineUsers(client.getUserList());
        }).start();
    }

    private void sendMessage(String text){
        //display("["+userName+"]: "+text);
        messageField.setText("");

        try {
            client.sendMessage(text);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    public void setOnlineUsers(Set<String> onlineUsers){
        onlineUsersArea.setText("");
        for (Object o : onlineUsers){
            onlineUsersArea.append(o + "\n");
        }
    }

    public void display(String message){
        chatArea.append(message + "\n");
    }


    public static void main(String[] args){
        JFrame frame = new ClientChatGui("Chat GUI");
        frame.setVisible(true);
    }
}
