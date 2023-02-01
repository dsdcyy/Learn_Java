package com.ljw.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @author ljw
 * @version 1.0
 * 客户端
 */
public class SocketTcP01Client {
    public static void main(String[] args) throws IOException, InterruptedException {
        // 连接服务器 InetAddress对象，端口
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        System.out.println("客户端 socket返回: " +socket.getClass());
        // 连接上后，生成Socket对象，通过socket.getOutputStream()得到和socket对象关联的输出流对象
        OutputStream outputStream = socket.getOutputStream();
        // 流写入数据（发送数据）
        outputStream.write("Client: Hello Server".getBytes());
        socket.shutdownOutput();
        // 接收服务器端的数据
        InputStream inputStream = socket.getInputStream();
        int data = 0;
        byte[] bytes = new byte[1024];
        while ((data = inputStream.read(bytes)) != -1) {
            System.out.println(new String(bytes,0,data));
        }
        // 结束标记
        socket.shutdownInput();
        outputStream.close();
        inputStream.close();
        socket.close();

    }
}
