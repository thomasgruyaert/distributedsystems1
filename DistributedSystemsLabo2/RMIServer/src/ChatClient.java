public class ChatClient {
    private String userName;
    private IChatClient chatClient;

    public ChatClient(String name, IChatClient chatClient){
        this.userName = userName;
        this.chatClient = chatClient;
    }

    public String getUserName(){
        return userName;
    }

    public IChatClient getChatClient(){
        return chatClient;
    }
}
