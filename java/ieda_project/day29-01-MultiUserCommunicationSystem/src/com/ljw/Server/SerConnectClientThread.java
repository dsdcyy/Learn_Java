package com.ljw.Server;

import com.ljw.Client.MangerClientConnectServerThread;
import com.ljw.service.Message;
import com.ljw.service.MessageType;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * @author ljw
 * @version 1.0
 * 该类用于服务端和客户端的通信
 */
public class SerConnectClientThread extends Thread {
    private Socket socket;
    private String userId;

    public SerConnectClientThread(Socket socket, String userId) {
        this.socket = socket;
        this.userId = userId;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public void run() { // 让线程处于一个run状态，可以发送/接收消息
        out:
        while (true) {
            System.out.println("客户端 " + userId + "和服务端保持通信,读取数据...");
            try {
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                // 不断读取从客户端发过来的Message对象
                Message message = (Message) ois.readObject();
                switch (message.getMessType()) {
                    case MessageType.MESSAGE_GET_ONLINE_FRIENDS:
                        // 这个人要在线列表
                        System.out.println(userId + "要在线用户列表");
                        // 构建message2
                        Message message2 = new Message();
                        // 设置文本
                        message2.setContent(MangerServerConnectClientThread.getOnlineUser());
                        // 设置消息类型
                        message2.setMessType(MessageType.MESSAGE_RET_ONLINE_FRIENDS);
                        // 设置发送者
                        message2.setSender("服务器");
                        // 设置接收者
                        message2.setReceiver(userId);
                        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                        oos.writeObject(message2); // 如果用户不在线，可以保存在数据中
                        break;
                    case MessageType.MESSAGE_CLIENT_EXIT:
                        // 客户端退出，需要断开连接
                        System.out.println("客户端 " + userId + "需要断开连接...");
                        // 将对应客户端线程从集合删除
                        MangerClientConnectServerThread.remove(userId);
                        // 关闭socket对象
                        socket.close();
                        // 将对应server端线程对象从集合移除
                        MangerServerConnectClientThread.remove(userId);
                        // 结束外循环
                        break out;
                    // 转发消息
                    case MessageType.MESSAGE_COMM_MES:
                        System.out.println("从" + message.getSender() + "接收到一条普通消息，发送给" + message.getReceiver());
                        // 获取Receiver对应线程管理类
                        SerConnectClientThread scct = MangerServerConnectClientThread.get(message.getReceiver());
                        ObjectOutputStream oos2 = new ObjectOutputStream(scct.socket.getOutputStream());
                        oos2.writeObject(message);
                        break;
                    // 群发消息
                    case MessageType.MESSAGE_GROUP_MESSAGE:
                        System.out.println("从" + message.getSender() + "接收到一条群消息...");
                        String[] groups = MangerServerConnectClientThread.getOnlineUser().split(" ");
                        for (String group : groups) {
                            // 获取Receiver对应线程管理类
                            if (!group.equals(message.getSender())) {
                                SerConnectClientThread scct2 = MangerServerConnectClientThread.get(group);
                                ObjectOutputStream oos3 = new ObjectOutputStream(scct2.socket.getOutputStream());
                                oos3.writeObject(message);
                            }
                        }
                        break;
                    // 发送文件
                    case MessageType.MESSAGE_CLIENT_FILE:
                        System.out.println(message.getSender() + "发送了文件给" + message.getReceiver() + "...");
                        SerConnectClientThread scct3 = MangerServerConnectClientThread.get(message.getReceiver());
                        ObjectOutputStream oos4 = new ObjectOutputStream(scct3.socket.getOutputStream());
                        oos4.writeObject(message);
                        break;
                    default:
                        System.out.println("错误的消息类型，不处理...");

                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("客户端 " + userId + "已断开连接...");

    }
}
