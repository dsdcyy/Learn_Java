package com.ljw.Server;

import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author ljw
 * @version 1.0
 * 管理服务器连接到客户端线程的类
 */
public class MangerServerConnectClientThread {
    // 多个ClientConnectServerThread放入到HashMap，key为用户Id，key为ClientConnectServerThread
    private static HashMap<String, SerConnectClientThread> hm = new HashMap<>();


    // 线程加入到集合
    public static boolean add(String userId, SerConnectClientThread ccst) {
        if (hm.get(userId) != null) {
            return false;
        }
        hm.put(userId, ccst);
        return true;
    }

    // 通过userId取出线程
    public static SerConnectClientThread get(String userId) {
        return hm.get(userId);
    }

    public static void remove(String userId) {
        hm.remove(userId);
    }

    public static String getOnlineUser() {
        // 获取用户列表
        Set<String> strings = hm.keySet();
        StringBuffer userIds = new StringBuffer();
        for (String user : strings) {
            userIds.append(user).append(" ");
        }
        return userIds.toString();
    }
}
