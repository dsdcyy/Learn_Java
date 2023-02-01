package com.ljw.Client;

import com.ljw.service.Message;
import com.ljw.service.MessageType;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

/**
 * @author ljw
 * @version 1.0
 * 客户端连接服务端的线程类，该类持有Socket对象
 */
public class ClientConnectServerThread extends Thread {
    private Socket socket;
    static boolean isActive = true;

    public static String onlineUser = null;

    // 构造器接受一个socket对象
    public ClientConnectServerThread(Socket socket) {
        setSocket(socket);
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }


    @Override
    public void run() {
        // 需要在后台和服务器通信
        while (isActive) {
            System.out.println("\n客户端线程读取服务端发送的消息");
            try {
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                // 如果没有读到服务器的Message对象，readObject会阻塞
                Message message = (Message) ois.readObject();
                // 判断Message类型
                switch (message.getMessType()) {
                    case MessageType.MESSAGE_RET_ONLINE_FRIENDS:
                        System.out.println("\n=============当前在线的用户列表=============");
                        String[] lines = message.getContent().split(" ");
                        onlineUser = message.getContent();
                        System.out.println();
                        // 判断message的接收者不是自己，剩下的即为在线用户
                        for (String line : lines) {
                            if (!line.equals(message.getReceiver())) {
                                System.out.println("用户 " + line);
                            }
                        }
                        break;
                    case MessageType.MESSAGE_COMM_MES:
                        System.out.println("\n" + message.getSendTime());
                        System.out.println(message.getSender() + "对你说: " + message.getContent());
                        break;
                    case MessageType.MESSAGE_GROUP_MESSAGE:
                        System.out.println("\n" + message.getSendTime());
                        System.out.println(message.getSender() + "对大家说: " + message.getContent());
                        break;
                    case MessageType.MESSAGE_CLIENT_FILE:
                        System.out.println("\n" + message.getSendTime());
                        System.out.println(message.getSender() + "发送了一个文件给你...");
                        String receiveFiles = "/home/Ljw/Desktop/java/ieda_project/day29-01-MultiUserCommunicationSystem/src/id-63c7990b4631f-0058-2.jpg";
                        BufferedOutputStream writer = new BufferedOutputStream(new FileOutputStream(receiveFiles));
                        writer.write(message.getBytes());
                        writer.close();
                        System.out.println("保存文件到" + receiveFiles + "成功...");
                        break;
                    default:
                        System.out.println("错误的消息类型,不处理...");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            } finally {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        try {
            socket.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
