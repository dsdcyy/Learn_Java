package com.ljw.Client;

import com.ljw.service.Message;
import com.ljw.service.MessageType;
import com.ljw.service.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @author ljw
 * @version 1.0
 * 该类完成登入用户登入验证和用户注册等功能
 */
public class UserClientService {
    private User u =new User();

    public boolean checkUser(String userId, String passwd) throws ClassNotFoundException, IOException {
        // 创建User对象
        u.setUserId(userId);
        u.setPassword(passwd);
        // 连接到服务器,发送u对象
        Socket socket = null;
        try {
            socket = new Socket(InetAddress.getByName("192.168.0.105"), 9999);
        } catch (IOException e) {
            System.out.println("无法连接服务器，请重试");
            return false;
        }
        // 获取ObjectOutputStream输出User对象给服务器
        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
        oos.writeObject(u); // 发送User对象
        // 读取从服务器回复的Message对象
        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
        // 将读取的对象转为Message
        Message ms = (Message) ois.readObject();
        // 判断类型Message.messType值从而判断是否登入成功
        if (!ms.getMessType().equals(MessageType.MESSAGE_LOGIN_SUCCEED)) {
            System.out.println("登入失败...");
            socket.close();
            return false;
        }
        System.out.println("登入成功...");
        ClientConnectServerThread ccst = new ClientConnectServerThread(socket);
        // 加入到管理连接的线程类
        if (!MangerClientConnectServerThread.add(userId, ccst)){
            System.out.println("用户已经登入，无法再次登入...");
            socket.close();
            return false;
        }
        // 启动客户端线程
        ccst.start();

        // 为了后面客户端的扩展，我们将线程放入到集合中管理
        return true;
    }

    // 向服务器请求在线用户列表
    public void onlineFriendsList() {
        // 获取Message对象，设置messType
        Message message = new Message();
        // 设置消息类型是MESSAGE_GET_ONLINE_FRIENDS 获取用户列表
        message.setMessType(MessageType.MESSAGE_GET_ONLINE_FRIENDS);
        // 设置发送者
        message.setSender(u.getUserId());

        // 发送到服务器
        // 从管理连接线程里取出对应线程的socket，并从socket获取输出流对象
        try {
            ObjectOutputStream oos = new ObjectOutputStream(MangerClientConnectServerThread.
                    get(u.getUserId()).getSocket().getOutputStream());
            oos.writeObject(message);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void logout() {
        // 获取Message对象，设置messType
        Message message = new Message();
        // 设置消息类型是MESSAGE_GET_ONLINE_FRIENDS 获取用户列表
        message.setMessType(MessageType.MESSAGE_CLIENT_EXIT);
        // 设置发送者
        message.setSender(u.getUserId());

        // 发送到服务器
        // 从管理连接线程里取出对应线程的socket，并从socket获取输出流对象
        try {
            ObjectOutputStream oos = new ObjectOutputStream(MangerClientConnectServerThread.
                    get(u.getUserId()).getSocket().getOutputStream());
            oos.writeObject(message);
            System.out.println(u.getUserId() + "退出系统...");
            // 正常退出
            System.exit(0);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
