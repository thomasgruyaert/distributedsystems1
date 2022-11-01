package be.mesc.labgrpc;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import be.msec.labgrpc.ChatServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import static be.msec.labgrpc.ChatClientGrpc.*;
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

    public void Connect(){}
    public void Disconnect(){}
    public void GetUsers(){}
    public void GetHistory(){}
    public void SendMessage(){}

    public static void main(String[] args) throws InterruptedException {
        ChatClient client = new ChatClient("localhost", 50050);
        try{

        } finally {
            client.shutdown();
        }


    }
}

