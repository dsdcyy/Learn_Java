package com.ljw.Server;

import com.ljw.service.Message;
import com.ljw.service.MessageType;
import com.ljw.service.User;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author ljw
 * @version 1.0
 * 这是服务器，在监听9999端口，等待用户连接，并保持通信
 */
public class Server {
    private ServerSocket ss = null;
    // ConcurrentHashMap 可以处理多并发，线程安全
    private static final ConcurrentHashMap<String, User> userData = new ConcurrentHashMap<>();
    // 离线消息存放
    public static ConcurrentHashMap<String, ArrayList<Message>> offlineMessage = new ConcurrentHashMap<>();

    public static ArrayList<Message> getOfflineMessageList(String user){
        return offlineMessage.get(user);
    }


    // 初始化用户
    static {
        userData.put("100", new User("100", "123456"));
        userData.put("200", new User("200", "123456"));
        userData.put("300", new User("300", "123456"));
        userData.put("至尊宝", new User("至尊宝", "123456"));
        userData.put("紫霞", new User("紫霞", "123456"));
    }

    public Server() {
        try {
            System.out.println("服务器在9999端口监听");
            new Thread(new ForwardNews()).start();
            ss = new ServerSocket(9999);
            // 会持续监听
            while (true) {
                // 没有连接会阻塞
                Socket socket = ss.accept();
                // 从客户端输出流里获取传入过来的User对象
                User user = (User) (new ObjectInputStream(socket.getInputStream()).readObject());
                // 准备给客户端发送的对象输出流
                ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                // 从客户端读取的user对象
                String userId = user.getUserId();
                String passwd = user.getPassword();
                Message message = new Message();
                // 和存放userData的ConcurrentHashMap表做对比，验证是否登入成功
                if (checkUser(userId, passwd)) {
                    message.setMessType(MessageType.MESSAGE_LOGIN_SUCCEED);
                    // 发送给客户端Message对象
                    oos.writeObject(message);
                    // 创建一个线程，和客户端保持通信
                    System.out.println("用户 " + userId + "登入成功");
                    SerConnectClientThread scct = new SerConnectClientThread(socket, userId);
                    // 启动该线程
                    scct.start();
                    MangerServerConnectClientThread.add(userId, scct);
                } else {
                    message.setMessType(MessageType.MESSAGE_LOGIN_FAIL);
                    oos.writeObject(message);
                    System.out.println("用户 " + userId + "登入失败");
                    // 登入失败不需要保留socket
                    socket.close();
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                assert ss != null;
                ss.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    // 验证用户密码
    public boolean checkUser(String userId, String passwd) {
        // 判断用户是否已经登入
        if(MangerServerConnectClientThread.getOnlineUser().contains(userId)){
            System.out.println("该用户已经登入过了...");
            return false;
        }
        // 判断用户是否存在
        User user = userData.get(userId);
        if (user == null) { // 判断用户是否在userData中
            System.out.println("用户不存在...");
            return false;
        }
        // 判断密码是否正确
        if (!user.getPassword().equals(passwd)) { // 判断密码是否正确
            System.out.println("密码错误...");
            return false;
        }
        return true;
    }
}
