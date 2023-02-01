package com.ljw.Client;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author ljw
 * @version 1.0
 * 管理客户端连接到服务器端线的程类
 */
public class MangerClientConnectServerThread {
    // 多个ClientConnectServerThread放入到HashMap，key为用户Id，key为ClientConnectServerThread
    private static HashMap<String, ClientConnectServerThread> hm = new HashMap<>();

    // 线程加入到集合
    public static boolean add(String userId, ClientConnectServerThread ccst) {
        if (hm.get(userId) != null) {
            return false;
        }
        hm.put(userId, ccst);
        System.out.println("客户端连接服务端成功...");
        return true;
    }

    // 通过userId取出线程
    public static ClientConnectServerThread get(String userId) {
        return hm.get(userId);
    }

    public static void remove(String userId) {
        hm.remove(userId);
    }
}
