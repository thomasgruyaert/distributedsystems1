package be.mesc.labgrpc;

import java.util.ArrayList;
import java.util.logging.Logger;

import java.io.IOException;

import be.msec.labgrpc.*;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class ChatServer {
    private static final Logger logger = Logger.getLogger(ChatServer.class.getName());

    private final int port;
    private final Server server;

    static ArrayList<Message> history;
    static ArrayList<User> userList;

    public ChatServer(int port) throws IOException {
        this(ServerBuilder.forPort(port), port);
    }

    public ChatServer(ServerBuilder<?> serverBuilder, int port){
        this.port = port;
        if(history == null)
            history = new ArrayList<Message>();
        if(userList == null)
            userList = new ArrayList<User>();
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

        @Override
        public void receiveMessage(Empty nul, StreamObserver<Message> responseObserver){
            for(int i = 0; i < history.size(); i++){
                responseObserver.onNext(history.get(i));
            }

            responseObserver.onCompleted();
        }

        @Override
        public void getUserList(Empty nul, StreamObserver<User> responseObserver){
            for(int i = 0; i < userList.size(); i++){
                responseObserver.onNext(userList.get(i));
            }

            responseObserver.onCompleted();
        }

        @Override
        public void sendMessage(Message data,StreamObserver<Response> responseObserver){
            history.add(data);
            String username = data.getSender();
            String messageContent = data.getContent();
            responseObserver.onNext(send(data));
            responseObserver.onCompleted();
        }

        private Response send(Message data){
            return Response.newBuilder().setMessage(data.getSender() +":"+ data.getContent()).setStatus("Ok").build();
        }

        @Override
        public void connectUser(User user, StreamObserver<Response> responseObserver){
            responseObserver.onNext(connect(user));
            responseObserver.onCompleted();
        }

        private Response connect(User user){
            if(userList.contains(user))
                return Response.newBuilder().setStatus("Failed").build();

            userList.add(user);
            return Response.newBuilder().setStatus("Accepted").build();
        }

        @Override
        public void disconnectUser(User user, StreamObserver<Response> responseObserver){
            responseObserver.onNext(disconnect(user));
            responseObserver.onCompleted();
        }

        private Response disconnect(User user){
            if(!userList.contains(user))
                return Response.newBuilder().setStatus("Failed").build();

            userList.remove(user);
            return Response.newBuilder().setStatus("Accepted").build();
        }
    }
}
