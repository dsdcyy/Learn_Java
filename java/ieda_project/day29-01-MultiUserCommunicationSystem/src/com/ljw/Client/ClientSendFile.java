package com.ljw.Client;

import com.ljw.service.Message;
import com.ljw.service.MessageType;
import com.ljw.utility.StreamUtils;
import com.ljw.utility.Utility;

import java.io.*;

/**
 * @author ljw
 * @version 1.0
 * // 该类完成文件传输
 */
public class ClientSendFile {
    public void sendFile(String sender) throws Exception {
        System.out.print("请输入想要发送的用户号：");
        String receiver = Utility.readString(100);
        System.out.print("\n请输入文件本地路径：");
        String fileName = Utility.readString(1000);
        File file = new File(fileName);
        if (!file.exists()) {
            System.out.println("\n不存在的文件...");
            return;
        }
        System.out.println("\n存在该文件,开始发送...");
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
        byte[] bytes = StreamUtils.streamToByteArray(bis);
        // 获取Message对象，设置messType
        Message message = new Message();
        // 设置消息类型是MESSAGE_CLIENT_File 文件
        message.setMessType(MessageType.MESSAGE_CLIENT_FILE);
        // 设置发送者
        message.setSender(sender);
        // 设置接收者
        message.setReceiver(receiver);
        // 发送的文件的字节数组
        message.setBytes(bytes);
        // 发送到服务器
        // 从管理连接线程里取出对应线程的socket，并从socket获取输出流对象
        try {
            bis.close();
            // 文件内容写入输出流
            ObjectOutputStream oos = new ObjectOutputStream(MangerClientConnectServerThread.
                    get(sender).getSocket().getOutputStream());
            //
            oos.writeObject(message);
            System.out.println("文件已发送给" + receiver);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
