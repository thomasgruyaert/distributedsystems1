// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: ChatClient.proto

package be.msec.labgrpc;

public final class TutorialProto {
  private TutorialProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_tutorial_Message_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_tutorial_Message_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_tutorial_Response_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_tutorial_Response_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_tutorial_ReceiveIndex_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_tutorial_ReceiveIndex_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_tutorial_User_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_tutorial_User_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_tutorial_Empty_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_tutorial_Empty_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\020ChatClient.proto\022\010tutorial\"9\n\007Message\022" +
      "\016\n\006sender\030\001 \001(\t\022\017\n\007content\030\002 \001(\t\022\r\n\005inde" +
      "x\030\003 \001(\005\"+\n\010Response\022\016\n\006status\030\001 \001(\t\022\017\n\007m" +
      "essage\030\002 \001(\t\"\035\n\014ReceiveIndex\022\r\n\005index\030\001 " +
      "\001(\005\"\030\n\004User\022\020\n\010username\030\001 \001(\t\"\007\n\005Empty2\240" +
      "\002\n\013ChatService\0228\n\016receiveMessage\022\017.tutor" +
      "ial.Empty\032\021.tutorial.Message\"\0000\001\0226\n\013send" +
      "Message\022\021.tutorial.Message\032\022.tutorial.Re" +
      "sponse\"\000\0223\n\013connectUser\022\016.tutorial.User\032" +
      "\022.tutorial.Response\"\000\0226\n\016disconnectUser\022" +
      "\016.tutorial.User\032\022.tutorial.Response\"\000\0222\n" +
      "\013getUserList\022\017.tutorial.Empty\032\016.tutorial" +
      ".User\"\0000\001B(\n\017be.msec.labgrpcB\rTutorialPr" +
      "otoP\001\242\002\003HLWb\006proto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_tutorial_Message_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_tutorial_Message_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_tutorial_Message_descriptor,
        new java.lang.String[] { "Sender", "Content", "Index", });
    internal_static_tutorial_Response_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_tutorial_Response_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_tutorial_Response_descriptor,
        new java.lang.String[] { "Status", "Message", });
    internal_static_tutorial_ReceiveIndex_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_tutorial_ReceiveIndex_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_tutorial_ReceiveIndex_descriptor,
        new java.lang.String[] { "Index", });
    internal_static_tutorial_User_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_tutorial_User_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_tutorial_User_descriptor,
        new java.lang.String[] { "Username", });
    internal_static_tutorial_Empty_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_tutorial_Empty_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_tutorial_Empty_descriptor,
        new java.lang.String[] { });
  }

  // @@protoc_insertion_point(outer_class_scope)
}