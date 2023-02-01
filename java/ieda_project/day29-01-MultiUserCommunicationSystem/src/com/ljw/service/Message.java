package com.ljw.service;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author ljw
 * @version 1.0
 * 通信时的消息对象
 */
public class Message implements Serializable { // 实现序列化
    private static final long serialVersionUID = 1L;
    private String sender; // 消息发送者(谁发送消息)
    private String receiver; // 消息接收者(给谁发送消息)
    private String content; // 消息内容
    private String sendTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss E").format(new Date()); // 发送时间时间
    private String  messType; // 消息类型[在接口定义已知消息类型]

    public byte[] getBytes() {
        return bytes;
    }

    public void setBytes(byte[] bytes) {
        this.bytes = bytes;
    }

    private byte[] bytes; // 接收文件

    public String getMessType() {
        return messType;
    }

    public void setMessType(String messType) {
        this.messType = messType;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSendTime() {
        return sendTime;
    }

    public void setSendTime(String sendTime) {
        this.sendTime = sendTime;
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println(new Message().sendTime);
        Thread.sleep(1000);
        System.out.println(new Message().sendTime);

    }

}
