package be.msec.labgrpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 * <pre>
 * De calculator service definitie
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.12.0)",
    comments = "Source: ChatClient.proto")
public final class ChatServiceGrpc {

  private ChatServiceGrpc() {}

  public static final String SERVICE_NAME = "tutorial.ChatService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getReceiveMessageMethod()} instead. 
  public static final io.grpc.MethodDescriptor<be.msec.labgrpc.Empty,
      be.msec.labgrpc.Message> METHOD_RECEIVE_MESSAGE = getReceiveMessageMethodHelper();

  private static volatile io.grpc.MethodDescriptor<be.msec.labgrpc.Empty,
      be.msec.labgrpc.Message> getReceiveMessageMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<be.msec.labgrpc.Empty,
      be.msec.labgrpc.Message> getReceiveMessageMethod() {
    return getReceiveMessageMethodHelper();
  }

  private static io.grpc.MethodDescriptor<be.msec.labgrpc.Empty,
      be.msec.labgrpc.Message> getReceiveMessageMethodHelper() {
    io.grpc.MethodDescriptor<be.msec.labgrpc.Empty, be.msec.labgrpc.Message> getReceiveMessageMethod;
    if ((getReceiveMessageMethod = ChatServiceGrpc.getReceiveMessageMethod) == null) {
      synchronized (ChatServiceGrpc.class) {
        if ((getReceiveMessageMethod = ChatServiceGrpc.getReceiveMessageMethod) == null) {
          ChatServiceGrpc.getReceiveMessageMethod = getReceiveMessageMethod = 
              io.grpc.MethodDescriptor.<be.msec.labgrpc.Empty, be.msec.labgrpc.Message>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "tutorial.ChatService", "receiveMessage"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  be.msec.labgrpc.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  be.msec.labgrpc.Message.getDefaultInstance()))
                  .setSchemaDescriptor(new ChatServiceMethodDescriptorSupplier("receiveMessage"))
                  .build();
          }
        }
     }
     return getReceiveMessageMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getSendMessageMethod()} instead. 
  public static final io.grpc.MethodDescriptor<be.msec.labgrpc.Message,
      be.msec.labgrpc.Response> METHOD_SEND_MESSAGE = getSendMessageMethodHelper();

  private static volatile io.grpc.MethodDescriptor<be.msec.labgrpc.Message,
      be.msec.labgrpc.Response> getSendMessageMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<be.msec.labgrpc.Message,
      be.msec.labgrpc.Response> getSendMessageMethod() {
    return getSendMessageMethodHelper();
  }

  private static io.grpc.MethodDescriptor<be.msec.labgrpc.Message,
      be.msec.labgrpc.Response> getSendMessageMethodHelper() {
    io.grpc.MethodDescriptor<be.msec.labgrpc.Message, be.msec.labgrpc.Response> getSendMessageMethod;
    if ((getSendMessageMethod = ChatServiceGrpc.getSendMessageMethod) == null) {
      synchronized (ChatServiceGrpc.class) {
        if ((getSendMessageMethod = ChatServiceGrpc.getSendMessageMethod) == null) {
          ChatServiceGrpc.getSendMessageMethod = getSendMessageMethod = 
              io.grpc.MethodDescriptor.<be.msec.labgrpc.Message, be.msec.labgrpc.Response>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "tutorial.ChatService", "sendMessage"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  be.msec.labgrpc.Message.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  be.msec.labgrpc.Response.getDefaultInstance()))
                  .setSchemaDescriptor(new ChatServiceMethodDescriptorSupplier("sendMessage"))
                  .build();
          }
        }
     }
     return getSendMessageMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getConnectUserMethod()} instead. 
  public static final io.grpc.MethodDescriptor<be.msec.labgrpc.User,
      be.msec.labgrpc.Response> METHOD_CONNECT_USER = getConnectUserMethodHelper();

  private static volatile io.grpc.MethodDescriptor<be.msec.labgrpc.User,
      be.msec.labgrpc.Response> getConnectUserMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<be.msec.labgrpc.User,
      be.msec.labgrpc.Response> getConnectUserMethod() {
    return getConnectUserMethodHelper();
  }

  private static io.grpc.MethodDescriptor<be.msec.labgrpc.User,
      be.msec.labgrpc.Response> getConnectUserMethodHelper() {
    io.grpc.MethodDescriptor<be.msec.labgrpc.User, be.msec.labgrpc.Response> getConnectUserMethod;
    if ((getConnectUserMethod = ChatServiceGrpc.getConnectUserMethod) == null) {
      synchronized (ChatServiceGrpc.class) {
        if ((getConnectUserMethod = ChatServiceGrpc.getConnectUserMethod) == null) {
          ChatServiceGrpc.getConnectUserMethod = getConnectUserMethod = 
              io.grpc.MethodDescriptor.<be.msec.labgrpc.User, be.msec.labgrpc.Response>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "tutorial.ChatService", "connectUser"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  be.msec.labgrpc.User.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  be.msec.labgrpc.Response.getDefaultInstance()))
                  .setSchemaDescriptor(new ChatServiceMethodDescriptorSupplier("connectUser"))
                  .build();
          }
        }
     }
     return getConnectUserMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getDisconnectUserMethod()} instead. 
  public static final io.grpc.MethodDescriptor<be.msec.labgrpc.User,
      be.msec.labgrpc.Response> METHOD_DISCONNECT_USER = getDisconnectUserMethodHelper();

  private static volatile io.grpc.MethodDescriptor<be.msec.labgrpc.User,
      be.msec.labgrpc.Response> getDisconnectUserMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<be.msec.labgrpc.User,
      be.msec.labgrpc.Response> getDisconnectUserMethod() {
    return getDisconnectUserMethodHelper();
  }

  private static io.grpc.MethodDescriptor<be.msec.labgrpc.User,
      be.msec.labgrpc.Response> getDisconnectUserMethodHelper() {
    io.grpc.MethodDescriptor<be.msec.labgrpc.User, be.msec.labgrpc.Response> getDisconnectUserMethod;
    if ((getDisconnectUserMethod = ChatServiceGrpc.getDisconnectUserMethod) == null) {
      synchronized (ChatServiceGrpc.class) {
        if ((getDisconnectUserMethod = ChatServiceGrpc.getDisconnectUserMethod) == null) {
          ChatServiceGrpc.getDisconnectUserMethod = getDisconnectUserMethod = 
              io.grpc.MethodDescriptor.<be.msec.labgrpc.User, be.msec.labgrpc.Response>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "tutorial.ChatService", "disconnectUser"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  be.msec.labgrpc.User.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  be.msec.labgrpc.Response.getDefaultInstance()))
                  .setSchemaDescriptor(new ChatServiceMethodDescriptorSupplier("disconnectUser"))
                  .build();
          }
        }
     }
     return getDisconnectUserMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetUserListMethod()} instead. 
  public static final io.grpc.MethodDescriptor<be.msec.labgrpc.Empty,
      be.msec.labgrpc.User> METHOD_GET_USER_LIST = getGetUserListMethodHelper();

  private static volatile io.grpc.MethodDescriptor<be.msec.labgrpc.Empty,
      be.msec.labgrpc.User> getGetUserListMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<be.msec.labgrpc.Empty,
      be.msec.labgrpc.User> getGetUserListMethod() {
    return getGetUserListMethodHelper();
  }

  private static io.grpc.MethodDescriptor<be.msec.labgrpc.Empty,
      be.msec.labgrpc.User> getGetUserListMethodHelper() {
    io.grpc.MethodDescriptor<be.msec.labgrpc.Empty, be.msec.labgrpc.User> getGetUserListMethod;
    if ((getGetUserListMethod = ChatServiceGrpc.getGetUserListMethod) == null) {
      synchronized (ChatServiceGrpc.class) {
        if ((getGetUserListMethod = ChatServiceGrpc.getGetUserListMethod) == null) {
          ChatServiceGrpc.getGetUserListMethod = getGetUserListMethod = 
              io.grpc.MethodDescriptor.<be.msec.labgrpc.Empty, be.msec.labgrpc.User>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "tutorial.ChatService", "getUserList"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  be.msec.labgrpc.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  be.msec.labgrpc.User.getDefaultInstance()))
                  .setSchemaDescriptor(new ChatServiceMethodDescriptorSupplier("getUserList"))
                  .build();
          }
        }
     }
     return getGetUserListMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ChatServiceStub newStub(io.grpc.Channel channel) {
    return new ChatServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ChatServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new ChatServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ChatServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new ChatServiceFutureStub(channel);
  }

  /**
   * <pre>
   * De calculator service definitie
   * </pre>
   */
  public static abstract class ChatServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void receiveMessage(be.msec.labgrpc.Empty request,
        io.grpc.stub.StreamObserver<be.msec.labgrpc.Message> responseObserver) {
      asyncUnimplementedUnaryCall(getReceiveMessageMethodHelper(), responseObserver);
    }

    /**
     */
    public void sendMessage(be.msec.labgrpc.Message request,
        io.grpc.stub.StreamObserver<be.msec.labgrpc.Response> responseObserver) {
      asyncUnimplementedUnaryCall(getSendMessageMethodHelper(), responseObserver);
    }

    /**
     */
    public void connectUser(be.msec.labgrpc.User request,
        io.grpc.stub.StreamObserver<be.msec.labgrpc.Response> responseObserver) {
      asyncUnimplementedUnaryCall(getConnectUserMethodHelper(), responseObserver);
    }

    /**
     */
    public void disconnectUser(be.msec.labgrpc.User request,
        io.grpc.stub.StreamObserver<be.msec.labgrpc.Response> responseObserver) {
      asyncUnimplementedUnaryCall(getDisconnectUserMethodHelper(), responseObserver);
    }

    /**
     */
    public void getUserList(be.msec.labgrpc.Empty request,
        io.grpc.stub.StreamObserver<be.msec.labgrpc.User> responseObserver) {
      asyncUnimplementedUnaryCall(getGetUserListMethodHelper(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getReceiveMessageMethodHelper(),
            asyncServerStreamingCall(
              new MethodHandlers<
                be.msec.labgrpc.Empty,
                be.msec.labgrpc.Message>(
                  this, METHODID_RECEIVE_MESSAGE)))
          .addMethod(
            getSendMessageMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                be.msec.labgrpc.Message,
                be.msec.labgrpc.Response>(
                  this, METHODID_SEND_MESSAGE)))
          .addMethod(
            getConnectUserMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                be.msec.labgrpc.User,
                be.msec.labgrpc.Response>(
                  this, METHODID_CONNECT_USER)))
          .addMethod(
            getDisconnectUserMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                be.msec.labgrpc.User,
                be.msec.labgrpc.Response>(
                  this, METHODID_DISCONNECT_USER)))
          .addMethod(
            getGetUserListMethodHelper(),
            asyncServerStreamingCall(
              new MethodHandlers<
                be.msec.labgrpc.Empty,
                be.msec.labgrpc.User>(
                  this, METHODID_GET_USER_LIST)))
          .build();
    }
  }

  /**
   * <pre>
   * De calculator service definitie
   * </pre>
   */
  public static final class ChatServiceStub extends io.grpc.stub.AbstractStub<ChatServiceStub> {
    private ChatServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ChatServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ChatServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ChatServiceStub(channel, callOptions);
    }

    /**
     */
    public void receiveMessage(be.msec.labgrpc.Empty request,
        io.grpc.stub.StreamObserver<be.msec.labgrpc.Message> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getReceiveMessageMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void sendMessage(be.msec.labgrpc.Message request,
        io.grpc.stub.StreamObserver<be.msec.labgrpc.Response> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSendMessageMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void connectUser(be.msec.labgrpc.User request,
        io.grpc.stub.StreamObserver<be.msec.labgrpc.Response> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getConnectUserMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void disconnectUser(be.msec.labgrpc.User request,
        io.grpc.stub.StreamObserver<be.msec.labgrpc.Response> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDisconnectUserMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getUserList(be.msec.labgrpc.Empty request,
        io.grpc.stub.StreamObserver<be.msec.labgrpc.User> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getGetUserListMethodHelper(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * De calculator service definitie
   * </pre>
   */
  public static final class ChatServiceBlockingStub extends io.grpc.stub.AbstractStub<ChatServiceBlockingStub> {
    private ChatServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ChatServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ChatServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ChatServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public java.util.Iterator<be.msec.labgrpc.Message> receiveMessage(
        be.msec.labgrpc.Empty request) {
      return blockingServerStreamingCall(
          getChannel(), getReceiveMessageMethodHelper(), getCallOptions(), request);
    }

    /**
     */
    public be.msec.labgrpc.Response sendMessage(be.msec.labgrpc.Message request) {
      return blockingUnaryCall(
          getChannel(), getSendMessageMethodHelper(), getCallOptions(), request);
    }

    /**
     */
    public be.msec.labgrpc.Response connectUser(be.msec.labgrpc.User request) {
      return blockingUnaryCall(
          getChannel(), getConnectUserMethodHelper(), getCallOptions(), request);
    }

    /**
     */
    public be.msec.labgrpc.Response disconnectUser(be.msec.labgrpc.User request) {
      return blockingUnaryCall(
          getChannel(), getDisconnectUserMethodHelper(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<be.msec.labgrpc.User> getUserList(
        be.msec.labgrpc.Empty request) {
      return blockingServerStreamingCall(
          getChannel(), getGetUserListMethodHelper(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * De calculator service definitie
   * </pre>
   */
  public static final class ChatServiceFutureStub extends io.grpc.stub.AbstractStub<ChatServiceFutureStub> {
    private ChatServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ChatServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ChatServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ChatServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<be.msec.labgrpc.Response> sendMessage(
        be.msec.labgrpc.Message request) {
      return futureUnaryCall(
          getChannel().newCall(getSendMessageMethodHelper(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<be.msec.labgrpc.Response> connectUser(
        be.msec.labgrpc.User request) {
      return futureUnaryCall(
          getChannel().newCall(getConnectUserMethodHelper(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<be.msec.labgrpc.Response> disconnectUser(
        be.msec.labgrpc.User request) {
      return futureUnaryCall(
          getChannel().newCall(getDisconnectUserMethodHelper(), getCallOptions()), request);
    }
  }

  private static final int METHODID_RECEIVE_MESSAGE = 0;
  private static final int METHODID_SEND_MESSAGE = 1;
  private static final int METHODID_CONNECT_USER = 2;
  private static final int METHODID_DISCONNECT_USER = 3;
  private static final int METHODID_GET_USER_LIST = 4;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ChatServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ChatServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_RECEIVE_MESSAGE:
          serviceImpl.receiveMessage((be.msec.labgrpc.Empty) request,
              (io.grpc.stub.StreamObserver<be.msec.labgrpc.Message>) responseObserver);
          break;
        case METHODID_SEND_MESSAGE:
          serviceImpl.sendMessage((be.msec.labgrpc.Message) request,
              (io.grpc.stub.StreamObserver<be.msec.labgrpc.Response>) responseObserver);
          break;
        case METHODID_CONNECT_USER:
          serviceImpl.connectUser((be.msec.labgrpc.User) request,
              (io.grpc.stub.StreamObserver<be.msec.labgrpc.Response>) responseObserver);
          break;
        case METHODID_DISCONNECT_USER:
          serviceImpl.disconnectUser((be.msec.labgrpc.User) request,
              (io.grpc.stub.StreamObserver<be.msec.labgrpc.Response>) responseObserver);
          break;
        case METHODID_GET_USER_LIST:
          serviceImpl.getUserList((be.msec.labgrpc.Empty) request,
              (io.grpc.stub.StreamObserver<be.msec.labgrpc.User>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class ChatServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ChatServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return be.msec.labgrpc.TutorialProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ChatService");
    }
  }

  private static final class ChatServiceFileDescriptorSupplier
      extends ChatServiceBaseDescriptorSupplier {
    ChatServiceFileDescriptorSupplier() {}
  }

  private static final class ChatServiceMethodDescriptorSupplier
      extends ChatServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ChatServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (ChatServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ChatServiceFileDescriptorSupplier())
              .addMethod(getReceiveMessageMethodHelper())
              .addMethod(getSendMessageMethodHelper())
              .addMethod(getConnectUserMethodHelper())
              .addMethod(getDisconnectUserMethodHelper())
              .addMethod(getGetUserListMethodHelper())
              .build();
        }
      }
    }
    return result;
  }
}
