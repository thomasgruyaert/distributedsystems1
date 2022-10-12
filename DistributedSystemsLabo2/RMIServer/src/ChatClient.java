public class ChatClient {
    private String userName;
    private ChatClientIF chatClient;

    public ChatClient(String name, ChatClientIF chatClient){
        this.userName = userName;
        this.chatClient = chatClient;
    }

    public String getUserName(){
        return userName;
    }

    public ChatClientIF getChatClient(){
        return chatClient;
    }
}
