package com.ljw.Client;

import com.ljw.Server.Server;
import com.ljw.service.Message;
import com.ljw.service.MessageType;
import com.ljw.utility.Utility;

import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * @author ljw
 * @version 1.0
 * 提供和消息的相关方法
 */
public class MessageClient {
    public void privateChat(String sender) {
        System.out.print("请输入想聊天的用户号: ");
        String receiver = Utility.readString(50);
        System.out.print("请输入需要发送的内容: ");
        String content = Utility.readString(100);
        // 获取Message对象，设置messType
        Message message = new Message();
        // 设置消息类型是MESSAGE_COMM_MES 普通消息
        message.setMessType(MessageType.MESSAGE_COMM_MES);
        // 设置发送者
        message.setSender(sender);
        // 发送内容
        message.setContent(content);
        // 接收者
        message.setReceiver(receiver);
        System.out.println(message.getSendTime());
        System.out.println("\n你对" + receiver + "说: " + content);
        // 发送到服务器
        // 从管理连接线程里取出对应线程的socket，并从socket获取输出流对象
        try {
            if ( ClientConnectServerThread.onlineUser != null && ClientConnectServerThread.onlineUser.contains(receiver)) {
                ObjectOutputStream oos = new ObjectOutputStream(MangerClientConnectServerThread.
                        get(sender).getSocket().getOutputStream());
                oos.writeObject(message);
            } else {
                System.out.println("用户不在线，已存储该消息...");
                Server.getOfflineMessageList(receiver).add(message);
                Server.offlineMessage.put(receiver,Server.getOfflineMessageList(receiver));
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void groupChat(String sender) {
        System.out.print("\n请输入想对大家说的话: ");
        String content = Utility.readString(100);
        // 获取Message对象，设置messType
        Message message = new Message();
        // 设置消息类型是MESSAGE_COMM_MES 普通消息
        message.setMessType(MessageType.MESSAGE_GROUP_MESSAGE);
        // 设置发送者
        message.setSender(sender);
        // 发送内容
        message.setContent(content);
        System.out.println(message.getSendTime());
        System.out.println("\n你对说大家说: " + content);
        // 发送到服务器
        // 从管理连接线程里取出对应线程的socket，并从socket获取输出流对象
        try {
            ObjectOutputStream oos = new ObjectOutputStream(MangerClientConnectServerThread.
                    get(sender).getSocket().getOutputStream());
            oos.writeObject(message);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
