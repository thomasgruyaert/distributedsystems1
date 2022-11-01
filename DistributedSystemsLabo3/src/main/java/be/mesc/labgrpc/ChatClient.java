package be.mesc.labgrpc;

import java.util.Iterator;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import be.msec.labgrpc.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;

import static be.msec.labgrpc.ChatServiceGrpc.*;
import static be.msec.labgrpc.ChatServiceGrpc.*;

public class ChatClient {
    private static final Logger logger = Logger.getLogger(ChatClient.class.getName());

    private final ManagedChannel channel;
    private final ChatServiceBlockingStub blockingStub;
    private final ChatServiceStub asyncStub;

    public ChatClient(String host, int port){
        this(ManagedChannelBuilder.forAddress(host, port).usePlaintext(true));
    }

    public ChatClient(ManagedChannelBuilder<?> channelBuilder) {
        channel = channelBuilder.build();
        blockingStub = newBlockingStub(channel);
        asyncStub = newStub(channel);

    }

    public void shutdown() throws InterruptedException {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }

    public void Connect(String username){
        User user = User.newBuilder().setUsername(username).build();
        blockingStub.connectUser(user);
    }
    public void Disconnect(String username){
        User user = User.newBuilder().setUsername(username).build();
        blockingStub.connectUser(user);
    }
    public String getUsers(){
        Iterator<User> users;
        try{
            users = blockingStub.getUserList(Empty.newBuilder().build());
        } catch (StatusRuntimeException e) {
            logger.log(Level.WARNING, "RPC failed: {0}", e.getStatus());
            return "";
        }

        StringBuilder responseLog = new StringBuilder("");
        while(users.hasNext()){
            User user = users.next();
            responseLog.append(user.getUsername()+"\n");
        }
        return responseLog.toString();
    }
    public String GetHistory() throws InterruptedException {
        Iterator<Message> messages;
        try{
            messages = blockingStub.receiveMessage(Empty.newBuilder().build());
        } catch (StatusRuntimeException e) {
            logger.log(Level.WARNING, "RPC failed: {0}", e.getStatus());
            return "";
        }

        StringBuilder responseLog = new StringBuilder("");
        while(messages.hasNext()){
            Message message = messages.next();
            responseLog.append(message.getSender()+": "+message.getContent()+"\n");
        }
        return responseLog.toString();
    }


    public void SendMessage(String message, String username){
        Message request = Message.newBuilder().setSender(username).setContent(message).build();
        Response reply;
        try{
            reply = blockingStub.sendMessage(request);
        } catch (StatusRuntimeException e) {
            logger.log(Level.WARNING, "RPC failed: {0}", e.getStatus());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ChatClient client = new ChatClient("localhost", 50050);
        try{
            Scanner sc = new Scanner(System.in);
            System.out.println("username: ");
            String username = sc.nextLine();
            client.Connect(username);
            String userList = client.getUsers();
            System.out.println(userList);
            new Thread(new Runnable() {
                @Override
                public void run() {
                    do {
                        String history = "";
                        try {
                            String h = client.GetHistory();
                            if(!history.equals(h)){
                                history = h;
                                System.out.print(history);
                            }
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }while (true);
                }
            }).start();

            new Thread(new Runnable() {
                @Override
                public void run() {
                    do {
                        String s = sc.nextLine();
                        client.SendMessage(s, username);
                    }while (true);
                }
            });


            client.Disconnect(username);
        } finally {
            client.shutdown();
        }


    }
}

