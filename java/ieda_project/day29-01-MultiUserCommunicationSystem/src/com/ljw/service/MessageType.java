package com.ljw.service;

import com.ljw.utility.Utility;

/**
 * @author ljw
 * @version 1.0
 * 消息类型接口
 */
public interface MessageType {
    String MESSAGE_LOGIN_SUCCEED = "1"; // 表示登入成功
    String MESSAGE_LOGIN_FAIL = "2"; // 表示登入失败
    String MESSAGE_COMM_MES = "3"; // 普通信息包
    String MESSAGE_GET_ONLINE_FRIENDS = "4"; // 要求返回在线用户列表
    String MESSAGE_RET_ONLINE_FRIENDS = "5"; // 要求返回在线用户列表
    String MESSAGE_CLIENT_EXIT = "6"; // 客户端请求退出
    String MESSAGE_GROUP_MESSAGE = "7"; // 群聊消息
    String MESSAGE_CLIENT_FILE = "8"; // 文件接收

}
