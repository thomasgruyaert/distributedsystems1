package be.mesc.labgrpc;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.io.IOException;

import be.msec.labgrpc.ChatServiceGrpc;
import be.msec.labgrpc.Message;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class ChatServer {
    private static final Logger logger = Logger.getLogger(ChatServer.class.getName());

    private final int port;
    private final Server server;

    static ArrayList<Message> history;

    public ChatServer(int port) throws IOException {
        this(ServerBuilder.forPort(port), port);
    }

    public ChatServer(ServerBuilder<?> serverBuilder, int port){
        this.port = port;
        if(history == null)
            history = new ArrayList<Message>();
        server = serverBuilder.addService(new ChatService()).build();
    }

    public void start() throws IOException{
        server.start();
        logger.info("Server started, listening on " + port);
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                // Use stderr here since the logger may has been reset by its JVM shutdown hook.
                System.err.println("*** shutting down gRPC server since JVM is shutting down");
                ChatServer.this.stop();
                System.err.println("*** server shut down");
            }
        });
    }

    /** Stop serving requests and shutdown resources. */
    public void stop() {
        if (server != null) {
            server.shutdown();
        }
    }
    private void blockUntilShutdown() throws InterruptedException {
        if (server != null) {
            server.awaitTermination();
        }
    }

    public static void main(String[] args) throws Exception{
        ChatServer server = new ChatServer(50050);
        server.start();
        server.blockUntilShutdown();

    }

    private static class ChatService extends ChatServiceGrpc.ChatServiceImplBase {

    }
}
