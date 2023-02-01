package com.ljw.Client;
import com.ljw.service.User;
import com.ljw.utility.Utility;

import java.io.IOException;

/**
 * @author ljw
 * @version 1.0
 * 客户端登入界面
 */
public class LoginView {
    // 显示主菜单
    private boolean loop = true; //从登入循环控制变量
    private String key = ""; // 登入选择功能
    private final User user = new User(); // 登入的用户

    public User getUser() {
        return user;
    }

    private final UserClientService userService = new UserClientService(); // 验证用户登入和用户注册等功能

    private final MessageClient messageClient = new MessageClient(); // 普通聊天管理

    private final ClientSendFile clientSendFile = new ClientSendFile(); //发送文件管理

    // 登入主界面
    public void mainMenu() throws IOException, ClassNotFoundException {
        while (loop) {
            System.out.println("=============欢迎登录网络通信系统=============");
            System.out.println("\t\t1.登录系统");
            System.out.println("\t\t9.退出系统");
            System.out.print("请选择功能: ");
            // 该方法读取一个字符串
            key = Utility.readString(1);
            switch (key) {
                case "1":
                    System.out.println("=============登录系统=============");
                    loginSystem();
                    break;
                case "9":
                    System.out.println("退出系统...");
                    loop = false;
                    break;
                default:
                    System.out.println("输入错误，不存在该功能...");

            }
        }
    }

    private void loginSystem() throws IOException, ClassNotFoundException {
        System.out.print("请输入用户号: ");
        String userId = Utility.readString(7);
        System.out.print("请输入密码 :");
        String passwd = Utility.readString(50);
        // 判断是否登入成功
        if (userService.checkUser(userId, passwd)) {
            System.out.println("=============欢迎用户 " + userId + "=============");
            user.setUserId(userId);
            user.setPassword(passwd);
        } else {
            System.out.println("登入失败,可能原因，用户号或密码不匹配，已经登入过...");
            return;
        }
        while (loop) {
            System.out.println("=============网络通信二级菜单(用户 " + userId + ")=============");
            secondaryMenu();
        }

    }

    private void secondaryMenu() {
        System.out.println("\t\t1 显示用户列表");
        System.out.println("\t\t2 群发消息");
        System.out.println("\t\t3 私聊消息");
        System.out.println("\t\t4 发送文件");
        System.out.println("\t\t9 退出系统");
        System.out.print("请输入你的选择: ");
        key = Utility.readString(1);
        System.out.println();
        switch (key) {
            case "1":
                userService.onlineFriendsList();
                break;
            case "2":
                messageClient.groupChat(user.getUserId());
                break;
            case "3":
                messageClient.privateChat(user.getUserId());
                break;
            case "4":
                try {
                    clientSendFile.sendFile(user.getUserId());
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                break;
            case "9":
                System.out.println("退出系统...");
                // 调用方法，发送退出Message
                userService.logout();
                loop = false;
                ClientConnectServerThread.isActive = false;
                break;
            default:
                System.out.println("输入错误，不存在该功能...");
        }
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

}
